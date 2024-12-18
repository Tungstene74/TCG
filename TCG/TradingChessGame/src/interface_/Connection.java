package interface_;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class Connection extends JFrame implements ActionListener{
	
	JButton seconnecter,creercompte;
	JTextField usernamefield, passworldfield;
	JPanel tout,boutons;
	
	public Connection() {
		this.setTitle ("Traiding Chess Game");
		this.setSize (500, 500);
		this.setLayout(new BorderLayout());
		JPanel tout = new JPanel(new GridBagLayout());

		//this.setLayout(new FlowLayout());
		//this.setLocation(randomInt1, randomInt2);
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants
        /*
		this.tout = new JPanel();
		this.tout.setLayout(new GridBagLayout(3,1));
		this.boutons = new JPanel();
		this.boutons.setLayout(new GridLayout(1,2));
		*/
		//this.getContentPane().add(BorderLayout.CENTER,tout); 
		
		seconnecter = new JButton ("Se connecter");
		creercompte = new JButton ("Creer un compte");
		usernamefield = new JTextField ("Nom d'utilisateur");
		passworldfield = new JTextField ("Mot de passe");
		
		creercompte.addActionListener(this); // s’ajouter à la liste des auditeurs
		seconnecter.addActionListener(this);
		usernamefield.addActionListener(this); //new TexteListener()
		passworldfield.addActionListener(this); //new TexteListener()
		/*
		boutons.add(seconnecter,0);
		boutons.add(creercompte,1);
		tout.add(usernamefield,0);
		tout.add(passworldfield,1);
		tout.add(boutons,2);
		*/
		
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tout.add(usernamefield, gbc);

        // Ligne 2 : Champ "Mot de passe"
        gbc.gridx = 0;
        gbc.gridy = 1;
        tout.add(passworldfield, gbc);

        // Ligne 3 : Panneau des boutons
        boutons = new JPanel(new GridLayout(1, 2, 10, 0)); // Boutons côte à côte avec un écart
        boutons.add(seconnecter);
        boutons.add(creercompte);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER; // Centre les boutons
        tout.add(boutons, gbc);

        // Ajout du panneau principal au centre de la fenêtre
        this.getContentPane().add(tout, BorderLayout.CENTER);

        // Configuration finale de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
	        /*
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(tout);
		//tout.add(boutons, BorderLayout.SOUTH);
		//this.getContentPane().add(boutons);
		this.getContentPane().add(tout, BorderLayout.CENTER);
		this.setVisible(true); 
		*/

	
	public void actionPerformed(ActionEvent event) {	
		if (event.getSource()==seconnecter) {
			this.dispose();
			//Question fen = new Question();
			//on devra appeler la classe dao qui gère les comptes pour qu'elle nous dise si c'est le bon mdp 
			//dans ce cas on ouvre la fenètre sur le compte de la personne	
		}
		
		if (event.getSource()==creercompte) {
			this.dispose();
			//on uvre la fenêtre pour creer un compte
		}
	} 
}
	