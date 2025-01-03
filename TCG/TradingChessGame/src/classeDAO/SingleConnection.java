package classeDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SingleConnection {
	private static Connection connect;

	public SingleConnection() {
		String databaseName="sql7755320	";
		
		SingleConnection.connect=null;
		
		String url="jdbc:mysql://sql7.freesqldatabase.com :3306/"+databaseName+"?serverTimezone=UTC";
		String login="sql7755320"; // dans l'idal un login de connexion pour l'application, et non root...
		String password="h2IsTW68bk"; // mot de passe avec xampp
		
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
