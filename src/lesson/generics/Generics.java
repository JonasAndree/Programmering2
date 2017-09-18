package lesson.generics;

import java.util.*;

public class Generics
{
	private static String MAZE =
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
	
	static int startX, startY;
	static int goalX, goalY;
	static int width, height;
	static ArrayList<ArrayList<Character>> maze;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		ArrayList<int[]> path = new ArrayList<>();
		
		parseMaze();
		findPath(path, startX, startY);
		drawMaze(path);
	}
	
	
	private static void parseMaze()
	{
		ArrayList<Character> row = new ArrayList<>();
		int x = 0, y = 0;

		maze = new ArrayList<>();

		for (char cell : MAZE.toCharArray())
		{
			switch (cell)
			{
			case '#':
				row.add('#');
				break;
			case 'S':
				row.add(' ');
				startX = x;
				startY = y;
				break;
			case 'G':
				row.add(' ');
				goalX = x;
				goalY = y;
				break;
			case ' ':
				row.add(' ');
				break;
			case '\n':
				y += 1;
				x = 0;
				maze.add(row);
				row = new ArrayList<>();
				break;
			}
			if (cell != '\n')
				x += 1;
		}
		
		height = maze.size();
		width = maze.get(0).size();
	}
	
	
	static boolean findPath(ArrayList<int[]> path, int x, int y)
	{
		char cell;
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return false;		
		cell = maze.get(y).get(x);
		if (cell != ' ')
			return false;
		
		path.add(new int[]{ x, y, });
		
		maze.get(y).set(x, '-');
		if (x == goalX && y == goalY)
			return true;
		
		if (findPath(path, x, y + 1))  return true;
		if (findPath(path, x, y - 1))  return true;
		if (findPath(path, x + 1, y))  return true;
		if (findPath(path, x - 1, y))  return true;
		
		path.remove(path.size() - 1);
		return false;
	}
	
	
	static void drawMaze(ArrayList<int[]> path) throws InterruptedException
	{
		int lx = -1, ly = -1;
		for (int[] loc : path)
		{
			char symbol = '?';
			int x = loc[0];
			int y = loc[1];
			drawMaze();
			if      (x - lx > 0)  symbol = '>';
			else if (x - lx < 0)  symbol = '<';
			else if (y - ly > 0)  symbol = '\\';
			else if (y - ly < 0)  symbol = '/';
			maze.get(y).set(x, symbol);
			lx = x;
			ly = y;
			Thread.sleep(100);
		}
		drawMaze();
	}
	
	
	static void drawMaze()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		for (ArrayList<Character> row : maze)
		{
			for (char cell : row)
			{
				if (cell == '-')
					cell = ' ';
				if (cell == '#')
					cell = '█';
				System.out.print(cell);
				System.out.print(cell == '/' ? '\\' : cell == '\\' ? '/' : cell);
			}
			System.out.println();
		}
	}
	
}
