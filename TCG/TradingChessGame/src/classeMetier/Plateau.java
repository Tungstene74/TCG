package classeMetier;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
	private ArrayList<Piece> listepieces;
	private HashMap<int[], Piece> dictCoordPiece = new HashMap<>();
	//#dilemme est-ce que je met les co des pieces en temps qu'attribut des pieces au bien en 
	//tant que clef pour les trouver dans le hashmap
	//à mon avis c'est mieux de faire avec le hashmap car la recherche sera instantannée :)
	
	public Plateau() {
		ArrayList<Piece> listepieces = new ArrayList<Piece>();
	}
	
	public void add(Piece piece) {
		listepieces.add(piece);
	}
	
	public Piece getPiece(int x, int y) {
		Piece pieceCherche=null;
		for(Piece piece : listepieces) {
			if (piece.getX()==x && piece.getY()==y) {
				pieceCherche=piece;
				break;
			}
		}
		return pieceCherche;
	}
}
