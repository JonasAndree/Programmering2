package TCPIP.Advanced.SingleThreadedServerHTMLOutput;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SingleThreadedServer implements Runnable {
	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;

	public SingleThreadedServer(int port) {
		System.out.println("Singelthreaded server: Constructed");
		this.serverPort = port;
	}

	public void run() {
		System.out.println("Singelthreaded server: Running");
		synchronized (this) {
			this.runningThread = Thread.currentThread();
			System.out.println("Singelthreaded server: Synchronized");
		}
		openServerSocket();

		while (!isStopped()) {
			System.out.println("Singelthreaded server: Loop.");
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
				System.out.println("Singelthreaded server: Server socket accept.");
			} catch (IOException e) {
				if (isStopped()) {
					System.out.println("Singelthreaded server: Server stopped.");
					return;
				}
				throw new RuntimeException("Singelthreaded server: Error accepting client connection", e);
			}
			try {
				processClientRequest(clientSocket);
			} catch (Exception e) {
				// log exception and go on to next request.
			}
		}

		System.out.println("Singelthreaded server: Stopped.");
	}

	private void processClientRequest(Socket clientSocket) throws Exception {
		System.out.println("Singelthreaded server: Processing client request.");
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
		System.out.println("Singelthreaded server: Request processed: " + time);
	}

	private synchronized boolean isStopped() {
		return this.isStopped;
	}
	
	/**
	 * 
	 */
	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
			System.out.println("Singelthreaded server: Closed.");
		} catch (IOException e) {
			throw new RuntimeException("Singelthreaded server: Error closing server", e);
		}
	}
	/**
	 * Open a server socket
	 */
	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
			System.out.println("Singelthreaded server: Server socket open.");
		} catch (IOException e) {
			throw new RuntimeException("Singelthreaded server: Cannot open port " + this.serverPort, e);
		}
	}
}
