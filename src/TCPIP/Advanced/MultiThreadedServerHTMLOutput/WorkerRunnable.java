package TCPIP.Advanced.MultiThreadedServerHTMLOutput;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

/**
 *
 */
public class WorkerRunnable implements Runnable {

	protected Socket clientSocket = null;
	protected String serverText = null;

	public WorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
		this.serverText = serverText;
	}

	public void run() {
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			long time = System.currentTimeMillis();
			
			StringBuilder contentBuilder = new StringBuilder();
		    System.out.println("Reading index.html");
			try {
			    BufferedReader in = new BufferedReader(new FileReader("C:/Users/jonas.andree/Documents/GitHub/Programmering2/src/TCPIP/Advanced/SingleThreadedServerHTMLOutput/index.html"));
			    String str;
			    while ((str = in.readLine()) != null) {
			        contentBuilder.append(str + "\n");
			    }
			    in.close();
			} catch (IOException e) {
				System.out.println("Reading html file failed.");
			}
			
			String content = contentBuilder.toString();
			byte[] responseDocument = content.getBytes();

			byte[] responseHeader = ("HTTP/1.1 200 OK\r\n" + "Content-Type: text/html; charset=UTF-8;\r\n" + "Content-Length: " + 
			                        responseDocument.length + "\r\n\r\n").getBytes("UTF-8");

			output.write(responseHeader);
			output.write(responseDocument);
					
			output.close();
			input.close();
			System.out.println("Request processed: " + time);
		} catch (IOException e) {
			// report exception somewhere.
			e.printStackTrace();
		}
	}
}