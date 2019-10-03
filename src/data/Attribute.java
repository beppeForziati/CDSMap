package data;

import java.io.Serializable;

public abstract class Attribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2416400680372454744L;
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
