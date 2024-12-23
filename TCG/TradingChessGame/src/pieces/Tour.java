package pieces;

import classeMetier.*;
import mouvement.*;
import java.util.ArrayList;

public class Tour extends Piece{

	public Tour(int idPiece) {
		super(idPiece, "tour", new ArrayList<Mouvement>(), null, "");
		// on définit les différents déplacements
		this.addMouvement(null);
	}
	
	public Tour(int idPiece, int x, int y) {
		super(idPiece, "tour", new ArrayList<Mouvement>(new Droit()), null, "",x,y);
	}
}
