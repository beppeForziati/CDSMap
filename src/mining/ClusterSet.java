package mining;

import data.Data;

public class ClusterSet {
	/** attributi membri **/
	private Cluster[] C = new Cluster[0];

	/** costruttore **/
	ClusterSet() {

	}

	/** metodo di aggiunta del cluster **/
	void add(Cluster c) {
		Cluster tempC[] = new Cluster[C.length + 1];
		for (int i = 0; i < C.length; i++)
			tempC[i] = C[i];
		tempC[C.length] = c;
		C = tempC;
	}

	/** restituisce il cluster nella posizone indicata **/
	public Cluster get(int i) {
		return C[i];
	}

	/** riscrittura della stampa **/
	@Override
	public String toString() {
		return this.C.toString();
	}

	public String toString(Data data) {
		String str = "";
		for (int i = 0; i < C.length; i++) {
			if (C[i] != null) {
				str += i + ":" + C[i].toString(data) + "\n";
			}
		}
		return str;
	}
}
