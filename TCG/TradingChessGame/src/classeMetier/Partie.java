package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;

public class Partie {
	
	private String couleur;
	
	public Partie(String couleur) {
		this.couleur=couleur;
		
		//initialisation du plateau
		Plateau plateau=new Plateau();
		plateau.add(new Piece("Tour"));
		
	}

}
