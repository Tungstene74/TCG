package classeMetier;


public class PartieLocale {
	private Plateau plateau;
	private int tour;
	
	public PartieLocale(){
		this.plateau=new Plateau(0);
		plateau.plateauClassique();
	}
	
	public void jouer(Combat combat) {
		Boolean echecetmat=false;
		while(!echecetmat);
		Piece pieceClique=combat.getPieceClique();
		
	}

}
