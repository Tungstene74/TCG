package classeMetier;

import java.util.ArrayList;

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
}
