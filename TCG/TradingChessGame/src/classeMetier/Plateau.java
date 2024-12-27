package classeMetier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Plateau {
	private ArrayList<Piece> listepieces;
	//private HashMap<int[], Piece> dictCoordPiece = new HashMap<>();
	//#dilemme est-ce que je met les co des pieces en temps qu'attribut des pieces au bien en 
	//tant que clef pour les trouver dans le hashmap
	//à mon avis c'est mieux de faire avec le hashmap car la recherche sera instantannée 
	
	public Plateau() {
		listepieces = new ArrayList<Piece>();
	}
	
	public ArrayList<ArrayList<Piece>> Matrice() {
		ArrayList<ArrayList<Piece>> matrice = new ArrayList<ArrayList<Piece>>();
		Piece piece = null;
		for (int y=7;y>=0;y--) {
			ArrayList<Piece> ligne = new ArrayList<Piece>();
			for (int x=0;x<=7;x++) {
				piece = this.getPiece(x, y);
				ligne.add(piece);
			}
			matrice.add(ligne);
		}
		return matrice;
	}
	
	public void add(Piece piece) {
		listepieces.add(piece);
	}
	
	public void add(Piece piece,int x,int y) {
		if (x > 8 | x<1 | y > 8 | y<1) {
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			piece.setX(x);
			piece.setY(y);
			listepieces.add(piece);
			//dictCoordPiece.put(co,piece);
		}
	}
	
	public Piece supp(int x,int y) {
		Piece piece = this.getPiece(x, y);
		listepieces.remove(piece);
		//dictCoordPiece.remove(co);
		return piece;
	}
	
	public void supp(Piece piece) {
		listepieces.remove(piece);
	}
	
	public void deplace(int x,int y, int new_x, int new_y) {
		if (new_x > 7 | new_x<0 | new_y > 7 | new_y<0) { //le plateau va de 0 à 7
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			Piece piece_manger = this.getPiece(new_x,new_y); 
			if (piece_manger!=null) {
				this.supp(piece_manger);
			}
			Piece piece = this.getPiece(x,y);
			piece.setX(new_x);
			piece.setY(new_y);
			//this.add(piece, new_x, new_y);
		
		//Piece piece=dictCoordPiece.remove(co);
		//dictCoordPiece.put(new_co,piece);
		}
	}
	
	/*
	public int[] getCoord(Piece piece) {
		Set<int[]> coordSet =dictCoordPiece.keySet();
		int[] coord=coordSet
		return CoordSet.
		}
	}*/
	
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

	public int nbPiece(ArrayList<int[]> listCoord) {
		int nb=0;
		Piece piece=null;
		for(int[] coord : listCoord) {
			int x=coord[0];
			int y=coord[1];
			piece=this.getPiece(x, y);
			if (piece!=null) {
				nb+=1;
			}
		}
		return nb;
	}
	
	public int creePiece(int id_piece) {
		switch (id_piece) {
	    case 1: add(new Tour());
	}
	
}
