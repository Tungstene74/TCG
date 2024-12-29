package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie {
	
	private int id_partie;
	private int tour_joueur;
	private int id_deck;
	private int id_joueur;
	private int id_joueur2;
	private Plateau plateau;
	
	public Partie(int couleur) {
		this.tour_joueur=couleur;
		//initialisation du plateau
		this.plateau=new Plateau(id_partie);
		
		//test
		Tour t1 = new Tour("blanc");
		this.plateau.add(t1);
	}

	public int getTour_joueur() {
		return tour_joueur;
	}

	public void setTour_joueur(int tour_joueur) {
		this.tour_joueur = tour_joueur;
	}

	public int getId_partie() {
		return id_partie;
	}

	public int getId_deck() {
		return id_deck;
	}

	public int getId_joueur() {
		return id_joueur;
	}

	public Partie(int id_partie, int tour_joueur, int id_deck, int id_joueur) {
		super();
		this.id_partie = id_partie;
		this.tour_joueur = tour_joueur;
		this.id_deck = id_deck;
		this.id_joueur = id_joueur;
		this.plateau.setId_partie(id_partie);
	}
	
	public Partie(int id_partie, int tour_joueur, int id_deck, int id_joueur, int id_deck2, int id_joueur2) {
		super();
		this.id_partie = id_partie;
		this.tour_joueur = tour_joueur;
		this.id_deck = id_deck;
		this.id_joueur = id_joueur;
		this.plateau.setId_partie(id_partie);
	}
	
}
