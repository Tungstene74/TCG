package classeMetier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interface_.Case;
import interface_.CombatLocal;
import pieces.*;
import mouvement.*;

public class Plateau {
	private ArrayList<Piece> listepieces;
	private int id_partie;
	private Boolean estTheorique;
	private ArrayList<String> historiqueDesCoups;
	
	

	public ArrayList<String> getHistoriqueDesCoups() {
		return historiqueDesCoups;
	}

	public void setHistoriqueDesCoups(ArrayList<String> historiqueDesCoups) {
		this.historiqueDesCoups = historiqueDesCoups;
	}

	public Boolean getEstTheorique() {
		return estTheorique;
	}

	public void setEstTheorique(Boolean estTheorique) {
		this.estTheorique = estTheorique;
	}
	
	public ArrayList<Piece> getListepieces() {
		return listepieces;
	}

	public void setListepieces(ArrayList<Piece> listepieces) {
		this.listepieces = listepieces;
	}

	public int getId_partie() {
		return id_partie;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public Plateau(int id_partie) {
		listepieces = new ArrayList<Piece>();
		historiqueDesCoups=new ArrayList<String>();
		this.id_partie=id_partie;
		estTheorique=false;
	}
	
	public ArrayList<ArrayList<Piece>> Matrice() {
		ArrayList<ArrayList<Piece>> matrice = new ArrayList<ArrayList<Piece>>();
		Piece piece = null;
		for (int y=7;y>=0;y--) {
			ArrayList<Piece> ligne = new ArrayList<Piece>();
			for (int x=0;x<=7;x++) {
				piece = this.getPiece(x, y);
				ligne.add(piece);
			}
			matrice.add(ligne);
		}
		return matrice;
	}
	

	public void add(Piece piece) {
		listepieces.add(piece);
	}
	
	public void add(Piece piece,int x,int y) {
		if (x>7 | x<0 | y>7 | y<0) {
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			piece.setX(x);
			piece.setY(y);
			listepieces.add(piece);
			//dictCoordPiece.put(co,piece);
		}
	}
	
	public Piece supp(int x,int y) {
		Piece piece = this.getPiece(x, y);
		listepieces.remove(piece);
		//dictCoordPiece.remove(co);
		return piece;
	}
	
	public void supp(Piece piece) {
		listepieces.remove(piece);
	}
	
	public void deplace(Piece piece, int new_x, int new_y) {
		if (new_x > 7 | new_x < 0 | new_y > 7 | new_y < 0) { //le plateau va de 0 à 7
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			if (piece==null) {
				throw new NullPointerException("La piece n'existe pas");
			}
			else {
				if (!piece.caseAteignable(this, new_x, new_y)) {
					throw new IllegalStateException("Déplacement interdit: "+"("+piece.getX()+", "+piece.getY()+") -> ("+new_x+", "+new_y+")");
				}
				else {
					Piece piece_mangee = this.getPiece(new_x,new_y); 
					if (piece_mangee!=null) {
						this.supp(piece_mangee);
					}
					this.enregistreCoup(piece, new_x, new_y); //fct incomptète, utile uniquement pour le en passant
					piece.appliqueEffet(new_x, new_y, this);
					piece.setX(new_x);
					piece.setY(new_y);
				}
			}
		}
	}
	
	public void enregistreCoup(Piece piece, int new_x, int new_y) {
		String str="0:"+piece.getIdPiece()+":"+piece.getX()+piece.getY()+":"+new_x+new_y;
		// 0=mouvement normal, puis l'id de la piece, sa position initial puis final exemple:
		// 0:0:31:32 = je bouge le pion en x=3 y=1 vers x=3 y=2
		this.historiqueDesCoups.add(str);
		//System.out.println(str);
	}
	
	//pas touche a cette fonction
	public void deplace(Piece piece, int new_x, int new_y, CombatLocal combat ) {
		if (new_x > 7 | new_x < 0 | new_y > 7 | new_y < 0) { //le plateau va de 0 à 7
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			if (piece==null) {
				throw new NullPointerException("La piece n'existe pas");
			}
			else {
				if (!piece.caseAteignable(this, new_x, new_y)) {
					throw new IllegalStateException("Déplacement interdit: "+"("+piece.getX()+", "+piece.getY()+") -> ("+new_x+", "+new_y+")");
				}
				else {
					Piece piece_mangee = this.getPiece(new_x,new_y);
					if (piece_mangee!=null) {
						if (piece_mangee.getCouleur()=="blanc") combat.getPieceJoueur2().ajout(piece_mangee);
						else combat.getPieceJoueur1().ajout(piece_mangee);
						this.supp(piece_mangee);
					}
					piece.appliqueEffet(new_x, new_y, this);
					this.enregistreCoup(piece, new_x, new_y); //fct incomptète, utile uniquement pour le en passant
					
					piece.setX(new_x);
					piece.setY(new_y);
					
				}
			}
		}
	}
	
	public void deplace(int x,int y, int new_x, int new_y) {
		if (new_x > 7 | new_x<0 | new_y > 7 | new_y<0) { //le plateau va de 0 à 7
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			Piece piece = this.getPiece(x,y);
			if (piece==null) {
				throw new NullPointerException("Pas de pièce en ces coordonées");
			}
			else {
				if (!piece.caseAteignable(this, new_x, new_y)) {
					throw new IllegalStateException("Déplacement interdit");
				}
				else {
					Piece piece_mangee = this.getPiece(new_x,new_y); 
					if (piece_mangee!=null) {
						this.supp(piece_mangee);
					}
					piece.setX(new_x);
					piece.setY(new_y);
				}
			}
		}
	}
	
	public Piece getPieceIdPiecePartie(int idPiecePartie) {
		Piece pieceCherchee=null;
		for(Piece piece : listepieces) {
			if (piece.getIdPiecePartie()==idPiecePartie) {
				pieceCherchee=piece;
				break;
			}
		}
		return pieceCherchee;
	}
	
	public Piece getPiece(int x, int y) {
		Piece pieceCherchee=null;
		for(Piece piece : listepieces) {
			if (piece.getX()==x && piece.getY()==y) {
				pieceCherchee=piece;
				break;
			}
		}
		return pieceCherchee;
	}
	
	public ArrayList<Piece> getPiecesNom(String nom, String couleur) {
		ArrayList<Piece> piecesCherchees=new ArrayList<Piece>();
		for(Piece piece : listepieces) {
			if (piece.getNom()==nom && piece.getCouleur()==couleur) {
				piecesCherchees.add(piece);
				break;
			}
		}
		return piecesCherchees;
	}
	
	public ArrayList<Piece> getPiecesClasse(String classe, String couleur) {
		ArrayList<Piece> piecesCherchees=new ArrayList<Piece>();
		for(Piece piece : listepieces) {
			if (piece.getClasse()==classe && piece.getCouleur()==couleur) {
				piecesCherchees.add(piece);
				break;
			}
		}
		return piecesCherchees;
	}
	
	public Piece getRoi(String couleur) {
		ArrayList<Piece> piecesCherchees=this.getPiecesClasse("roi", couleur);
		Piece pieceCherchee=piecesCherchees.getFirst();
		return pieceCherchee;
	}

	public int nbPiece(ArrayList<int[]> listCoord) {
		int nb=0;
		Piece piece=null;
		for(int[] coord : listCoord) {
			int x=coord[0];
			int y=coord[1];
			piece=this.getPiece(x, y);
			if (piece!=null) {
				nb+=1;
			}
		}
		return nb;
	}

	/*public void creePiece(int id_piece, String couleur) {
		switch (id_piece) {
			case 0: add(new Pion(couleur));
			case 1: add(new Tour(couleur));
			case 2: add(new Cavalier(couleur));
			case 3: add(new Fou(couleur));
			case 4: add(new Dame(couleur));
			case 5: add(new Roi(couleur));
		}
	}*/
	
	public void appliquePouvoirs() {
		for(Piece piece:listepieces) {
			if (piece.getPouvoirs()!=null) {
				for(Pouvoir pouvoir:piece.getPouvoirs()) {
					pouvoir.pouvoirSiCondition(piece,this);
				}
			}
		}
	}

	public Plateau copy() {
		Plateau new_plateau=new Plateau(this.id_partie); //!!!!!!!!!!!boucle récurssive infinie!!!!!!!!!!!!!
		for (Piece piece:listepieces) {
			new_plateau.add(piece.copy());
		}
		return new_plateau;
	}
	
	public Boolean estEnEchec(String couleur) { //permet de voir si le déplacement d'une piece cree un echec
		Boolean b=false;
		Piece roi=this.getRoi(couleur);
		for (Piece piecette:this.listepieces) { //pour toutes les pieces
			//et tout leurs déplacements
			//System.out.println("testechec");
			if (piecette.caseAteignable(this, roi.getX(), roi.getY())) { //on test si on peut manger le roi
				b=true;
				//System.out.println("est en echec _________________________");
			}
		}
		return b;
	}
	
	public Boolean metEnEchec(Piece piece, int new_x, int new_y) { //permet de voir si le déplacement d'une piece cree un echec de son propre roi
		Boolean b=false; //on suppose qu'il n'y a pas d'echec
		String couleurRoi=piece.getCouleur();
		Plateau plateauTheorique = this.copy(); //creer un plateau theorique pour tester si un deplacement va creer un echec
		plateauTheorique.setEstTheorique(true);
		Piece pieceTheorique = plateauTheorique.getPiece(piece.getX(), piece.getY()); 
		if (pieceTheorique.caseAteignable(plateauTheorique, new_x, new_y)) {
			plateauTheorique.deplace(pieceTheorique, new_x, new_y);
			//System.out.println("déplacement effectué");
		}
			
		
		if (plateauTheorique.estEnEchec(couleurRoi)) { //si on peut manger le roi (il y a echec)
			b=true; //alors oui on a mis le roi en echec
		}
		//System.out.println("plateau theorique:\n"+plateauTheorique.toString());
		return b;
	}
	
	public Boolean estEnMat(String couleur) {
		Boolean b=false;
		int sorties=0; //nombres de coups possible pour se sortir d'un echec
		if (!estEnEchec(couleur)) { //si la couleur n'est pas en echec
			for (Piece piece:this.listepieces) { //on teste pour toutes les pieces
				for (int new_x=0;new_x<=7;new_x++) { //un déplacement sur de nouvelles coordonnées
					for (int new_y=0;new_y<=7;new_y++) {
						if (piece.getCouleur()==couleur & piece.caseAteignable(this, new_x, new_y)) {
							// si la piece déplacée est bien de la couleur de notre roi, qu'on veut protéger, et que le mouvement est possible
							if (!this.metEnEchec(piece, new_x, new_y)) { //si ce déplacement ne met pas en echec le roi
								sorties+=1; 
							}
						}
					}
				}
			}
		}
		if (sorties==0) {
			b=true;
			System.out.println("mat");
		}
		return b;
	}

	public Boolean estEnEchecEtMat(String couleur) { //on teste si pour n'importe quel coup de la couleur actuel, on restera en echec
		Boolean b=false;
		int sorties=0; //nombres de coups possible pour se sortir d'un echec
		if (estEnEchec(couleur)) { //si la couleur est en echec
			for (Piece piece:this.listepieces) { //on teste pour toutes les pieces
				for (int new_x=0;new_x<=7;new_x++) { //un déplacement sur de nouvelles coordonnées
					for (int new_y=0;new_y<=7;new_y++) {
						if (piece.getCouleur()==couleur & piece.caseAteignable(this, new_x, new_y)) {
							// si la piece déplacée est bien de la couleur de notre roi, qu'on veut protéger, et que le mouvement est possible
							if (/*!this.metEnEchec(piece, new_x, new_y)*/ true) { //si ce déplacement ne met pas en echec le roi <- déjà dans caseAteignable
								sorties+=1; 
								//System.out.println("("+piece.getX()+","+piece.getY()+")->("+new_x+","+new_y+")");
							}
						}
					}
				}
			}
			
			if (sorties==0) {
				b=true;
				System.out.println("echec et mat");
			}

		}
		return b;
	}

	//a modifier
	public void generePlateau(Deck deckblanc, Deck decknoir) {
		int i=0;
		for(Piece piece:deckblanc.getListepieces()) {
			piece.setCouleur("blanc");
			i+=1;
			if (i<=7) {
				//a modifier
				this.add(piece, i, 1);
			}
			if (i>=8 & i<=15) {
				this.add(piece, i, 0);
			}
		}
		i=0;
		for(Piece piece:decknoir.getListepieces()) {
			piece.setCouleur("noir");
			i+=1;
			if (i<=7) {
				this.add(piece, i, 1);
			}
			if (i>=8 & i<=15) {
				this.add(piece, i, 0);
			}
		}
	}
	
	public void plateauClassique() {
		
		//génération des pions
		for(int x=0;x<=7;x++) {
			this.add(new Pion("blanc",x,x,1));
			this.add(new Pion("noir",x+8,x,6));
		}
		
		//génération des pieces blanches
		this.add(new Tour("blanc",16,0,0));
		this.add(new Cavalier("blanc",17,1,0));
		this.add(new Fou("blanc",18,2,0));
		this.add(new Dame("blanc",19,3,0));
		this.add(new Roi("blanc",20,4,0));
		this.add(new Fou("blanc",21,5,0));
		this.add(new Cavalier("blanc",22,6,0));
		this.add(new Tour("blanc",23,7,0));
		
		//génération des pieces noires
		this.add(new Tour("noir",24,0,7));
		this.add(new Cavalier("noir",25,1,7));
		this.add(new Fou("noir",26,2,7));
		this.add(new Dame("noir",27,3,7));
		this.add(new Roi("noir",28,4,7));
		this.add(new Fou("noir",29,5,7));
		this.add(new Cavalier("noir",30,6,7));
		this.add(new Tour("noir",31,7,7));
	}
	
	public String toString() {
		String str="";
		for (Piece piece:this.listepieces) {
			str+=piece.toString()+"\n";
		}
		return str;
	}
}


