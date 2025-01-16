package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import classeMetier.*;

public class ChoixCombat extends JPanel {
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private JPanel plateau;
	
	private JButton rejoindre, creer, local;

	public ChoixCombat(TCG fenetre) {
		this.fenetre = fenetre;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {X/3, X/3, X/3};
		gbl.rowHeights = new int[] {3*Y/4, Y/4};
		setLayout(gbl);
		
		setBackground(new Color(133, 6, 6));
		
		plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.gridwidth = 3;
		gbc_plateau.insets = new Insets(0, 0, 5, 5);
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 0;
		gbc_plateau.gridy = 0;
		add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		int L = 3*Y/4;
		int l = X;
		int x = (L/8);
		int r = (l/2)-(4*x)-4;
		gbl_plateau.columnWidths = new int[]{r,x,x,x,x,x,x,x,x,r};
		gbl_plateau.rowHeights = new int[]{0,x,x,x,x,x,x,x,x,0};
		plateau.setLayout(gbl_plateau);
		
		rejoindre = new JButton("Rejoindre une partie");
		rejoindre.setBackground(new Color(128, 128, 128));
		rejoindre.addActionListener(new ALRejoindre());
		GridBagConstraints gbc_rejoindre = new GridBagConstraints();
		gbc_rejoindre.fill = GridBagConstraints.BOTH;
		gbc_rejoindre.insets = new Insets(5, 5, 5, 5);
		gbc_rejoindre.gridx = 0;
		gbc_rejoindre.gridy = 1;
		add(rejoindre, gbc_rejoindre);
		
		creer = new JButton("Créer une partie");
		creer.setBackground(new Color(128, 128, 128));
		creer.addActionListener(new ALCreer());
		GridBagConstraints gbc_creer = new GridBagConstraints();
		gbc_creer.insets = new Insets(5, 5, 5, 5);
		gbc_creer.fill = GridBagConstraints.BOTH;
		gbc_creer.gridx = 1;
		gbc_creer.gridy = 1;
		add(creer, gbc_creer);
		
		local = new JButton("Créer une partie local");
		local.setBackground(new Color(128, 128, 128));
		local.addActionListener(new ALLocal());
		GridBagConstraints gbc_local = new GridBagConstraints();
		gbc_local.insets = new Insets(5, 5, 5, 5);
		gbc_local.fill = GridBagConstraints.BOTH;
		gbc_local.gridx = 2;
		gbc_local.gridy = 1;
		add(local, gbc_local);
		
		TCG.dessinEchiquier(plateau);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	private class ALCreer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.creationPartie();
		}
		
	}
	
	private class ALRejoindre implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.rejoindrePartie();
		}
		
	}
	
	private class ALLocal implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			PartieLocale partie = new PartieLocale();
			fenetre.combatLocal(partie);
			
		}
		
	}
}
