package lesson.painting2;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * 
 * @author Jonas Andrée
 *
 */
public class MainGame
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGUI();
			}
		});
	}
	private static void createAndShowGUI(){
		 JFrame f = new JFrame("Painting is fun!");
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.add(new MyPanel());
		 f.pack();
		 f.setVisible(true);
	}
}
