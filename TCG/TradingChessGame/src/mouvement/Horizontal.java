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
		for(int i=1;i<=8;i++) {
			int[] pos= {i%8,y};
			piece=plateau.getPiece(i,y);
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
		
		return null;
	}

	@Override
	public void effet(Plateau plateau) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
