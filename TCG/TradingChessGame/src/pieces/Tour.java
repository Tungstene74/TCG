package pieces;

import classeMetier.*;
import mouvement.*;

import java.util.ArrayList;

public class Tour extends Piece{
	//id=1;
	private Boolean aBouge;
	

	public Boolean getaBouge() {
		return aBouge;
	}

	public void setaBouge(Boolean aBouge) {
		this.aBouge = aBouge;
	}

	public Tour(String couleur) {
		super(1, "tour", new ArrayList<Mouvement>(), null, "","tour",couleur);
		// on définit les différents déplacements
		aBouge=false;
		this.addMouvement(new MouvTour());
	}
	
	public Tour(String couleur, int idPiecePartie, int x, int y) {
		super(1, idPiecePartie, "tour", new ArrayList<Mouvement>(), null, "","tour",couleur,x,y);
		aBouge=false;
		this.addMouvement(new MouvTour());
	}
	
	public Piece copy() {
		Tour tour = new Tour(this.getCouleur(),this.getIdPiecePartie(),this.getX(),this.getY());
		tour.aBouge=this.aBouge;
		return (tour);
	}
	
}
