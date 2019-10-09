package database;

@SuppressWarnings("serial")
public class NoValueException extends Exception {
	
	public NoValueException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage() +"No Value!";
	}
	
}
