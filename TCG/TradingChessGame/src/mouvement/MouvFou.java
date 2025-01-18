package mouvement;

import java.util.ArrayList;
import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;

public class MouvFou extends Mouvement {
	
	@Override
	public Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau) {
		int x=piece.getX();
		int y=piece.getY();
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		Boolean condition = false; //au moins une condition doit être respecté
		ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		
		if (piece.mangeableOuNull(plateau,new_x,new_y) & (new_x-x==new_y-y | new_x+new_y==x+y)) {
			condition=true;
			if (new_x>x & new_y>y) {
				for (int i=1;i<=7;i++) { 
					if (new_x==x+i & new_y==y+i) 
						break;
					int[] co = {x+i,y+i};
					listeCoord.add(co);
				}
			}
			if (new_x<x & new_y>y) {
				for (int i=1;i<=7;i++) { 
					if (new_x==x-i & new_y==y+i) 
						break;
					int[] co = {x-i,y+i};
					listeCoord.add(co);
				}
			}
			if (new_x>x & new_y<y) {
				for (int i=1;i<=7;i++) {
					if (new_x==x+i & new_y==y-i) 
						break;
					int[] co = {x+i,y-i};
					listeCoord.add(co);
				}
			}
			if (new_x<x & new_y<y) {
				for (int i=1;i<=7;i++) {
					if (new_x==x-i & new_y==y-i) 
						break;
					int[] co = {x-i,y-i};
					listeCoord.add(co);
				}
			}
			if (plateau.nbPiece(listeCoord)==0 & condition==true) { //on compte le nombre de piece entre x et new_x, ça doit être 0
				b=true;
			}
		}
		return b;
	}


	@Override
	public void effet(int x, int y, int new_x, int new_y,Plateau plateau) {
		// TODO Auto-generated method stub
		//plateau.deplace(piece.getX(), piece.getY(), new_x, new_y);
	}
	
}