package interface_;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.util.random.RandomGeneratorFactory;
import java.util.Random;

public class Connection extends JFrame implements ActionListener{
	
	JButton monBouton1,monBouton2;
	
	public Question() {
		this.setTitle ("Question");
		this.setSize (300, 200);
		Random random = new Random();

        // Générer un entier aléatoire dans une plage [0, max)
        int randomInt1 = random.nextInt(1700); // entre 0 et 99
        int randomInt2 = random.nextInt(900);
		
		this.setLocation(randomInt1, randomInt2);
		this.setLayout(new FlowLayout());
		monBouton1 = new JButton ("Encore ?");
		monBouton2 = new JButton ("Stop ?");
		monBouton1.addActionListener(this); // s’ajouter à la liste des auditeurs
		monBouton2.addActionListener(this);
		this.getContentPane().add(monBouton1);
		this.getContentPane().add(monBouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {	
		if (event.getSource()==monBouton1) {
			Question fen = new Question();
		}
		if (event.getSource()==monBouton2) {
			this.dispose();
		}
		
		// bouton appelle cette méthode quand l’évènement se produit
	} 
}
	