package data;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DiscreteAttribute extends Attribute implements Iterable<String> {

	/** membri attributo **/
	Set<String> values = new TreeSet<String>(); // seguono un ordine lessicografico

	/** costruttore **/
	DiscreteAttribute(String name, int index, Set<String> values) {
		super(name, index);
		this.values = values;
	}

	/** ritorna il numero di valori discreti **/
	public int getnumberOfDistinctValues() {
		return values.size();
	}

	@Override
	public Iterator<String> iterator() {
		return values.iterator();
	}
}
