package classeMetier;

import java.util.ArrayList;

import pieces.Tour;

public class MainTestTerminal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau();
		Tour t1 = new Tour(0,0,0);
		System.out.println(t1.toString());
		plateau.add(t1);
		System.out.println(t1.getNom().charAt(0));
		
		
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

}
