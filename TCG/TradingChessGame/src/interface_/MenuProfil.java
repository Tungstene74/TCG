package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classeMetier.Joueur;

public class MenuProfil extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private JPanel panelBoutonHome, panel;
	
	private JButton boutonHome;
	
	private JLabel profil, photo, nomUtilisateur, statistiques, nbPartiesJouees, nbPartiesGagnees;
	
	private TCG fenetre;
	
	public MenuProfil(TCG fenetre) {
		this.fenetre = fenetre;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		setBackground(new Color (0,0,0));
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {X/3, X/3-10, X/3};
		gbl.rowHeights = new int[] {Y};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
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
		
		panel = new JPanel();
		panel.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] {45, 150, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};
		gbl_panel.columnWidths = new int[] {X/9-5, X/9, X/9-5};
		panel.setLayout(gbl_panel);
		
		profil = new JLabel("PROFIL");
		profil.setForeground(new Color(0, 0, 0));
		profil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profil.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_profil = new GridBagConstraints();
		gbc_profil.insets = new Insets(5, 5, 5, 5);
		gbc_profil.fill = GridBagConstraints.BOTH;
		gbc_profil.gridx = 1;
		gbc_profil.gridy = 0;
		panel.add(profil, gbc_profil);
		
		photo = new JLabel("");
		photo.setForeground(new Color(0, 0, 0));
		photo.setIcon(new ImageIcon(TCG.class.getResource("/images/logo3resized.png")));
		GridBagConstraints gbc_photo = new GridBagConstraints();
		gbc_photo.insets = new Insets(5, 5, 5, 5);
		gbc_photo.gridx = 1;
		gbc_photo.gridy = 1;
		panel.add(photo, gbc_photo);
		
		nomUtilisateur = new JLabel(fenetre.getPlayer().getIdentifiant());
		nomUtilisateur.setForeground(new Color(0, 0, 0));
		nomUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 20));
		nomUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nomUtilisateur = new GridBagConstraints();
		gbc_nomUtilisateur.insets = new Insets(5, 5, 5, 5);
		gbc_nomUtilisateur.gridx = 1;
		gbc_nomUtilisateur.gridy = 2;
		panel.add(nomUtilisateur, gbc_nomUtilisateur);
		
		statistiques = new JLabel("<html><u>Statistiques :</u></html>");
		statistiques.setForeground(new Color(0, 0, 0));
		statistiques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statistiques.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Statistiques = new GridBagConstraints();
		gbc_Statistiques.fill = GridBagConstraints.BOTH;
		gbc_Statistiques.insets = new Insets(5, 5, 5, 5);
		gbc_Statistiques.gridx = 1;
		gbc_Statistiques.gridy = 3;
		panel.add(statistiques, gbc_Statistiques);
		
		nbPartiesJouees = new JLabel(" - nombres de parties jouées : "+fenetre.getPlayer().getNbPartiesJ());
		nbPartiesJouees.setBackground(Color.WHITE);
		nbPartiesJouees.setForeground(new Color(0, 0, 0));
		nbPartiesJouees.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPartiesJouees = new GridBagConstraints();
		gbc_nbPartiesJouees.insets = new Insets(5, 5, 5, 5);
		gbc_nbPartiesJouees.fill = GridBagConstraints.BOTH;
		gbc_nbPartiesJouees.gridx = 1;
		gbc_nbPartiesJouees.gridy = 4;
		panel.add(nbPartiesJouees, gbc_nbPartiesJouees);
		
		nbPartiesGagnees = new JLabel(" - nombre de parties gagnées : "+fenetre.getPlayer().getNbPartiesG());
		nbPartiesGagnees.setForeground(new Color(0, 0, 0));
		nbPartiesGagnees.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_nbPartiesGagnees = new GridBagConstraints();
		gbc_nbPartiesGagnees.insets = new Insets(5, 5, 5, 5);
		gbc_nbPartiesGagnees.fill = GridBagConstraints.BOTH;
		gbc_nbPartiesGagnees.gridx = 1;
		gbc_nbPartiesGagnees.gridy = 5;
		panel.add(nbPartiesGagnees, gbc_nbPartiesGagnees);
		
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
}
