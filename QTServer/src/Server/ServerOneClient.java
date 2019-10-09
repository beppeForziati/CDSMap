package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import data.Data;
import data.EmptyDatasetException;
import database.DatabaseConnectionException;
import database.EmptySetException;
import mining.ClusteringRadiusException;
import mining.QTMiner;

public class ServerOneClient extends Thread {

	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private QTMiner kmeans;

	public ServerOneClient(Socket socket) throws IOException {
		this.socket = socket;

		// con in riceve le richieste dal client
		in = new ObjectInputStream(socket.getInputStream());

		// passa le richieste al client
		out = new ObjectOutputStream(socket.getOutputStream());

		// avvio del thread
		this.start();
	}

	@Override
	public void run() {

		System.out.println("sono qui");

		String tableName = "non stampato";

		try {

			Data data = null;
			Double radius = null;

			if ((int) in.readObject() == 0) {

				tableName = String.valueOf(in.readObject());
				data = new Data(tableName);
				// risposta a storeTableFromDb
				out.writeObject("OK");

			}

			if ((int) in.readObject() == 1) {

				radius = (Double) in.readObject();
				// prima risposta a learningFromDbTablr
				out.writeObject("OK");
				kmeans = new QTMiner(radius);
				int numIter = kmeans.compute(data);
				// seconda risposta a learningFromDbTablr
				out.writeObject(numIter);
				// terza risposta a learningFromDbTablr
				out.writeObject(kmeans.getC().toString(data));
			}

			if ((int) in.readObject() == 2) {
				String str = tableName + radius;
				kmeans.salva(str);
				out.writeObject("OK");
			}

			if ((int) in.readObject() == 3) {
				tableName = String.valueOf(in.readObject());
				radius = (Double) in.readObject();
				String fileName = tableName + radius;
				out.writeObject("OK");
				kmeans = new QTMiner(fileName);
				out.writeObject(kmeans.toString());

			}

		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
		} catch (EmptyDatasetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptySetException e) {
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		} catch (ClusteringRadiusException e) {
			e.printStackTrace();
		}

	}

}
