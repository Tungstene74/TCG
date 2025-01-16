package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Inventaire extends JPanel{
	private GridBagLayout gbl;
	
	private GridBagConstraints gbc;
	
	private TCG fenetre;
	
	private JLabel labelCollection;
	
	private JButton home;
	
	private JScrollPane scrollPaneCollection;
	
	private JPanel panelCollection;

	public Inventaire(TCG fenetre) {
		this.fenetre = fenetre;
		int X = fenetre.getWidth();
		int Y = fenetre.getHeight();
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		setBackground(new Color(200, 200, 200));
		
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {X-60, 50};
		gbl.rowHeights = new int[] {70, Y-75};
		setLayout(gbl);
		
		labelCollection = new JLabel("Collection");
		labelCollection.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelCollection.setOpaque(true);
		labelCollection.setBackground(new Color(200, 200, 200));
		labelCollection.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelCollection = new GridBagConstraints();
		gbc_labelCollection.fill = GridBagConstraints.BOTH;
		gbc_labelCollection.insets = new Insets(0, 0, 5, 5);
		gbc_labelCollection.gridx = 0;
		gbc_labelCollection.gridy = 0;
		add(labelCollection, gbc_labelCollection);
		
		home = new JButton("Home");
		home.setBackground(new Color(200, 200, 200));
		home.setForeground(new Color(0,0,0));
		home.addActionListener(new ALHome(fenetre));
		GridBagConstraints gbc_home = new GridBagConstraints();
		gbc_home.fill = GridBagConstraints.BOTH;
		gbc_home.insets = new Insets(0, 0, 5, 0);
		gbc_home.gridx = 1;
		gbc_home.gridy = 0;
		add(home, gbc_home);
		
		scrollPaneCollection = new JScrollPane();
		GridBagConstraints gbc_scrollPaneCollection = new GridBagConstraints();
		gbc_scrollPaneCollection.gridwidth = 2;
		gbc_scrollPaneCollection.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneCollection.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCollection.gridx = 0;
		gbc_scrollPaneCollection.gridy = 1;
		add(scrollPaneCollection, gbc_scrollPaneCollection);
		
		@SuppressWarnings("unused")
		JScrollBar verticalScrollBar = scrollPaneCollection.getVerticalScrollBar();
		
		panelCollection = new JPanel();
		scrollPaneCollection.setViewportView(panelCollection);
		panelCollection.setBackground(new Color(200, 200, 200));
		GridBagLayout gbl_panelCollection = new GridBagLayout();
		int x = X/5 - 10;
		gbl_panelCollection.columnWidths = new int[]{x, x, x, x, x};
		gbl_panelCollection.rowHeights = new int[]{400, 400, 400, 400, 400, 400, 400, 400};
		panelCollection.setLayout(gbl_panelCollection);
		
		int n = fenetre.getPlayer().getListepiece().size();
		int i = 0;
		for (Map.Entry<Integer, Integer>entry: fenetre.getPlayer().getListepiece().entrySet()) {
			GridBagConstraints gbc_carte = new GridBagConstraints();
			gbc_carte.anchor = GridBagConstraints.NORTHWEST;
			gbc_carte.gridx = i%n;
			gbc_carte.gridy = i/n;
			panelCollection.add(new Card(), gbc_carte);
		}
	}
	
	public GridBagConstraints getGbc() {
		return gbc;
	}
	
}
