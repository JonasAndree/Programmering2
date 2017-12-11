package lesson.draw.image;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * 
 * @author Jonas Andrée
 *
 */
public class MainGame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Create GUI and EDT?" + SwingUtilities.isEventDispatchThread());
		
		JFrame frame = new JFrame("My first game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Player player1 = new Player();
		GamePanel gamePanel = new GamePanel(player1);
		
		
		frame.add(gamePanel);
		frame.pack();
		frame.addKeyListener(gamePanel);
		frame.addKeyListener(player1);
		
		//f.setUndecorated(true);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
}
