package interface_;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import classeDAO.JoueurDAO;
import classeDAO.PartieDAO;
import classeDAO.PlateauDAO;
import classeMetier.Joueur;
import classeMetier.Partie;
import classeMetier.Piece;
import classeMetier.Plateau;


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
		
		concederNoir.setEnabled(jCreator); 
		concederBlanc.setEnabled(!jCreator); 
		voteEgaliteNoir.setEnabled(false); 
		voteEgaliteBlanc.setEnabled(false);
		
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
		Timer timer = new Timer();
		timer.schedule(new TimerTaskUpdate(this),10000,5000);
	}
	
	
	/*
	@Override
	public void update() {
		super.update();
		
		Plateau plateau = partie.getPlateau();
		if(this instanceof Combat) {
			PlateauDAO PlDAO = new PlateauDAO();
			try {
				PlDAO.open();
				PlDAO.update(plateau);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	*/


	private class TimerTaskUpdate extends TimerTask{
		
		private Combat combat;
		private PlateauDAO plateauDAO;
		private PartieDAO partieDAO;
		
		public TimerTaskUpdate(Combat combat) {
			this.combat = combat;
			plateauDAO = new PlateauDAO();
			partieDAO = new PartieDAO();
			try {
				plateauDAO.open();
				partieDAO.open();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		private void suppressionPartie() {
			try {
				plateauDAO.updateMoi(partie.getPlateau(), combat);
				partieDAO.delete((Partie)combat.partie);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				partie.getPlateau().redraw(combat);
				if (partie.getTour()%2==0) {
					tour.setText("Tour : "+(partie.getTour()+1)+" ! Au blanc de jouer !");
					if(jCreator==false) {
						combat.enable(false);
						plateauDAO.updateMoi(partie.getPlateau(), combat);
								
						//partie.setPlateau(
					}
					else combat.enable(true);
				}
				else {
					tour.setText("Tour : "+(partie.getTour()+1)+" ! Au noir de jouer !");
					if(jCreator==true) {
						combat.enable(false);
						plateauDAO.updateMoi(partie.getPlateau(), combat);
						//partie.setPlateau()
					}
					else combat.enable(true);
				}
				partieDAO.tours((Partie)partie);
				
				Plateau plateau=partie.getPlateau();
				
				// consomme beaucoup (repaint des pièces)
				for (ArrayList<Case> a:combat.arrayButton) {
					for (Case c:a) {

						Piece piece=plateau.getPiece(c.getAbscisse(), c.getOrdonnee());

						if (piece==null) {
							c.setIcon(null);	
							c.revalidate();
							c.repaint();
						}

						else {
							if (piece!=c.getPiece()) {
								c.setPiece(piece);
								c.putImage(piece);
								c.revalidate();
								c.repaint();
							}	
						}
					}
				}
		
				
				if (partie.getPlateau().estEnEchecEtMat("blanc")) {
					cancel();
					new Victoire(fenetre,"noir");
					suppressionPartie();
					if (!jCreator) fenetre.getPlayer().setNbPartiesG(fenetre.getPlayer().getNbPartiesG()+1);
					fenetre.getPlayer().setNbPartiesJ(fenetre.getPlayer().getNbPartiesJ()+1);
					JoueurDAO playerDAO = new JoueurDAO();
					playerDAO.open();
					playerDAO.update(fenetre.getPlayer());
				}
				if (partie.getPlateau().estEnEchecEtMat("noir")) {
					cancel();
					new Victoire(fenetre,"blanc");
					suppressionPartie();
					if (jCreator) fenetre.getPlayer().setNbPartiesG(fenetre.getPlayer().getNbPartiesG()+1);
					fenetre.getPlayer().setNbPartiesJ(fenetre.getPlayer().getNbPartiesJ()+1);
					JoueurDAO playerDAO = new JoueurDAO();
					playerDAO.open();
					playerDAO.update(fenetre.getPlayer());
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
