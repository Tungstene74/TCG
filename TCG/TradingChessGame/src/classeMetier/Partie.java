package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie {
	
	private int id_partie;
	private int tour_joueur;
	
	public Partie(int couleur) {
		this.tour_joueur=couleur;
		
		//initialisation du plateau
		Plateau plateau=new Plateau();
		Tour t1 = new Tour(0);
		plateau.add(t1);
	}
}
