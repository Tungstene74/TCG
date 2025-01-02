package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classeMetier.Deck;
import classeMetier.Piece;

public class DeckDAO extends DAO<Deck> {
	private ResultSet rs;

	@Override
	public Deck create(Deck obj) throws SQLException {
		String sqlQuery = "INSERT INTO `deck`( `nom`, `id_joueur`, `deckprincipal`) "
				+ "VALUES (?,?,?)";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,obj.getNom());
		st3.setString(2,Integer.toString(obj.getId_joueur()));
		st3.setString(3,obj.getDeckprincipal().toString());
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();

		int id_deck =0;

		if (rs.next()) {
			id_deck = rs.getInt(1); // La première colonne est l'ID généré
			obj.setId_deck(id_deck);
		}		
		for(Piece p : obj.getListepieces()){
			sqlQuery = "INSERT INTO `contient`(`id_piece`, `id_deck`, `id_joueur`) "
					+ "VALUES (?,?,?)";
			st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(id_deck));
			st3.setString(2,Integer.toString(p.getIdPiece()));
			st3.setString(3,Integer.toString(obj.getId_joueur()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		}

		return obj;
	}

	@Override
	public Deck update(Deck obj) throws SQLException {
		String sqlQuery = "UPDATE `deck` "
				+ "SET `nom`=?,`deckprincipal`=? "
				+ "WHERE `id_deck`=? AND `id_joueur`=?";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,obj.getNom());
		st3.setString(2,Integer.toString(obj.getDeckprincipal() ? 1 : 0));
		st3.setString(3,Integer.toString(obj.getId_deck()));
		st3.setString(4,Integer.toString(obj.getId_joueur()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();

		sqlQuery = "DELETE FROM `contient` WHERE `id_deck`=? AND `id_joueur`=?";
		st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(obj.getId_deck()));
		st3.setString(2,Integer.toString(obj.getId_joueur()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();

		for(Piece p : obj.getListepieces()){
			sqlQuery = "INSERT INTO `contient`(`id_piece`, `id_deck`, `id_joueur`) "
					+ "VALUES (?,?,?)";
			st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_deck()));
			st3.setString(2,Integer.toString(p.getIdPiece()));
			st3.setString(3,Integer.toString(obj.getId_joueur()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		}


		return obj;
	}

	public ArrayList<Deck> read(int Id_joueur) throws SQLException {
		String sqlQuery = "SELECT * FROM `deck`, `contient`"
				+ "WHERE deck.id_joueur= contient.id_joueur AND deck.id_deck=contient.id_deck"
				+ "AND deck.id_joueur= ?";
		PreparedStatement st = connect.prepareStatement(sqlQuery);
		st.setString(1,Integer.toString(Id_joueur));
		rs = st.executeQuery();

		ArrayList<Deck> listeDeck = new ArrayList<Deck>();

		int id_deck  = 0;
		String nom ="";
		int id_joueur  = 0;
		int id_piece  = 0;
		Boolean deckprincipal  = null;
		int id_deckPast = -1;
		Deck D = null;
		// Affichage du resultat
		while(rs.next()) {			
			id_deck  = Integer.parseInt(rs.getString("id_deck"));
			nom = rs.getString("nom");
			id_joueur  = Integer.parseInt(rs.getString("id_joueur"));
			deckprincipal  = rs.getInt("deckprincipal") == 1;
			id_piece  = Integer.parseInt(rs.getString("id_piece"));

			
			if (id_deck != id_deckPast) {
				if (D != null) {
					listeDeck.add(D);
				}
				D = new Deck(nom, deckprincipal, new ArrayList<Piece>(), id_joueur);
			}
			
			Piece P = Méthode_pour_faire_les_pèce_de_floca(id_piece);
			
			D.AddPiece(P);
			
			id_deckPast = id_deck;

		}


		return listeDeck;
	}



	@Override
	public void delete(Deck obj) throws SQLException {
		String sqlQuery = "DELETE FROM `deck` WHERE `id_deck`=? AND `id_joueur`=?";
		PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(obj.getId_deck()));
		st3.setString(2,Integer.toString(obj.getId_joueur()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();

		sqlQuery = "DELETE FROM `contient` WHERE `id_deck`=? AND `id_joueur`=?";
		st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1,Integer.toString(obj.getId_deck()));
		st3.setString(2,Integer.toString(obj.getId_joueur()));
		st3.executeUpdate();
		rs = st3.getGeneratedKeys();


	}

}
