package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class MenuPrincipal2 extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private JButton profil, combat;
	
	private JPanel echiquier, plateau;
	
	private TCG fenetre;
	
	public MenuPrincipal2(TCG fenetre) {
		this.fenetre = fenetre;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		setBackground(new Color(133,6,6));
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{X/2,X/2}; //Definition des deux colonnes qui accueillerons les deux sous-panels
		gbl.rowHeights = new int[]{Y/4,Y/4,Y/4,Y/4};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		//Définition du bouton profil
		profil = new JButton("Profil");
		profil.setForeground(new Color(255, 255, 255));
		profil.setBackground(new Color(128, 128, 128));
		profil.addActionListener(new ALProfil());
		GridBagConstraints gbc_profil = new GridBagConstraints();
		gbc_profil.fill = GridBagConstraints.BOTH;
		gbc_profil.insets = new Insets(0, 0, 5, 0);
		gbc_profil.gridx = 1;
		gbc_profil.gridy = 3;
		add(profil, gbc_profil);
		
		//Definition du bouton Combat
		combat = new JButton("Combat");
		combat.setForeground(new Color(255, 255, 255));
		combat.setBackground(new Color(128, 128, 128));
		combat.addActionListener(new ALCombat());
		GridBagConstraints gbc_combat = new GridBagConstraints();
		gbc_combat.fill = GridBagConstraints.BOTH;
		gbc_combat.insets = new Insets(0, 0, 5, 0);
		gbc_combat.gridx = 0;
		gbc_combat.gridy = 3;
		add(combat, gbc_combat);
		
		//Dessin de l'échiquier
		plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 0;
		gbc_plateau.gridy = 0;
		gbc_plateau.gridheight = 3;
		gbc_plateau.gridwidth = 2;
		add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		//mesure pour les colonnes et les lignes
		int L = 3*Y/4;
		int x = ((L/8)-1);
		gbl_plateau.columnWidths = new int[]{0,L,0};
		gbl_plateau.rowHeights = new int[]{L};
		plateau.setLayout(gbl_plateau);
		
		echiquier = new JPanel();
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
		
		TCG.dessinEchiquier(echiquier);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	private class ALCombat implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.choixCombat();
		}
		
	}
	
	private class ALProfil implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.menuProfil();
		}
		
	}
}
