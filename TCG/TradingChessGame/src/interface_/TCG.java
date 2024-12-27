package interface_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TCG extends JFrame{
	
	private int X ;
	private int Y ;
	private JPanel basePanel = new JPanel();
	
	public TCG() {
		setTitle("Trading Chess Game");
		setBackground(new Color(128, 128, 128));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		X = (int)dim.getWidth() ; 
		Y = (int)dim.getHeight(); 
		basePanel.setBackground(new Color(0, 0, 0));
		basePanel.setForeground(new Color(0, 0, 0));
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(basePanel);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ecranTitre();
		setVisible(true);
	}
	
	private void ecranTitre() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 300, 100};
		gbl_panel.rowHeights = new int[] {100, 300, 30, 100};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		basePanel.setLayout(gbl_panel);
		
		JLabel LogoEcranDemarrage = new JLabel("");
		LogoEcranDemarrage.setIcon(new ImageIcon(TCG.class.getResource("/images/logo4resized.jpg")));
		GridBagConstraints gbc_LogoEcranDemarrage = new GridBagConstraints();
		gbc_LogoEcranDemarrage.insets = new Insets(0, 0, 5, 5);
		gbc_LogoEcranDemarrage.gridx = 1;
		gbc_LogoEcranDemarrage.gridy = 1;
		basePanel.add(LogoEcranDemarrage, gbc_LogoEcranDemarrage);
		
		JButton startButton = new JButton("START");
		startButton.addActionListener(new ALstartButton());
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 5, 5);
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 2;
		basePanel.add(startButton, gbc_startButton);
		this.setVisible(true);
		 
	}
	
	private void menuPrincipale() {
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[]{X/2,X/2}; //Definition des deux colonnes qui accueillerons les deux sous-panels
		gbl_basePanel.rowHeights = new int[]{Y};
		basePanel.setLayout(gbl_basePanel);
		setContentPane(basePanel);
		
		//Définition du menu de Combat à droite
		JPanel menuCombat = new JPanel();
		menuCombat.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_menuCombat = new GridBagConstraints();
		gbc_menuCombat.fill = GridBagConstraints.BOTH;
		gbc_menuCombat.gridx = 0;
		gbc_menuCombat.gridy = 0;
		basePanel.add(menuCombat, gbc_menuCombat);
		GridBagLayout gbl_menuCombat = new GridBagLayout();
		gbl_menuCombat.columnWidths = new int[]{X/2};
		gbl_menuCombat.rowHeights = new int[]{5,3*Y/4,Y/4};
		menuCombat.setLayout(gbl_menuCombat);
		
		// Définition du Menu des Menus à gauche
		JPanel MenuMenu = new JPanel();
		MenuMenu.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_MenuMenu = new GridBagConstraints();
		gbc_MenuMenu.fill = GridBagConstraints.BOTH;
		gbc_MenuMenu.gridx = 1;
		gbc_MenuMenu.gridy = 0;
		basePanel.add(MenuMenu, gbc_MenuMenu);
		GridBagLayout gbl_MenuMenu = new GridBagLayout();
		gbl_MenuMenu.columnWidths = new int[] {X/2};
		gbl_MenuMenu.rowHeights = new int[] {Y/4, Y/4, Y/4, Y/4};
		MenuMenu.setLayout(gbl_MenuMenu);
		
		//Définition du bouton profil
		JButton profil = new JButton("Profil");
		profil.setForeground(new Color(255, 255, 255));
		profil.setBackground(new Color(128, 128, 128));
		profil.addActionListener(new ALProfil());
		GridBagConstraints gbc_profil = new GridBagConstraints();
		gbc_profil.fill = GridBagConstraints.BOTH;
		gbc_profil.insets = new Insets(0, 0, 5, 0);
		gbc_profil.gridx = 0;
		gbc_profil.gridy = 0;
		MenuMenu.add(profil, gbc_profil);
		
		//Definition du bouton collection
		JButton collection = new JButton("Collection");
		collection.setForeground(new Color(255, 255, 255));
		collection.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_collection = new GridBagConstraints();
		gbc_collection.fill = GridBagConstraints.BOTH;
		gbc_collection.insets = new Insets(0, 0, 5, 0);
		gbc_collection.gridx = 0;
		gbc_collection.gridy = 1;
		MenuMenu.add(collection, gbc_collection);
		
		//Definition du bouton deck
		JButton deck = new JButton("Deck");
		deck.setForeground(new Color(255, 255, 255));
		deck.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_deck = new GridBagConstraints();
		gbc_deck.fill = GridBagConstraints.BOTH;
		gbc_deck.insets = new Insets(0, 0, 5, 0);
		gbc_deck.gridx = 0;
		gbc_deck.gridy = 2;
		MenuMenu.add(deck, gbc_deck);
		
		//Definition du bouton du Gacha
		JButton tirage = new JButton("Tirage");
		tirage.setForeground(new Color(255, 255, 255));
		tirage.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_tirage = new GridBagConstraints();
		gbc_tirage.fill = GridBagConstraints.BOTH;
		gbc_tirage.insets = new Insets(0, 0, 5, 0);
		gbc_tirage.gridx = 0;
		gbc_tirage.gridy = 3;
		MenuMenu.add(tirage, gbc_tirage);
		
		//Definition du bouton Combat
		JButton combat = new JButton("Combat");
		combat.setForeground(new Color(255, 255, 255));
		combat.setBackground(new Color(128, 128, 128));
		combat.addActionListener(new ALCombat());
		GridBagConstraints gbc_combat = new GridBagConstraints();
		gbc_combat.fill = GridBagConstraints.BOTH;
		gbc_combat.insets = new Insets(0, 0, 5, 0);
		gbc_combat.gridx = 0;
		gbc_combat.gridy = 2;
		menuCombat.add(combat, gbc_combat);
		
		//Dessin de l'échiquier
		JPanel plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 0;
		gbc_plateau.gridy = 1;
		menuCombat.add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		//mesure pour les colonnes et les lignes
		int L = 3*Y/4;
		int l = X/2;
		int x = ((L/8)-1);
		int y = (l/2)-(4*x)-4;
		gbl_plateau.columnWidths = new int[]{y,L,y};
		gbl_plateau.rowHeights = new int[]{L};
		plateau.setLayout(gbl_plateau);
		
		JPanel echiquier = new JPanel();
		echiquier.setBackground(Color.BLACK);
		GridBagConstraints gbc_echiquier = new GridBagConstraints();
		gbc_echiquier.fill = GridBagConstraints.BOTH;
		gbc_echiquier.gridx = 1;
		gbc_echiquier.gridy = 0;
		plateau.add(echiquier, gbc_echiquier);
		GridBagLayout gbl_echiquier = new GridBagLayout();
		gbl_echiquier.columnWidths = new int[]{4,x,x,x,x,x,x,x,x,4};
		gbl_echiquier.rowHeights = new int[]{4,x,x,x,x,x,x,x,x,4};
		echiquier.setLayout(gbl_echiquier);
		dessinEchiquier(echiquier);
	}
	
	private void dessinEchiquier(JPanel panel) {
		for(int i=1; i<=8;i++) {
			for (int j=1; j<=8;j++) {
				if ((j+i)%2==0) {
					JLabel caseNoir = new JLabel();
					caseNoir.setOpaque(true);
					caseNoir.setBackground(Color.BLACK);
					GridBagConstraints gbc_caseNoir = new GridBagConstraints();
					gbc_caseNoir.fill = GridBagConstraints.BOTH;
					gbc_caseNoir.gridx = j;
					gbc_caseNoir.gridy = i;
					panel.add(caseNoir,gbc_caseNoir);
				}
				else {
					JLabel caseBlanche = new JLabel();
					caseBlanche.setOpaque(true);
					caseBlanche.setBackground(new Color(222, 184, 135));
					GridBagConstraints gbc_caseBlanche = new GridBagConstraints();
					gbc_caseBlanche.fill = GridBagConstraints.BOTH;
					gbc_caseBlanche.gridx = j;
					gbc_caseBlanche.gridy = i;
					panel.add(caseBlanche,gbc_caseBlanche);
				}
			}
		}
	}
	
	private void menuProfil() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {X/3, X/3-10, X/3};
		gbl_contentPane.rowHeights = new int[] {Y};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0};
		basePanel.setLayout(gbl_contentPane);
		
		JPanel panelBoutonHome = new JPanel();
		panelBoutonHome.setBackground(new Color(0, 0, 0));
		panelBoutonHome.setLayout(null);
		GridBagConstraints gbc_panelBoutonHome = new GridBagConstraints();
		gbc_panelBoutonHome.insets = new Insets(0, 0, 0, 5);
		gbc_panelBoutonHome.fill = GridBagConstraints.BOTH;
		gbc_panelBoutonHome.gridx = 0;
		gbc_panelBoutonHome.gridy = 0;
		basePanel.add(panelBoutonHome, gbc_panelBoutonHome);
		
		JButton boutonHome = new JButton("<=");
		boutonHome.setBackground(new Color(0, 0, 0));
		boutonHome.setForeground(new Color(133, 6, 6));
		boutonHome.addActionListener(new ALstartButton());
		boutonHome.setBounds(0, 0, 85, 21);
		panelBoutonHome.add(boutonHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(new Color(220, 178, 83));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		basePanel.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(133, 6, 6));
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] {45, 150, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};
		gbl_panel.columnWidths = new int[] {X/9-5, X/9, X/9-5};
		panel.setLayout(gbl_panel);
		
		JLabel profil = new JLabel("PROFIL");
		profil.setForeground(new Color(0, 0, 0));
		profil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profil.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_profil = new GridBagConstraints();
		gbc_profil.insets = new Insets(0, 0, 5, 0);
		gbc_profil.fill = GridBagConstraints.BOTH;
		gbc_profil.gridx = 1;
		gbc_profil.gridy = 0;
		panel.add(profil, gbc_profil);
		
		JLabel photo = new JLabel("");
		photo.setForeground(new Color(0, 0, 0));
		photo.setIcon(new ImageIcon(MenuProfil.class.getResource("/image/logo3resized.png")));
		GridBagConstraints gbc_photo = new GridBagConstraints();
		gbc_photo.insets = new Insets(0, 0, 5, 0);
		gbc_photo.gridx = 1;
		gbc_photo.gridy = 1;
		panel.add(photo, gbc_photo);
		
		JLabel nomUtilisateur = new JLabel("pseudo");
		nomUtilisateur.setForeground(new Color(0, 0, 0));
		nomUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 20));
		nomUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nomUtilisateur = new GridBagConstraints();
		gbc_nomUtilisateur.insets = new Insets(0, 0, 5, 0);
		gbc_nomUtilisateur.gridx = 1;
		gbc_nomUtilisateur.gridy = 2;
		panel.add(nomUtilisateur, gbc_nomUtilisateur);
		
		JLabel statistiques = new JLabel("<html><u>Statistiques :</u></html>");
		statistiques.setForeground(new Color(0, 0, 0));
		statistiques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statistiques.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Statistiques = new GridBagConstraints();
		gbc_Statistiques.fill = GridBagConstraints.BOTH;
		gbc_Statistiques.insets = new Insets(0, 0, 5, 0);
		gbc_Statistiques.gridx = 1;
		gbc_Statistiques.gridy = 3;
		panel.add(statistiques, gbc_Statistiques);
		
		JLabel nbPartiesJouees = new JLabel(" - nombres de parties jouées :");
		nbPartiesJouees.setBackground(Color.WHITE);
		nbPartiesJouees.setForeground(new Color(0, 0, 0));
		nbPartiesJouees.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPartiesJouees = new GridBagConstraints();
		gbc_nbPartiesJouees.insets = new Insets(0, 0, 5, 0);
		gbc_nbPartiesJouees.fill = GridBagConstraints.BOTH;
		gbc_nbPartiesJouees.gridx = 1;
		gbc_nbPartiesJouees.gridy = 4;
		panel.add(nbPartiesJouees, gbc_nbPartiesJouees);
		
		JLabel nbPartiesGagnees = new JLabel(" - nombre de parties gagnées : ");
		nbPartiesGagnees.setForeground(new Color(0, 0, 0));
		nbPartiesGagnees.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPartiesGagnees = new GridBagConstraints();
		gbc_nbPartiesGagnees.insets = new Insets(0, 0, 5, 0);
		gbc_nbPartiesGagnees.fill = GridBagConstraints.BOTH;
		gbc_nbPartiesGagnees.gridx = 1;
		gbc_nbPartiesGagnees.gridy = 5;
		panel.add(nbPartiesGagnees, gbc_nbPartiesGagnees);
		
		JLabel nbPieces = new JLabel(" - nombre de pièces obtenues : ");
		nbPieces.setForeground(new Color(0, 0, 0));
		nbPieces.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPieces = new GridBagConstraints();
		gbc_nbPieces.insets = new Insets(0, 0, 5, 0);
		gbc_nbPieces.fill = GridBagConstraints.BOTH;
		gbc_nbPieces.gridx = 1;
		gbc_nbPieces.gridy = 6;
		panel.add(nbPieces, gbc_nbPieces);
		
		JLabel nbRoi = new JLabel(" - nombre de rois obtenus : ");
		nbRoi.setForeground(new Color(0, 0, 0));
		nbRoi.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbRoi = new GridBagConstraints();
		gbc_nbRoi.insets = new Insets(0, 0, 5, 0);
		gbc_nbRoi.fill = GridBagConstraints.BOTH;
		gbc_nbRoi.gridx = 1;
		gbc_nbRoi.gridy = 7;
		panel.add(nbRoi, gbc_nbRoi);
		
		JLabel nbDames = new JLabel(" - nombre de dames obtenues :");
		nbDames.setForeground(new Color(0, 0, 0));
		nbDames.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbDames = new GridBagConstraints();
		gbc_nbDames.fill = GridBagConstraints.BOTH;
		gbc_nbDames.insets = new Insets(0, 0, 5, 0);
		gbc_nbDames.gridx = 1;
		gbc_nbDames.gridy = 8;
		panel.add(nbDames, gbc_nbDames);
		
		JLabel nbFou = new JLabel(" - nombres de fous obtenus :");
		nbFou.setForeground(new Color(0, 0, 0));
		nbFou.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbFou = new GridBagConstraints();
		gbc_nbFou.fill = GridBagConstraints.BOTH;
		gbc_nbFou.insets = new Insets(0, 0, 5, 0);
		gbc_nbFou.gridx = 1;
		gbc_nbFou.gridy = 9;
		panel.add(nbFou, gbc_nbFou);
		
		JLabel nbCavalier = new JLabel("- nombre de cavaliers obtenues :");
		nbCavalier.setHorizontalAlignment(SwingConstants.LEFT);
		nbCavalier.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_nbCavalier = new GridBagConstraints();
		gbc_nbCavalier.insets = new Insets(0, 0, 5, 0);
		gbc_nbCavalier.fill = GridBagConstraints.BOTH;
		gbc_nbCavalier.gridx = 1;
		gbc_nbCavalier.gridy = 10;
		panel.add(nbCavalier, gbc_nbCavalier);
		
		JLabel nbTour = new JLabel(" - nombre de tours obtenues");
		nbTour.setForeground(new Color(0, 0, 0));
		nbTour.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbTour = new GridBagConstraints();
		gbc_nbTour.insets = new Insets(0, 0, 5, 0);
		gbc_nbTour.fill = GridBagConstraints.BOTH;
		gbc_nbTour.gridx = 1;
		gbc_nbTour.gridy = 11;
		panel.add(nbTour, gbc_nbTour);
		
		JLabel nbPion = new JLabel(" - nombre de pions obtenus :");
		nbPion.setForeground(new Color(0, 0, 0));
		nbPion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPion = new GridBagConstraints();
		gbc_nbPion.fill = GridBagConstraints.BOTH;
		gbc_nbPion.gridx = 1;
		gbc_nbPion.gridy = 12;
		panel.add(nbPion, gbc_nbPion);
	}
	
	private void gameBoard() {
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[] {(X-Y)/2, Y, (X-Y)/2};
		gbl_basePanel.rowHeights = new int[] {Y};
		basePanel.setLayout(gbl_basePanel);
		
		JPanel panelAdversaire = new JPanel();
		panelAdversaire.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelAdversaire = new GridBagConstraints();
		gbc_panelAdversaire.insets = new Insets(0, 0, 0, 5);
		gbc_panelAdversaire.fill = GridBagConstraints.BOTH;
		gbc_panelAdversaire.gridx = 0;
		gbc_panelAdversaire.gridy = 0;
		basePanel.add(panelAdversaire, gbc_panelAdversaire);
		GridBagLayout gbl_panelAdversaire = new GridBagLayout();
		gbl_panelAdversaire.columnWidths = new int[] {(X-Y)/2};
		gbl_panelAdversaire.rowHeights = new int[] {50, Y-55};
		panelAdversaire.setLayout(gbl_panelAdversaire);
		
		JLabel pseudoAdversaire = new JLabel("Adversaire");
		pseudoAdversaire.setForeground(Color.BLACK);
		pseudoAdversaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoAdversaire.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pseudoAdversaire = new GridBagConstraints();
		gbc_pseudoAdversaire.fill = GridBagConstraints.BOTH;
		gbc_pseudoAdversaire.gridx = 0;
		gbc_pseudoAdversaire.gridy = 0;
		panelAdversaire.add(pseudoAdversaire, gbc_pseudoAdversaire);
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		basePanel.add(panelJoueur, gbc_panelJoueur);
		GridBagLayout gbl_panelJoueur = new GridBagLayout();
		gbl_panelJoueur.columnWidths = new int[] {(X-Y)/2};
		gbl_panelJoueur.rowHeights = new int[] {50, Y-55};
		panelJoueur.setLayout(gbl_panelJoueur);
		
		JLabel pseudoJoueur = new JLabel("Joueur");
		pseudoJoueur.setForeground(Color.BLACK);
		pseudoJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		pseudoJoueur.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.fill = GridBagConstraints.BOTH;
		gbc_pseudoJoueur.gridx = 0;
		gbc_pseudoJoueur.gridy = 0;
		panelJoueur.add(pseudoJoueur, gbc_pseudoJoueur);
		
		JPanel plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.insets = new Insets(0, 0, 0, 5);
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 1;
		gbc_plateau.gridy = 0;
		basePanel.add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		gbl_plateau.columnWidths = new int[] {Y-100};
		gbl_plateau.rowHeights = new int[] {30,Y-100};
		plateau.setLayout(gbl_plateau);
		
		JLabel tour = new JLabel("Tour : _ ! A ____ de jouer !");
		tour.setForeground(Color.BLACK);
		tour.setHorizontalAlignment(SwingConstants.CENTER);
		tour.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_tour = new GridBagConstraints();
		gbc_tour.fill = GridBagConstraints.BOTH;
		gbc_tour.gridx = 0;
		gbc_tour.gridy = 0;
		plateau.add(tour, gbc_tour);
		
		JPanel echiquier = new JPanel();
		echiquier.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_echiquier = new GridBagConstraints();
		gbc_echiquier.fill = GridBagConstraints.BOTH;
		gbc_echiquier.gridx = 0;
		gbc_echiquier.gridy = 1;
		plateau.add(echiquier, gbc_echiquier);
		GridBagLayout gbl_echiquier = new GridBagLayout();
		int x = (Y-140)/8;
		gbl_echiquier.columnWidths = new int[] {x, x, x, x, x, x, x, x};
		gbl_echiquier.rowHeights = new int[] {x, x, x, x, x, x, x, x};
		echiquier.setLayout(gbl_echiquier);
		
		echiquier(echiquier);
	}
	
	private void echiquier(JPanel panel) {
		for (int i=0;i<=7;i++) {
			for (int j=0; j<=7;j++) {
				if((i+j+1)%2==1) {
					JButton caseBlanche = new JButton();
					caseBlanche.setBackground(new Color(222,184,135));
					caseBlanche.addActionListener(new ALCase(i,j));
					GridBagConstraints gbc_caseBlanche = new GridBagConstraints();
					gbc_caseBlanche.fill = GridBagConstraints.BOTH;
					gbc_caseBlanche.gridx = j;
					gbc_caseBlanche.gridy = i;
					panel.add(caseBlanche,gbc_caseBlanche);
				}
				else {
					JButton caseNoir = new JButton();
					caseNoir.setBackground(Color.BLACK);
					caseNoir.addActionListener(new ALCase(i,j));
					GridBagConstraints gbc_caseNoir = new GridBagConstraints();
					gbc_caseNoir.fill = GridBagConstraints.BOTH;
					gbc_caseNoir.gridx = j;
					gbc_caseNoir.gridy = i;
					panel.add(caseNoir,gbc_caseNoir);
				}
			}
		}
	}
	
	private class ALstartButton implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			basePanel.removeAll();
			menuPrincipale();
			basePanel.revalidate();
			basePanel.repaint();
			
		}
	}
	
	private class ALProfil implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			basePanel.removeAll();
			menuProfil();
			basePanel.revalidate();
			basePanel.repaint();
		}
	}
	
	private class ALCombat implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			basePanel.removeAll();
			gameBoard();
			basePanel.revalidate();
			basePanel.repaint();
		}
	}
	
	private class ALCase implements ActionListener{
		
		private int ligne;
		private int colonne;
		
		public ALCase(int ligne, int colonne) {
			super();
			this.ligne = ligne;
			this.colonne = colonne;
		}

		public void actionPerformed(ActionEvent event) {
			basePanel.removeAll();
			menuPrincipale();
			basePanel.revalidate();
			basePanel.repaint();
		}
	}
}
