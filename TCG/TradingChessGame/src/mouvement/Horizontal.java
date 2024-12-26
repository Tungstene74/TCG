package mouvement;

import java.util.ArrayList;

import classeMetier.*;

public class Horizontal implements Mouvement {
	
	@Override
	public ArrayList<int[]> casesAteignables(Plateau plateau, Piece piece) {
		// TODO Auto-generated method stub
		ArrayList<int[]> listeCoord = new ArrayList<int[]>();
		int x=piece.getX();
		int y=piece.getY();
		int[] test= {1,2};
		for(int i=0;i<=7;i++) { //on répète autant de fois qu'il y a de cases
			int[] pos= {i%8,y}; //à 8 on retourne à 0
			piece=plateau.getPiece(i,y); //on prend la valeur de la case
			if (i!=x & plateau.getPiece(i,y)!=null ) {
				listeCoord.add(pos);
			}
			//listeCoord ({i%8,y});
		}
		return null;
	}
	
	@Override
	public Boolean estPossible(int x, int y, Plateau plateau) {
		// TODO Auto-generated method stub
		Arrayliste<int[]> listCoord= new Arrayliste<int[]>();
		for (int i=x;i<=7;i++) {
			
		}
		return null;
	}

	@Override
	public void effet(Plateau plateau) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
