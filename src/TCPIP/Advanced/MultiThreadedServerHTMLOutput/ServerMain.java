package TCPIP.Advanced.MultiThreadedServerHTMLOutput;

public class ServerMain {

	public static void main(String[] args) {
		MultiThreadedServer server = new MultiThreadedServer(8080);
		new Thread(server).start();
		try {
			System.out.println("Multithreaded server: Sleeping.");
			Thread.sleep(10 * 100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Multithreaded server: Stopping server");
		server.stop();

	}

}
