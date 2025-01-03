package classeDAO;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import classeMetier.Joueur;
import classeMetier.Partie;


public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Hello World java");
			System.out.println("Hello World java2");

			Joueur J1 = new Joueur("Bill", "123");

			JoueurDAO J = new JoueurDAO();
			J.open();
			J.create(J1);

			J.connection("Bill", "123");

			System.out.println(J1.getId_joueur());

			Joueur J2 = new Joueur("rock", "dfsdq");
			J2.mainDeck();

			J.create(J2);
			

			System.out.println(J2.getId_joueur());
			J.delete(J1);

			
			Partie D1 = new Partie(J2, 38);

			PartieDAO D = new PartieDAO();
			D.open();
			D.create(D1);

			D.delete(D1);
			J.delete(J2);

			
			D.close();
			J.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}

		
		/*
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("salut");
			}
		},0, 5000);*/

	}

}
