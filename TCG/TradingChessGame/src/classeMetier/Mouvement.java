package classeMetier;

import java.util.ArrayList;

public interface Mouvement {
	
	public ArrayList<int[]> casesAteignables(Plateau plateau, Piece piece);
	public Boolean estPossible(int x, int y, Plateau plateau);
	public void effet(Plateau plateau);
}
