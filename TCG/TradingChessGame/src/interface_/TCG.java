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
	
	public TCG() {
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
		basePanel.removeAll();
		
		EcranTitre ecranTitre = new EcranTitre(this);
		
		basePanel.add(ecranTitre, ecranTitre.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	public void menuPrincipal() {
		basePanel.removeAll();

		MenuPrincipal menuPrincipal = new MenuPrincipal(X,Y,this);
		
		basePanel.add(menuPrincipal, menuPrincipal.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public static void dessinEchiquier(JPanel panel) {
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
	
	public void menuProfil() {
		basePanel.removeAll();

		MenuProfil menuProfil = new MenuProfil(X,Y, this);
		
		basePanel.add(menuProfil, menuProfil.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void gameBoard(Joueur opponent) {
		basePanel.removeAll();

		Combat fight = new Combat(X,Y, this,opponent);
		
		basePanel.add(fight, fight.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void choixCombat() {
		basePanel.removeAll();

		ChoixCombat choixCombat = new ChoixCombat(this,X,Y);
		
		basePanel.add(choixCombat, choixCombat.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void collection() {
		basePanel.removeAll();

		Inventaire inventaire = new Inventaire(this,X,Y);
		
		basePanel.add(inventaire, inventaire.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void menuDeck() {
		basePanel.removeAll();

		MenuDeck menuDeck = new MenuDeck(this,X,Y);
		
		basePanel.add(menuDeck, menuDeck.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void connection() {
		basePanel.removeAll();

		EcranConnection ecranConnection = new EcranConnection(this);
		
		basePanel.add(ecranConnection, ecranConnection.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	public Joueur getPlayer() {
		return player;
	}

	public void setPlayer(Joueur player) {
		this.player = player;
	}
	
	public void creationPartie() {
		basePanel.removeAll();

		CreationPartie creationPartie = new CreationPartie(this);
		
		basePanel.add(creationPartie, creationPartie.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
	
	public void rejoindrePartie() {
		basePanel.removeAll();

		RejoindrePartie rejoindrePartie = new RejoindrePartie(this);
		
		basePanel.add(rejoindrePartie, rejoindrePartie.getGbc());
		
		basePanel.revalidate();
		basePanel.repaint();
	}
}
