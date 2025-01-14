package pouvoir;

import classeMetier.Piece;
import classeMetier.Plateau;
import classeMetier.Pouvoir;
import interface_.CombatLocal;
import interface_.PromotionPiece;
import pieces.Pion;

public class Promotion extends Pouvoir{

	public Promotion() {
		super("Promotion", "Quand le pion arrive à la dernière ligne, il peut se transformé en n'importe quel pièce", true);
		// TODO Auto-generated constructor stub
	}

	public Boolean pouvoirSiCondition(Plateau plateau) {
		Boolean b= false;
		Piece newpiece=null;
		System.out.println("pre promotion");
		for(Piece piece:plateau.getListepieces()) {
			System.out.println(piece.toString());
			if (piece.getY()==0 & piece.getClasse()=="pion" & piece.getCouleur()=="noir")
				b=true;
			if (piece.getY()==7 & piece.getClasse()=="pion" & piece.getCouleur()=="blanc")
				b=true;
			if (b) {
				System.out.println("promotion");
				PromotionPiece fenPromotion = new PromotionPiece((Pion)piece);
				while (newpiece==null) {
					newpiece=fenPromotion.getpieceSelectionnee();
				}
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
