package classeDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SingleConnection {
	private static Connection connect;

	public SingleConnection() {
		String databaseName="echec";
		
		SingleConnection.connect=null;
		
		String mode_conection = "en ";
		
		String url="";
		if (mode_conection== "en ligne") {
		 url="jdbc:mysql://4.tcp.eu.ngrok.io:18149  /"+databaseName+"?serverTimezone=UTC";//base de donner en ligne désormer fermer 
		}else { url="jdbc:mysql://localhost:3306 /"+databaseName+"?serverTimezone=UTC";
		}
		String login="root"; // dans l'idal un login de connexion pour l'application, et non root...
		String password=""; // mot de passe avec xampp
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(url);
		mysqlDS.setUser(login);
		mysqlDS.setPassword(password);

		try {
			SingleConnection.connect = mysqlDS.getConnection();
		} catch (SQLException e1) {
			System.err.println("Erreur de parcours de connexion");
			e1.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		if (SingleConnection.connect == null) {
			new SingleConnection();
		}
		
		return SingleConnection.connect;
		
	}
	
	public static void close() {
		try {
			SingleConnection.connect.close();
		} catch (SQLException e) {
			System.err.println("Erreur de fermeture de connexion");
			e.printStackTrace();
		}
	}

}
