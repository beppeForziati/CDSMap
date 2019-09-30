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

	/**
	 * esegue l'agoritmo QT
	 * 
	 * @throws ClusteringRadiusException
	 **/
	public int compute(Data data) throws ClusteringRadiusException {
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
			for (Integer cc : c) {
				isClustered[cc] = true;
			}

			countClustered += c.getSize();
		}
		if (C.getSize() == 1)
			throw new ClusteringRadiusException();
		return numclusters;
	}

	/**
	 * costruisce un cluster per ciascuna tupla di data non ancora clusterizzata in
	 * un cluster di C e restituisce il cluster candidato più popoloso
	 **/

	private Cluster buildCandidateCluster(Data data, boolean[] isClustered) {
		Cluster MAX = null;
		for (int i = 0; i < isClustered.length; i++) {
			// System.out.println(i + " ");
			Cluster c = new Cluster(data.getItemSet(i));
			if (!isClustered[i]) {
				for (int j = 0; j < isClustered.length; j++) {
					if (!isClustered[j] && c.getCentroid().getDistance(data.getItemSet(j)) <= radius) {
						c.addData(j);
					}

					/* PROVARE A GESTIRE ALCUNI CICLI CON I METODI NEXT E HASNEXT-- */
				}
			}
			if (MAX == null || c.getSize() > MAX.getSize()) {
				MAX = c;
			}
			// System.out.println("sono qui" + i + " " + c.getSize());

			// System.out.println(" " + MAX.getSize());
		}
		return MAX;
	}
}
