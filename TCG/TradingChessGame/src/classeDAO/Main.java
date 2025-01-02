package classeDAO;

import java.sql.SQLException;

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

			J.create(J2);
			

			System.out.println(J2.getId_joueur());
			J.delete(J2);
			J.delete(J1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {


			Partie D1 = new Partie(1,1, 1, 1);

			PartieDAO D = new PartieDAO();
			D.open();
			D.create(D1);

			System.out.println(D1.getId_joueur1());

			D.delete(D1);
			
			D.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}



	}

}
