package interface_;

import javax.swing.* ;

import ex2.FenetreLitEntier.TexteListener;

import java.awt.*;
import java.awt.event.*;

public class Connection extends JFrame implements ActionListener{
	
	JButton seconnecter,creercompte;
	JTextField usernamefield, passworldfield;
	JPanel text,boutons;
	
	public Connection() {
		this.setTitle ("Traiding Chess Game");
		this.setSize (300, 200);


		
		//this.setLocation(randomInt1, randomInt2);
		this.text = new JPanel();
		this.text.setLayout(new GridLayout(2,1));
		this.boutons = new JPanel();
		this.boutons.setLayout(new GridLayout(1,2));
		
		seconnecter = new JButton ("Se connecter");
		creercompte = new JButton ("Creer un compte");
		usernamefield = new JTextField ("Nom d'utilisateur");
		passworldfield = new JTextField ("Mot de passe");
		
		creercompte.addActionListener(this); // s’ajouter à la liste des auditeurs
		seconnecter.addActionListener(this);
		usernamefield.addActionListener(this); //new TexteListener()
		passworldfield.addActionListener(this); //new TexteListener()
		
		text.add(usernamefield);
		text.add(passworldfield);
		boutons.add(seconnecter);
		boutons.add(creercompte);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(text);
		this.getContentPane().add(boutons);
		this.setVisible(true); 
	}
	
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
	
	/*
	class TexteListener implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
			String username= usernamefield.getText();
			String passworld = passworldfield.getText();

			try {
				Integer.parseInt(text);
			}
			catch (NumberFormatException e){
				b=false;
			}

			if (b==false) {
				s=text+" n'est pas un entier !";
				JOptionPane.showMessageDialog(null, s); 
			}
			else {
				s=text+" est un entier !";
				JOptionPane.showMessageDialog(null, s); 
			}
			
		}
	}*/
}
	