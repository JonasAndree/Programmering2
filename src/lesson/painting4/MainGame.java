package lesson.painting4;

import javax.swing.*;
import java.awt.*;


public class MainGame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					System.exit(1);
				}
			}
		});
	}
	
	private static void createAndShowGUI() throws InterruptedException {
		 JFrame f = new JFrame("Gaming is fun!");
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setLayout(new BorderLayout());
		 f.add(new MazePanel(), BorderLayout.CENTER);
         f.setResizable(false);
         f.setAlwaysOnTop(true);
         
         //Display the window.
		 f.pack();
		 f.setVisible(true);
	}
}
