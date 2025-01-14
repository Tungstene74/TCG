package classeMetier;

import interface_.CombatLocal;

public class Promotion extends Pouvoir{

	public Promotion() {
		super("Promotion", "Quand le pion arrive à la dernière ligne, il peut se transformé en n'importe quel pièce", true);
		// TODO Auto-generated constructor stub
	}

	public Boolean pouvoirSiCondition(Plateau plateau) {
		Boolean b= false;
		Piece newpiece=null;
		for(Piece piece:plateau.getListepieces()) {
			if (piece.getY()==0 & piece.getClasse()=="pion" & piece.getCouleur()=="noir")
				b=true;
			if (piece.getY()==7 & piece.getClasse()=="pion" & piece.getCouleur()=="blanc")
				b=true;
			if (b) {
				newpiece=CombatLocal.promotion();
				newpiece.setX(piece.getX());
				newpiece.setY(piece.getY());
				plateau.add(newpiece);
				plateau.supp(piece);
			}
		}
		Boolean b2=false;
		if (newpiece!=null) {
			b2=true;
		}

		return b2;
	}

}
