package interface_;

import javax.imageio.ImageIO;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Connection extends JFrame implements ActionListener{
	
	JButton seconnecter, creercompte;
    JTextField usernamefield, passworldfield;
    JPanel tout, boutons;

    public Connection() {
        // Configuration de la fenêtre
        this.setTitle("Trading Chess Game");
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        // Panneau principal avec GridBagLayout pour l'alignement
        tout = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants

        // Création des composants
        seconnecter = new JButton("Se connecter");
        creercompte = new JButton("Créer un compte");
        usernamefield = new JTextField("Nom d'utilisateur", 20);
        passworldfield = new JTextField("Mot de passe", 20);

        // Ajout des auditeurs
        creercompte.addActionListener(this);
        seconnecter.addActionListener(this);

        // Configuration et ajout des composants avec GridBagConstraints
        // Ligne 1 : Champ "Nom d'utilisateur"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tout.add(usernamefield, gbc);

        // Ligne 2 : Champ "Mot de passe"
        gbc.gridx = 0;
        gbc.gridy = 2;
        tout.add(passworldfield, gbc);

        // Ligne 3 : Panneau des boutons
        boutons = new JPanel(new GridLayout(1, 2, 10, 0)); // Boutons côte à côte avec un écart
        boutons.add(seconnecter);
        boutons.add(creercompte);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER; // Centre les boutons
        tout.add(boutons, gbc);

        
        
        // Ligne 4 : Ajout de l'image
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = loadImage("TCG/TradingChessGame/src/images/Chat_test.png"); // Charge l'image
        if (imageIcon != null) {
            imageLabel.setIcon(imageIcon);
        } else {
            imageLabel.setText("Image non disponible");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        //ImageIcon imageIcon = new ImageIcon("Chat_test.png"); // Remplacez par le chemin de votre image
        imageLabel.setIcon(imageIcon);

        gbc.gridx = 0;
        gbc.gridy = 0; // Position après les boutons
        gbc.anchor = GridBagConstraints.CENTER; // Centrer l'image
        tout.add(imageLabel, gbc);

        // Ajout du panneau principal au centre de la fenêtre
        this.getContentPane().add(tout, BorderLayout.CENTER);

        // Configuration finale de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private ImageIcon loadImage(String path) {
        try {
            // Charge l'image et redimensionne si nécessaire
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage();
            Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionne à 100x100
            return new ImageIcon(resizedImg);
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
            return null;
        }
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
}
	