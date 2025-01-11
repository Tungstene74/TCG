package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
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
	
	public Case(int x,int y) {
		abscisse = x;
		ordonnee = 7 - y;
		
		if ((abscisse+ordonnee)%2==1) setBackground(new Color(222,184,135));
		else setBackground(new Color(0,0,0));
		
		addActionListener(new ALCase());
		
		if (piece!=null) setIcon(new ImageIcon(Case.class.getResource(piece.getimage())));
		//setIcon(new ImageIcon(TCG.class.getResource("/images/logo3resized.png")));
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
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
			System.out.println(piece);
		}
		
	}
}
