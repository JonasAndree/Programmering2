package lesson.painting.images2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class MazePanel extends JPanel {;
    
	private int squareWidth;
	private int squareHeight;
	
	private Toolkit tk; 
	
	private ArrayList<ArrayList<Character>> maze;
	private ArrayList<int[]> path;
	
	private int mazeWidth;
	private BufferedImage img;
	private BufferedImage img2;
	
	/**
	 * @throws InterruptedException
	 */
	public MazePanel() throws InterruptedException  {

		
		this.setBackground(Color.BLACK);

        Maze maze = new Maze();
		this.maze = maze.getMaze();
		this.path = maze.getPath();
		
		this.mazeWidth = maze.getSize().width;
		tk = Toolkit.getDefaultToolkit();
		this.setPreferredSize(new Dimension(tk.getScreenSize().width,tk.getScreenSize().height));
		
		// Sets square size dependent on with or height of the screen.
		if (tk.getScreenSize().height < tk.getScreenSize().width) {
			squareWidth = tk.getScreenSize().height/maze.getSize().height;
			squareHeight = tk.getScreenSize().height/maze.getSize().height;
		} else {
			squareWidth = tk.getScreenSize().width/mazeWidth;
			squareHeight = tk.getScreenSize().width/mazeWidth;
		}
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) { /* forever */
					int lx = -1, ly = -1;
					for (int[] loc : path) {
						char symbol = '?';
						int x = loc[0];
						int y = loc[1];
						
						MazePanel.this.repaint();
						
						if (x - lx > 0){
							symbol = '>';
						}
						else if (x - lx < 0) {
							symbol = '<';
						}
						else if (y - ly > 0){
							symbol = '\\';
						}
						else if (y - ly < 0) {
							symbol = '/';
						}
						if (ly >= 0 && lx >= 0)
							MazePanel.this.maze.get(ly).set(lx, ' ');
						
						MazePanel.this.maze.get(y).set(x, symbol);

						lx = x;
						ly = y;
						try	{
							Thread.sleep(200);
						}
						catch (InterruptedException e) {
							e.printStackTrace();
							System.exit(1);
						}
					}
					MazePanel.this.maze.get(ly).set(lx, ' ');
					MazePanel.this.repaint();
				}
			}
		});
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		img = LoadImageApp("src/lesson/painting/images2/images/TilesforJonas-1.1.png");
		img2 = LoadImageApp("src/lesson/painting/images2/images/PlayerforJonas-1.0.png");
		
		    
		drawMaze(g, this.maze);
		
		
	}
	
	private void drawMaze(Graphics g, ArrayList<ArrayList<Character>> maze) {
		int x = (tk.getScreenSize().width - this.mazeWidth*squareWidth)/2; 
		int y = 0;
		for (ArrayList<Character> row : maze) {
			for (char cell : row) {
				
				switch (cell) {
				case ' ':
				case '-':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 130, 0, 160, 30, null);
					break;
				case '1':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 0, 0, 32, 32, null);
					break;
				case '2':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 32, 0, 64, 32, null);
					break;
				case '3':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 64, 0, 96, 32, null);
					break;
				case '4':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 96, 0, 128, 32, null);
					break;
				case '5':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 0, 32, 32, 64, null);
					break;
				case '6':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 32, 32, 64, 64, null);
					break;
				case '7':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 64, 32, 96, 64, null);
					break;
				case '8':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 96, 32, 128, 64, null);
					break;
				case '9':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 0, 64, 32, 96, null);
					break;
				case 'A':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 32, 64, 64, 96, null);
					break;
				case 'B':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 64, 64, 96, 96, null);
					break;
				case 'C':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 96, 64, 128, 96, null);
					break;
				case 'D':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 0, 96, 32, 128, null);
					break;
				case 'E':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 32, 96, 64, 128, null);
					break;
				case 'F':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 64, 96, 96, 128, null);
					break;
				case 'H':
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 96, 96, 128, 128, null);
					break;
				default:
					img2 = LoadImageApp("src/lesson/painting/images2/images/PlayerforJonas-1.0.png");
					AffineTransform tx = new AffineTransform();
					if (cell == '>') {
						tx.rotate(Math.PI/2, img2.getWidth() / 2, img2.getHeight() / 2);
					} else if (cell == '/'){
						tx.rotate(0, img2.getWidth() / 2, img2.getHeight() / 2);
					} else if (cell == '<'){
						tx.rotate(-Math.PI/2, img2.getWidth() / 2, img2.getHeight() / 2);
					} else {
						tx.rotate(Math.PI, img2.getWidth() / 2, img2.getHeight() / 2);
					}
					AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
					img2 = op.filter(img2, null);
					
					
					g.drawImage(img, x, y, x+squareWidth, y+squareHeight, 130, 0, 160, 30, null);
					g.drawImage(img2, x, y, squareWidth, squareHeight, null);
					break;
				}
				x += squareWidth;

/*
				AffineTransform tx = new AffineTransform();
				tx.rotate(Math.PI/2, img2.getWidth() / 2, img2.getHeight() / 2);

				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				img2 = op.filter(img2, null);
	*/			
				
				
				
			}
			y += squareHeight;
			x = (tk.getScreenSize().width - this.mazeWidth*squareWidth)/2;
		}
		/* NEW CODE! */
		
		/*Graphics2D g2 = (Graphics2D)g;
		/*g2.drawImage(loadImage("TilesforJonas-1.1.png"), 
	            0, 0, 200, 200,
	            0, 0, 200, 200,
	            null);*/
		/* END OF NEW CODE! */
	}
	/**
	 * 
	 * @param name
	 * @return 
	 * @return 
	 * @return
	 */
	public BufferedImage LoadImageApp(String name) {
		try {
			return ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return img ;
		}
	}
}
