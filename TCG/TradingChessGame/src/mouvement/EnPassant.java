package mouvement;

import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;

public class EnPassant extends Mouvement{

	
	@Override
	public Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau) {

		int x=piece.getX();
		int y=piece.getY();
		// TODO Auto-generated method stub
		Boolean b = false; //on suppose que le mouv n'est pas possible
		//ArrayList<int[]> listeCoord = new ArrayList<int[]>(); //liste des co entre la position de départ et d'arrivée
		Piece pieceMangee=plateau.getPiece(new_x, y);

		//0:0:31:32
		if (plateau.getHistoriqueDesCoups().size()!=0) {
			int pre_y_precedant_coup=Integer.parseInt(plateau.getHistoriqueDesCoups().getLast().substring(5,6));
			int new_y_precedant_coup=Integer.parseInt(plateau.getHistoriqueDesCoups().getLast().substring(8,9));
			int id_precedant_coup=Integer.parseInt(plateau.getHistoriqueDesCoups().getLast().substring(2,3));
			Boolean precedant_a_bouge_de_2_cases_et_est_un_pion=false;
			//System.out.println(pre_y_precedant_coup+","+new_y_precedant_coup+","+id_precedant_coup);

			if (id_precedant_coup==0 & (new_y_precedant_coup==pre_y_precedant_coup+2 | new_y_precedant_coup==pre_y_precedant_coup-2))
				precedant_a_bouge_de_2_cases_et_est_un_pion=true;

			//(piece.getCouleur()=="noir" & new_y==y-1)

			if (pieceMangee!=null) {
				if (pieceMangee.getCouleur()!=piece.getCouleur() & ((new_x==x+1 | new_x==x-1) & y==new_y_precedant_coup & precedant_a_bouge_de_2_cases_et_est_un_pion )) {
					if ((piece.getCouleur()=="blanc" & new_y==y+1) )  
						b=true;
					if ((piece.getCouleur()=="noir" & new_y==y-1) )  { 
						b=true;
					}
				}
			}
		}

		return b;
	}

	@Override
	public void effet(int x, int y, int new_x, int new_y, Plateau plateau) {
		// TODO Auto-generated method stub
		//plateau.deplace(piece.getX(), piece.getY(), new_x, new_y);
		//on a déjà déplacé la piece
		Piece piece = plateau.getPiece(x, y);
		if (piece.getCouleur()=="blanc")
			plateau.supp(new_x, new_y-1);
		if (piece.getCouleur()=="noir")
			plateau.supp(new_x, new_y+1);
	}
}
