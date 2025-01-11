package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classeMetier.*;

public class CombatLocal extends JPanel {

	private Case 
	case00,case01,case02,case03,case04,case05,case06,case07,
	case10,case11,case12,case13,case14,case15,case16,case17,
	case20,case21,case22,case23,case24,case25,case26,case27,
	case30,case31,case32,case33,case34,case35,case36,case37,
	case40,case41,case42,case43,case44,case45,case46,case47,
	case50,case51,case52,case53,case54,case55,case56,case57,
	case60,case61,case62,case63,case64,case65,case66,case67,
	case70,case71,case72,case73,case74,case75,case76,case77;

	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	private int numeroTour;
	
	private JPanel panelAdversaire, panelJoueur, plateau, echiquier;
	
	private JLabel pseudoAdversaire, pseudoJoueur, tour;
	
	private static ArrayList<ArrayList<Case>>  arrayButton;
	
	private PartieLocale partie;
	
	private TCG fenetre;
	
	public CombatLocal(int X,int Y, TCG fenetre, PartieLocale partie) {
		this.fenetre = fenetre;
		this.partie = partie;
		this.numeroTour = 1;
		
		setBackground(new Color(133,6,6));
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {(X-Y)/2, Y, (X-Y)/2};
		gbl.rowHeights = new int[] {Y};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		panelAdversaire = new JPanel();
		panelAdversaire.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelAdversaire = new GridBagConstraints();
		gbc_panelAdversaire.insets = new Insets(0, 0, 0, 5);
		gbc_panelAdversaire.fill = GridBagConstraints.BOTH;
		gbc_panelAdversaire.gridx = 0;
		gbc_panelAdversaire.gridy = 0;
		add(panelAdversaire, gbc_panelAdversaire);
		GridBagLayout gbl_panelAdversaire = new GridBagLayout();
		gbl_panelAdversaire.columnWidths = new int[] {(X-Y)/2};
		gbl_panelAdversaire.rowHeights = new int[] {50, Y-55};
		panelAdversaire.setLayout(gbl_panelAdversaire);
		
		pseudoAdversaire = new JLabel("Joueur 2");
		pseudoAdversaire.setForeground(Color.BLACK);
		pseudoAdversaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoAdversaire.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pseudoAdversaire = new GridBagConstraints();
		gbc_pseudoAdversaire.fill = GridBagConstraints.BOTH;
		gbc_pseudoAdversaire.gridx = 0;
		gbc_pseudoAdversaire.gridy = 0;
		panelAdversaire.add(pseudoAdversaire, gbc_pseudoAdversaire);
		
		panelJoueur = new JPanel();
		panelJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		add(panelJoueur, gbc_panelJoueur);
		GridBagLayout gbl_panelJoueur = new GridBagLayout();
		gbl_panelJoueur.columnWidths = new int[] {(X-Y)/2};
		gbl_panelJoueur.rowHeights = new int[] {50, Y-55};
		panelJoueur.setLayout(gbl_panelJoueur);
		
		pseudoJoueur = new JLabel("Joueur 1");
		pseudoJoueur.setForeground(Color.BLACK);
		pseudoJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		pseudoJoueur.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.fill = GridBagConstraints.BOTH;
		gbc_pseudoJoueur.gridx = 0;
		gbc_pseudoJoueur.gridy = 0;
		panelJoueur.add(pseudoJoueur, gbc_pseudoJoueur);
		
		plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.insets = new Insets(0, 0, 0, 5);
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 1;
		gbc_plateau.gridy = 0;
		add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		gbl_plateau.columnWidths = new int[] {Y-100};
		gbl_plateau.rowHeights = new int[] {30,Y-100};
		plateau.setLayout(gbl_plateau);
		
		if (numeroTour%2==1) tour = new JLabel("Tour : "+numeroTour+" ! Au blanc de jouer !");
		else tour = new JLabel("Tour : "+numeroTour+" ! Au noir de jouer !");
		tour.setForeground(Color.BLACK);
		tour.setHorizontalAlignment(SwingConstants.CENTER);
		tour.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_tour = new GridBagConstraints();
		gbc_tour.fill = GridBagConstraints.BOTH;
		gbc_tour.gridx = 0;
		gbc_tour.gridy = 0;
		plateau.add(tour, gbc_tour);
		
		echiquier = new JPanel();
		echiquier.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_echiquier = new GridBagConstraints();
		gbc_echiquier.fill = GridBagConstraints.BOTH;
		gbc_echiquier.gridx = 0;
		gbc_echiquier.gridy = 1;
		plateau.add(echiquier, gbc_echiquier);
		GridBagLayout gbl_echiquier = new GridBagLayout();
		int x = (Y-140)/8;
		Case.setSize(x);
		gbl_echiquier.columnWidths = new int[] {x, x, x, x, x, x, x, x};
		gbl_echiquier.rowHeights = new int[] {x, x, x, x, x, x, x, x};
		echiquier.setLayout(gbl_echiquier);
		
		creationArrayButton();
		
		echiquier(echiquier);
	}
	
