package classeMetier;
import java.util.ArrayList;


public class Piece {
	//private int idB; //id sur le plateaux
	private int idPiece; //id de la pièce
	//private ArrayList<int[]> mouvement; //les vecteur mouvement en [(x,y),…]
	private ArrayList<Mouvement> mouvements;
	private String nom; //nom de la pièce
	private Pouvoir pouvoir; // nom du pouvoir
	private int x; // position sur le plateaux en x 
	private int y; // position sur le plateaux en y
	private String image; // url de l'image
	//private static int Nbp=0; // pour comptre le nombre de pièce 

	public Piece(int idPiece, String nom, ArrayList<Mouvement> mouvements, Pouvoir pouvoir, String image){
		this.idPiece=idPiece;
		this.mouvements=mouvements;
		this.pouvoir=pouvoir;
		this.nom=nom;
		this.x=-1;
		this.y=-1;
		this.image=image;
	}

	public Piece(int idPiece, String nom, ArrayList<Mouvement> mouvement, Pouvoir pouvoir, String image, int x, int y){
		this.idPiece=idPiece;
		this.mouvements=mouvements;
		this.pouvoir=pouvoir;
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.image=image;
	}

	/*
	    public Piece(int idP, ArrayList<int[]> mouvement, String pouvoirs, String Nom, int x, int y, String image){
	        this.idP=idP;
	        this.idP= Nbp;
	        this.mouvement=mouvement;
	        this.pouvoirs=pouvoirs;
	        this.Nom=Nom;
	        this.x=x;
	        this.y=y;
	        this.image=image;
	        piece.Nbp +=1;
	    }
	 */

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public String getimage(){
		return this.image;
	}

	public void setX(int X){
		this.x= X;
	}

	public void setY(int Y){
		this.x= Y;
	}
	
	public void addMouvement(Mouvement mouvement) {
		this.mouvements.add(mouvement);
	}
	
	/*

	public ArrayList<int[]> caseAtegnable(){
		ArrayList<int[]> caseAtegnable = new ArrayList<int[]>();
		for (int[] mouv: this.mouvement){
			if (this.x+mouv[0]>0 && this.y+mouv[1]>0 && this.x+mouv[0]<0 && this.y+mouv[1]>0){
				int[] mouve = {this.x+mouv[0],this.y+mouv[1]};
				caseAtegnable.add(mouve);
			}
		}
		return caseAtegnable;
	}

	public boolean pouvoirs(String type){

		return false;
	}
	
	*/





}



