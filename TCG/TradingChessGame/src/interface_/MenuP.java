package interface_;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.GridBagLayout;

import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MenuP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuP frame = new MenuP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuP() {
		ecranTitre();
	}
	
	private void ecranTitre() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int X = (int)dim.getWidth() ; 
		int Y = (int)dim.getHeight(); 
		setTitle("Trading Chess Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((X/2)-250, (Y/2)-250, 500, 500);
		JPanel Panel = new JPanel();
		Panel.setBackground(new Color(0, 0, 0));
		Panel.setForeground(new Color(0, 0, 0));
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 300, 100};
		gbl_panel.rowHeights = new int[] {100, 300, 30, 100};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		Panel.setLayout(gbl_panel);
		
		JLabel LogoEcranDemarrage = new JLabel("");
		LogoEcranDemarrage.setIcon(new ImageIcon(MenuP.class.getResource("/image/logo4resized.jpg")));
		GridBagConstraints gbc_LogoEcranDemarrage = new GridBagConstraints();
		gbc_LogoEcranDemarrage.insets = new Insets(0, 0, 5, 5);
		gbc_LogoEcranDemarrage.gridx = 1;
		gbc_LogoEcranDemarrage.gridy = 1;
		Panel.add(LogoEcranDemarrage, gbc_LogoEcranDemarrage);
		
		JButton startButton = new JButton("START");
		startButton.addActionListener(new ALstartButton());
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 5, 5);
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 2;
		Panel.add(startButton, gbc_startButton);
		this.setVisible(true);
		
		 
	}
	
	public void menuPrincipale() {
		setTitle("Trading Chess Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int X = screenSize.width; //largeur de l'écran
		int Y = screenSize.height;//hauteur de l'écran
		//setSize(X, Y);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Panel de base de l'interface
		JPanel menu = new JPanel();
		GridBagLayout gbl_menu = new GridBagLayout();
		gbl_menu.columnWidths = new int[]{X/2,X/2}; //Definition des deux colonnes qui accueillerons les deux sous-panels
		gbl_menu.rowHeights = new int[]{Y};
		gbl_menu.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_menu.rowWeights = new double[]{Double.MIN_VALUE};
		menu.setLayout(gbl_menu);
		contentPane.add(menu);
		
		//Définition du menu de Combat à droite
		JPanel menuCombat = new JPanel();
		menuCombat.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_menuCombat = new GridBagConstraints();
		gbc_menuCombat.fill = GridBagConstraints.BOTH;
		gbc_menuCombat.gridx = 0;
		gbc_menuCombat.gridy = 0;
		menu.add(menuCombat, gbc_menuCombat);
		GridBagLayout gbl_menuCombat = new GridBagLayout();
		gbl_menuCombat.columnWidths = new int[]{X/2};
		gbl_menuCombat.rowHeights = new int[]{3*Y/4,Y/4};
		gbl_menuCombat.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_menuCombat.rowWeights = new double[]{Double.MIN_VALUE};
		menuCombat.setLayout(gbl_menuCombat);
		
		// Définition du Menu des Menus à gauche
		JPanel MenuMenu = new JPanel();
		MenuMenu.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_MenuMenu = new GridBagConstraints();
		gbc_MenuMenu.fill = GridBagConstraints.BOTH;
		gbc_MenuMenu.gridx = 1;
		gbc_MenuMenu.gridy = 0;
		menu.add(MenuMenu, gbc_MenuMenu);
		GridBagLayout gbl_MenuMenu = new GridBagLayout();
		gbl_MenuMenu.columnWidths = new int[] {X/2};
		gbl_MenuMenu.rowHeights = new int[] {Y/4, Y/4, Y/4, Y/4};
		gbl_MenuMenu.columnWeights = new double[]{0.0};
		gbl_MenuMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		MenuMenu.setLayout(gbl_MenuMenu);
		
		//Définition du bouton profil
		JButton profil = new JButton("Profil");
		profil.setForeground(new Color(255, 255, 255));
		profil.setBackground(new Color(128, 128, 128));
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
		GridBagConstraints gbc_combat = new GridBagConstraints();
		gbc_combat.fill = GridBagConstraints.BOTH;
		gbc_combat.insets = new Insets(0, 0, 5, 0);
		gbc_combat.gridx = 0;
		gbc_combat.gridy = 1;
		menuCombat.add(combat, gbc_combat);
		
		//Dessin de l'échiquier
		JPanel plateau = new JPanel();
		plateau.setBackground(new Color(0, 0, 0));//code couleur pour les cases blanches
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 0;
		gbc_plateau.gridy = 0;
		menuCombat.add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		//mesure pour les colonnes et les lignes
		int L = 3*Y/4;
		int l = X/2;
		int x = ((L/10)-1);
		int y = (l/2)-(5*x)-5;
		gbl_plateau.columnWidths = new int[]{y,L,y};
		gbl_plateau.rowHeights = new int[]{L};
		gbl_plateau.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_plateau.rowWeights = new double[]{Double.MIN_VALUE};
		plateau.setLayout(gbl_plateau);
		
		JPanel echiquier = new JPanel();
		echiquier.setBackground(Color.BLACK);//code couleur pour les cases blanches
		GridBagConstraints gbc_echiquier = new GridBagConstraints();
		gbc_echiquier.fill = GridBagConstraints.BOTH;
		gbc_echiquier.gridx = 1;
		gbc_echiquier.gridy = 0;
		plateau.add(echiquier, gbc_echiquier);
		GridBagLayout gbl_echiquier = new GridBagLayout();
		gbl_echiquier.columnWidths = new int[]{5,x,x,x,x,x,x,x,x,x,x,5};
		gbl_echiquier.rowHeights = new int[]{5,x,x,x,x,x,x,x,x,x,x,5};
		gbl_echiquier.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_echiquier.rowWeights = new double[]{Double.MIN_VALUE};
		echiquier.setLayout(gbl_echiquier);
		dessinEchiquier(echiquier);
	}
	
	private void dessinEchiquier(JPanel panel) {
		for(int i=1; i<=10;i++) {
			for (int j=1; j<=10;j++) {
				if ((j+i)%2==0) {
					JLabel caseNoir = new JLabel();
					caseNoir.setIcon(new ImageIcon(MenuP.class.getResource("/image/caseNoir.png")));
					GridBagConstraints gbc_caseNoir = new GridBagConstraints();
					gbc_caseNoir.fill = GridBagConstraints.BOTH;
					gbc_caseNoir.gridx = j;
					gbc_caseNoir.gridy = i;
					panel.add(caseNoir,gbc_caseNoir);
				}
				else {
					JLabel caseBlanche = new JLabel();
					caseBlanche.setIcon(new ImageIcon(MenuP.class.getResource("/image/caseBlanche.png")));
					GridBagConstraints gbc_caseBlanche = new GridBagConstraints();
					gbc_caseBlanche.fill = GridBagConstraints.BOTH;
					gbc_caseBlanche.gridx = j;
					gbc_caseBlanche.gridy = i;
					panel.add(caseBlanche,gbc_caseBlanche);
				}
			}
		}
	}
	
	private class ALstartButton implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			menuPrincipale();
			
		}
	}
}
