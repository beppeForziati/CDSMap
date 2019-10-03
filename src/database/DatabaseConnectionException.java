package database;

@SuppressWarnings("serial")
public class DatabaseConnectionException extends Exception {
	
	public DatabaseConnectionException(){
		super("Connection Failed!\n");
	}
	@Override
	public String toString() {
		return getMessage() +"connection failed";
	}
}
