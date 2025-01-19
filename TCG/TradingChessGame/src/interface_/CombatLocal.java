package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classeMetier.*;
import pieces.Roi;

public class CombatLocal extends JPanel {

	protected Case 
	case00,case01,case02,case03,case04,case05,case06,case07,
	case10,case11,case12,case13,case14,case15,case16,case17,
	case20,case21,case22,case23,case24,case25,case26,case27,
	case30,case31,case32,case33,case34,case35,case36,case37,
	case40,case41,case42,case43,case44,case45,case46,case47,
	case50,case51,case52,case53,case54,case55,case56,case57,
	case60,case61,case62,case63,case64,case65,case66,case67,
	case70,case71,case72,case73,case74,case75,case76,case77;

	protected GridBagLayout gbl;
	protected GridBagConstraints gbc;
	
	protected JButton concederNoir, concederBlanc, voteEgaliteNoir, voteEgaliteBlanc;
	
	protected JLabel pseudoAdversaire, pseudoJoueur;
	
	protected JPanel panelAdversaire, panelJoueur, plateau, echiquier;
	
	protected TableauPiecePrise pieceJoueur1, pieceJoueur2;
	
	protected JLabel tour;
	
	protected ArrayList<ArrayList<Case>>  arrayButton;
	
	protected PartieLocale partie;
	
	protected TCG fenetre;
	
	protected Piece pieceAbouger;
	
	protected boolean voteBlanc, voteNoir;
	
