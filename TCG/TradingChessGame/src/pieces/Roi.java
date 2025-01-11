package pieces;

import java.util.ArrayList;

import classeMetier.Mouvement;
import classeMetier.Piece;
import mouvement.*;

public class Roi extends Piece {
	//id=5;

		public Roi(String couleur) {
			super(5, "roi", new ArrayList<Mouvement>(), null, "","roi",couleur);
			// on définit les différents déplacements
			this.addMouvement(new MouvRoi());
		}
		
		public Roi(String couleur, int idPiecePartie, int x, int y) {
			super(5, idPiecePartie, "roi", new ArrayList<Mouvement>(), null, "","roi",couleur,x,y);
			this.addMouvement(new MouvRoi());
		}

}