	private void creationArrayButton() {
		ArrayList<Case> A0 = new ArrayList<Case>();
		A0.add(case00); 
		A0.add(case01); 
		A0.add(case02); 
		A0.add(case03); 
		A0.add(case04); 
		A0.add(case05); 
		A0.add(case06); 
		A0.add(case07);
		
		ArrayList<Case> A1 = new ArrayList<Case>();
		A1.add(case10); 
		A1.add(case11); 
		A1.add(case12); 
		A1.add(case13); 
		A1.add(case14); 
		A1.add(case15); 
		A1.add(case16); 
		A1.add(case17);
		
		ArrayList<Case> A2 = new ArrayList<Case>();
		A2.add(case20); 
		A2.add(case21); 
		A2.add(case22); 
		A2.add(case23); 
		A2.add(case24); 
		A2.add(case25); 
		A2.add(case26); 
		A2.add(case27);
		
		ArrayList<Case> A3 = new ArrayList<Case>();
		A3.add(case30); 
		A3.add(case31); 
		A3.add(case32); 
		A3.add(case33); 
		A3.add(case34); 
		A3.add(case35); 
		A3.add(case36); 
		A3.add(case37);
		
		ArrayList<Case> A4 = new ArrayList<Case>();
		A4.add(case40); 
		A4.add(case41); 
		A4.add(case42); 
		A4.add(case43); 
		A4.add(case44); 
		A4.add(case45); 
		A4.add(case46);
		A4.add(case47);
		
		ArrayList<Case> A5 = new ArrayList<Case>();
		A5.add(case50); 
		A5.add(case51); 
		A5.add(case52); 
		A5.add(case53); 
		A5.add(case54);
		A5.add(case55); 
		A5.add(case56); 
		A5.add(case57);
		
		ArrayList<Case> A6 = new ArrayList<Case>();
		A6.add(case60); 
		A6.add(case61); 
		A6.add(case62); 
		A6.add(case63); 
		A6.add(case64); 
		A6.add(case65); 
		A6.add(case66); 
		A6.add(case67);
		
		ArrayList<Case> A7 = new ArrayList<Case>();
		A7.add(case70); 
		A7.add(case71); 
		A7.add(case72);
		A7.add(case73);
		A7.add(case74); 
		A7.add(case75); 
		A7.add(case76); 
		A7.add(case77);
		
		arrayButton = new ArrayList<ArrayList<Case>>();
		arrayButton.add(A7);
		arrayButton.add(A6);
		arrayButton.add(A5);
		arrayButton.add(A4);
		arrayButton.add(A3);
		arrayButton.add(A2);
		arrayButton.add(A1);
		arrayButton.add(A0);
		
	}
	
	public int getNumeroTour() {
		return numeroTour;
	}

	public void setNumeroTour(int numeroTour) {
		this.numeroTour = numeroTour;
	}
	
	private void placementInitial(Case tile) {
		for (Piece p : partie.getPlateau().getListepieces()) {
			if (p.getX()==tile.getAbscisse()&&p.getY()==tile.getOrdonnee()) {
				tile.setPiece(p);
				tile.putImage(p);
			}
		}
	}
	
	private void echiquier(JPanel panel) {
		int i = 0;
		for (ArrayList<Case> a : arrayButton) {
			int j = 0;
			for (Case c: a) {
				if (partie.getPlateau().getPiece(j, i)!=null) {
					if (partie.getPlateau().getPiece(j, i).getX()==j&&partie.getPlateau().getPiece(j, i).getY()==i) {
						c = new Case(j,i,partie.getPlateau().getPiece(j, i));
					}
				}
				else c = new Case(j,i);
				//placementInitial(c);
				panel.add(c,c.getGbc());
				j++;
			}
			i++;
		}
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}
}
