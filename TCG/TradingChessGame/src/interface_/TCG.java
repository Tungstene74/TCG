package interface_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classeDAO.*;
import classeMetier.*;

public class TCG extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private int X ;
	private int Y ;
	private JPanel basePanel;
	private Joueur player;
	
	//pour lancer l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCG frame = new TCG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TCG() {//Constructeur
		//Definition du titre de la fenêtre
		setTitle("Trading Chess Game v2");
		
		//récupération de la taille de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		X = (int)dim.getWidth(); 
		Y = (int)dim.getHeight() - 50;
		
		//Paramétrage du panel de base
		basePanel = new JPanel();
		basePanel.setBackground(new Color(0, 0, 0));
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0};
		gbl_panel.rowHeights = new int[] {0};
		basePanel.setLayout(gbl_panel);
		
		//Paramétrage de la fenêtre
		setBackground(new Color(0, 0, 0));
		setContentPane(basePanel);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Affichage de l'écran titre
		ecranTitre();
	}
	
	public void ecranTitre() {
		basePanel.removeAll();//efface tous ce qu'il y a sur basePanel
		
		EcranTitre ecranTitre = new EcranTitre(this); //creation du panel ecranTitre
		
		basePanel.add(ecranTitre, ecranTitre.getGbc()); // ajout à basePanel
		
		//repaint BasePanel
		basePanel.revalidate();
		basePanel.repaint();
	}
	public void menuPrincipal() {//obselète
		basePanel.removeAll();

		MenuPrincipal menuPrincipal = new MenuPrincipal(this);//création du menu principal
		
		basePanel.add(menuPrincipal, menuPrincipal.getGbc());//ajout du MP au panel de base
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void menuPrincipal2() {//actuelle
		basePanel.removeAll();

		MenuPrincipal2 menuPrincipal = new MenuPrincipal2(this);
		
		basePanel.add(menuPrincipal, menuPrincipal.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public static void dessinEchiquier(JPanel panel) {//dessin de l'echiquier sur le panel 8x8 passer en paramètre
		for(int i=1; i<=8;i++) {
			for (int j=1; j<=8;j++) {
				if ((j+i)%2==0) {
					JLabel caseNoir = new JLabel();//case noir de l'échiquier
					caseNoir.setOpaque(true); //les JLAbel sont transparent de base donc on les rend opaque
					caseNoir.setBackground(Color.BLACK);// changement de couleur de fond
					//ajout au Layout
					GridBagConstraints gbc_caseNoir = new GridBagConstraints(); 
					gbc_caseNoir.fill = GridBagConstraints.BOTH;
					gbc_caseNoir.gridx = j;
					gbc_caseNoir.gridy = i;
					panel.add(caseNoir,gbc_caseNoir);
				}
				else {
					JLabel caseBlanche = new JLabel();//case blanche de l'échiquier
					caseBlanche.setOpaque(true);
					caseBlanche.setBackground(new Color(222, 184, 135));//couleur bois
					//ajout au Layout
					GridBagConstraints gbc_caseBlanche = new GridBagConstraints();
					gbc_caseBlanche.fill = GridBagConstraints.BOTH;
					gbc_caseBlanche.gridx = j;
					gbc_caseBlanche.gridy = i;
					panel.add(caseBlanche,gbc_caseBlanche);
				}
			}
		}
	}
	
	public void menuProfil() {// panel du menu du profil du joueur
		basePanel.removeAll();

		MenuProfil menuProfil = new MenuProfil(this);
		
		basePanel.add(menuProfil, menuProfil.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void gameBoard(Joueur opponent, boolean jCreator, Partie partie) {// plateau de combat
		basePanel.removeAll();

		Combat fight = new Combat(this,partie,jCreator, opponent);
		
		basePanel.add(fight, fight.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void choixCombat() { //pour choisir entre créer ou rejoidre une partie en ligne ou faire une partie locale
		basePanel.removeAll();

		ChoixCombat choixCombat = new ChoixCombat(this);
		
		basePanel.add(choixCombat, choixCombat.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	//obselète
	public void collection() {// écran de la collection/inventaire de pièce 
		basePanel.removeAll();

		Inventaire inventaire = new Inventaire(this);
		
		basePanel.add(inventaire, inventaire.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	//obselète
	public void menuDeck() {// écran de conception de deck
		basePanel.removeAll();

		MenuDeck menuDeck = new MenuDeck(this);
		
		basePanel.add(menuDeck, menuDeck.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void connection() { // écran de connection pour se connecter à son compte joueur
		basePanel.removeAll();

		EcranConnection ecranConnection = new EcranConnection(this);
		
		basePanel.add(ecranConnection, ecranConnection.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	// setter et getter de joueur
	public Joueur getPlayer() {
		return player;
	}

	public void setPlayer(Joueur player) {
		this.player = player;
	}
	
	//écran de création de partie
	public void creationPartie() {
		basePanel.removeAll();

		CreationPartie creationPartie = new CreationPartie(this);
		
		basePanel.add(creationPartie, creationPartie.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	//ecran pour rejoindre une partie
	public void rejoindrePartie() {
		basePanel.removeAll();

		RejoindrePartie rejoindrePartie = new RejoindrePartie(this);
		
		basePanel.add(rejoindrePartie, rejoindrePartie.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	// plateau de jeu lors d'un combat local
	public void combatLocal(PartieLocale partie) {
		basePanel.removeAll();

		CombatLocal fight = new CombatLocal(this, partie);
		
		basePanel.add(fight, fight.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	//lancement rapide d'un combat local via MainCombatLocal 
	public void mainCombatLocal(PartieLocale partie) {
		basePanel.removeAll();

		CombatLocal fight = new CombatLocal(X,Y,this, partie);
		
		basePanel.add(fight, fight.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
}


