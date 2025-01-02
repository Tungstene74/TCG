package pieces;

import java.util.ArrayList;
import mouvement.*;
import classeMetier.Mouvement;
import classeMetier.Piece;

public class Cavalier extends Piece{
	//id=2;

	public Cavalier(String couleur) {
		super(3, "cavalier", new ArrayList<Mouvement>(), null, "","cavalier",couleur);
		// on définit les différents déplacements
		this.addMouvement(new MouvCavalier());
	}
	
	public Cavalier(String couleur, int idPiecePartie, int x, int y) {
		super(3,idPiecePartie, "cavalier", new ArrayList<Mouvement>(), null, "","cavalier",couleur,x,y);
		this.addMouvement(new MouvCavalier());
	}

}
