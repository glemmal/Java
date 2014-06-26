import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class ServerClientThread extends Thread {
	
	private DataInputStream streamIn;
	private DataOutputStream streamOut;
	private ArrayList<ServerClientThread> clients;
	private Socket client;
	private boolean keepRunning = true;
	
	
	public ServerClientThread(Socket client, ArrayList<ServerClientThread> clients) {
		this.clients = clients;
		this.client = client;
	}
	
	public void run() {
		try {
			open();
			while(keepRunning) {
				try {
					System.out.print("\rnew");
					sendToAll(streamIn.readUTF());
				} catch(IOException e) {
					System.out.println("Lost connection to client.");
					keepRunning = false;
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void open() throws IOException {
		streamIn = new DataInputStream(new BufferedInputStream(client.getInputStream()));
		streamOut = new DataOutputStream(client.getOutputStream());
	}
	
	public void sendMessage(String message) throws IOException {
		streamOut.writeUTF(message);
		streamOut.flush();
	}
	
	public void sendToAll(String message) throws IOException {
		for(ServerClientThread client : clients) {
			client.sendMessage(message);
		}
	}
}
