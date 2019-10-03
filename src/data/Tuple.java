package data;

import java.io.Serializable;
import java.util.Set;

public class Tuple implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1128862453280410765L;
	/** membri attributi **/
	private Item[] tuple;

	/** costruttore **/
	public Tuple(int size) {
		tuple = new Item[size];
	}

	/** restituisce la lunghezza della tupla **/
	public int getLength() {
		return tuple.length;
	}

	/** restituisce l'item nella posizione indicata **/
	public Item get(int i) {
		return tuple[i];
	}

	/** memorizza l'elemento indicato nella posizione indicata **/
	public void add(Item c, int i) {
		tuple[i] = c;
	}

	/** determina la distanza tra la tupla riferita e la tupla corrente **/
	public double getDistance(Tuple obj) {
		double dist = 0.0;
		for (int i = 0; i < obj.getLength(); i++) {
			if (tuple[i].getAttribute().getName().equals(obj.get(i).getAttribute().getName()))
				dist += this.get(i).distance(obj.get(i).getValue());
		}
		// System.out.println(dist);
		return dist;
	}

	/**
	 * restituisce la media delle distanze tra la tupla corrente e e quelle
	 * ottenibili dalle righe della matrice in data aventi indice in clusteredData
	 **/
	public double avgDistance(Data data, Set<Integer> clusteredData) {
		double p = 0.0, sumD = 0.0;
		for (Integer c : clusteredData) {
			double d = getDistance(data.getItemSet(c));
			sumD += d;
		}
		p = sumD / clusteredData.size();
		return p;
	}

}
