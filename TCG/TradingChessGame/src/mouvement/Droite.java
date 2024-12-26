package mouvement;

import java.util.ArrayList;

import classeMetier.*;

public class Droite implements Mouvement {
	
	@Override
	public Boolean estPossible(int x, int y, int new_x, int new_y, Plateau plateau) {
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		for (int i=x;i<=new_x;i++) {
			int[] co = {i,y};
			listeCoord.add(co);
		}
		if (plateau.nbPiece(listeCoord)==0) {
			b=true;
		}
		return b;
	}

	@Override
	public void effet(int x, int y, int new_x, int new_y,Plateau plateau) {
		// TODO Auto-generated method stub
		plateau.deplace(x, y, new_x, new_y);
	}

	
	
	

}