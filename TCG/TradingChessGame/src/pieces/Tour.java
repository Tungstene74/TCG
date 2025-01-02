package pieces;

import classeMetier.*;
import mouvement.*;

import java.util.ArrayList;

public class Tour extends Piece{
	//id=1;

	public Tour(String couleur) {
		super(1, "tour", new ArrayList<Mouvement>(), null, "","tour",couleur);
		// on définit les différents déplacements
		this.addMouvement(new MouvTour());
	}
	
	public Tour(String couleur, int idPiecePartie, int x, int y) {
		super(1, idPiecePartie, "tour", new ArrayList<Mouvement>(), null, "","tour",couleur,x,y);
		this.addMouvement(new MouvTour());
	}
	
}
