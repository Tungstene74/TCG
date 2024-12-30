package classeMetier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import pieces.*;

public class Plateau {
	private ArrayList<Piece> listepieces;
	private int id_partie;
	
	
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
		this.id_partie=id_partie;
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
		if (new_x > 7 | new_x<0 | new_y > 7 | new_y<0) { //le plateau va de 0 à 7
			throw new IndexOutOfBoundsException("Dépassement limite plateau");
		}
		else {
			if (piece==null) {
				throw new NullPointerException("La piece n'existe pas");
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
	
	public Piece getPiece(int x, int y) {
		Piece pieceCherche=null;
		for(Piece piece : listepieces) {
			if (piece.getX()==x && piece.getY()==y) {
				pieceCherche=piece;
				break;
			}
		}
		return pieceCherche;
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

	public void creePiece(int id_piece, String couleur) {
		switch (id_piece) {
			case 0: // pion
			case 1: add(new Tour(couleur));
			case 2: //cavalier
			case 3: //fou
			case 4: //dame
			case 5: //roi
		}
	}
	
	public void attributionCoord() {
		//for piece
	}
}


