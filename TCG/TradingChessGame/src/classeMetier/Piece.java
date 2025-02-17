package classeMetier;
import java.util.ArrayList;

import pieces.Pion;


public abstract class Piece {
	private int idPiecePartie; //id sur le plateaux
	private int idPiece; //id de la pièce
	//private ArrayList<int[]> mouvement; //les vecteur mouvement en [(x,y),…]
	private String nom; //nom de la pièce
	private ArrayList<Pouvoir> pouvoirs; // nom du pouvoir
	private ArrayList<Mouvement> mouvements;
	private int x; // position sur le plateaux en x 
	private int y; // position sur le plateaux en y
	private String image; // url de l'image
	private static int Nbp=0; // pour comptre le nombre de pièce 
	private String couleur;
	private String descriptionMvt;//Description du mouvement de la pièce
	private String classe;
	private Boolean estMangee;
	
	public String lienImage() {
		String str="/images/"+this.nom+this.couleur+".png";
		return str;
	}

	public Piece(int idPiece, String nom, ArrayList<Mouvement> mouvements, ArrayList<Pouvoir> pouvoirs, String image,String classe){
		this.idPiece=idPiece;
		this.pouvoirs=pouvoirs;
		this.mouvements=mouvements;
		this.nom=nom;
		this.classe=classe;
		this.x=-1;
		this.y=-1;
		this.couleur=null;
		this.image=lienImage();
		this.estMangee=false;
		Nbp+=1;
	}

	public Piece(int idPiece, String nom, ArrayList<Mouvement> mouvements, ArrayList<Pouvoir> pouvoirs, String image, String classe,String couleur){
		// attention la couleur doit être instancier avec une majuscule!
		this.idPiece=idPiece;
		this.pouvoirs=pouvoirs;
		this.mouvements=mouvements;
		this.nom=nom;
		this.classe=classe;
		this.x=-1;
		this.y=-1;
		this.couleur=couleur;
		this.image=lienImage();
		this.estMangee=false;
		Nbp+=1;
	}

	public Piece(int idPiece, int idPiecePartie, String nom, ArrayList<Mouvement> mouvements, ArrayList<Pouvoir> pouvoirs, String image,String classe, String couleur, int x, int y){
		// attention la couleur doit être instancier avec une majuscule!
		this.idPiece=idPiece;
		this.idPiecePartie=idPiecePartie;
		this.mouvements=mouvements;
		this.pouvoirs=pouvoirs;
		this.nom=nom;
		this.classe=classe;
		this.x=x;
		this.y=y;
		this.couleur=couleur;
		this.image=lienImage();
		this.estMangee=false;
		Nbp+=1;
	}
	
	public Boolean caseAteignable(Plateau plateau, int new_x, int new_y) { //pour voir si une case est ateignable
		Boolean b=false;
		for (Mouvement mouv:mouvements) {
			if (mouv.estPossible(this, new_x, new_y, plateau)) {
				b=true;
			}
		}
		return b;
	}
	/*
	public Boolean caseAteignable(Plateau plateau, int new_x, int new_y) { //pour voir si une case 
		ArrayList<int[]> listeCoord =this.casesAteignables(plateau);
		for (int[] coord:listeCoord) {
			if (coord[0]==new_x & coord[1]==new_y) {
				b=true;
			}
		}
		return b;
	}*/
	
	public ArrayList<int[]> casesAteignables(Plateau plateau){
		ArrayList<int[]> listeCoord= new ArrayList<int[]>();
		for (Mouvement mouvement:mouvements) { //pour pour chaques mouvements possibles
			for (int new_x=0;new_x<=7;new_x++) { //pour chaques colonnes
				for (int new_y=0;new_y<=7;new_y++) { //pour chaques lignes
					if (mouvement.estPossible(this,new_x,new_y,plateau)) {
						int[] co= {new_x,new_y};
						listeCoord.add(co);
					}
				}
			}
		}
		return listeCoord;
	}
	
