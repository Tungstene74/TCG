package interface_;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import classeDAO.PlateauDAO;
import classeMetier.Joueur;
import classeMetier.Partie;


public class Combat extends CombatLocal {
	
	protected Joueur opponent;
	
	protected boolean jCreator;
	
	public Combat(TCG fenetre, Partie partie,boolean jCreator, Joueur opponent) {
		super(fenetre,partie);
		
		this.jCreator = jCreator;
		
		if (jCreator==true)pseudoAdversaire.setText(opponent.getIdentifiant());
		else pseudoAdversaire.setText(fenetre.getPlayer().getIdentifiant());
		
		if (jCreator==true)pseudoJoueur.setText(fenetre.getPlayer().getIdentifiant());
		else pseudoJoueur.setText(opponent.getIdentifiant());
		
		this.opponent = opponent;
		
		enable(jCreator);
		
		boucleUpdate();
	}
	
	@Override
	public void enable(boolean b) {
		for(ArrayList<Case> array : arrayButton) {
			for (Case c : array) {
				c.setEnabled(b);
			}
		}
	}
	
	public void boucleUpdate() {
		PlateauDAO plateauDAO = new PlateauDAO();
		try {
			plateauDAO.open();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					partie.setPlateau(null);.updateMoi(partie.getPlateau());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		},0, 1000);
	}
}
