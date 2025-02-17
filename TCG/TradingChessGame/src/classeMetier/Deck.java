package classeMetier;

import java.util.ArrayList;

import pieces.Cavalier;
import pieces.Dame;
import pieces.Fou;
import pieces.Pion;
import pieces.Roi;
import pieces.Tour;

public class Deck {
	private int id_deck;
	private String nom;
	private Boolean deckprincipal;
	private ArrayList<Piece> listepieces;
	
	public Deck(String nom, Boolean deckprincipal, int id_joueur) {
		super();
		this.nom = nom;
		this.deckprincipal = deckprincipal;
		this.listepieces = new ArrayList<Piece>();
		this.id_joueur = id_joueur;
	}
	
	public Deck(String nom, Boolean deckprincipal, ArrayList<Piece> listepieces, int id_joueur) {
		super();
		this.nom = nom;
		this.deckprincipal = deckprincipal;
		this.listepieces = listepieces;
		this.id_joueur = id_joueur;
	}
	
	public Deck(String nom, Boolean deckprincipal, ArrayList<Piece> listepieces, int id_joueur, int id_deck) {
		super();
		this.nom = nom;
		this.deckprincipal = deckprincipal;
		this.listepieces = listepieces;
		this.id_joueur = id_joueur;
		this.id_deck = id_deck;
	}

	public void defaultDeck() {
		System.out.println("création deck base"); // ici print 
		//generation des pions
		for(int x=0;x<=7;x++) {
			this.AddPiece(new Pion("blanc"));
		}		
		//génération des pieces blanches
		this.AddPiece(new Tour("blanc"));
		this.AddPiece(new Cavalier("blanc"));
		this.AddPiece(new Fou("blanc"));
		this.AddPiece(new Dame("blanc"));
		this.AddPiece(new Roi("blanc"));
		this.AddPiece(new Fou("blanc"));
		this.AddPiece(new Cavalier("blanc"));
		this.AddPiece(new Tour("blanc"));	
	}
	
	public void AddPiece(Piece piece) {
		this.listepieces.add(piece);
	}

	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	private int id_joueur;
	
	public int getId_deck() {
		return id_deck;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId_deck(int id_deck) {
		this.id_deck = id_deck;
	}

	public Boolean getDeckprincipal() {
		return deckprincipal;
	}

	public void setDeckprincipal(Boolean deckprincipal) {
		this.deckprincipal = deckprincipal;
	}

	public ArrayList<Piece> getListepieces() {
		return listepieces;
	}

	public void setListepieces(ArrayList<Piece> listepieces) {
		this.listepieces = listepieces;
	}

	private Boolean verification() {
		return true; //vérifira qu'un deck est valide
	}
	
	public Piece creePiece(int id_piece) {
		switch (id_piece) {
			case 0: return (new Pion("blanc"));
			case 1: return (new Tour("blanc"));
			case 2: return (new Cavalier("blanc"));
			case 3: return (new Fou("blanc"));
			case 4: return (new Dame("blanc"));
			case 5: return (new Roi("blanc"));
		}
		return null;
	}
	
}
