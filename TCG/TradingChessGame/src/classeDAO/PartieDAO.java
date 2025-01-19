package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classeMetier.Deck;
import classeMetier.Joueur;
import classeMetier.Partie;
import classeMetier.Piece;
import classeMetier.Pouvoir;

public class PartieDAO extends DAO<Partie>{
	private ResultSet rs;

	@Override
	//on creer la partie en tant que joueur 1, et on creer joueur 2 à l'occasion
	public Partie create(Partie obj) throws SQLException { //à partir d'une partie renvois une nouvelle partie avec les paramettre de la base de donné + ça l'ajoute dans la base de donné 
		String sqlQuery = "INSERT INTO `partie`(`id_partie`, `tour_joueur`, `id_deck`, `id_joueur`,`id_deck2`, `id_joueur2`) "
				+ "VALUES (?,?,?,?,'1','1')";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);//obj.getId_partie()
		st3.setString(1,Integer.toString(obj.getId_partie()));
		st3.setString(2,Integer.toString(obj.getTour()));
		System.out.println(obj.getdeck1()); // ici print 
		st3.setString(3,Integer.toString(obj.getdeck1().getId_deck()));
		st3.setString(4,Integer.toString(obj.getjoueur1().getId_joueur()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();
		
		//JoueurDAO joueurdao=new JoueurDAO();
		//joueurdao.open();
		//Joueur joueur2= joueurdao.creerjoueur(0);
		//Deck deck2= joueur2.mainDeck();
		obj.setjoueur2(null);
		obj.setdeck2(null);;

		return obj;
	}
	
	//on rejoint la partie de joueur 1 en tant que joueur 2, on récupère les info de joueur 1
	public Partie join(int id_partie,Joueur joueur2) throws SQLException { //à partir d'id renvois une nouvelle partie avec ça version dans la base de donné 
		String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?";
		PreparedStatement st = connect.prepareStatement(sqlQuery);
		st.setString(1,Integer.toString(id_partie));
		rs = st.executeQuery();

		int id_deck1  = 0;
		int id_joueur1  = 0;
		int tour_joueur  = 0;
		// Affichage du resultat
		while(rs.next()) {
			id_deck1  = Integer.parseInt(rs.getString("id_deck"));
			id_joueur1  = Integer.parseInt(rs.getString("id_joueur"));
			tour_joueur  = Integer.parseInt(rs.getString("tour_joueur"));
		}

		sqlQuery = "UPDATE `partie` "
				+ "SET `id_deck2`=?,"
				+ "`id_joueur2`=? "
				+ "WHERE `id_partie`=?";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(joueur2.mainDeck().getId_deck()));
		st3.setString(2,Integer.toString(joueur2.getId_joueur()));
		st3.setString(3,Integer.toString(id_partie));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();
		
		JoueurDAO joueurdao=new JoueurDAO();
		joueurdao.open();
		Joueur joueur1= joueurdao.creerjoueur(id_joueur1);
		Deck deck1= joueur1.mainDeck();
		
		Partie partie=new Partie(joueur1, id_partie);
		partie.setdeck1(deck1);
		
		partie.Join(joueur2, id_partie);
		Deck deck2= joueur2.mainDeck();
		partie.setdeck2(deck2);
		
		return partie;
	}

	//on attend le joueur 2 en tant que joueur 1, on récupère quand il arrive les info de joueur 2 dans la bdd
	@Override
	public Partie update(Partie obj) throws SQLException { //à partir d'une partie renvois une nouvelle partie avec les mise à jour de la base de donné 
		String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?";
		PreparedStatement st = connect.prepareStatement(sqlQuery);
		st.setString(1,Integer.toString(obj.getId_partie()));
		rs = st.executeQuery();


		int id_deck1  = 0;
		int id_joueur1  = 0;
		int id_deck2  = 0;
		int id_joueur2  = 0;
		int tour_joueur  = 0;
		// Affichage du resultat
		while(rs.next()) {
			//id_deck1  = Integer.parseInt(rs.getString("id_deck"));
			//id_joueur1  = Integer.parseInt(rs.getString("id_joueur"));
			id_deck2  = Integer.parseInt(rs.getString("id_deck2"));
			id_joueur2  = Integer.parseInt(rs.getString("id_joueur2"));
			//tour_joueur  = Integer.parseInt(rs.getString("tour_joueur"));
		}
		if (id_joueur2 != 1 && id_joueur2 != 0) {
		JoueurDAO joueurdao=new JoueurDAO();
		joueurdao.open();
		Joueur joueur2= joueurdao.creerjoueur(id_joueur2);
		Deck deck2= joueur2.mainDeck();
		
		obj.setdeck2(deck2);
		obj.setjoueur2(joueur2);
		}else {
			return null;
		}
		/*
		obj.setId_deck(id_deck);
		obj.setId_joueur(id_joueur);
		obj.setTour_joueur(tour_joueur);
		obj.setId_joueur2(id_joueur2);
		obj.setId_deck2(id_deck2);
		*/

		return obj;
	}
	
	public Partie tours(Partie obj) throws SQLException {
		String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?";
		PreparedStatement st = connect.prepareStatement(sqlQuery);
		st.setString(1,Integer.toString(obj.getId_partie()));
		rs = st.executeQuery();

		int tour_joueur  = 0;
		// Affichage du resultat
		while(rs.next()) {
			
			tour_joueur  = Integer.parseInt(rs.getString("tour_joueur"));
		}
		obj.setTour(tour_joueur);

		return obj;
	}
	
	public Partie tours_plus(Partie obj) throws SQLException {
		String sqlQuery = "SELECT * FROM `partie` WHERE id_partie=?";
		PreparedStatement st = connect.prepareStatement(sqlQuery);
		st.setString(1,Integer.toString(obj.getId_partie()));
		rs = st.executeQuery();

		int tour_joueur  = 0;
		// Affichage du resultat
		while(rs.next()) {
			
			tour_joueur  = Integer.parseInt(rs.getString("tour_joueur"));
		}
		
		sqlQuery = "UPDATE `partie` "
				+ "SET `tour_joueur`=?,"
				+ "WHERE `id_partie`=?";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(tour_joueur+1));
		st3.setString(2,Integer.toString(obj.getId_partie()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();
		
		return obj;
	}
	

	@Override
	public void delete(Partie obj)throws SQLException  { //suprime la partie de la base de donné 
		String sqlQuery = "DELETE FROM `partie` WHERE id_partie=?";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(obj.getId_partie()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();

	}

}
