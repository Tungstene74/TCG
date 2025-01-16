package interface_;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Victoire extends JFrame{
	
	private JPanel basePanel, colonne;
	
	private TCG fen;
	
	private JLabel victoire, couleur;
	
	private JButton home;
	
	private String farbe;
	
	public Victoire(TCG fenetre, String color) {
		
		fen = fenetre;
		farbe = color;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((fen.getWidth()-450)/2, (fen.getHeight()-300)/2, 450, 300);
		basePanel = new JPanel();
		basePanel.setBackground(new Color(133, 6, 6));
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(basePanel);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[] {30, 300, 30};
		gbl_basePanel.rowHeights = new int[] {300};
		basePanel.setLayout(gbl_basePanel);
		
		colonne = new JPanel();
		colonne.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_colonne = new GridBagConstraints();
		gbc_colonne.fill = GridBagConstraints.BOTH;
		gbc_colonne.gridx = 1;
		gbc_colonne.gridy = 0;
		basePanel.add(colonne, gbc_colonne);
		GridBagLayout gbl_colonne = new GridBagLayout();
		gbl_colonne.columnWidths = new int[] {300};
		gbl_colonne.rowHeights = new int[] {0, 0, 0};
		colonne.setLayout(gbl_colonne);
		
		victoire = new JLabel("Victoire des ");
		victoire.setHorizontalAlignment(SwingConstants.CENTER);
		victoire.setFont(new Font("Tahoma", Font.BOLD, 20));
		victoire.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_victoire = new GridBagConstraints();
		gbc_victoire.fill = GridBagConstraints.HORIZONTAL;
		gbc_victoire.insets = new Insets(5, 5, 5, 0);
		gbc_victoire.gridx = 0;
		gbc_victoire.gridy = 0;
		colonne.add(victoire, gbc_victoire);
		
		couleur = new JLabel(farbe);
		if (farbe == "noir")couleur.setForeground(new Color(0, 0, 0));
		else couleur.setForeground(new Color(240, 240, 240));
		couleur.setFont(new Font("Tahoma", Font.BOLD, 30));
		couleur.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_couleur = new GridBagConstraints();
		gbc_couleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_couleur.gridx = 0;
		gbc_couleur.gridy = 1;
		colonne.add(couleur, gbc_couleur);
		
		home = new JButton("Home");
		home.addActionListener(new ALHome());
		GridBagConstraints gbc_home = new GridBagConstraints();
		gbc_home.insets = new Insets(5, 5, 0, 0);
		gbc_home.gridx = 0;
		gbc_home.gridy = 2;
		colonne.add(home, gbc_home);
		
		setVisible(true);
	}
	
	public class ALHome implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			fen.menuPrincipal2();
		}
		
	}
}
