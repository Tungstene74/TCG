package classeMetier;

import java.util.Timer;
import classeDAO.*;
import interface_.*;
import pieces.*;

public class Partie extends PartieLocale{
	
	private int id_partie;
	private Deck deck1;
	private Deck deck2;
	private Joueur joueur1;
	private Joueur joueur2;
	
	public Joueur joueuraJouer() {
		if (super.tour%2==0){
			return joueur1;
		}
		if (super.tour%2==1){
			return joueur2;
		}
		return null;
	}
	
	/*
	public Partie(int couleur) {
		this.tour_joueur=couleur;
	}*/

	public int getId_partie() {
		return id_partie;
	}

	public Joueur getjoueur1() {
		return joueur1;
	}
	
	public Joueur getjoueur2() {
		return joueur2;
	}

	public void setjoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	
	public void setjoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public void setdeck1(Deck deck1) {
		this.deck1 = deck1;
	}
	
	public void setdeck2(Deck deck2) {
		this.deck2 = deck2;
	}
	
	public Deck getdeck1() {
		return deck1;
	}

	public Deck getdeck2() {
		return deck2;
	}
	
	public Boolean Join(Joueur joueur2, int idPartie) {
		Boolean b=false;
		if (idPartie==this.id_partie) {
			this.joueur2 = joueur2;
			this.deck2= joueur2.mainDeck();
			b=true;
		}
		return b;
	}
	
	

	public Partie(Joueur joueur1, int id_partie) {
		super();
		this.id_partie = id_partie;
		this.joueur1 = joueur1;
		this.deck1 = joueur1.mainDeck();
		super.getPlateau().setId_partie(id_partie);
		
	}
	
}
