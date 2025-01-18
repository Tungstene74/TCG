package pieces;

import java.util.ArrayList;

import classeMetier.Mouvement;
import classeMetier.Piece;
import mouvement.*;

public class Dame extends Piece{
	//id=4;

		public Dame(String couleur) {
			super(4, "dame", new ArrayList<Mouvement>(), null, "","dame",couleur);
			// on définit les différents déplacements
			this.addMouvement(new MouvFou());
			this.addMouvement(new MouvTour());
		}
		
		public Dame(String couleur, int idPiecePartie, int x, int y) {
			super(4, idPiecePartie, "dame", new ArrayList<Mouvement>(), null, "","dame",couleur,x,y);
			this.addMouvement(new MouvFou());
			this.addMouvement(new MouvTour());
		}
		
		public Piece copy() {
			return (new Dame(this.getCouleur(),this.getIdPiecePartie(),this.getX(),this.getY()));
		}
}
