package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classeDAO.JoueurDAO;
import classeMetier.Joueur;

public class EcranConnection extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private String identifiant;
	private char[] mdp;
	
	private JLabel lbCreer, lbNomUtil, lbMDP;
	
	private JTextField nomDutilisateur;
	
	private JPasswordField passwordField;
	
	private JButton boutonNvCompte, boutonConnection;
	
	private JPanel panel;
	
	public EcranConnection(TCG fenetre) {
		this.fenetre = fenetre;
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		setBackground(new Color(240,240, 240));
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {0};
		gbl.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		setLayout(gbl);
		
		lbCreer = new JLabel();
		lbCreer.setText("Connection");
		lbCreer.setOpaque(true);
		lbCreer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbCreer.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbCreer = new GridBagConstraints();
		gbc_lbCreer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbCreer.insets = new Insets(10, 10, 10, 10);
		gbc_lbCreer.gridx = 0;
		gbc_lbCreer.gridy = 0;
		add(lbCreer, gbc_lbCreer);
		
		lbNomUtil = new JLabel("nom d'utilsateur :");
		GridBagConstraints gbc_lbNomUtil = new GridBagConstraints();
		gbc_lbNomUtil.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbNomUtil.insets = new Insets(10, 10, 0, 10);
		gbc_lbNomUtil.gridx = 0;
		gbc_lbNomUtil.gridy = 1;
		add(lbNomUtil, gbc_lbNomUtil);
		
		nomDutilisateur = new JTextField();
		nomDutilisateur.setColumns(20);
		nomDutilisateur.addActionListener(new ALIdentifiant());
		GridBagConstraints gbc_nomDutilisateur = new GridBagConstraints();
		gbc_nomDutilisateur.insets = new Insets(0, 10, 10, 10);
		gbc_nomDutilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomDutilisateur.gridx = 0;
		gbc_nomDutilisateur.gridy = 2;
		add(nomDutilisateur, gbc_nomDutilisateur);
		
		lbMDP = new JLabel("mot de passe :");
		GridBagConstraints gbc_lbMDP = new GridBagConstraints();
		gbc_lbMDP.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbMDP.insets = new Insets(10, 10, 5, 10);
		gbc_lbMDP.gridx = 0;
		gbc_lbMDP.gridy = 3;
		add(lbMDP, gbc_lbMDP);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setColumns(20);
		passwordField.addActionListener(new ALPassword());
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 10, 10, 10);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		
		panel = new JPanel();
		panel.setBackground(new Color(240,240, 240));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0,0};
		gbl_panel.rowHeights = new int[] {0};
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 10, 10, 10);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		
		boutonNvCompte = new JButton("Créer un Compte");
		boutonNvCompte.addActionListener(new ALNvCompte());
		GridBagConstraints gbc_boutonNvCompte = new GridBagConstraints();
		gbc_boutonNvCompte.insets = new Insets(10, 10, 10, 10);
		gbc_boutonNvCompte.gridx = 0;
		gbc_boutonNvCompte.gridy = 0;
		panel.add(boutonNvCompte, gbc_boutonNvCompte);
		
		boutonConnection = new JButton("Connexion");
		boutonConnection.addActionListener(new ALConnection());
		GridBagConstraints gbc_boutonConnection = new GridBagConstraints();
		gbc_boutonConnection.insets = new Insets(10, 10, 10, 10);
		gbc_boutonConnection.gridx = 1;
		gbc_boutonConnection.gridy = 0;
		panel.add(boutonConnection, gbc_boutonConnection);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	private class ALIdentifiant implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			identifiant = nomDutilisateur.getText();
		}
	}
	
	private class ALPassword implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mdp = passwordField.getPassword();
		}
	}
	
	private class ALConnection implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			if(identifiant==null||mdp==null||identifiant=="") {
				lbCreer.setBackground(Color.RED);
				lbCreer.setText("Erreur de Connection");
			}
			else{
				String motDePasse = "";
				for(char c:mdp)motDePasse+=c;
				JoueurDAO JDAO = new JoueurDAO();
				try {
					JDAO.open();
					fenetre.setPlayer(JDAO.connection(identifiant,motDePasse));
					//JDAO.close();
					fenetre.menuPrincipal2();
				}
				catch(SQLException e) {
					System.out.println(e);
					lbCreer.setBackground(Color.RED);
					lbCreer.setText("Erreur de Connection");
				}
			}
		}
	}
	
	private class ALNvCompte implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			if(identifiant==null||mdp==null||identifiant=="") {
				lbCreer.setBackground(Color.RED);
				lbCreer.setText("Erreur de creation de compte");
			}
			else{
				String motDePasse = "";
				for(char c:mdp)motDePasse+=c;
				try {
					JoueurDAO JDAO = new JoueurDAO();
					fenetre.setPlayer(new Joueur(identifiant,motDePasse));
					JDAO.open();
					JDAO.create(fenetre.getPlayer());
					//JDAO.close();
					fenetre.menuPrincipal2();
				}
				catch(SQLException e) {
					System.out.println(e);
					lbCreer.setBackground(Color.RED);
					lbCreer.setText("Erreur de creation de compte");
				}
			}
		}
	}
}