	public String casesAteignablesString(Plateau plateau) {
		ArrayList<int[]> listeCases = casesAteignables(plateau);
		String str="[";
		for (int[] case_: listeCases) {
			str+="("+case_[0]+","+case_[1]+"),";
		}
		str+="]";//
		return str;
	}
	
	public Mouvement getMouvement(int new_x, int new_y, Plateau plateau) {
		Mouvement mouv=null;
		for (Mouvement mouvTest : this.getMouvements()) {
			if (mouvTest.estPossible(this, new_x, new_y, plateau))
				mouv=mouvTest;
		}
		return mouv;
	}
	
	public void appliqueEffet(int new_x,int new_y,Plateau plateau) {
		Mouvement mouv=this.getMouvement(new_x, new_y, plateau);
		if (mouv!=null)
			mouv.effet(x, y, new_x, new_y, plateau);	
	}
	
	public Boolean mangeableOuNull(Plateau plateau, int x, int y) {
		Piece piece=plateau.getPiece(x, y);
		Boolean b=true;
		if (piece!=null) {
			if (piece.getCouleur()==this.couleur ) { //& piece.getClasse()!="roi" on ne l'utilise pas car si un roi peut être manger, c'est soi qu'il y a echec et mat, soit que le programme est faux
				b=false;
			}
		}
		return b;
	}
	
	public Boolean mangeableOuNull(Piece piece) {
		Boolean b=true;
		if (piece!=null) {
			if (piece.getCouleur()==this.couleur) {
				b=false;
			}
		}
		return b;
	}
	
	public abstract Piece copy();
	
	/*
	public Piece copy() {
		switch(idPiece) {
		case 0: Pion new_pion = new Pion(idPiece,idPiecePartie);
		}
		
		Piece new_piece=new Piece(this.idPiece, this.idPiecePartie, this.nom, this.mouvements, this.pouvoirs, this.image,this.classe,this.couleur, this.x, this.y);
		
		return new_piece;
	}*/

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
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur=couleur;
	}
	
	public String getCouleurInverse() {
		if (couleur=="blanc") {
			return "noir";
		}
		if (couleur=="noir") {
			return "blanc";
		}
		else {
			return null;
		}
	}
	
	public ArrayList<Pouvoir> getPouvoirs() {
		return this.pouvoirs;
	}
	
	public void setPouvoirs(ArrayList<Pouvoir> pouvoirs) {
		this.pouvoirs=pouvoirs;
	}

	public ArrayList<Mouvement> getMouvements() {
		return this.mouvements;
	}
	
	public int getIdPiecePartie() {
		return this.idPiecePartie;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String toString() {
		String txt="nom: "+this.nom+", couleur: "+this.couleur+", classe: "+this.classe+", idPiece: "+this.idPiece+", idPiecePartie: "+this.idPiecePartie+", image:"+this.image+", coord: ("+this.x+", "+this.y+")";
		if (pouvoirs!=null) 
			txt+=", Pouvoirs: "+this.pouvoirs.toString();
		return txt;
	}
	
	public String getClasse() {
		return this.classe;
	}
	
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public String getimage(){
		return this.image;
	}
	
	public void setImage(String url){
		this.image = url ;
	}
	
	public void setX(int x){
		this.x= x;
	}

	public int getIdPiece() {
		return idPiece;
	}

	public void setY(int y){
		this.y= y;
	}

	public void setDescriptionMvt(String description){
		this.descriptionMvt = description;
	}

	public String getDescriptionMvt(){
		return this.descriptionMvt;
	}
	
	public void addMouvement(Mouvement mouvement) {
		this.mouvements.add(mouvement);
	}
	
	public void addPouvoir(Pouvoir pouvoir) {
		this.pouvoirs.add(pouvoir);
	}

	public Boolean getEstMangee() {
		return estMangee;
	}

	public void setEstMangee(Boolean estMangee) {
		this.estMangee = estMangee;
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



