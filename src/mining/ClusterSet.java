package mining;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import data.Data;

public class ClusterSet implements Iterable<Cluster> {
	/** attributi membri **/
	private Set<Cluster> C = new TreeSet<Cluster>();

	/** costruttore **/
	ClusterSet() {

	}

	/** metodo di aggiunta del cluster **/
	void add(Cluster c) {
		C.add(c);
	}

	/**
	 * restituisce il cluster nella posizone indicata public Cluster get(int i) { }
	 **/

	/** riscrittura della stampa **/
	@Override
	public String toString() {
		return C.toString();
	}

	public String toString(Data data) {
		String str = "";
		int i = 0;
		for (Cluster cc : C) {
			if (cc != null) {
				str += i + ":" + cc.toString(data) + "\n";
			}
			i++;
		}
		return str;
	}

	@Override
	public Iterator<Cluster> iterator() {
		return C.iterator();
	}
}
