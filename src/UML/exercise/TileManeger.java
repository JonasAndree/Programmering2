package UML.exercise;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileManeger {
	public static Block[][] blocks;
		
	public void init(int width, int height) {
		blocks = new Block[height][width];
	}
	public void tick (double deltaTime) {
		for (Block[] row : blocks)
			for (Block cell : row)
				if (cell != null){
					cell.tick(deltaTime);
					
					if (Camera.render.intersects(cell))
						cell.setActive(true);
					else
						cell.setActive(false);
				}
					
	}
	public void render(Graphics2D g) {
		for (Block[] row : blocks)
			for (Block cell : row)
				if (cell != null)
					cell.render(g);
	}
}
