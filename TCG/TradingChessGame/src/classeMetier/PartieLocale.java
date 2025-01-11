package classeMetier;

public class PartieLocale {
	private Plateau plateau;
	private int tour;
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public void setPlateau(Plateau plateau){
		this.plateau=plateau;
	}
	
	public PartieLocale(){
		this.plateau=new Plateau(0);
		plateau.plateauClassique();
	}
	
	
	public void jouer(Combat combat) {
		Boolean echecetmat=false;
		while(!echecetmat) {
			if (combat.actionDetect()) {
				
			}
			Piece pieceClique=combat.getPieceClique();
		}
		
		
	}

}
