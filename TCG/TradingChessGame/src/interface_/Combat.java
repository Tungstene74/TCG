package interface_;

import java.util.ArrayList;

import javax.swing.JPanel;

import classeMetier.Joueur;
import classeMetier.Partie;


public class Combat extends CombatLocal {
	
	private Joueur opponent;
	
	public Combat(TCG fenetre, Partie partie,boolean jCreator, Joueur opponent) {
		super(fenetre,partie);
		
		if (jCreator==true)pseudoAdversaire.setText(opponent.getIdentifiant());
		else pseudoAdversaire.setText(fenetre.getPlayer().getIdentifiant());
		
		if (jCreator==true)pseudoJoueur.setText(fenetre.getPlayer().getIdentifiant());
		else pseudoJoueur.setText(opponent.getIdentifiant());
		
		this.opponent = opponent;
		
	}
}
