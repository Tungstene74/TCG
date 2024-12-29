package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie {
	
	private int id_partie;
	private int tour_joueur;
	private int id_deck;
	private int id_deck2;
	private int id_joueur;
	private int id_joueur2;
	private Plateau plateau;
	
	public Partie(int couleur) {
		this.tour_joueur=couleur;
	}
	
	public int getId_joueur2() {
		return id_joueur2;
	}

	public void setId_joueur2(int id_joueur2) {
		this.id_joueur2 = id_joueur2;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public void setId_deck(int id_deck) {
		this.id_deck = id_deck;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public Partie(int tour_joueur, int id_deck, int id_joueur) {
		this.tour_joueur=tour_joueur;
		this.id_deck = id_deck;
		this.id_joueur = id_joueur;
		
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

	public int getId_deck2() {
		return id_deck2;
	}

	public void setId_deck2(int id_deck2) {
		this.id_deck2 = id_deck2;
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
		this.id_deck2 = id_deck2;
		this.id_joueur = id_joueur;
		this.id_joueur = id_joueur2;
		this.plateau.setId_partie(id_partie);
	}
	
}
