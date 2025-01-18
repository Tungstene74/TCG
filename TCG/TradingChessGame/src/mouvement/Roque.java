package mouvement;

import classeMetier.Mouvement;
import classeMetier.Piece;
import classeMetier.Plateau;
import pieces.*;

public class Roque extends Mouvement {
	
	public Boolean estPossibleNormal(Piece piece, int new_x, int new_y, Plateau plateau) {
		Boolean b=false;
		//System.out.println(piece.toString());
		//System.out.println("Type réel : " + piece.getClass().getName());
		
		Roi roi=(Roi)piece;
		
		if (roi.getaBouge()==false) {

			if(roi.getCouleur()=="blanc" & new_x==2 & new_y==0) {
				Tour tour = (Tour)plateau.getPiece(0, 0);				
				if (tour!=null & plateau.getPiece(1, 0)==null & plateau.getPiece(2, 0)==null & plateau.getPiece(3, 0)==null) {
					if (tour.getaBouge()==false & !plateau.estEnEchec("blanc"))
						b=true;	
				}		
			}
			
			if(roi.getCouleur()=="blanc" & new_x==6 & new_y==0) {
				Tour tour = (Tour)plateau.getPiece(7, 0);				
				if (tour!=null & plateau.getPiece(5, 0)==null & plateau.getPiece(6, 0)==null) {
					if (tour.getaBouge()==false & !plateau.estEnEchec("blanc"))
						b=true;	
				}	
			}
			
			if(roi.getCouleur()=="noir" & new_x==2 & new_y==7) {
				Tour tour = (Tour)plateau.getPiece(0, 7);				
				if (tour!=null & plateau.getPiece(1, 7)==null & plateau.getPiece(2, 7)==null & plateau.getPiece(3, 7)==null) {
					if (tour.getaBouge()==false & !plateau.estEnEchec("noir"))
						b=true;	
				}	
			}
			
			if(roi.getCouleur()=="noir" & new_x==6 & new_y==7) {
				Tour tour = (Tour)plateau.getPiece(7, 7);				
				if (tour!=null & plateau.getPiece(5, 7)==null & plateau.getPiece(6, 7)==null) {
					if (tour.getaBouge()==false & !plateau.estEnEchec("noir"))
						b=true;	
				}	
			}
		}	
		return b;
	}

	@Override
	public void effet(int x, int y, int new_x, int new_y,Plateau plateau) {
		// TODO Auto-generated method stub
		//plateau.deplace(piece, new_x, new_y);
		Roi roi=(Roi)plateau.getPiece(x, y);
		roi.setaBouge(true);
		Tour tour=null;

		if (new_x==2)  {
			tour=(Tour)plateau.getPiece(0, y);
			tour.setX(3);
			tour.setaBouge(true);
		}
		if (new_x==6) {
			tour=(Tour)plateau.getPiece(7, y);
			tour.setX(5);
			tour.setaBouge(true);
		}
	}
}


