package data;

public class DiscreteAttribute extends Attribute {

	/** membri attributo **/
	String values[]; // seguono un ordine lessicografico

	/** costruttore **/
	DiscreteAttribute(String name, int index, String values[]) {
		super(name, index);
		this.values = values;
	}

	/** ritorna il numero di valori discreti **/
	public int getnumberOfDistinctValues() {
		return values.length;
	}

	/** ritorna valore nella posizione indicata **/
	public String getValues(int i) {
		return values[i];
	}

}
