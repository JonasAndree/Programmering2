package TCPIP.Advanced.MultiThreadedServerHTMLOutput;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
public class MultiThreadedServer implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public MultiThreadedServer(int port){
		System.out.println("Multithreaded server: Constructed");
        this.serverPort = port;
    }

    public void run(){
		System.out.println("Multithreaded server: Running");
        synchronized(this){
            this.runningThread = Thread.currentThread();
			System.out.println("Multithreaded server: Synchronized");
        }
        openServerSocket();
        while(!isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Multithreaded server: Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Multithreaded server: Error accepting client connection", e);
            }
            new Thread(
                new WorkerRunnable(
                    clientSocket, "Multithreaded Server")
            ).start();
        }
        System.out.println("Multithreaded server: Server stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
			System.out.println("Multithreaded server: Closed.");
        } catch (IOException e) {
            throw new RuntimeException("Multithreaded server: Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
			System.out.println("Multithreaded server: Server socket open.");
        } catch (IOException e) {
            throw new RuntimeException("Multithreaded server: Cannot open port 8080", e);
        }
    }

}