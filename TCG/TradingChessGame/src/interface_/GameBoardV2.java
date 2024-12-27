package interface_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameBoardV2 extends JFrame {

	private JPanel basePanel;
	
	public GameBoardV2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int X = (int)dim.getWidth() ; 
		int Y = (int)dim.getHeight();
		basePanel = new JPanel();
		basePanel.setBackground(new Color(133, 6, 6));
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(basePanel);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[] {(X-Y)/2, Y, (X-Y)/2};
		gbl_basePanel.rowHeights = new int[] {Y};
		basePanel.setLayout(gbl_basePanel);
		
		JPanel panelAdversaire = new JPanel();
		panelAdversaire.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_panelAdversaire = new GridBagConstraints();
		gbc_panelAdversaire.insets = new Insets(0, 0, 0, 5);
		gbc_panelAdversaire.fill = GridBagConstraints.BOTH;
		gbc_panelAdversaire.gridx = 0;
		gbc_panelAdversaire.gridy = 0;
		basePanel.add(panelAdversaire, gbc_panelAdversaire);
		GridBagLayout gbl_panelAdversaire = new GridBagLayout();
		gbl_panelAdversaire.columnWidths = new int[] {(X-Y)/2};
		gbl_panelAdversaire.rowHeights = new int[] {50, Y-55};
		panelAdversaire.setLayout(gbl_panelAdversaire);
		
		JLabel pseudoAdversaire = new JLabel("Adversaire");
		pseudoAdversaire.setForeground(Color.BLACK);
		pseudoAdversaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		pseudoAdversaire.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pseudoAdversaire = new GridBagConstraints();
		gbc_pseudoAdversaire.fill = GridBagConstraints.BOTH;
		gbc_pseudoAdversaire.gridx = 0;
		gbc_pseudoAdversaire.gridy = 0;
		panelAdversaire.add(pseudoAdversaire, gbc_pseudoAdversaire);
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		basePanel.add(panelJoueur, gbc_panelJoueur);
		GridBagLayout gbl_panelJoueur = new GridBagLayout();
		gbl_panelJoueur.columnWidths = new int[] {(X-Y)/2};
		gbl_panelJoueur.rowHeights = new int[] {50, Y-55};
		panelJoueur.setLayout(gbl_panelJoueur);
		
		JLabel pseudoJoueur = new JLabel("Joueur");
		pseudoJoueur.setForeground(Color.BLACK);
		pseudoJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		pseudoJoueur.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.fill = GridBagConstraints.BOTH;
		gbc_pseudoJoueur.gridx = 0;
		gbc_pseudoJoueur.gridy = 0;
		panelJoueur.add(pseudoJoueur, gbc_pseudoJoueur);
		
		JPanel plateau = new JPanel();
		plateau.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_plateau = new GridBagConstraints();
		gbc_plateau.insets = new Insets(0, 0, 0, 5);
		gbc_plateau.fill = GridBagConstraints.BOTH;
		gbc_plateau.gridx = 1;
		gbc_plateau.gridy = 0;
		basePanel.add(plateau, gbc_plateau);
		GridBagLayout gbl_plateau = new GridBagLayout();
		gbl_plateau.columnWidths = new int[] {Y-100};
		gbl_plateau.rowHeights = new int[] {30,Y-100};
		plateau.setLayout(gbl_plateau);
		
		JLabel tour = new JLabel("Tour : _ ! A ____ de jouer !");
		tour.setForeground(Color.BLACK);
		tour.setHorizontalAlignment(SwingConstants.CENTER);
		tour.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_tour = new GridBagConstraints();
		gbc_tour.fill = GridBagConstraints.BOTH;
		gbc_tour.gridx = 0;
		gbc_tour.gridy = 0;
		plateau.add(tour, gbc_tour);
		
		JPanel echiquier = new JPanel();
		echiquier.setBackground(new Color(133, 6, 6));
		GridBagConstraints gbc_echiquier = new GridBagConstraints();
		gbc_echiquier.fill = GridBagConstraints.BOTH;
		gbc_echiquier.gridx = 0;
		gbc_echiquier.gridy = 1;
		plateau.add(echiquier, gbc_echiquier);
		GridBagLayout gbl_echiquier = new GridBagLayout();
		int x = (Y-140)/8;
		gbl_echiquier.columnWidths = new int[] {x, x, x, x, x, x, x, x};
		gbl_echiquier.rowHeights = new int[] {x, x, x, x, x, x, x, x};
		echiquier.setLayout(gbl_echiquier);
		
		echiquier(echiquier);
		
		setVisible(true);
	}
	
	private void echiquier(JPanel panel) {
		for (int i=0;i<=7;i++) {
			for (int j=0; j<=7;j++) {
				if((i+j+1)%2==1) {
					JButton caseBlanche = new JButton();
					caseBlanche.setBackground(new Color(222,184,135));
					caseBlanche.addActionListener(new ALCase(j,i));
					GridBagConstraints gbc_caseBlanche = new GridBagConstraints();
					gbc_caseBlanche.fill = GridBagConstraints.BOTH;
					gbc_caseBlanche.gridx = j;
					gbc_caseBlanche.gridy = i;
					panel.add(caseBlanche,gbc_caseBlanche);
				}
				else {
					JButton caseNoir = new JButton();
					caseNoir.setBackground(Color.BLACK);
					caseNoir.addActionListener(new ALCase(j,i));
					GridBagConstraints gbc_caseNoir = new GridBagConstraints();
					gbc_caseNoir.fill = GridBagConstraints.BOTH;
					gbc_caseNoir.gridx = j;
					gbc_caseNoir.gridy = i;
					panel.add(caseNoir,gbc_caseNoir);
				}
			}
		}
	}
	
	private class ALCase implements ActionListener{
		
		private int colonne;
		private int ligne;
		
		public ALCase(int colonne, int ligne) {
			super();
			this.colonne = colonne;
			this.ligne = ligne;
		}



		public void actionPerformed(ActionEvent e) {
			new MenuProfilV2();
			//ToDo
		}
		
	}
}
