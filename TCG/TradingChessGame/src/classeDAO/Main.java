package classeDAO;

import java.sql.SQLException;

import classeMetier.Joueur;

public class Main {

	public static void main(String[] args) {
		try {
		System.out.println("Hello World java");
		System.out.println("Hello World java2");
		
		Joueur J1 = new Joueur("Bill", "123");
		
		JoueurDAO J = new JoueurDAO();
		J.open();
		J.create(J1);
		
		System.out.println(J1.getId_joueur());
		
		Joueur J2 = new Joueur("rock", "dfsdq");
		
		J.create(J2);
		J.close();
		
		System.out.println(J2.getId_joueur());
		}catch (SQLException e) {
            e.printStackTrace();
        }
		

	}

}
