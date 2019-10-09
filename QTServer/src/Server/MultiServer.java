package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	private int PORT;

	public static void main(String[] args) throws IOException {
		MultiServer MS = new MultiServer();
	}

	public MultiServer() throws IOException {
		PORT = 8080;
		this.run();
	}

	private void run() throws IOException {
		ServerSocket server = new ServerSocket(PORT);

		System.out.println("server in attesa sulla porta" + PORT);

		// crea il socket e pone in attesa su quella porta
		Socket socketServer = server.accept();

		System.out.println("collegamento avvenuto");

		//
		ServerOneClient connection = new ServerOneClient(socketServer);

	}
}
