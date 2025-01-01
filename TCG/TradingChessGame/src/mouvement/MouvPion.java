package mouvement;

import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;

public class MouvPion implements Mouvement{
	@Override
	public Boolean estPossible(Piece piece, int new_x, int new_y, Plateau plateau) {
		int x=piece.getX();
		int y=piece.getY();
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		//ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		Piece pieceMangee=plateau.getPiece(new_x, new_y);
		
		if ((piece.getCouleur()=="blanc" & new_y==y+1) | (piece.getCouleur()=="noir" & new_y==y-1))  { 
			//si le pion est blanc, il va d'une case en haut, si il est noir il va d'une case en bas

			if (new_x==x | pieceMangee==null) {
				//si il n'y a pas de piece devant, c'est bon
				b=true;
			}

			if (new_x==x+1 | new_x==x-1 | pieceMangee!=null) {
				if (pieceMangee.getCouleur()!=piece.getCouleur()) { //si on prend une piece de couleur differente c'est bon
					b=true;
				}
			}
		}

		if (piece.getCouleur()=="blanc" & new_y==y+2 & y==1) {//si on pars du début et qu'on se déplace de 2 cases
			if (plateau.getPiece(x, y+1)==null & pieceMangee==null) { //si il n'y a pas de pieces
				b=true;
			}
		}

		if (piece.getCouleur()=="noir" & new_y==y-2 & y==6) { //pareil
			if (plateau.getPiece(x, y-1)==null & pieceMangee==null) {
				b=true;
			}
		}
		return b;
	}
	
	@Override
	public void effet(Piece piece, int new_x, int new_y,Plateau plateau) {
		// TODO Auto-generated method stub
		plateau.deplace(piece.getX(), piece.getY(), new_x, new_y);
	}
	
}
