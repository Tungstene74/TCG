package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie {
	
	private String couleur;
	
	public Partie(String couleur) {
		this.couleur=couleur;
		
		//initialisation du plateau
		Plateau plateau=new Plateau();
		Tour t1 = new Tour(0);
		plateau.add(t1);
	}
}
