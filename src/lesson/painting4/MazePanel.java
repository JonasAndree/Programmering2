package lesson.painting4;

import java.awt.*;
import java.util.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class MazePanel extends JPanel
{
	private final int SQUARE_WIDTH = 20;
	private final int SQUARE_HEIGHT = 20;
	
	private ArrayList<ArrayList<Character>> maze;
	private ArrayList<int[]> path;
	
	public MazePanel() throws InterruptedException
	{
		this.setBackground(Color.BLACK);
		Maze maze = new Maze();
		this.maze = maze.getMaze();
		this.path = maze.getPath();
		this.setPreferredSize(new Dimension(maze.getSize().width  * SQUARE_WIDTH,
											maze.getSize().height * SQUARE_HEIGHT));
		
		Thread thread = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					boolean erase = false; 
					for (;;) /* forever */
					{
						int lx = -1, ly = -1;
						for (int[] loc : path)
						{
							char symbol = '?';
							int x = loc[0];
							int y = loc[1];
							
							MazePanel.this.repaint();
							
							if      (erase)       symbol = ' ';
							else if (x - lx > 0)  symbol = '>';
							else if (x - lx < 0)  symbol = '<';
							else if (y - ly > 0)  symbol = '\\';
							else if (y - ly < 0)  symbol = '/';
							MazePanel.this.maze.get(y).set(x, symbol);
							
							lx = x;
							ly = y;
							try
							{
								Thread.sleep(100);
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
								System.exit(1);
							}
						}
						MazePanel.this.repaint();
						erase = !erase;
					}
				}
			});
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawMaze(g, this.maze);
	}
	
	private void drawMaze(Graphics g, ArrayList<ArrayList<Character>> maze)
	{
		int x = 0, y = 0;
		for (ArrayList<Character> row : maze)
		{
			for (char cell : row)
			{
				switch (cell)
				{
				case ' ':
				case '-':
					g.setColor(Color.WHITE);
					break;
				case '#':
					g.setColor(Color.BLACK);
					break;
				default:
					g.setColor(new Color(192, 16, 255));
					break;
				}
				g.fillRect(x, y, SQUARE_WIDTH, SQUARE_HEIGHT);
				
				x += SQUARE_WIDTH;
			}
			y += SQUARE_HEIGHT;
			x = 0;
		}
	}
}
