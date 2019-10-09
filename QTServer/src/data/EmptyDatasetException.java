package data;

@SuppressWarnings("serial")
public class EmptyDatasetException extends Exception {

	EmptyDatasetException() {
		super("no insert data!");
	}
}
