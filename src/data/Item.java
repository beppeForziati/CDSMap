package data;

public abstract class Item {

	/** membri attributi **/
	Attribute attribute;
	Object value;

	/** costruttore **/
	Item(Attribute attribute, Object value) {
		this.attribute = attribute;
		this.value = value;
	}

	/** ritorna attribute **/
	public Attribute getAttribute() {
		return attribute;
	}

	/** restituisce value **/
	public Object getValue() {
		return value;
	}

	/** override stampa **/
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	/** metodo astratto **/
	abstract double distance(Object a);
}
