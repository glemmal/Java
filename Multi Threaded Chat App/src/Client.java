import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Client {

	private DataOutputStream streamOut;
	private DataInputStream streamIn;
	private Socket socket;
	private BufferedReader input;
	private String username;
	private HashMap<String, String> userRequests;
	private boolean keepRunning;

	public static void main(String args[]) {
		if(args.length != 2) {
			System.out.println("Usage java Client [host] [port]");
		} else {
			new Client(args[0], Integer.parseInt(args[1]));
		}
	}

	public Client(String host, int port) {
		keepRunning = true;
		userRequests = new HashMap<String, String>();
		input = new BufferedReader(new InputStreamReader(System.in));
		setUserRequests();
		try {
			socket = new Socket(host, port);
			open();
			run();
		} catch (UnknownHostException e) {
			System.out.println(userRequests.get("ERROR_HOSTNOTFOUND"));
		} catch (IOException e) {
			System.out.println(userRequests.get("ERROR_SERVERNOTAVAILABLE"));
		}

	}
	
	public void open() throws IOException {
		streamOut = new DataOutputStream(socket.getOutputStream());
		streamIn = new DataInputStream(socket.getInputStream());
	}

	public void run() throws IOException {
		System.out.println(userRequests.get("MESSAGE_ENTERUSERNAME"));
		username = input.readLine();
		if(!username.equals("")) {
			startClientThreads();
			System.out.println(userRequests.get("MESSAGE_WELCOME"));
		} else {
			System.out.println(userRequests.get("ERROR_USERNAME"));
			run();
		}
	}
	
	public void startClientThreads() {
		clientReadThread.start();
		clientWriteThread.start();
	}
	
	public void setUserRequests() {
		userRequests.put("ERROR_HOSTNOTFOUND", "Host not found!");
		userRequests.put("ERROR_SERVERNOTAVAILABLE", "Server is not available. Please try again later.");
		userRequests.put("ERROR_USERNAME", "Sorry this is not a valid username. :(");
		userRequests.put("MESSAGE_ENTERUSERNAME", "Please enter your username :)");
		userRequests.put("MESSAGE_WELCOME", "Welcome to our Chatroom");
		
	}
	
	Thread clientReadThread = new Thread() {
		public void run() {
			while(keepRunning) {
				try {
					System.out.println(streamIn.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Lost connection!");
					keepRunning = false;
					System.exit(0);
				}
			}
		}
	};
	
	Thread clientWriteThread = new Thread() {		
		public void run() {
			try {
				streamOut.writeUTF(username + " " + "joined your chatroom!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(keepRunning) {
				try {
					String message = input.readLine();
					if (message.trim().equals("exit")) {
						System.out.println("Good Bye!");
						System.exit(0);
					} else if(!message.trim().equals("")) {
						streamOut.writeUTF(username + ": " + message);
						streamOut.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Lost connection!");
					keepRunning = false;
					System.exit(0);
				}
			}
		}
	};

}
