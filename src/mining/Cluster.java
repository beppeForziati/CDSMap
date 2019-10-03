package mining;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import data.Data;
import data.Tuple;

class Cluster implements Iterable<Integer>, Comparable<Cluster>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8318958471241143291L;

	private Tuple centroid;

	private Set<Integer> clusteredData = new HashSet<Integer>();

	/*
	 * Cluster(){
	 * 
	 * }
	 */

	Cluster(Tuple centroid) {
		this.centroid = centroid;
	}

	Tuple getCentroid() {
		return centroid;
	}

	// return true if the tuple is changing cluster
	boolean addData(int id) {
		return clusteredData.add(id);

	}

	// verifica se una transazione è clusterizzata nell'array corrente
	boolean contain(int id) {
		return clusteredData.contains(id);
	}

	// remove the tuplethat has changed the cluster
	void removeTuple(int id) {
		clusteredData.remove(id);

	}

	public int getSize() {
		return clusteredData.size();
	}

	@Override
	public String toString() {
		String str = "Centroid=(";
		for (int i = 0; i < centroid.getLength(); i++)
			str += centroid.get(i);
		str += ")";
		return str;

	}

	public String toString(Data data) {
		String str = "Centroid=(";
		for (int i = 0; i < centroid.getLength(); i++)
			str += centroid.get(i) + " ";
		str += ")\nExamples:\n";
		for (Integer c : clusteredData) {
			str += "[";
			for (int j = 0; j < data.getNumberOfExplanatoryAttributes(); j++)
				str += data.getValue(c, j) + " ";
			str += "] dist=" + getCentroid().getDistance(data.getItemSet(c)) + "\n";

		}
		str += "\nAvgDistance=" + getCentroid().avgDistance(data, this.clusteredData);
		return str;

	}

	@Override
	public int compareTo(Cluster o) {
		if (this.getSize() > o.getSize()) {
			return 1;
		} else
			return -1;
	}

	@Override
	public Iterator<Integer> iterator() {
		return clusteredData.iterator();
	}

}
