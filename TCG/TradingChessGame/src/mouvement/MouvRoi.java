package mouvement;

import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;
import pieces.Roi;

public class MouvRoi extends Mouvement{

	@Override
	public Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau) {
		int x=piece.getX();
		int y=piece.getY();
		Boolean b = false; //on suppose que le mouv n'est pas possible
		
		if (piece.mangeableOuNull(plateau,new_x,new_y)) {
			if ((new_x==x | new_x==x-1 | new_x==x+1) & (new_y==y+1 | new_y==y-1 | new_y==y))  {
				b=true;
			}
		}
		return b;
	}

	@Override
	public void effet(int x, int y, int new_x, int new_y,Plateau plateau) {
		Roi roi=(Roi)plateau.getPiece(x, y);
		roi.setaBouge(true);
	}
}
