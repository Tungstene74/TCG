package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import classeMetier.*;
import pieces.Roi;

public class Case extends JButton{

	private int abscisse;
	private int ordonnee;

	private GridBagConstraints gbc;

	private Piece piece;

	private static int size;

	private ImageIcon icon;

	private static PartieLocale partieLocale;

	private static CombatLocal combat;

	private Boolean estAteignable;

	private Boolean estAbouger;

	public Case(int x,int y) {
		abscisse = x;
		ordonnee = 7 - y;

		normalColor();

		addActionListener(new ALCase());

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;

		estAteignable=false;
	}

	public void normalColor() {
		if ((abscisse+ordonnee)%2==1) setBackground(new Color(222,184,135));
		else setBackground(new Color(25,25,25));
	}

	public void cliquedColor() {
		if ((abscisse+ordonnee)%2==1) setBackground(new Color(222,250,135));
		else setBackground(new Color(0,80,0));
	}

	public void setEstAteignable(Boolean estAteignable) {
		this.estAteignable=estAteignable;
	}

	public Boolean getEstAteignable() {
		return estAteignable;
	}

	public Piece getPiece() {
		return piece;
	}

	public static void setPartie(PartieLocale partie_) {
		partieLocale=partie_;
	}

	public static PartieLocale getPartieLocale() {
		return partieLocale;
	}
	
	public static void setCombat(CombatLocal combat_) {
		combat=combat_;
	}

	public static CombatLocal getCombat() {
		return combat;
	}

	public static void setSize(int size) {
		Case.size = size;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void putImage(Piece piece) {
		removeAll();

		icon = new ImageIcon(TCG.class.getResource(piece.lienImage())); //il faudra généré les images une seule fois!!!
		icon.setImage(icon.getImage().getScaledInstance(size, size,Image.SCALE_SMOOTH));
		setIcon(icon);

		revalidate();
		repaint();
	}
	
	public void imageEchec(Roi piece) {
		removeAll();

		icon = new ImageIcon(TCG.class.getResource("/images/roi"+piece.getCouleur()+"echec.png")); //il faudra généré les images une seule fois!!!
		icon.setImage(icon.getImage().getScaledInstance(size, size,Image.SCALE_SMOOTH));
		setIcon(icon);

		revalidate();
		repaint();

	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public String toString() {
		return "("+this.abscisse+", "+this.ordonnee+")";
	}

	private class ALCase implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) { // quand 

			Plateau plateau = partieLocale.getPlateau();
			Piece piece = plateau.getPiece(abscisse, ordonnee);

			if (estAteignable) {
				plateau.deplace(combat.getPieceAbouger(), abscisse, ordonnee, combat);

				combat.resetAteignable();
				
				partieLocale.ajouttour();
				combat.update();
			}
			
			if (piece!=null) { // on pensera à ajouter un if avec la couleur 
				if (piece.getCouleur()== partieLocale.couleurAjouer()) {
					combat.resetAteignable(); 

					combat.setPieceAbouger(piece);

					ArrayList<int[]> coordCasesAteignables = piece.casesAteignables(plateau);

					//System.out.println(coordCasesAteignables);

					//System.out.println(combat.getArrayButton());

					for(ArrayList<Case> arraycase : combat.getArrayButton()) {
						for(Case case_ : arraycase ) {
							//System.out.println(case_.getAbscisse()+","+case_.getOrdonnee());
							int[] co= {case_.getAbscisse(),case_.getOrdonnee()};
							//System.out.println(co[0]+","+co[1]);
							for (int[] coAteignable : coordCasesAteignables) {
								if (co[0]==coAteignable[0] & co[1]==coAteignable[1]) {
									//System.out.println("do");
									if ((co[0]+co[1])%2==1) case_.setBackground(new Color(222,250,135));
									else case_.setBackground(new Color(0,80,0));
									case_.setEstAteignable(true);
								}
							}
						}
					}
				}
			}
		}
	}
}
