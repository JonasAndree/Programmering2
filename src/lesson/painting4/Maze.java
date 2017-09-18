package lesson.painting4;

import java.util.*;
import java.awt.*;

/**
 * "C:\Program Files\Java\jdk1.8.0_65\bin\javac.exe" -cp src -s src -d bin src\painting3\*.java
 * "C:\Program Files\Java\jdk1.8.0_65\bin\java.exe" -cp bin painting3.Test3
 *
 */
public class Maze
{
	private static final String MAZE =
			"#############G#########\n" +
			"# #       # #         #\n" +
			"# # # ### # # ####### #\n" +
			"#   #   #   # #   #   #\n" +
			"# ##### ##### # # # ###\n" +
			"#     #     # # # # # #\n" +
			"# ######### ### # # # #\n" +
			"# #     #   #   #   # #\n" +
			"# # ### # # # ####### #\n" +
			"# # #     # #   #     #\n" +
			"# # ########### ### # #\n" +
			"S # #         #     # #\n" +
			"### # ####### ####### #\n" +
			"#   # #     #         #\n" +
			"# ### ##### ###########\n" +
			"#                     #\n" +
			"#######################\n";
	
	private int startX, startY;
	private int goalX, goalY;
	private int width, height;
	private ArrayList<ArrayList<Character>> maze;
	private ArrayList<int[]> path;
	
	public Maze() throws InterruptedException
	{
		this.path = new ArrayList<>();
		this.parseMaze();
		this.findPath(this.startX, this.startY);
	}
	
	public ArrayList<ArrayList<Character>> getMaze()
	{
		return this.maze;
	}
	
	public ArrayList<int[]> getPath()
	{
		return this.path;
	}
	
	public Dimension getSize()
	{
		return new Dimension(this.width, this.height);
	}
	
	private void parseMaze()
	{
		ArrayList<Character> row = new ArrayList<>();
		int x = 0, y = 0;

		this.maze = new ArrayList<>();

		for (char cell : MAZE.toCharArray())
		{
			switch (cell)
			{
			case '#':
				row.add('#');
				break;
			case 'S':
				row.add(' ');
				this.startX = x;
				this.startY = y;
				break;
			case 'G':
				row.add(' ');
				this.goalX = x;
				this.goalY = y;
				break;
			case ' ':
				row.add(' ');
				break;
			case '\n':
				y += 1;
				x = 0;
				this.maze.add(row);
				row = new ArrayList<>();
				break;
			}
			if (cell != '\n')
				x += 1;
		}
		
		this.height = this.maze.size();
		this.width = maze.get(0).size();
	}
	
	private boolean findPath(int x, int y)
	{
		char cell;
		
		if (x < 0 || y < 0 || x >= this.width || y >= this.height)
			return false;
		cell = this.maze.get(y).get(x);
		if (cell != ' ')
			return false;
		
		this.path.add(new int[]{ x, y });
		
		this.maze.get(y).set(x, '-');
		if (x == this.goalX && y == this.goalY)
			return true;
		
		if (findPath(x, y + 1)) return true;
		if (findPath(x, y - 1)) return true;
		if (findPath(x + 1, y)) return true;
		if (findPath(x - 1, y)) return true;
		
		this.path.remove(this.path.size() - 1);
		return false;
	}
}
