package pieces;

import classeMetier.*;
import mouvement.*;
import java.util.ArrayList;

public class Tour extends Piece{
	// id=1

	public Tour(String couleur) {
		super(1, "tour", new ArrayList<Mouvement>(), null, "",couleur);
		// on définit les différents déplacements
		Droite d = new Droite();
		this.addMouvement(d);
	}
	
	public Tour(String couleur, int x, int y) {
		super(1, "tour", new ArrayList<Mouvement>(), null, "",couleur,x,y);
		Droite d = new Droite();
		this.addMouvement(d);
	}
}
