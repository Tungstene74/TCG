package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classeMetier.Joueur;



public class JoueurDAO extends DAO<Joueur>{
	private ResultSet rs;

	@Override
	public Joueur create(Joueur obj) {
		try {
			String sqlQuery = "INSERT INTO `joueur`(`identifiant`, `mdp`, `argent`, `NbPartiesG`, `NbPartiesJ`) "
					+ "VALUES ('?','?','?','?','?')";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,obj.getIdentifiant());
			st3.setString(2,PasswordUtil.hashPassword(obj.getMbp()));
			st3.setString(3,Integer.toString(obj.getArgent()));
			st3.setString(4,Integer.toString(obj.getNbPartiesG()));
			st3.setString(5,Integer.toString(obj.getNbPartiesJ()));
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		try {
			String sqlQuery = "SELECT id_partie FROM `partie` "
					+ "WHERE identifiant='?' AND mdp='?' AND argent='?' AND NbPartiesG='1' AND NbPartiesJ ='1';";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,obj.getIdentifiant());
			st.setString(2,PasswordUtil.hashPassword(obj.getMbp()));
			st.setString(3,Integer.toString(obj.getArgent()));
			st.setString(4,Integer.toString(obj.getNbPartiesG()));
			st.setString(5,Integer.toString(obj.getNbPartiesJ()));
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		int id_joueur  = 0;
		// Affichage du resultat
		try {
			while(rs.next()) {
				id_joueur  = Integer.parseInt(rs.getString("id_partie "));
				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		obj.setId_joueur(id_joueur);
		return obj;
	}
	
	public Joueur connection(String identifiant, String mdp) {
		try {
			String sqlQuery = "SELECT id_partie FROM `partie` "
					+ "WHERE identifiant='?' AND mdp='?'";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,identifiant);
			st.setString(2,PasswordUtil.hashPassword(mdp));
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		int id_joueur  = 0;
		int nbPartiesJ = 0;
		int money = 0;
		int nbPartiesG = 0;
		// Affichage du resultat
		try {
			while(rs.next()) {
				id_joueur  = Integer.parseInt(rs.getString("id_partie "));
				nbPartiesJ = Integer.parseInt(rs.getString("nbPartiesJ "));
				nbPartiesG = Integer.parseInt(rs.getString("nbPartiesG "));
				money = Integer.parseInt(rs.getString("argent "));				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		return new Joueur(id_joueur, identifiant, mdp,  nbPartiesJ,  money, nbPartiesG);
		
	}

	@Override
	public Joueur update(Joueur obj) {
		try {
			String sqlQuery = "UPDATE `joueur` "
					+ "SET ,`argent`='?',`NbPartiesG`='?',`NbPartiesJ`='?' "
					+ "WHERE `id_joueur`='?' AND `identifiant`='?' AND `mdp`='?'";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			st3.setString(1,Integer.toString(obj.getArgent()));
			st3.setString(2,Integer.toString(obj.getNbPartiesG()));
			st3.setString(3,Integer.toString(obj.getNbPartiesJ()));
			
			st3.setString(1,Integer.toString(obj.getId_joueur()));
			st3.setString(2,obj.getIdentifiant());
			st3.setString(3,PasswordUtil.hashPassword(obj.getMbp()));
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Joueur obj) {
		try {
			String sqlQuery = "DELETE FROM `joueur` WHERE WHERE `id_joueur`='?' AND `identifiant`='?' AND `mdp`='?'";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_joueur()));
			st3.setString(2,obj.getIdentifiant());
			st3.setString(3,PasswordUtil.hashPassword(obj.getMbp()));
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		
	}
	
	

}
