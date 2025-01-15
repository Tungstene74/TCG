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

	public void pouvoirSiCondition(Piece piece, Plateau plateau) {
		Boolean b= false;
		System.out.println("pre promotion");
		System.out.println(piece.toString());
		if (piece.getY()==0 & piece.getClasse()=="pion" & piece.getCouleur()=="noir")
			b=true;
		if (piece.getY()==7 & piece.getClasse()=="pion" & piece.getCouleur()=="blanc")
			b=true;
		if (b) {
			System.out.println("promotion");
			new PromotionPiece((Pion)piece,plateau);
		}
		
	}

}
