package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import classeMetier.Joueur;

public class MenuDeck extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private JPanel panelDeckBuilder, panelDeckConsulteur, panelBoutonHome;
	
	private JButton deckBuilder, consultDeck, boutonHome;
	
	public MenuDeck(TCG fenetre) {
		this.fenetre = fenetre;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		setBackground(new Color(0,0,0));
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {100, X/3, 100, X/3, 100};
		gbl.rowHeights = new int[] {100,Y/4,100};
		setLayout(gbl);
		
		panelDeckBuilder = new JPanel();
		panelDeckBuilder.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panelDeckBuilder = new GridBagConstraints();
		gbc_panelDeckBuilder.insets = new Insets(0, 0, 5, 5);
		gbc_panelDeckBuilder.fill = GridBagConstraints.BOTH;
		gbc_panelDeckBuilder.gridx = 1;
		gbc_panelDeckBuilder.gridy = 1;
		add(panelDeckBuilder, gbc_panelDeckBuilder);
		GridBagLayout gbl_panelDeckBuilder = new GridBagLayout();
		gbl_panelDeckBuilder.columnWidths = new int[] {30, X/3, 30};
		gbl_panelDeckBuilder.rowHeights = new int[] {0,Y/4,0};
		panelDeckBuilder.setLayout(gbl_panelDeckBuilder);
		
		panelDeckConsulteur = new JPanel();
		panelDeckConsulteur.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panelDeckConsulteur = new GridBagConstraints();
		gbc_panelDeckConsulteur.insets = new Insets(0, 0, 5, 0);
		gbc_panelDeckConsulteur.fill = GridBagConstraints.BOTH;
		gbc_panelDeckConsulteur.gridx = 3;
		gbc_panelDeckConsulteur.gridy = 1;
		add(panelDeckConsulteur, gbc_panelDeckConsulteur);
		GridBagLayout gbl_panelDeckConsulteur = new GridBagLayout();
		gbl_panelDeckConsulteur.columnWidths = new int[] {30, X/3, 30};
		gbl_panelDeckConsulteur.rowHeights = new int[] {0,Y/4,0};
		panelDeckConsulteur.setLayout(gbl_panelDeckConsulteur);
		
		deckBuilder = new JButton("nouveau Deck");
		deckBuilder.setBackground(new Color(128, 128, 128));
		deckBuilder.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_deckBuilder = new GridBagConstraints();
		gbc_deckBuilder.fill = GridBagConstraints.BOTH;
		gbc_deckBuilder.insets = new Insets(0, 0, 0, 5);
		gbc_deckBuilder.gridx = 1;
		gbc_deckBuilder.gridy = 1;
		panelDeckBuilder.add(deckBuilder, gbc_deckBuilder);
		
		consultDeck = new JButton("consulter les Decks");
		consultDeck.setBackground(new Color(128, 128, 128));
		consultDeck.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_consultDeck = new GridBagConstraints();
		gbc_consultDeck.fill = GridBagConstraints.BOTH;
		gbc_consultDeck.gridx = 1;
		gbc_consultDeck.gridy = 1;
		panelDeckConsulteur.add(consultDeck, gbc_consultDeck);
		
		panelBoutonHome = new JPanel();
		panelBoutonHome.setBackground(new Color(0, 0, 0));
		panelBoutonHome.setLayout(null);
		GridBagConstraints gbc_panelBoutonHome = new GridBagConstraints();
		gbc_panelBoutonHome.insets = new Insets(0, 0, 0, 5);
		gbc_panelBoutonHome.fill = GridBagConstraints.BOTH;
		gbc_panelBoutonHome.gridx = 0;
		gbc_panelBoutonHome.gridy = 0;
		add(panelBoutonHome, gbc_panelBoutonHome);
		
		boutonHome = new JButton("<=");
		boutonHome.setBackground(new Color(0, 0, 0));
		boutonHome.setForeground(new Color(133, 6, 6));
		boutonHome.addActionListener(new ALHome(fenetre));
		boutonHome.setBounds(0, 0, 85, 21);
		panelBoutonHome.add(boutonHome);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
}
