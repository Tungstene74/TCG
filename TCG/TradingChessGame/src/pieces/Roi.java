package pieces;

import java.util.ArrayList;

import classeMetier.Mouvement;
import classeMetier.Piece;
import mouvement.*;

public class Roi extends Piece {
	//id=5;
	
	private Boolean aBouge;
	

	public Boolean getaBouge() {
		return aBouge;
	}

	public void setaBouge(Boolean aBouge) {
		this.aBouge = aBouge;
	}

	public Roi(String couleur) {
		super(5, "roi", new ArrayList<Mouvement>(), null, "","roi",couleur);
		// on définit les différents déplacements
		aBouge=false;
		this.addMouvement(new MouvRoi());
		this.addMouvement(new Roque());
	}

	public Roi(String couleur, int idPiecePartie, int x, int y) {
		super(5, idPiecePartie, "roi", new ArrayList<Mouvement>(), null, "","roi",couleur,x,y);
		aBouge=false;
		this.addMouvement(new MouvRoi());
		this.addMouvement(new Roque());
	}
	
	public Piece copy() {
		Roi roi = new Roi(this.getCouleur(),this.getIdPiecePartie(),this.getX(),this.getY());
		roi.aBouge=this.aBouge;
		return (roi);
	}

}
