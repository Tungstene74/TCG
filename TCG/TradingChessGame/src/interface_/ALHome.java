package interface_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALHome implements ActionListener{
	
	private TCG fen;
	
	public ALHome(TCG fenetre) {
		fen = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fen.menuPrincipal2();
	}
	
	
}
