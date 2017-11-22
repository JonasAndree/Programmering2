package lesson.live.graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Exercises 
 * Make 2 or more boxes move across the screen forwards and backwards,
 * like if it was obstacles you need to cross. 
 * 
 * Paint a few other types of geometric objects. 
 * 
 * Variate the colors and objects across time.
 * 
 * If an object touches another object change the color of the objects to red
 * 
 * Make the frame size:
 * width = 32 px * number of maze cell in maze row
 * height = 32 px * number of maze rows. 
 * 
 * 
 * 
 * @author jonas.andree
 *
 */
public class MainGame {

	public static void main(String[] args) {
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("My first frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel panel = new GamePanel();
		frame.add(panel);
		
		frame.addKeyListener(panel);
		
		
		frame.pack();
		frame.setVisible(true);
	}


}
