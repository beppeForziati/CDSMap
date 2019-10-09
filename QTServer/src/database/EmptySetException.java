package database;

@SuppressWarnings("serial")

public class EmptySetException extends Exception {
	public EmptySetException() {
		super("Empty Set!\n");
	}
	
	@Override
	public String toString() {
		return getMessage() +"No Value!";
	}
	
}
