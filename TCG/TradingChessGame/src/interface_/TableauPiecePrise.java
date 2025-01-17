package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.*;

import classeMetier.*;
import pieces.*;

public class TableauPiecePrise extends JPanel {
	
	private int score,i;
	
	private JLabel labelScore;
	
	private JPanel panelPrise;

	public TableauPiecePrise() {
		setBackground(new Color(192,192,192));

		score = 0;
		i = 0;
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {300};
		gbl.rowHeights = new int[] {30,600};
		setLayout(gbl);
		
		labelScore = new JLabel("Score : "+score);
		GridBagConstraints gbc_labelScore = new GridBagConstraints();
		gbc_labelScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelScore.gridx = 0;
		gbc_labelScore.gridy = 0;
		add(labelScore,gbc_labelScore);
		
		panelPrise = new JPanel();
		panelPrise.setBackground(new Color(192,192,192));
		GridBagConstraints gbc_panelPrise = new GridBagConstraints();
		gbc_panelPrise.fill = GridBagConstraints.BOTH;
		gbc_panelPrise.gridx = 0;
		gbc_panelPrise.gridy = 1;
		add(panelPrise,gbc_panelPrise);
		int y = panelPrise.getHeight()/5;
		GridBagLayout gbl_panelPrise = new GridBagLayout();
		gbl_panelPrise.columnWidths = new int[] {y,y};
		gbl_panelPrise.rowHeights = new int[] {y,y,y,y};
		panelPrise.setLayout(gbl_panelPrise);
	}
	
	
	
	public void ajout(Piece p) {
		JLabel label = new JLabel();
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(5,5,5,5);
		gbc_label.gridx = i%2;
		gbc_label.gridy = i/2;
		panelPrise.add(label,gbc_label);
		
		ImageIcon icon = new ImageIcon(TCG.class.getResource(p.lienImage()));
		icon.setImage(icon.getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH));
		label.setIcon(icon);
		
		i++;
		
		if (p instanceof Dame) {
			score+=9;
			labelScore.setText("Score : "+score);
		}
		if(p instanceof Pion) {
			score+=1;
			labelScore.setText("Score : "+score);
		}
		if(p instanceof Cavalier||p instanceof Fou) {
			score+=3;
			labelScore.setText("Score : "+score);
		}
		if (p instanceof Tour) {
			score+=5;
			labelScore.setText("Score : "+score);
		}
	}

}
