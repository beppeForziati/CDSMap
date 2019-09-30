package mainTest;

import data.Data;
import data.EmptyDatasetException;
import keyboardinput.Keyboard;
import mining.ClusteringRadiusException;
import mining.QTMiner;

public class MainTest {
	/**
	 * @param args
	 * @throws ClusteringRadiusException
	 * @throws EmptyDatasetException
	 */
	public static void main(String[] args) throws ClusteringRadiusException, EmptyDatasetException {

		Data data = new Data();
		System.out.println(data);
		char ricomincia;
		do {
			System.out.println("insert radius(>0)");
			double radius = Keyboard.readInt();
			QTMiner qt = new QTMiner(radius);
			int numIter = qt.compute(data);
			// System.out.println("ci sono");
			System.out.println("Number of clusters:" + numIter);
			System.out.println(qt.getC().toString(data));
			System.out.println("new execution?(y/n)");
			ricomincia = Keyboard.readChar();
		} while (ricomincia == 'y');
	}

}
