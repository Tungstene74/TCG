package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classeMetier.Piece;
import classeMetier.Plateau;

public class PlateauDAO extends DAO<Plateau>{
	private ResultSet rs;

	@Override
	public Plateau create(Plateau obj) {
		for (int i = 0; i < obj.getListepieces().size(); i++) {
			Piece piece = obj.getListepieces().get(i);
			try {
				String sqlQuery = "INSERT INTO `variable_partie`(`id_piece`, `id_partie`, `id_piece_partie`, `Couleur`, `x`, `y`, `pouvoir_utilise`) "
						+ "VALUES (?,?,?,?,?,?,?)";
				PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				st3.setString(1,Integer.toString(piece.getIdPiece()));
				st3.setString(2,Integer.toString(obj.getId_partie()));
				st3.setString(3,Integer.toString(i));
				st3.setString(4,piece.getCouleur());
				st3.setString(5,Integer.toString(piece.getX()));
				st3.setString(6,Integer.toString(piece.getY()));
				st3.setString(7,Integer.toString(0));
				rs = st3.getGeneratedKeys();
			}
			catch(SQLException e) {
				System.err.println("Erreur requete SQL");
				e.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public Plateau update(Plateau obj) {
		for (int i = 0; i < obj.getListepieces().size(); i++) {
			try {
				String sqlQuery = "SELECT * FROM `variable_partie` WHERE id_piece_partie=?;";
				PreparedStatement st = connect.prepareStatement(sqlQuery);
				st.setString(1,Integer.toString(obj.getId_partie()));
				rs = st.executeQuery();
			}
			catch(SQLException e) {
				System.err.println("Erreur requete SQLvvvvvv");
				e.printStackTrace();
			}

			int apparait  = 0;

			// Affichage du resultat
			try {
				while(rs.next()) {
					apparait = 1;
				}
			}
			catch(SQLException e) {
				System.err.println("Erreur de parcours de ResultSet");
				e.printStackTrace();
			}
			Piece piece = obj.getListepieces().get(i);
			if (apparait == 0) {
				try {
					String sqlQuery = "INSERT INTO `variable_partie`(`id_piece`, `id_partie`, `id_piece_partie`, `Couleur`, `x`, `y`, `pouvoir_utilise`) "
							+ "VALUES (?,?,?,?,?,?,?)";
					PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
					st3.setString(1,Integer.toString(piece.getIdPiece()));
					st3.setString(2,Integer.toString(obj.getId_partie()));
					st3.setString(3,Integer.toString(i));
					st3.setString(4,piece.getCouleur());
					st3.setString(5,Integer.toString(piece.getX()));
					st3.setString(6,Integer.toString(piece.getY()));
					st3.setString(7,Integer.toString(0));
					rs = st3.getGeneratedKeys();
				}
				catch(SQLException e) {
					System.err.println("Erreur requete SQL");
					e.printStackTrace();
				}
			}else if (apparait == 1) {
				try {
					String sqlQuery = "UPDATE `variable_partie` SET `id_piece`=?,`id_partie`=?,`Couleur`=?,`x`=?,`y`=?,`pouvoir_utilise`=? "
							+ "WHERE `id_piece_partie`=?";
					PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
					st3.setString(1,Integer.toString(piece.getIdPiece()));
					st3.setString(2,Integer.toString(obj.getId_partie()));
					st3.setString(3,piece.getCouleur());
					st3.setString(4,Integer.toString(piece.getX()));
					st3.setString(5,Integer.toString(piece.getY()));
					st3.setString(6,Integer.toString(0));
					st3.setString(7,Integer.toString(i));
					rs = st3.getGeneratedKeys();
				}
				catch(SQLException e) {
					System.err.println("Erreur requete SQL");
					e.printStackTrace();
				}
			}
		}
		return obj;
	}
	
	public void updateMoi(Plateau obj) {
		ArrayList<Piece> listepieces = new ArrayList<Piece>();
		try {
			String sqlQuery = "SELECT * FROM `variable_partie` "
					+ "WHERE id_partie=? "
					+ "ORDER BY id_piece_partie";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(obj.getId_partie()));
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}
		// Affichage du resultat
		try {
			while(rs.next()) {
				int id_piece  = Integer.parseInt(rs.getString("id_piece "));
				String Couleur  = rs.getString("Couleur ");
				int x  = Integer.parseInt(rs.getString("x "));
				int y  = Integer.parseInt(rs.getString("y "));
				listepieces.add(Méthode_pour_faire_les_pèce_de_floca(id_piece,Couleur,x,y));
				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		obj.setListepieces(listepieces);
	}

	@Override
	public void delete(Plateau obj) {
		try {
			String sqlQuery = "DELETE FROM `variable_partie` WHERE id_partie=?";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_partie()));
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
	}

}
