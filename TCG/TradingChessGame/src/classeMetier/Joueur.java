package classeMetier;

import java.util.HashMap;

import classeDAO.JoueurDAO;

public class Joueur {
	private int id_joueur;
	private String identifiant;
	private String Mbp;
	private int Argent=0;
	private int NbPartiesJ=0;
	private int NbPartiesG=0;
	private HashMap<Integer, Integer> listepiece = new HashMap<Integer,Integer>();
	
	
	public String getMbp() {
		return Mbp;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public int getNbPartiesJ() {
		return NbPartiesJ;
	}

	public void setNbPartiesJ(int nbPartiesJ) {
		NbPartiesJ = nbPartiesJ;
	}

	public int getNbPartiesG() {
		return NbPartiesG;
	}

	public void setNbPartiesG(int nbPartiesG) {
		NbPartiesG = nbPartiesG;
	}

	public HashMap<Integer, Integer> getListepiece() {
		return listepiece;
	}

	public void setListepiece(HashMap<Integer, Integer> listepiece) {
		this.listepiece = listepiece;
	}

	public int getId_joueur() {
		return id_joueur;
	}

	public void setMbp(String mbp) {
		Mbp = mbp;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int getArgent() {
		return Argent;
	}

	public void setArgent(int argent) {
		Argent = argent;
	}

	public Joueur(int id_joueur, String identifiant, String Mbp, int nbPartiesJ, int money, int nbPartiesG,  HashMap<Integer, Integer> listepiece) {
		super();
		this.id_joueur = id_joueur;
		this.identifiant = identifiant;
		this.Mbp = Mbp;
		this.NbPartiesJ = nbPartiesJ;
		this.NbPartiesG = nbPartiesG;
		this.Argent = money;
		this.listepiece = listepiece;
	}
	
	public Joueur(String identifiant, String Mbp) {
		super();
		this.identifiant = identifiant;
		this.Mbp = Mbp;

	}
	
	
	public void addPiece(int id_piece) {
		JoueurDAO J = new JoueurDAO();
		if (this.listepiece.containsKey(id_piece)) {
			int Nb=this.listepiece.get(id_piece)+1;
			this.listepiece.remove(id_piece);
			this.listepiece.put(id_piece, Nb);
			J.missPiece(this.id_joueur,id_piece,Nb);
		} else {
			this.listepiece.put(id_piece, 1);
			J.addPiece(this.id_joueur,id_piece,1);
		}

	}
	
	

}
