package classeMetier;

import java.util.ArrayList;

import pieces.*;

public class MainTestTerminal {
	
	public static void affiche(Plateau plateau) {
		ArrayList<ArrayList<Piece>> matrice= plateau.Matrice();
		//System.out.println(matrice.toString());
		for (ArrayList<Piece> ligne : matrice ) {
			String strligne="";
			for (Piece piece : ligne ) {
				if (piece!=null) {
					strligne+=piece.getNom().charAt(0)+""+piece.getCouleur().charAt(0)+" ";//
				}
				else {
					strligne+="-- ";
				}
			}
			System.out.println(strligne);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau(0);
		Tour t1 = new Tour("Blanc",0,2,1);
		//Tour t2 = new Tour("Blanc",1,4,1);
		Fou f1 = new Fou("Blanc",2,5,3);
		Pion p1= new Pion("Blanc",3,4,1);
		System.out.println(t1.toString());
		plateau.add(t1);
		//plateau.add(t2);
		plateau.add(f1);
		plateau.add(p1);
		System.out.println(t1.getNom().charAt(0));
		
		affiche(plateau);
		
		//System.out.println(t1.casesAteignablesString(plateau));
		System.out.println(p1.casesAteignablesString(plateau));
		
		plateau.deplace(p1, 4, 3);
		//plateau.add(t1, 1, 5);
		//plateau.deplace(2, 1, 1, 1);
		
		affiche(plateau);
		
		System.out.println(f1.casesAteignablesString(plateau));
	}

}
