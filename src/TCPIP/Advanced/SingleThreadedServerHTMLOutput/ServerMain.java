package TCPIP.Advanced.SingleThreadedServerHTMLOutput;

public class ServerMain {
	public static void main(String[] args) {
		SingleThreadedServer server = new SingleThreadedServer(8080);
		new Thread(server).start();
		try {
			System.out.println("Singelthreaded server: Sleeping.");
			Thread.sleep(10 * 100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Singelthreaded server: Stopping server");
		server.stop();
	}
}