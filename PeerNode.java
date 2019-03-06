import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
//import org.apache.http.protocol.HttpRequestHandler;

public class PeerNode {
	private int port;
	private ArrayList<PeerNode> Nodes;
	private PrintWriter out;	//Prints formatted representations of objects to a text-output stream.
	private BufferedReader in;	//Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
	private String msg = "";
	
	PeerNode(int port)
	{
		this.setPort(port);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	private void sendReq(int port, String stringMSG, String host) throws UnknownHostException, IOException
	{
		Socket socket = new Socket(host, port);	// A socket is an endpoint for communication between two machines.
		out = new PrintWriter(socket.getOutputStream(), true);
		out.checkError();
		out.println(stringMSG);
		
		out.close();
		socket.close();
	}
	
	private void startSenderNode(int port)
	{
		try {
			
			ServerSocket sender = new ServerSocket(0);	//A server socket waits for requests to come in over the network.
			System.out.print("connected to" + getPort());
			
			Socket connection = sender.accept();	//Listens for a connection -TCP connection- to be made to this socket and accepts it.
			HttpRequestHandler req = new HttpRequestHandler( connection );
			
			Thread thread = new Thread(req);	//// Create a new thread to process the request
			thread.start();
			System.out.println("thread for port " + port + " has started...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
