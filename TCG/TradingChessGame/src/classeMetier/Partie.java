package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie {
	
	private int id_partie;
	private int tour_joueur;
	private int id_deck1;
	private int id_deck2;
	private int id_joueur1;
	private int id_joueur2;
	private Plateau plateau;
	
	/*
	public Partie(int couleur) {
		this.tour_joueur=couleur;
	}*/
	
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

	public void setId_deck(int id_deck1) {
		this.id_deck1 = id_deck1;
	}

	public void setId_joueur(int id_joueur1) {
		this.id_joueur1 = id_joueur1;
	}
	
	public Boolean Join(int id_joueur2, int idPartie) {
		Boolean b=false;
		if (idPartie==this.id_partie) {
			this.id_joueur2 = id_joueur2;
			b=true;
		}
		return b;
	}

	public Partie(int id_joueur1) {
		this.tour_joueur=0;
		//this.id_deck1 = id_deck1;
		this.id_joueur1 = id_joueur1;
		
		//initialisation du plateau
		this.plateau=new Plateau(id_partie);
		
		this.plateau.plateauClassique();
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

	public int getId_deck1() {
		return id_deck1;
	}

	public int getId_deck2() {
		return id_deck2;
	}

	public void setId_deck2(int id_deck2) {
		this.id_deck2 = id_deck2;
	}

	public int getId_joueur1() {
		return id_joueur1;
	}

	public Partie(int id_partie, int tour_joueur, int id_deck1, int id_joueur1) {
		super();
		this.id_partie = id_partie;
		this.tour_joueur = tour_joueur;
		this.id_deck1 = id_deck1;
		this.id_joueur1 = id_joueur1;
		//initialisation du plateau
				this.plateau=new Plateau(id_partie);
				
				this.plateau.plateauClassique();
				//test
				Tour t1 = new Tour("blanc");
				this.plateau.add(t1);
				
		this.plateau.setId_partie(id_partie);

	}
	
	public Partie(int id_partie, int tour_joueur, int id_deck1, int id_joueur1, int id_deck2, int id_joueur2) {
		super();
		this.id_partie = id_partie;
		this.tour_joueur = tour_joueur;
		this.id_deck1 = id_deck1;
		this.id_deck2 = id_deck2;
		this.id_joueur1 = id_joueur1;
		this.id_joueur2 = id_joueur2;
		this.plateau.setId_partie(id_partie);
	}
	
}
