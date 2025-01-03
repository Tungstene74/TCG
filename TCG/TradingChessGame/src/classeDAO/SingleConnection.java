package classeDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SingleConnection {
		private static Connection connect;

		//Constructeur priv� pour une connexion avec MysqlDataSource
		private SingleConnection(String serverName, String dbName, String login, String password) throws ClassNotFoundException, SQLException{
			// Parametres de connexion : url, login, mdp
			String url="jdbc:mysql://"+serverName+":3306/"+dbName+"?serverTimezone=UTC";
			//port mysql avec USBWebserver:3307
			// port mysq avec xampp 3306

			// Creation d'une connexion avec MysqlDataSource
			MysqlDataSource mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(url);
			mysqlDS.setUser(login);
			mysqlDS.setPassword(password);

			connect = mysqlDS.getConnection();
		}
		//M�thode qui cr�e/retourne l'instance unique avec MySQLDataSource
		public static Connection getInstance(String serverName, String dbName, String login, String password) throws ClassNotFoundException, SQLException{
			if(connect == null){  
				new SingleConnection(serverName, dbName, login, password);
			}
			return connect;   
		}
		
		public static Connection getInstance() throws ClassNotFoundException, SQLException{
			if(connect == null){  
				new SingleConnection("sql7.freesqldatabase.com", "sql7755320", "sql7755320", "h2IsTW68bk");
			}
			return connect; 
		}
		
		public static void close() {
			try {
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
