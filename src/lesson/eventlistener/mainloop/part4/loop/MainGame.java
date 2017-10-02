package lesson.eventlistener.mainloop.part4.loop;

import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * This is the basic code structure for the game. With event listeners and some
 * graphics painting.
 * 
 * @author Jonas Andrée
 * @version 0.1
 */
public class MainGame {
	// ALL global variables is placed at the top of the class.
	private static GamePanel gamePanel;

	/**
	 * Always needed to run the game. Starts the GUI Remember that you can always
	 * read the documentations of you want to learn more about how things work and
	 * why we use them.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * invokeLater Causes doRun.run() to be executed asynchronously on the AWT event
		 * dispatching thread. This will happen after all pending AWT events have been
		 * processed. This method should be used when an application thread needs to
		 * update the GUI. In the following example the invokeLater call queues the
		 * Runnable object doHelloWorld on the event dispatching thread and then prints
		 * a message.
		 * 
		 * The Runnable interface should be implemented by any class whose instances are
		 * intended to be executed by a thread. The class must define a method of no
		 * arguments called run.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			/*
			 * When an object implementing interface Runnable is used to create a thread,
			 * starting the thread causes the object's run method to be called in that
			 * separately executing thread. The general contract of the method run is that
			 * it may take any action whatsoever. We use @Override to symbolize that the
			 * method already exists.
			 */
			@Override
			public void run() {
				// A new Game window
				new GameWindow();
			}
		});
	}
}