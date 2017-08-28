package lesson.threads.runnableinterface.extendingTheThread;

public class ExampleThreadsMain {

	public static void main(String args[]) {
		ExampleThreads T1 = new ExampleThreads("Thread-1");
		T1.start();

		ExampleThreads T2 = new ExampleThreads("Thread-2");
		T2.start();
	}
}