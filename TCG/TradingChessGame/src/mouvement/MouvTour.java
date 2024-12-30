package mouvement;

import java.util.ArrayList;
import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;

public class MouvTour implements Mouvement {
	
	@Override
	public Boolean estPossible(Piece piece, int new_x, int new_y, Plateau plateau) {
		int x=piece.getX();
		int y=piece.getY();
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		Boolean condition = false; //au moins une condition doit être respecté
		ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		
		if (piece.mangeableOuNull(plateau,new_x,new_y)) {
			if (new_x>x & y==new_y) {
				for (int i=x+1;i<new_x;i++) { //on va de x exclu jusqu'au nouveau x exclue, car on peut manger, mais il faut pas compter notre piece
					int[] co = {i,y};
					listeCoord.add(co);
				}
				condition=true;
			}
			if (new_x<x & y==new_y) {
				for (int i=x-1;i>new_x;i--) { 
					int[] co = {i,y};
					listeCoord.add(co);
				}
				condition=true;
			}
			if (new_y>y & x==new_x) {
				for (int i=y+1;i<new_y;i++) {
					int[] co = {x,i};
					listeCoord.add(co);
				}
				condition=true;
			}
			if (new_y<y & x==new_x) {
				for (int i=y-1;i>new_x;i--) {
					int[] co = {x,i};
					listeCoord.add(co);
				}
				condition=true;
			}
			if (plateau.nbPiece(listeCoord)==0 & condition==true) { //on compte le nombre de piece entre x et new_x, ça doit être 0
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
