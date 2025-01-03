package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classeDAO.JoueurDAO;
import classeDAO.PartieDAO;
import classeMetier.Partie;

public class RejoindrePartie extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private JLabel lbRejoidre,id_Partie;
	
	private JTextField textFieldCode;
	
	private JButton boutonRejoidre;
	
	private int code;
	
	public RejoindrePartie(TCG fenetre) {
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
		
		lbRejoidre = new JLabel();
		lbRejoidre.setText("Rejoindre une Partie");
		lbRejoidre.setOpaque(true);
		lbRejoidre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbRejoidre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbRejoidre = new GridBagConstraints();
		gbc_lbRejoidre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbRejoidre.insets = new Insets(10, 10, 10, 10);
		gbc_lbRejoidre.gridx = 0;
		gbc_lbRejoidre.gridy = 0;
		add(lbRejoidre, gbc_lbRejoidre);
		
		id_Partie = new JLabel("code de la partie :");
		GridBagConstraints gbc_id_Partie = new GridBagConstraints();
		gbc_id_Partie.fill = GridBagConstraints.HORIZONTAL;
		gbc_id_Partie.insets = new Insets(10, 10, 0, 10);
		gbc_id_Partie.gridx = 0;
		gbc_id_Partie.gridy = 1;
		add(id_Partie, gbc_id_Partie);
		
		textFieldCode = new JTextField();
		textFieldCode.setColumns(20);
		textFieldCode.addActionListener(new ALCode());
		GridBagConstraints gbc_textFieldCode = new GridBagConstraints();
		gbc_textFieldCode.insets = new Insets(0, 10, 10, 10);
		gbc_textFieldCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCode.gridx = 0;
		gbc_textFieldCode.gridy = 2;
		add(textFieldCode, gbc_textFieldCode);
		
		boutonRejoidre = new JButton("Confirmer");
		boutonRejoidre.addActionListener(new ALRejoindre());
		GridBagConstraints gbc_boutonRejoidre = new GridBagConstraints();
		gbc_boutonRejoidre.insets = new Insets(0, 10, 10, 10);
		gbc_boutonRejoidre.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonRejoidre.gridx = 0;
		gbc_boutonRejoidre.gridy = 3;
		add(boutonRejoidre, gbc_boutonRejoidre);
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
	private class ALCode implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			code = Integer.parseInt(textFieldCode.getText());
		}
	}
	
	private class ALRejoindre implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			try {
				PartieDAO PDAO = new PartieDAO();
				PDAO.open();
				Partie p = PDAO.join(code,fenetre.getPlayer());
				fenetre.gameBoard(p.getjoueur1(),false);
				//PDAO.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
