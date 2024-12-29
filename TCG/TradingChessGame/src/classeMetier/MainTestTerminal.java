package classeMetier;

import java.util.ArrayList;

import pieces.Tour;

public class MainTestTerminal {
	
	public static void affiche(Plateau plateau) {
		ArrayList<ArrayList<Piece>> matrice= plateau.Matrice();
		System.out.println(matrice.toString());
		for (ArrayList<Piece> ligne : matrice ) {
			String strligne="";
			for (Piece piece : ligne ) {
				if (piece!=null) {
					strligne+=piece.getNom().charAt(0)+" ";
				}
				else {
					strligne+="/ ";
				}
			}
			System.out.println(strligne);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau(0);
		Tour t1 = new Tour("blanc",2,1);
		Tour t2 = new Tour("blanc",4,1);
		System.out.println(t1.toString());
		plateau.add(t1);
		plateau.add(t2);
		System.out.println(t1.getNom().charAt(0));
		
		affiche(plateau);
		
		System.out.println(t1.casesAteignablesString(plateau));
	}

}