	public CombatLocal(TCG fenetre, PartieLocale partie) {
		this.fenetre = fenetre;
		this.partie = partie;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		voteBlanc = false;
		voteNoir = false;
		
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
		gbc_panelAdversaire.fill = GridBagConstraints.BOTH;
		gbc_panelAdversaire.gridx = 0;
		gbc_panelAdversaire.gridy = 0;
		add(panelAdversaire, gbc_panelAdversaire);
		GridBagLayout gbl_panelAdversaire = new GridBagLayout();
		gbl_panelAdversaire.columnWidths = new int[] {(X-Y)/2};
		gbl_panelAdversaire.rowHeights = new int[] {50,50,50, Y-150};
		panelAdversaire.setLayout(gbl_panelAdversaire);
		
		pseudoAdversaire = new JLabel("Noir");
		pseudoAdversaire.setForeground(Color.BLACK);
		pseudoAdversaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoAdversaire.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pseudoAdversaire = new GridBagConstraints();
		gbc_pseudoAdversaire.fill = GridBagConstraints.BOTH;
		gbc_pseudoAdversaire.gridx = 0;
		gbc_pseudoAdversaire.gridy = 0;
		panelAdversaire.add(pseudoAdversaire, gbc_pseudoAdversaire);
		
		//tableau des pieces prises blanches
		pieceJoueur2 = new TableauPiecePrise();
		GridBagConstraints gbc_pieceJoueur2 = new GridBagConstraints();
		gbc_pieceJoueur2.fill = GridBagConstraints.BOTH;
		gbc_pieceJoueur2.gridx = 0;
		gbc_pieceJoueur2.gridy = 3;
		panelAdversaire.add(pieceJoueur2, gbc_pieceJoueur2);
		
		voteEgaliteNoir = new JButton("Vote pour égalité : Non");
		voteEgaliteNoir.setForeground(Color.BLACK);
		voteEgaliteNoir.setHorizontalAlignment(SwingConstants.CENTER);
		voteEgaliteNoir.setBackground(new Color(192,192,192));
		voteEgaliteNoir.addActionListener(new ALVote("noir"));
		GridBagConstraints gbc_voteEgaliteNoir = new GridBagConstraints();
		gbc_voteEgaliteNoir.fill = GridBagConstraints.BOTH;
		gbc_voteEgaliteNoir.gridx = 0;
		gbc_voteEgaliteNoir.gridy = 2;
		panelAdversaire.add(voteEgaliteNoir, gbc_voteEgaliteNoir);
			
		concederBlanc = new JButton("Concéder au Blanc");
		concederBlanc.setForeground(Color.BLACK);
		concederBlanc.setHorizontalAlignment(SwingConstants.CENTER);
		concederBlanc.setBackground(new Color(192,192,192));
		concederBlanc.addActionListener(new ALConcede("blanc"));
		GridBagConstraints gbc_concederBlanc = new GridBagConstraints();
		gbc_concederBlanc.fill = GridBagConstraints.BOTH;
		gbc_concederBlanc.gridx = 0;
		gbc_concederBlanc.gridy = 1;
		panelAdversaire.add(concederBlanc, gbc_concederBlanc);
		
		panelJoueur = new JPanel();
		panelJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		add(panelJoueur, gbc_panelJoueur);
		GridBagLayout gbl_panelJoueur = new GridBagLayout();
		gbl_panelJoueur.columnWidths = new int[] {(X-Y)/2};
		gbl_panelJoueur.rowHeights = new int[] {50, 50,50, Y-150};
		panelJoueur.setLayout(gbl_panelJoueur);
		
		pseudoJoueur = new JLabel("Blanc");
		pseudoJoueur.setForeground(Color.WHITE);
		pseudoJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		pseudoJoueur.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.fill = GridBagConstraints.BOTH;
		gbc_pseudoJoueur.gridx = 0;
		gbc_pseudoJoueur.gridy = 0;
		panelJoueur.add(pseudoJoueur, gbc_pseudoJoueur);
		
		concederNoir = new JButton("Concéder au Noir");
		concederNoir.setForeground(Color.WHITE);
		concederNoir.setHorizontalAlignment(SwingConstants.CENTER);
		concederNoir.setBackground(new Color(192,192,192));
		concederNoir.addActionListener(new ALConcede("noir"));
		GridBagConstraints gbc_concederNoir = new GridBagConstraints();
		gbc_concederNoir.fill = GridBagConstraints.BOTH;
		gbc_concederNoir.gridx = 0;
		gbc_concederNoir.gridy = 1;
		panelJoueur.add(concederNoir, gbc_concederNoir);
		
		voteEgaliteBlanc = new JButton("Vote pour égalité : Non");
		voteEgaliteBlanc.setForeground(Color.WHITE);
		voteEgaliteBlanc.setHorizontalAlignment(SwingConstants.CENTER);
		voteEgaliteBlanc.setBackground(new Color(192,192,192));
		voteEgaliteBlanc.addActionListener(new ALVote("blanc"));
		GridBagConstraints gbc_voteEgaliteBlanc = new GridBagConstraints();
		gbc_voteEgaliteBlanc.fill = GridBagConstraints.BOTH;
		gbc_voteEgaliteBlanc.gridx = 0;
		gbc_voteEgaliteBlanc.gridy = 2;
		panelJoueur.add(voteEgaliteBlanc, gbc_voteEgaliteBlanc);
		
		//tableau des pieces prises noires
		pieceJoueur1 = new TableauPiecePrise();
		GridBagConstraints gbc_pieceJoueur1 = new GridBagConstraints();
		gbc_pieceJoueur1.fill = GridBagConstraints.BOTH;
		gbc_pieceJoueur1.gridx = 0;
		gbc_pieceJoueur1.gridy = 3;
		panelJoueur.add(pieceJoueur1, gbc_pieceJoueur1);
		
		plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 1;
		gbc_plateau.gridy = 0;
		add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		gbl_plateau.columnWidths = new int[] {Y-100};
		gbl_plateau.rowHeights = new int[] {30,Y-100};
		plateau.setLayout(gbl_plateau);
		
		tour = new JLabel("Tour : "+(partie.getTour()+1)+" ! Au blanc de jouer !");
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
		Case.setSize(x-40);
		gbl_echiquier.columnWidths = new int[] {x, x, x, x, x, x, x, x};
		gbl_echiquier.rowHeights = new int[] {x, x, x, x, x, x, x, x};
		echiquier.setLayout(gbl_echiquier);
		
		creationArrayButton();
		
		echiquier(echiquier);
		
		Case.setPartie(partie);
		
		Case.setCombat(this);
		
		Pouvoir.setCombat(this);
		
		
		//System.out.println(arrayButton);
	}
	
	
	
