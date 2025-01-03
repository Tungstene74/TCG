package interface_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classeMetier.Piece;

public class Card extends JPanel{
	private JLabel spritePiece, nomPiece, pouvoirPiece, mvtPiece, raretePiece, nbExemplaire;
	private JPanel basCarte;
	private int l;
	private Piece piece;
	
	public Card () {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int X = (int)dim.getWidth(); 
		l = (X)/7;
		setBackground(new Color(200, 200, 200));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		GridBagLayout gbl_carte = new GridBagLayout();
		gbl_carte.columnWidths = new int[] {20, l, 20};
		gbl_carte.rowHeights = new int[] {20, 200, 50, 50, 50, 20};
		setLayout(gbl_carte);
		
		spritePiece = new JLabel("");
		spritePiece.setOpaque(true);
		spritePiece.setBackground(new Color(0,0,0));
		spritePiece.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		GridBagConstraints gbc_spritePiece = new GridBagConstraints();
		gbc_spritePiece.insets = new Insets(0, 0, 5, 0);
		gbc_spritePiece.fill = GridBagConstraints.BOTH;
		gbc_spritePiece.gridx = 1;
		gbc_spritePiece.gridy = 1;
		add(spritePiece, gbc_spritePiece);
		
		nomPiece = new JLabel("nomPièce");
		nomPiece.setOpaque(true);
		nomPiece.setBackground(new Color(220, 220, 220));
		nomPiece.setFont(new Font("Tahoma", Font.BOLD, 15));
		nomPiece.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nomPiece = new GridBagConstraints();
		gbc_nomPiece.insets = new Insets(0, 0, 5, 0);
		gbc_nomPiece.fill = GridBagConstraints.BOTH;
		gbc_nomPiece.gridx = 1;
		gbc_nomPiece.gridy = 2;
		add(nomPiece, gbc_nomPiece);
		
		pouvoirPiece = new JLabel("Description du pouvoir de la pièce");
		pouvoirPiece.setHorizontalAlignment(SwingConstants.CENTER);
		pouvoirPiece.setOpaque(true);
		pouvoirPiece.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_pouvoirPiece = new GridBagConstraints();
		gbc_pouvoirPiece.insets = new Insets(0, 0, 5, 0);
		gbc_pouvoirPiece.fill = GridBagConstraints.BOTH;
		gbc_pouvoirPiece.gridx = 1;
		gbc_pouvoirPiece.gridy = 3;
		add(pouvoirPiece, gbc_pouvoirPiece);
		
		mvtPiece = new JLabel("Description du mouvement de la pièce");
		mvtPiece.setHorizontalAlignment(SwingConstants.CENTER);
		mvtPiece.setOpaque(true);
		mvtPiece.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_mvtPiece = new GridBagConstraints();
		gbc_mvtPiece.fill = GridBagConstraints.BOTH;
		gbc_mvtPiece.gridx = 1;
		gbc_mvtPiece.gridy = 4;
		add(mvtPiece, gbc_mvtPiece);
		
		basCarte = new JPanel();
		basCarte.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_basCarte = new GridBagConstraints();
		gbc_basCarte.fill = GridBagConstraints.BOTH;
		gbc_basCarte.gridx = 1;
		gbc_basCarte.gridy = 5;
		add(basCarte, gbc_basCarte);
		GridBagLayout gbl_basCarte = new GridBagLayout();
		gbl_basCarte.columnWidths = new int[] {l/2, l/2};
		gbl_basCarte.rowHeights = new int[] {15};
		basCarte.setLayout(gbl_basCarte);
		
		raretePiece = new JLabel("rareté");
		raretePiece.setHorizontalAlignment(SwingConstants.CENTER);
		raretePiece.setOpaque(true);
		raretePiece.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_raretePiece = new GridBagConstraints();
		gbc_raretePiece.fill = GridBagConstraints.BOTH;
		gbc_raretePiece.gridx = 0;
		gbc_raretePiece.gridy = 0;
		basCarte.add(raretePiece, gbc_raretePiece);
		
		nbExemplaire = new JLabel("nbExemplaire");
		nbExemplaire.setHorizontalAlignment(SwingConstants.CENTER);
		nbExemplaire.setOpaque(true);
		nbExemplaire.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_nbExemplaire = new GridBagConstraints();
		gbc_nbExemplaire.fill = GridBagConstraints.BOTH;
		gbc_nbExemplaire.gridx = 1;
		gbc_nbExemplaire.gridy = 0;
		basCarte.add(nbExemplaire, gbc_nbExemplaire);
	}
}
