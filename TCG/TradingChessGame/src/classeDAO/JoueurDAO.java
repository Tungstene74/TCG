package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import classeMetier.Joueur;



public class JoueurDAO extends DAO<Joueur>{
	private ResultSet rs;

	@Override
	public Joueur create(Joueur obj) throws SQLException {
			String sqlQuery = "INSERT INTO `joueur`(`identifiant`, `mdp`, `argent`, `NbPartiesG`, `NbPartiesJ`) "
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,obj.getIdentifiant());
			st3.setString(2,PasswordUtil.hashPassword(obj.getMbp()));
			st3.setString(3,Integer.toString(obj.getArgent()));
			st3.setString(4,Integer.toString(obj.getNbPartiesG()));
			st3.setString(5,Integer.toString(obj.getNbPartiesJ()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
			
			if (rs.next()) {
	            int id_joueur = rs.getInt(1); // La première colonne est l'ID généré
	            obj.setId_joueur(id_joueur);
	        }
			
		
		return obj;
	}
	
	public Joueur connection(String identifiant, String mdp) throws SQLException {
			String sqlQuery = "SELECT id_partie FROM `partie` "
					+ "WHERE identifiant=? AND mdp=?";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,identifiant);
			st.setString(2,PasswordUtil.hashPassword(mdp));
			rs = st.executeQuery();
		

		int id_joueur  = 0;
		int nbPartiesJ = 0;
		int money = 0;
		int nbPartiesG = 0;
		// Affichage du resultat
			while(rs.next()) {
				id_joueur  = Integer.parseInt(rs.getString("id_partie "));
				nbPartiesJ = Integer.parseInt(rs.getString("nbPartiesJ "));
				nbPartiesG = Integer.parseInt(rs.getString("nbPartiesG "));
				money = Integer.parseInt(rs.getString("argent "));				
			}
		
		
		HashMap<Integer, Integer> listepiece = new HashMap<Integer,Integer>();
		
		
			sqlQuery = "SELECT * FROM `possède` WHERE id_joueur=?";
			st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(id_joueur));
			rs = st.executeQuery();
		

		// Affichage du resultat

			while(rs.next()) {
				int id_piece  = Integer.parseInt(rs.getString("id_piece "));
				int nombre  = Integer.parseInt(rs.getString("nombre "));
				listepiece.put(id_piece, nombre);
				
			}
				
				
		return new Joueur(id_joueur, identifiant, mdp,  nbPartiesJ,  money, nbPartiesG,listepiece);
		
	}

	@Override
	public Joueur update(Joueur obj) throws SQLException {
			String sqlQuery = "UPDATE `joueur` "
					+ "SET ,`argent`=?,`NbPartiesG`=?,`NbPartiesJ`=? "
					+ "WHERE `id_joueur`=? AND `identifiant`=? AND `mdp`=?";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			st3.setString(1,Integer.toString(obj.getArgent()));
			st3.setString(2,Integer.toString(obj.getNbPartiesG()));
			st3.setString(3,Integer.toString(obj.getNbPartiesJ()));
			
			st3.setString(4,Integer.toString(obj.getId_joueur()));
			st3.setString(5,obj.getIdentifiant());
			st3.setString(6,PasswordUtil.hashPassword(obj.getMbp()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		return obj;
	}

	@Override
	public void delete(Joueur obj) throws SQLException {
			String sqlQuery = "DELETE FROM `joueur` WHERE WHERE `id_joueur`=? AND `identifiant`=? AND `mdp`=?";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_joueur()));
			st3.setString(2,obj.getIdentifiant());
			st3.setString(3,PasswordUtil.hashPassword(obj.getMbp()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
	}
		
		public void addPiece(int id_joueur,int id_piece,int nombre) throws SQLException {
				String sqlQuery = "INSERT INTO `possède`(`id_joueur`, `id_piece`, `nombre`) VALUES (?,?,?)";
				PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				st3.setString(1,Integer.toString(id_joueur));
				st3.setString(2,Integer.toString(id_piece));
				st3.setString(3,Integer.toString(nombre));
				st3.executeUpdate();
				rs = st3.getGeneratedKeys();
		}
		
		public void missPiece(int id_joueur,int id_piece,int nombre) throws SQLException {
				String sqlQuery = "UPDATE `possède` "
						+ "SET `nombre`=? "
						+ "WHERE `id_joueur`=? AND `id_piece`=?,";
				PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				
				st3.setString(2,Integer.toString(id_joueur));
				st3.setString(3,Integer.toString(id_piece));
				st3.setString(1,Integer.toString(nombre));

				st3.executeUpdate();
				rs = st3.getGeneratedKeys();
			}
		}
		
	
	


