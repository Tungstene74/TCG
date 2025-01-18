package mouvement;

import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;
import pieces.Roi;

public class MouvRoi extends Mouvement{
	//Boolean roque;
	
	@Override
	public Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau) {
		int x=piece.getX();
		int y=piece.getY();
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		//ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		
		if (piece.mangeableOuNull(plateau,new_x,new_y)) {
			if ((new_x==x | new_x==x-1 | new_x==x+1) & (new_y==y+1 | new_y==y-1 | new_y==y))  {
				b=true;
			}
		}
		return b;
	}


	@Override
	public void effet(int x, int y, int new_x, int new_y,Plateau plateau) {
		// TODO Auto-generated method stub
		//plateau.deplace(piece.getX(), piece.getY(), new_x, new_y);
		//System.out.println(plateau.getPiece(x, y).toString());
		Roi roi=(Roi)plateau.getPiece(x, y);
		roi.setaBouge(true);
	}

}
