package interface_;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import classeMetier.Piece;
import pieces.*;

public class PromotionPiece extends JFrame{
	
	private JPanel contentPane;
	
	private JButton dameButton, tourButton, fouButton, cavalierButton;
	
	private ImageIcon dame,fou,tour,cavalier;
	
	private Pion pion;
	
	private Piece pieceSelectionnee;
	
	public Piece getpieceSelectionnee() {
		return pieceSelectionnee;
	}

	public PromotionPiece(Pion p) {
		
		pion = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {25, 100, 100, 100, 100, 25};
		gbl_contentPane.rowHeights = new int[] {25, 100, 25};
		contentPane.setLayout(gbl_contentPane);
		
		dameButton = new JButton();
		dame = new ImageIcon(PromotionPiece.class.getResource("/images/dame"+pion.getCouleur()+".png"));
		dame.setImage(dame.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH));
		dameButton.setIcon(dame);
		GridBagConstraints gbc_dameButton = new GridBagConstraints();
		gbc_dameButton.insets = new Insets(5, 5, 5, 5);
		gbc_dameButton.fill = GridBagConstraints.BOTH;
		gbc_dameButton.gridx = 1;
		gbc_dameButton.gridy = 1;
		contentPane.add(dameButton, gbc_dameButton);
		
		tourButton = new JButton();
		tour = new ImageIcon(PromotionPiece.class.getResource("/images/tour"+pion.getCouleur()+".png"));
		tour.setImage(tour.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH));
		tourButton.setIcon(tour);
		GridBagConstraints gbc_tourButton = new GridBagConstraints();
		gbc_tourButton.insets = new Insets(5, 5, 5, 5);
		gbc_tourButton.fill = GridBagConstraints.BOTH;
		gbc_tourButton.gridx = 2;
		gbc_tourButton.gridy = 1;
		contentPane.add(tourButton, gbc_tourButton);
		
		fouButton = new JButton();
		fou = new ImageIcon(PromotionPiece.class.getResource("/images/fou"+pion.getCouleur()+".png"));
		fou.setImage(fou.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH));
		fouButton.setIcon(fou);
		GridBagConstraints gbc_fouButton = new GridBagConstraints();
		gbc_fouButton.insets = new Insets(5, 5, 5, 5);
		gbc_fouButton.fill = GridBagConstraints.BOTH;
		gbc_fouButton.gridx = 3;
		gbc_fouButton.gridy = 1;
		contentPane.add(fouButton, gbc_fouButton);
		
		cavalierButton = new JButton();
		cavalier = new ImageIcon(PromotionPiece.class.getResource("/images/cavalier"+pion.getCouleur()+".png"));
		cavalier.setImage(cavalier.getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH));
		cavalierButton.setIcon(cavalier);
		GridBagConstraints gbc_cavalierButton = new GridBagConstraints();
		gbc_cavalierButton.insets = new Insets(5, 5, 5, 5);
		gbc_cavalierButton.fill = GridBagConstraints.BOTH;
		gbc_cavalierButton.gridx = 4;
		gbc_cavalierButton.gridy = 1;
		contentPane.add(cavalierButton, gbc_cavalierButton);
		
		setVisible(true);
	}
	
	private class ALDame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pieceSelectionnee=new Dame(pion.getCouleur(), pion.getIdPiecePartie(), pion.getX(), pion.getY());
			dispose();
		}
		
	}
	
	private class ALFou implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pieceSelectionnee=new Fou(pion.getCouleur(), pion.getIdPiecePartie(), pion.getX(), pion.getY());
			dispose();
		}
		
	}
	
	private class ALTour implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pieceSelectionnee=new Tour(pion.getCouleur(), pion.getIdPiecePartie(), pion.getX(), pion.getY());
			dispose();
		}
		
	}
	
	private class ALCavalier implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pieceSelectionnee=new Cavalier(pion.getCouleur(), pion.getIdPiecePartie(), pion.getX(), pion.getY());
			dispose();
		}
		
	}

}
