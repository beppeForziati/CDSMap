package data;

import java.io.Serializable;

public abstract class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7083356003943992182L;
	/** membri attributi **/
	private Attribute attribute;
	private Object value;

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
