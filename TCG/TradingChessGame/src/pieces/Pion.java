package pieces;

import java.util.ArrayList;

import classeMetier.*;
import mouvement.*;
import pouvoir.Promotion;

public class Pion extends Piece {
	//id=0;

		public Pion(String couleur) {
			super(0, "pion", new ArrayList<Mouvement>(), new ArrayList<Pouvoir>(), "","pion",couleur);
			// on définit les différents déplacements
			this.addMouvement(new MouvPion());
			this.addPouvoir(new Promotion());
		}
		
		public Pion(String couleur, int idPiecePartie, int x, int y) {
			super(0, idPiecePartie, "pion", new ArrayList<Mouvement>(), new ArrayList<Pouvoir>(), "","pion",couleur,x,y);
			this.addMouvement(new MouvPion());
			this.addPouvoir(new Promotion());
		}
}
