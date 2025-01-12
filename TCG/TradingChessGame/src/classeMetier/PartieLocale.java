package classeMetier;

import interface_.Combat;

public class PartieLocale {
	private Plateau plateau;
	private int tour;
	private Boolean estEnCour;
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public void setPlateau(Plateau plateau){
		this.plateau=plateau;
	}
	
	public PartieLocale(){
		this.plateau=new Plateau(0);
		plateau.plateauClassique();
		this.tour=0;
	}
	
	public int getTour() {
		return tour;
	}

	public void ajouttour() {
		tour+=1;
	}
	
	public String couleurAjouer(){
		if (tour%2==0){
			return "blanc";
		}
		if (tour%2==1){
			return "noir";
		}
		return null;
	}
	
	/*
	public void jouer(Combat combat) {
		Boolean echecetmat=false;
		while(!echecetmat) {
			if (combat.actionDetect()) {
				
			}
			Piece pieceClique=combat.getPieceClique();
		}
		
		
	}*/

}
