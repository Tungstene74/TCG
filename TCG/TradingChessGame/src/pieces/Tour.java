package pieces;

import classeMetier.*;
import mouvement.*;
import java.util.ArrayList;

public class Tour extends Piece{

	public Tour(String couleur) {
		super(1, "tour", new ArrayList<Mouvement>(), null, "");
		// on définit les différents déplacements
		Droite d = new Droite();
		this.addMouvement(d);
	}
	
	public Tour(int idPiece, int x, int y) {
		super(idPiece, "tour", new ArrayList<Mouvement>(), null, "",x,y);
		Droite d = new Droite();
		this.addMouvement(d);
	}
}
