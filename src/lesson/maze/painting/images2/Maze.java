package lesson.maze.painting.images2;

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
			"6373333333738G233333338\n" +
			"9 9       9 9         9\n" +
			"9 D 5 238 D 9 6333734 9\n" +
			"9   9   9   9 9   9   9\n" +
			"9 23F38 E333C 9 5 9 63C\n" +
			"9     9     9 9 9 9 9 9\n" +
			"9 6333F3734 A3H 9 D 9 9\n" +
			"9 9     9   9   9   9 9\n" +
			"9 9 634 D 5 9 23B333H 9\n" +
			"9 9 9     9 9   9     9\n" +
			"D 9 A33333F F38 E34 5 9\n" +
			"S 9 9         9     9 9\n" +
			"63H 9 6333338 E33333H 9\n" +
			"9   9 9     9         9\n" +
			"9 23H E3334 E333333333C\n" +
			"9                     9\n" +
			"E333333333333333333333H\n";
	
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
			case '1':
				row.add('1');
				break;
			case '2':
				row.add('2');
				break;
			case '3':
				row.add('3');
				break;
			case '4':
				row.add('4');
				break;
			case '5':
				row.add('5');
				break;
			case '6':
				row.add('6');
				break;
			case '7':
				row.add('7');
				break;
			case '8':
				row.add('8');
				break;
			case '9':
				row.add('9');
				break;
			case 'A':
				row.add('A');
				break;
			case 'B':
				row.add('B');
				break;
			case 'C':
				row.add('C');
				break;
			case 'D':
				row.add('D');
				break;
			case 'E':
				row.add('E');
				break;
			case 'F':
				row.add('F');
				break;
			case 'H':
				row.add('H');
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
