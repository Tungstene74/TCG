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

import classeDAO.*;
import classeMetier.*;

public class CreationPartie extends JPanel{
	
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private JLabel lbCreer,id_Partie;
	
	private JTextField textFieldCode;
	
	private JButton boutonCreer;
	
	private int code;
	
	public CreationPartie(TCG fenetre) {
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
		lbCreer.setText("Créer une Partie");
		lbCreer.setOpaque(true);
		lbCreer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbCreer.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbCreer = new GridBagConstraints();
		gbc_lbCreer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbCreer.insets = new Insets(10, 10, 10, 10);
		gbc_lbCreer.gridx = 0;
		gbc_lbCreer.gridy = 0;
		add(lbCreer, gbc_lbCreer);
		
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
		
		boutonCreer = new JButton("Confirmer");
		boutonCreer.addActionListener(new ALCreer());
		GridBagConstraints gbc_boutonCreer = new GridBagConstraints();
		gbc_boutonCreer.insets = new Insets(0, 10, 10, 10);
		gbc_boutonCreer.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonCreer.gridx = 0;
		gbc_boutonCreer.gridy = 3;
		add(boutonCreer, gbc_boutonCreer);
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
	
	private class ALCreer implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			Partie current = new Partie(fenetre.getPlayer(),code);
			PartieDAO PDAO = new PartieDAO();
			try {
				PDAO.open();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					try {
						PDAO.update(current);
						try {
							if(current.getjoueur2()!=null) cancel();
						}
						catch(NullPointerException n) {
							n.printStackTrace();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}  
				}
			}, 5000);
			try {
				PDAO.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			JoueurDAO JDAO = new JoueurDAO();
			fenetre.gameBoard(current.getjoueur2());

		}
	}
}

