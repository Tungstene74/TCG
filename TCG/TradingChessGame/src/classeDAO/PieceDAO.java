package classeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classeMetier.Piece;
import classeMetier.Pouvoir;

public class PieceDAO extends DAO<Piece>{
	private ResultSet rs;

	@Override
	public Piece create(Piece obj) {
		// les joueur ne créer pas de nouvelle pièce 
		return null;
	}

	@Override
	public Piece update(Piece obj) {
		// les joueur ne modifie pas de  pièce 
		return null;
	}

	@Override
	public void delete(Piece obj) {
		// les joueur ne suprime pas de pièce 
		
	}
	
	public Piece find(String nom) {
		try {
			String sqlQuery = "SELECT * FROM `pièces` WHERE nom=?;";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			st.setString(1,nom);
			rs = st.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("Erreur requete SQLvvvvvv");
			e.printStackTrace();
		}

		// Affichage du resultat
		try {
			while(rs.next()) {
				int idPiece  = Integer.parseInt(rs.getString("idPiece "));
				String nom1  = rs.getString("nom");
				String mouvements  = rs.getString("mouvements");
				String pouvoir  = rs.getString("pouvoir");
				String image  = rs.getString("image");
				
				Pouvoir pouvoir1 = new Pouvoir(pouvoir);
				
				
				return new Piece(idPiece,nom1,null, null, image, idPiece, idPiece);
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		return null;
		
	}

		
		
	}
	


