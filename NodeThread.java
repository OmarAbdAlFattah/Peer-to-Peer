import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NodeThread implements Runnable{
	
	String name;
	Thread t;
	NodeThread(String nodeName){
		name = nodeName;
		t = new Thread(this, name);
		System.out.println("New Thread " + t);
		t.start();
	}
	
	public void run()
	{
		System.out.println("Node is Running..." + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
		{
			new NodeThread("One");
			
			try 
			{
			     Thread.sleep(10000);
			} catch (InterruptedException e)
			{
			      System.out.println("Main thread Interrupted!");
			}
			System.out.println("Main thread exiting...");
		}
}
