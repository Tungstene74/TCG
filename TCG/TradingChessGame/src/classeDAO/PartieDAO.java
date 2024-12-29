package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classeMetier.Partie;
import classeMetier.Piece;
import classeMetier.Pouvoir;

public class PartieDAO extends DAO<Partie>{
	private ResultSet rs;

	@Override
	public Partie create(Partie obj) { //à partir d'une partie renvois une nouvelle partie avec les paramettre de la base de donné + ça l'ajoute dans la base de donné 
		try {
			String sqlQuery = "INSERT INTO `partie`(`tour_joueur`, `id_deck`, `id_joueur`,`id_deck2`, `id_joueur2`) "
					+ "VALUES ('?','?','?','1','1')";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getTour_joueur()));
			st3.setString(2,Integer.toString(obj.getId_deck()));
			st3.setString(3,Integer.toString(obj.getId_joueur()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		try {
			String sqlQuery = "SELECT id_partie FROM `partie` WHERE tour_joueur='?' AND id_deck='?' AND id_joueur='?' AND id_deck2='1' AND id_joueur2 ='1';";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(obj.getTour_joueur()));
			st.setString(2,Integer.toString(obj.getId_deck()));
			st.setString(3,Integer.toString(obj.getId_joueur()));
			st.executeUpdate();
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		int id_partie  = 0;
		// Affichage du resultat
		try {
			while(rs.next()) {
				id_partie  = Integer.parseInt(rs.getString("id_partie "));
				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		obj.setId_partie(id_partie);
		obj.setId_joueur2(0);
		obj.setId_joueur2(0);
		
		return obj;
	}
	
	public Partie join(int id_partie,int id_joueur2,int id_deck2) { //à partir d'id renvois une nouvelle partie avec ça version dans la base de donné 
		try {
			String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?;";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(id_partie));
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		int id_deck  = 0;
		int id_joueur  = 0;
		int tour_joueur  = 0;
		// Affichage du resultat
		try {
			while(rs.next()) {
				id_deck  = Integer.parseInt(rs.getString("id_deck "));
				id_joueur  = Integer.parseInt(rs.getString("id_joueur "));
				tour_joueur  = Integer.parseInt(rs.getString("tour_joueur "));
				
				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		
		try {
			String sqlQuery = "UPDATE `partie` "
					+ "SET `id_deck2`=?,"
					+ "`id_joueur2`=? "
					+ "WHERE `id_partie`=?,";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(id_deck2));
			st3.setString(2,Integer.toString(id_joueur2));
			st3.setString(3,Integer.toString(id_partie));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		
		return new Partie(id_partie, tour_joueur, id_deck, id_joueur, id_deck2, id_joueur2);
	}

	@Override
	public Partie update(Partie obj) { //à partir d'une partie renvois une nouvelle partie avec les mise à jour de la base de donné 
		try {
			String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?;";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(obj.getId_partie()));
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		int id_deck  = 0;
		int id_joueur  = 0;
		int id_deck2  = 0;
		int id_joueur2  = 0;
		int tour_joueur  = 0;
		// Affichage du resultat
		try {
			while(rs.next()) {
				id_deck  = Integer.parseInt(rs.getString("id_deck "));
				id_joueur  = Integer.parseInt(rs.getString("id_joueur "));
				id_deck2  = Integer.parseInt(rs.getString("id_deck2 "));
				id_joueur2  = Integer.parseInt(rs.getString("id_joueur2 "));
				tour_joueur  = Integer.parseInt(rs.getString("tour_joueur "));
				
				
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		obj.setId_deck(id_deck);
		obj.setId_joueur(id_joueur);
		obj.setTour_joueur(tour_joueur);
		obj.setId_deck2(id_deck2);
		
		return new Partie(obj.getId_partie(), tour_joueur, id_deck, id_joueur, id_deck2, id_joueur2);
	}

	@Override
	public void delete(Partie obj) { //suprime la partie de la base de donné 
		try {
			String sqlQuery = "DELETE FROM `partie` WHERE id_partie=?";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_partie()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		
	}

}
