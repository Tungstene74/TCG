package classeMetier;

import java.util.ArrayList;

public class Deck {
	private int id_deck;
	private Boolean deckprincipal;
	private ArrayList<Piece> listepieces;
	
	private Boolean verification() {
		return true; //vérifira qu'un deck est valide
	}
}
