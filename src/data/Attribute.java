package data;

public abstract class Attribute {
	/** Attributi di classe **/
	private String name;
	private int index;

	/** Costruttore **/
	Attribute(String name, int index) {
		this.name = name;
		this.index = index;
	}

	/** metodo get del nome **/
	public String getName() {
		return name;
	}

	/** metodo get dell'indice **/
	public int getIndex() {
		return index;
	}

	/** override della stampa **/
	@Override
	public String toString() {
		return name;
	}
}
