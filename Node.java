import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Node {
	
	private Socket socketNode;
	private PrintWriter out;
    private BufferedReader in;
	
	Node(String ip, int port) throws IOException
	{
		socketNode = new Socket(ip, port);
		
		out = new PrintWriter(socketNode.getOutputStream(), true);	//Prints formatted representations of objects to a text-output stream
        in = new BufferedReader(new InputStreamReader(socketNode.getInputStream()));
	}
	
	public String sendMsg(String msg) throws IOException
	{
		out.println(msg);
		String response = in.readLine();
		return response;
	}
	
	public void stopConnection() throws IOException
	{
		in.close();
		out.close();
		socketNode.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		int numberOfNodes = 3;
		for(int i = 0; i < numberOfNodes; i++){
			
			String IP = "172.20.184.65";
			int port = 135;
			Node node = new Node(IP, port);
			NodeThread nodethread = new NodeThread("one");
			NodeThread nodethread1 = new NodeThread("two");
			
			node.sendMsg("Hello other NODE!!!");
		}
	}
}
