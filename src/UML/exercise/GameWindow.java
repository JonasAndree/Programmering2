package UML.exercise;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.     BufferedImage;
import java.awt.Point;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sets the preferences for the game window
	 */
	public GameWindow (String titel){
		setTitle(titel);
		 // Sets so that the window dose not have any borders. 
		setUndecorated(true);
		 // Sets so that we can't change the size off the window.
        setResizable(false);
        // Lets set it on top of everything like games generally are. 
        setAlwaysOnTop(true);
        /* Causes this Window to be sized to fit the preferred size 
         * and layouts of its subcomponents. 
         */
        addKeyListener(this);
        addKeyListener(new Player());
        
        /********************************************************************
         * 						Mouse listener 								*
         ********************************************************************/
        addMouseListener(new Aim());
        
        add(new GameLoop());
        // Sets the window size relative to the content.
		pack();
		// Shows or hides this Window.
		setVisible(true);
		
		//getContentPane().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		//		new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor"));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/*
		  * So if something happens what should happen. 
		  * The ge.getKeyKode() shows what key was pressed. 
		  * There are all the keys that could have been pressed 
		  * can be found using KeyEvent._______ 
		  */
		 if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			 /* Write to the terminal if we press the esc button 
			  * and then close the program using id 0 saying that 
			  * the closing of the program went well and natural. 
			  * Sometimes when u use get an error you want to close the 
			  * program in this case use the id 1. There are many more id's 
			  * but I'm not going to go through it. 
			  */
			 System.out.println("Exit program!");
			 System.exit(0);  
		 }
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}