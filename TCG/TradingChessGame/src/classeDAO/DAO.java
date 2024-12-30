package classeDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO<T> {
	protected Connection connect;
	protected Statement stmt;
	
	public void open() throws SQLException {
		connect = SingleConnection.getInstance();
	}
	
	public abstract T create(T obj)throws SQLException ;
	
	public abstract T update(T obj)throws SQLException ;
	
	public abstract void delete(T obj)throws SQLException ;
	
	public void close() throws SQLException {
		SingleConnection.close();
	}
}
