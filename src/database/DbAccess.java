package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbAccess {
	
	private String DRIVER_CLASS_NAME = "org.gjt.mm.mysql.Driver";
	private final String DBMS = "jdbc:mysql";
	private final String SERVER="localhost";
	private final String DATABASE = "MapDB";
	private final String PORT="3306";
	private final String USER_ID = "MapUser";
	private final String PASSWORD = "map";
	private Connection conn=null;
	
	public DbAccess() {
		
	}
	
	public void initConnection() throws DatabaseConnectionException, ClassNotFoundException, SQLException{
		try {
			Class.forName(DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE,USER_ID,PASSWORD);
			if(conn==null) {
				throw new DatabaseConnectionException();
			}
			
			
		} catch(ClassNotFoundException cls) {
			System.out.println("Class not found!\n");
		}catch(DatabaseConnectionException dce) {
			System.out.println(dce.getMessage());
		}
		
		
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() throws SQLException {
		try {
			conn.close();
		} catch(SQLException SQLe) {
			System.out.println("Can't close the connection!\n");
		}
		
	}
}
