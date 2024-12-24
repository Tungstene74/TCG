package classeMetier;

import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
	//private ArrayList<Piece> listepieces;
	private HashMap<int[], Piece> dictCoordPiece = new HashMap<>();
	//#dilemme est-ce que je met les co des pieces en temps qu'attribut des pieces au bien en 
	//tant que clef pour les trouver dans le hashmap
	//à mon avis c'est mieux de faire avec le hashmap car la recherche sera instantannée 
	
	public Plateau() {
		ArrayList<Piece> listepieces = new ArrayList<Piece>();
	}
	
	public void add(Piece piece,int x,int y) {
		if (x > 8 | x<1 | y > 8 | y<1) {
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			int[] co = {x,y};
			dictCoordPiece.put(co,piece);
		}
	}
	
	public void supp(int x,int y) {
		int[] co = {x,y};
		dictCoordPiece.remove(co);
	}
	
	public void deplace(int x,int y, int new_x, int new_y) {
		if (new_x > 8 | new_x<1 | new_y > 8 | new_y<1) {
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
		int[] co = {x,y};
		int[] new_co = {new_x,new_y};
		Piece piece=dictCoordPiece.remove(co);
		dictCoordPiece.put(new_co,piece);
		}
	}
	
	/*
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
	*/
}
