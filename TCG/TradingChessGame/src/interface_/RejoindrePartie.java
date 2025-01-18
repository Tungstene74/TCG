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

	private JButton boutonRejoidre,boutonHome;

	private int code;

	private JPanel panel;

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

		panel = new JPanel();
		panel.setBackground(new Color(240,240, 240));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 10, 10, 10);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0,0};
		gbl_panel.rowHeights = new int[] {0};
		panel.setLayout(gbl_panel);

		boutonRejoidre = new JButton("Confirmer");
		boutonRejoidre.addActionListener(new ALRejoindre());
		GridBagConstraints gbc_boutonRejoidre = new GridBagConstraints();
		gbc_boutonRejoidre.insets = new Insets(0, 10, 10, 10);
		gbc_boutonRejoidre.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonRejoidre.gridx = 1;
		gbc_boutonRejoidre.gridy = 0;
		panel.add(boutonRejoidre, gbc_boutonRejoidre);

		boutonHome = new JButton("retour");
		boutonHome.addActionListener(new ALHome(fenetre));
		GridBagConstraints gbc_boutonHome = new GridBagConstraints();
		gbc_boutonHome.insets = new Insets(0, 10, 10, 10);
		gbc_boutonHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonHome.gridx = 0;
		gbc_boutonHome.gridy = 0;
		panel.add(boutonHome, gbc_boutonHome);
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
			if(code!=0) {
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
}
