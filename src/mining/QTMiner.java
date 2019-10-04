package mining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import data.Data;

public class QTMiner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6178352022036478469L;
	// attributi
	private ClusterSet C;
	private double radius;

	/** costruttore serializzato **/
	public QTMiner(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
			C = (ClusterSet) input.readObject();
			System.out.println(C);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " (Impossibile trovare il file specificato!)");
		}
	}

	/** costruttore **/
	public QTMiner(double radius) {
		C = new ClusterSet();
		this.radius = radius;
	}

	public void salva(String fileName) throws FileNotFoundException, IOException {
		// questo metodo funziona senza l'interfaccia serializable(???)

		/*
		 * PrintWriter outputStream = null; try { outputStream = new
		 * PrintWriter(fileName); } catch (FileNotFoundException e) {
		 * System.out.println("errore nell'apertura del file " + fileName);
		 * System.exit(0); } outputStream.println(C); outputStream.close();
		 * System.out.println("ClusterSet inserito nel file " + fileName);
		 */

		// questo metodo funziona solo con l'interfaccia ma scrive solo sequenze di //
		// numeri e caratteri
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(fileName));
			output.writeObject(C);
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("errore nell'apertura del file " + fileName);
		}
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
