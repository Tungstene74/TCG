package classeMetier;

import java.util.ArrayList;

public interface Mouvement {
	
	//public ArrayList<int[]> casesAteignables(Plateau plateau, Piece piece);
	public Boolean estPossible(Piece piece, int new_x, int new_y, Plateau plateau);
	public void effet(Piece piece, int new_x, int new_y, Plateau plateau);
}
