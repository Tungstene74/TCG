package classeMetier;

import java.util.ArrayList;

public abstract class Mouvement {
	
	//public ArrayList<int[]> casesAteignables(Plateau plateau, Piece piece);
	public Boolean estPossible(Piece piece, int new_x, int new_y, Plateau plateau) {
		Boolean b=false;
		if (!plateau.getEstTheorique()) {
			if (!plateau.metEnEchec(piece, new_x, new_x) & estPossibleNormal(piece, new_x, new_y, plateau))
					b=true;
		}
		if (plateau.getEstTheorique()) {
			if (estPossibleNormal(piece, new_x, new_y, plateau))
				b=true;
		}
		return b;
	}
	
	public abstract Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau);
	public abstract void effet(Piece piece, int new_x, int new_y, Plateau plateau);
}