	public CombatLocal(int X, int Y, TCG fenetre, PartieLocale partie) {
		this.fenetre = fenetre;
		this.partie = partie;
		
		voteBlanc = false;
		voteNoir = false;
		
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
		gbc_panelAdversaire.fill = GridBagConstraints.BOTH;
		gbc_panelAdversaire.gridx = 0;
		gbc_panelAdversaire.gridy = 0;
		add(panelAdversaire, gbc_panelAdversaire);
		GridBagLayout gbl_panelAdversaire = new GridBagLayout();
		gbl_panelAdversaire.columnWidths = new int[] {(X-Y)/2};
		gbl_panelAdversaire.rowHeights = new int[] {50,50,50, Y-150};
		panelAdversaire.setLayout(gbl_panelAdversaire);
		
		pseudoAdversaire = new JLabel("Noir");
		pseudoAdversaire.setForeground(Color.BLACK);
		pseudoAdversaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoAdversaire.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pseudoAdversaire = new GridBagConstraints();
		gbc_pseudoAdversaire.fill = GridBagConstraints.BOTH;
		gbc_pseudoAdversaire.gridx = 0;
		gbc_pseudoAdversaire.gridy = 0;
		panelAdversaire.add(pseudoAdversaire, gbc_pseudoAdversaire);
		
		//tableau des pieces prises blanches
		pieceJoueur2 = new TableauPiecePrise();
		GridBagConstraints gbc_pieceJoueur2 = new GridBagConstraints();
		gbc_pieceJoueur2.fill = GridBagConstraints.BOTH;
		gbc_pieceJoueur2.gridx = 0;
		gbc_pieceJoueur2.gridy = 3;
		panelAdversaire.add(pieceJoueur2, gbc_pieceJoueur2);
		
		voteEgaliteNoir = new JButton("Vote pour égalité : Non");
		voteEgaliteNoir.setForeground(Color.BLACK);
		voteEgaliteNoir.setHorizontalAlignment(SwingConstants.CENTER);
		voteEgaliteNoir.setBackground(new Color(192,192,192));
		voteEgaliteNoir.addActionListener(new ALVote("noir"));
		GridBagConstraints gbc_voteEgaliteNoir = new GridBagConstraints();
		gbc_voteEgaliteNoir.fill = GridBagConstraints.BOTH;
		gbc_voteEgaliteNoir.gridx = 0;
		gbc_voteEgaliteNoir.gridy = 2;
		panelAdversaire.add(voteEgaliteNoir, gbc_voteEgaliteNoir);
			
		concederBlanc = new JButton("Concéder au Blanc");
		concederBlanc.setForeground(Color.BLACK);
		concederBlanc.setHorizontalAlignment(SwingConstants.CENTER);
		concederBlanc.setBackground(new Color(192,192,192));
		concederBlanc.addActionListener(new ALConcede("blanc"));
		GridBagConstraints gbc_concederBlanc = new GridBagConstraints();
		gbc_concederBlanc.fill = GridBagConstraints.BOTH;
		gbc_concederBlanc.gridx = 0;
		gbc_concederBlanc.gridy = 1;
		panelAdversaire.add(concederBlanc, gbc_concederBlanc);
		
		panelJoueur = new JPanel();
		panelJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		add(panelJoueur, gbc_panelJoueur);
		GridBagLayout gbl_panelJoueur = new GridBagLayout();
		gbl_panelJoueur.columnWidths = new int[] {(X-Y)/2};
		gbl_panelJoueur.rowHeights = new int[] {50, 50,50, Y-150};
		panelJoueur.setLayout(gbl_panelJoueur);
		
		pseudoJoueur = new JLabel("Blanc");
		pseudoJoueur.setForeground(Color.WHITE);
		pseudoJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		pseudoJoueur.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.fill = GridBagConstraints.BOTH;
		gbc_pseudoJoueur.gridx = 0;
		gbc_pseudoJoueur.gridy = 0;
		panelJoueur.add(pseudoJoueur, gbc_pseudoJoueur);
		
		concederNoir = new JButton("Concéder au Noir");
		concederNoir.setForeground(Color.WHITE);
		concederNoir.setHorizontalAlignment(SwingConstants.CENTER);
		concederNoir.setBackground(new Color(192,192,192));
		concederNoir.addActionListener(new ALConcede("noir"));
		GridBagConstraints gbc_concederNoir = new GridBagConstraints();
		gbc_concederNoir.fill = GridBagConstraints.BOTH;
		gbc_concederNoir.gridx = 0;
		gbc_concederNoir.gridy = 1;
		panelJoueur.add(concederNoir, gbc_concederNoir);
		
		voteEgaliteBlanc = new JButton("Vote pour égalité : Non");
		voteEgaliteBlanc.setForeground(Color.WHITE);
		voteEgaliteBlanc.setHorizontalAlignment(SwingConstants.CENTER);
		voteEgaliteBlanc.setBackground(new Color(192,192,192));
		voteEgaliteBlanc.addActionListener(new ALVote("blanc"));
		GridBagConstraints gbc_voteEgaliteBlanc = new GridBagConstraints();
		gbc_voteEgaliteBlanc.fill = GridBagConstraints.BOTH;
		gbc_voteEgaliteBlanc.gridx = 0;
		gbc_voteEgaliteBlanc.gridy = 2;
		panelJoueur.add(voteEgaliteBlanc, gbc_voteEgaliteBlanc);
		
		//tableau des pieces prises noires
		pieceJoueur1 = new TableauPiecePrise();
		GridBagConstraints gbc_pieceJoueur1 = new GridBagConstraints();
		gbc_pieceJoueur1.fill = GridBagConstraints.BOTH;
		gbc_pieceJoueur1.gridx = 0;
		gbc_pieceJoueur1.gridy = 3;
		panelJoueur.add(pieceJoueur1, gbc_pieceJoueur1);
		
		plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 1;
		gbc_plateau.gridy = 0;
		add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		gbl_plateau.columnWidths = new int[] {Y-100};
		gbl_plateau.rowHeights = new int[] {30,Y-100};
		plateau.setLayout(gbl_plateau);
		
		tour = new JLabel("Tour : 1 ! Au blanc de jouer !");
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
		Case.setSize(x-40);
		gbl_echiquier.columnWidths = new int[] {x, x, x, x, x, x, x, x};
		gbl_echiquier.rowHeights = new int[] {x, x, x, x, x, x, x, x};
		echiquier.setLayout(gbl_echiquier);
		
		creationArrayButton();
		
		echiquier(echiquier);
		
		Case.setPartie(partie);
		
		Case.setCombat(this);
		
		Pouvoir.setCombat(this);
		
		//System.out.println(arrayButton);
	}
	
