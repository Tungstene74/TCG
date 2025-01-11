package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import classeMetier.Piece;

public class Case extends JButton{
	
	private int abscisse;
	private int ordonnee;
	
	private GridBagConstraints gbc;
	
	private Piece piece;
	
	private static int size;
	
	private ImageIcon icon;
	
	public Case(int x,int y) {
		abscisse = x;
		ordonnee = 7 - y;
		
		
		if ((abscisse+ordonnee)%2==1) setBackground(new Color(222,184,135));
		else setBackground(new Color(0,0,0));
		
		addActionListener(new ALCase());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
	}
	
	public Case(int x, int y, Piece piece) {
		this.piece = piece;
		abscisse = x;
		ordonnee = 7 - y;
		
		if ((abscisse+ordonnee)%2==1) setBackground(new Color(222,184,135));
		else setBackground(new Color(0,0,0));
		
		ImageIcon icon = new ImageIcon(TCG.class.getResource("/images/pionnoir.png"));
		icon.getImage().getScaledInstance(size, size,Image.SCALE_SMOOTH);
		setIcon(icon);
		
		addActionListener(new ALCase());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
	}

	public Piece getPiece() {
		return piece;
	}
	
	
	
	public static void setSize(int size) {
		Case.size = size;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void putImage(Piece piece) {
		removeAll();
		
		ImageIcon icon = new ImageIcon(Case.class.getResource("/images/pionnoir.png"));
		setIcon(icon);
		
		revalidate();
		repaint();
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	private class ALCase implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//setIcon(new javax.swing.ImageIcon("images/logo3resized.png"));
			//System.out.println(piece.lienImage());
		}
		
	}
}
