package lesson.eventlistener.mainloop.part4.loop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements KeyListener {

	private static GamePanel gamePanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3706026480807280471L;

	public GameWindow() {

		/*
		 * Adds a component JPanel to the JFrame. We will do the painting on this. You
		 * can add other components like buttons and panels to this. But lets start with
		 * just a panel.
		 */
		add(gamePanel = new GamePanel(this));
		// Sets so that the window do not have any borders.
		setUndecorated(true);
		// Sets so that we can't change the size off the window.
		setResizable(false);
		// Lets set it on top of everything like games generally are.
		setAlwaysOnTop(true);
		// Add's the listeners needed to change the window.
		addKeyListener(this);
		/*
		 * Causes this Window to be sized to fit the preferred size and layouts of its
		 * subcomponents.
		 */
		pack();
		// Shows or hides this Window.
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			/*
			 * Write to the terminal if we press the esc button and then close the program
			 * using id 0 saying that the closing of the program went well and natural.
			 * Sometimes when u use get an error you want to close the program in this case
			 * use the id 1. There are many more id's but I'm not going to go through it.
			 */
			System.out.println("Exit program!");
			System.exit(0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