	public TableauPiecePrise getPieceJoueur1() {
		return pieceJoueur1;
	}

	public void setPieceJoueur1(TableauPiecePrise pieceJoueur1) {
		this.pieceJoueur1 = pieceJoueur1;
	}

	public TableauPiecePrise getPieceJoueur2() {
		return pieceJoueur2;
	}

	public void setPieceJoueur2(TableauPiecePrise pieceJoueur2) {
		this.pieceJoueur2 = pieceJoueur2;
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
	
	
	
	public Piece getPieceAbouger() {
		return pieceAbouger;
	}

	public void setPieceAbouger(Piece pieceAbouger) {
		this.pieceAbouger = pieceAbouger;
	}
	
	
	protected void placementInitial(Case tile) {
		for (Piece p : partie.getPlateau().getListepieces()) {
			if (p.getX()==tile.getAbscisse()&&p.getY()==tile.getOrdonnee()) {
				tile.setPiece(p);
				tile.putImage(p);
			}
		}
	}
	
	public void updatePiece(Piece piece){
		for (ArrayList<Case> a:this.arrayButton) {
			for (Case c:a) {
				if (piece.getX()==c.getAbscisse()&&piece.getY()==c.getOrdonnee()) {
					c.setPiece(piece);
					c.putImage(piece);
					c.revalidate();
					c.repaint();
				}				
			}
		}		
	}
	
	public String getCouleurInverse(String couleur) {
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

	public void update() {
		
		if(this instanceof Combat) {
			if (fenetre.getPlayer()==((Partie) partie).joueuraJouer()) ((Combat)this).enable(false);
			else ((Combat)this).enable(true);
		}
		
		System.out.println("update");
		
		Plateau plateau=partie.getPlateau();
		
		for (ArrayList<Case> a:this.arrayButton) {
			for (Case c:a) {
				c.setIcon(null);			
				
				for (Piece p : plateau.getListepieces()) {
				
					if (p.getX()==c.getAbscisse()&&p.getY()==c.getOrdonnee()) {
						c.setPiece(p);
						c.putImage(p);
					}
				}
				c.revalidate();
				c.repaint();
			}
		}
		
		
		
		if (partie.getTour()%2==0) {
			tour.setText("Tour : "+(partie.getTour()+1)+" ! Au blanc de jouer !");
		}
		else {
			tour.setText("Tour : "+(partie.getTour()+1)+" ! Au noir de jouer !");
		}
		
		plateau.appliquePouvoirs();
		
		if (plateau.getHistoriqueDesCoups().size()!=0)
			System.out.println(plateau.getHistoriqueDesCoups().getLast());
		
		//comme on a déjà ajouté un tour avant l'update, on regarde la mise en echec de la couleur du tour actuel
		if(plateau.estEnEchecEtMat(partie.couleurAjouer())) {
			for (ArrayList<Case> array : this.getArrayButton()) {
				for(Case c : array) {
					try {
						if (c.getPiece() instanceof Roi && c.getPiece().getCouleur()==partie.couleurAjouer()) {
							c.imageEchec((Roi)c.getPiece());
							c.setBackground(new Color(133,6,6));
						}
					}
					catch(NullPointerException e) {
						System.out.println("null");
					}
				}
			}
			if (partie.couleurAjouer()=="blanc") new Victoire(fenetre,"noir");
			else new Victoire(fenetre,"blanc");
		}
		
		if(plateau.estEnPat(partie.couleurAjouer())) {
			Victoire egalite=new Victoire(this.fenetre);
		}
		
		
	}

	public void resetAteignable() {
		for (ArrayList<Case> a:arrayButton) {
			for (Case c: a) {
				c.normalColor();
				c.setEstAteignable(false);
			}
		}
	}

	private void echiquier(JPanel panel) {
		for (int i=0;i<=7;i++) {
			ArrayList<Case> arrayCase = arrayButton.get(i);
			for (int j=0;j<=7;j++) {
					Case c = new Case(j,i);
					arrayCase.set(j, c);
					placementInitial(c);
					panel.add(c,c.getGbc());
			}
		}
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	public ArrayList<ArrayList<Case>> getArrayButton(){
		return this.arrayButton;
	}
	
	private class ALConcede implements ActionListener{
		
		private String couleur;
		
		public ALConcede(String couleur) {
			this.couleur = couleur;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new Victoire(fenetre,couleur);
		}

	}

	private class ALVote implements ActionListener{

		private String couleur;

		public ALVote(String couleur) {
			this.couleur = couleur;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (couleur=="blanc") {
				voteBlanc = !voteBlanc;
				if (voteBlanc==true) voteEgaliteBlanc.setText("Vote pour égalité : Oui");
				else voteEgaliteBlanc.setText("Vote pour égalité : Non");
			}
			else {
				voteNoir = !voteNoir;
				voteEgaliteNoir.setText("Vote pour égalité : "+voteNoir);
				if (voteNoir==true) voteEgaliteNoir.setText("Vote pour égalité : Oui");
				else voteEgaliteNoir.setText("Vote pour égalité : Non");
			}
			if (voteNoir==true&&voteBlanc==true) new Victoire(fenetre);
		}

	}
}
