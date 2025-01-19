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
	public Plateau create(Plateau obj) throws SQLException {
		for (int i = 0; i < obj.getListepieces().size()-1; i++) {
			Piece piece = obj.getListepieces().get(i);
				String sqlQuery = "INSERT INTO `variable_partie`(`id_piece`, `id_partie`, `id_piece_partie`, `Couleur`, `x`, `y`, `pouvoir_utilise`) "
						+ "VALUES (?,?,?,?,?,?,?)";
				PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				System.out.println(piece.getIdPiece());
				System.out.println(obj.getId_partie());
				System.out.println(i);
				st3.setString(1,Integer.toString(piece.getIdPiece()));
				st3.setString(2,Integer.toString(obj.getId_partie()));
				st3.setString(3,Integer.toString(i));
				st3.setString(4,piece.getCouleur());
				st3.setString(5,Integer.toString(piece.getX()));
				st3.setString(6,Integer.toString(piece.getY()));
				st3.setString(7,Integer.toString(0));
				st3.executeUpdate();
				rs = st3.getGeneratedKeys();
		}
		return obj;
	}

	@Override
	public Plateau update(Plateau obj) throws SQLException {
		for (int i = 0; i < obj.getListepieces().size(); i++) {
				Piece piece = obj.getListepieces().get(i);
				String sqlQuery = "SELECT * FROM `variable_partie` WHERE id_partie= ? AND id_piece_partie=?;";
				PreparedStatement st = connect.prepareStatement(sqlQuery);
				st.setString(1,Integer.toString(obj.getId_partie()));
				st.setString(2,Integer.toString(piece.getIdPiecePartie()));
				rs = st.executeQuery();
			

			int apparait  = 0;

			// Affichage du resultat
				while(rs.next()) {
					apparait = 1;
				}
			
			
			if (apparait == 0) {
					sqlQuery = "INSERT INTO `variable_partie`(`id_piece`, `id_partie`, `id_piece_partie`, `Couleur`, `x`, `y`, `pouvoir_utilise`) "
							+ "VALUES (?,?,?,?,?,?,?)";
					PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
					st3.setString(1,Integer.toString(piece.getIdPiece()));
					st3.setString(2,Integer.toString(obj.getId_partie()));
					st3.setString(3,Integer.toString(piece.getIdPiecePartie()));
					st3.setString(4,piece.getCouleur());
					st3.setString(5,Integer.toString(piece.getX()));
					st3.setString(6,Integer.toString(piece.getY()));
					st3.setString(7,Integer.toString(0));
					st3.executeUpdate();
					rs = st3.getGeneratedKeys();
				
			}else if (apparait == 1) {
					sqlQuery = "UPDATE `variable_partie` SET `id_piece`=?,`id_partie`=?,`Couleur`=?,`x`=?,`y`=?,`pouvoir_utilise`=? "
							+ "WHERE `id_piece_partie`=?";
					PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
					st3.setString(1,Integer.toString(piece.getIdPiece()));
					st3.setString(2,Integer.toString(obj.getId_partie()));
					st3.setString(3,piece.getCouleur());
					st3.setString(4,Integer.toString(piece.getX()));
					st3.setString(5,Integer.toString(piece.getY()));
					st3.setString(6,Integer.toString(0));
					st3.setString(7,Integer.toString(piece.getIdPiecePartie()));
					st3.executeUpdate();
					rs = st3.getGeneratedKeys();
				
			}
		}
		return obj;
	}
	
	public void updateMoi(Plateau obj) throws SQLException {
		ArrayList<Piece> listepieces = new ArrayList<Piece>();
			String sqlQuery = "SELECT * FROM `variable_partie` "
					+ "WHERE id_partie=? "
					+ "ORDER BY id_piece_partie";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,Integer.toString(obj.getId_partie()));
			rs = st.executeQuery();
		
		// Affichage du resultat
			while(rs.next()) {
				int id_piece_partie = Integer.parseInt(rs.getString("id_piece_partie"));
				Piece piece=obj.getPieceIdPiecePartie(id_piece_partie);
				int x=piece.getX();
				int y=piece.getY();
				//int id_piece  = Integer.parseInt(rs.getString("id_piece"));
				//String Couleur  = rs.getString("Couleur");
				int new_x  = Integer.parseInt(rs.getString("x"));
				int new_y  = Integer.parseInt(rs.getString("y"));
				System.out.println(id_piece_partie);
				System.out.println(new_x);
				System.out.println(new_y);

				if (x!=new_x | y!=new_y) {
					obj.deplace(piece, new_x, new_y);
				}
				//listepieces.add(Méthode_pour_faire_les_pèce_de_floca(id_piece,Couleur,x,y));			
			}
		
		//obj.setListepieces(listepieces);
	}

	@Override
	public void delete(Plateau obj) throws SQLException {
			String sqlQuery = "DELETE FROM `variable_partie` WHERE id_partie=?";
			PreparedStatement st3 = connect.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			st3.setString(1,Integer.toString(obj.getId_partie()));
			st3.executeUpdate();
			rs = st3.getGeneratedKeys();
		
	}

}
