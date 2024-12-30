package pieces;

import classeMetier.*;
import mouvement.*;

import java.util.ArrayList;

public class Fou extends Piece{
	//id=1;

	public Fou(String couleur) {
		super(2, "fou", new ArrayList<Mouvement>(), null, "",couleur);
		// on définit les différents déplacements
		MouvFou f = new MouvFou();
		this.addMouvement(f);
	}
	
	public Fou(String couleur, int x, int y) {
		super(2, "fou", new ArrayList<Mouvement>(), null, "",couleur,x,y);
		MouvFou f = new MouvFou();
		this.addMouvement(f);
	}
	
	private void attributionDeplacement() {
		//on attribut touts les déplacements de la pièce
	}
}
