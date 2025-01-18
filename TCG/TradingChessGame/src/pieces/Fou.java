package pieces;

import classeMetier.*;
import mouvement.*;
import java.util.ArrayList;

public class Fou extends Piece{
	//id=3;

	public Fou(String couleur) {
		super(3, "fou", new ArrayList<Mouvement>(), null, "","fou",couleur);
		// on définit les différents déplacements
		this.addMouvement(new MouvFou());
	}
	
	public Fou(String couleur, int idPiecePartie, int x, int y) {
		super(3, idPiecePartie, "fou", new ArrayList<Mouvement>(), null, "","fou",couleur,x,y);
		this.addMouvement(new MouvFou());
		this.setImage("/images/fou"+couleur+".png");
	}
	
	public Piece copy() {
		return (new Fou(this.getCouleur(),this.getIdPiecePartie(),this.getX(),this.getY()));
	}

}