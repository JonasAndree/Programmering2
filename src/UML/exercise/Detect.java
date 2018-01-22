package UML.exercise;

import java.awt.Point;

public class Detect {
	
	public static Block playerCollision(String direction, float x, float y, int width, int height, float speed){
		if (direction.equals("down")){
			for (float f = 0; f < speed; f += speed/6){
				Block detBlock = Detect.playerCollision(
						new Point((int) (x),
								  (int) (y + height + speed)), 
						new Point((int) (x + width),
								  (int) (y + height + speed)));
				if (detBlock != null)
					return detBlock;
				}
		} else if (direction.equals("up")){
			for (float f = 0; f < speed; f += speed/6){
				Block detBlock = Detect.playerCollision(
						new Point((int) (x),
								  (int) (y - speed)), 
						new Point((int) (x + width),
								  (int) (y - speed)));
			if (detBlock != null)
				return detBlock;
			}
		} else if (direction.equals("right")){
			for (float f = 0; f < speed; f += speed/6){
				Block detBlock = Detect.playerCollision(
						new Point((int) (x + width + speed),
								  (int) (y)), 
						new Point((int) (x + width + speed),
								  (int) (y + height)));
				if (detBlock != null)
					return detBlock;
			}
		} else if (direction.equals("left")){
			for (float f = 0; f < speed; f += speed/6){
				Block detBlock = Detect.playerCollision(
									new Point((int) (x - speed),
											  (int) (y)), 
									new Point((int) (x - speed),
											  (int) (y + height)));
				if (detBlock != null)
					return detBlock;
			}
		}
		
		return null;	
	}
	public static Block playerCollision(Point p1, Point p2){
		if (isMapPositionFree((int)(p1.x/32), (int)(p1.y/32)) != null)
			return isMapPositionFree((int)(p1.x/32), (int)(p1.y/32));
		if (isMapPositionFree((int)(p2.x/32), (int)(p2.y/32)) != null)
			return isMapPositionFree((int)(p2.x/32), (int)(p2.y/32));
		return null;
	}
	public static Block isMapPositionFree(int x, int y) {
		if (x >= 0 && y >= 0 && x < Map.map.getWidth() && y < Map.map.getHeight())
			if (TileManeger.blocks[y][x] != null){
				if (TileManeger.blocks[y][x].isSolid() && !TileManeger.blocks[y][x].isTaken)
					return TileManeger.blocks[y][x];
				if (TileManeger.blocks[y][x].isCoin() && !TileManeger.blocks[y][x].isTaken)
					return TileManeger.blocks[y][x];
			}
		return null;
	}
}