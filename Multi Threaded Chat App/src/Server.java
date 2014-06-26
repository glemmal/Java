import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;


public class Server {

	private ServerSocket server;
	private ArrayList<ServerClientThread> clientThreads;

	public Server(int port) {
		clientThreads = new ArrayList<ServerClientThread>();
		try {
			// Server setup
			server = new ServerSocket(port);
			System.out.println("Listening on port " + port + ". Waiting for client to connect ...");
			// Listenind for clients
			listening.start();
		} catch (IOException e) {
			System.out.println(e.getMessage() + "\nUnable to connect to port " + port);
		}
	}

	public static void main(String args[]) {
		if(args.length != 1) {
			System.out.println("Usage java Server [port]");
		} else {
			//Initialize new server
			new Server(Integer.parseInt(args[0]));
		}
	}
	
	Thread listening = new Thread() {
		public void run() {
			while(true) {
				System.out.println("Listening...");
				try {
					ServerClientThread clientThread = new ServerClientThread(server.accept(), clientThreads);
					clientThread.start();
					clientThreads.add(clientThread);
					System.out.println("New Client connected");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

}
