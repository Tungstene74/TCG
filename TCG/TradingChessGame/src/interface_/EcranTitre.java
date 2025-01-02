package interface_;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EcranTitre extends JPanel{
	
	private JLabel LogoEcranDemarrage;
	
	private JButton startButton;
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	public EcranTitre(TCG fenetre) {
		this.fenetre = fenetre;
		
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {100, 300, 100};
		gbl.rowHeights = new int[] {100, 300, 30, 100};
		setLayout(gbl);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		setBackground(new Color(0,0,0));
		
		LogoEcranDemarrage = new JLabel("");
		LogoEcranDemarrage.setIcon(new ImageIcon(TCG.class.getResource("/images/logo4resized.jpg")));
		GridBagConstraints gbc_LogoEcranDemarrage = new GridBagConstraints();
		gbc_LogoEcranDemarrage.insets = new Insets(0, 0, 5, 5);
		gbc_LogoEcranDemarrage.gridx = 1;
		gbc_LogoEcranDemarrage.gridy = 1;
		add(LogoEcranDemarrage, gbc_LogoEcranDemarrage);
		
		startButton = new JButton("START");
		startButton.addActionListener(new ALstartButton());
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 5, 5);
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 2;
		add(startButton, gbc_startButton);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	private class ALstartButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.connection();
		}
		
	}
}