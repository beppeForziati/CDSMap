package mining;

import data.Data;

public class QTMiner {

	// attributi
	private ClusterSet C;
	private double radius;

	/** costruttore **/
	public QTMiner(double radius) {
		C = new ClusterSet();
		this.radius = radius;
	}

	/** restituisce C **/
	public ClusterSet getC() {
		return C;
	}

	/** esegue l'agoritmo QT **/
	public int compute(Data data) {
		int numclusters = 0;
		boolean isClustered[] = new boolean[data.getNumberOfExamples()];
		for (int i = 0; i < isClustered.length; i++)
			isClustered[i] = false;
		int countClustered = 0;
		while (countClustered != data.getNumberOfExamples()) {
			// Ricerca cluster più popoloso
			Cluster c = buildCandidateCluster(data, isClustered);
			C.add(c);
			numclusters++;

			// Rimuovo tuple clusterizzate da dataset

			int clusteredTupleId[] = c.iterator();
			for (int i = 0; i < clusteredTupleId.length; i++) {
				isClustered[clusteredTupleId[i]] = true;
			}
			countClustered += c.getSize();
		}
		return numclusters;
	}

	/**
	 * costruisce un cluster per ciascuna tupla di data non ancora clusterizzata in
	 * un cluster di C e restituisce il cluster candidato più popoloso
	 **/
	private Cluster buildCandidateCluster(Data data, boolean[] isClustered) {
		Cluster MAX = null;
		int sizeMax = 0;
		for (int i = 0; i < isClustered.length; i++) {
			Cluster c = new Cluster(data.getItemSet(i));
			if (!isClustered[i]) {
				for (int j = 0; j < isClustered.length; j++) {
					System.out.println(c);
					if (!isClustered[j] && c.getCentroid().getDistance(data.getItemSet(j)) <= this.radius) {
						c.addData(j);
					}
				}
				if (c.getSize() > sizeMax) {
					sizeMax = c.getSize();
					MAX = c;
				}
			}
		}
		return MAX;
	}
}
