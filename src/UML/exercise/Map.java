package UML.exercise;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import UML.exercise.Block.BlockType;


public class Map {

	public TileManeger tiles = new TileManeger();
	public static BufferedImage map = null;

	public void init(){
		System.out.println("Initializes Map");
		
		try {
			System.out.println("Load map...");
			map = LoadImages.LoadImage(Main.class, "Images/worldMapTest2.png");
		} catch (Exception e) {
			System.out.println("Error getting worlMapTest.png");
			System.exit(1);
		}
		
		tiles.init(map.getHeight(), map.getWidth());
		
		
		System.out.println("World map loaded!");
		for(int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				
				int color = map.getRGB(x, y);
				int colorUp, colorDown, colorRight, colorLeft;
				boolean up, down, right, left = false;
				
				
				/**
				 * Here is where we check what color is painted on the map. 
				 * We also decide what the meaning of that color is. 
				 */
				switch (color & 0xFFFFFF) {
				case 0x808080:
					if (y-1 >= 0) {
						colorUp = map.getRGB(x, y-1);
						if ((colorUp & 0xFFFFFF) == 0x808080) 
							up = true;
						else 
							up = false;
					} else
						up = false;
					
					if (y+1 < map.getHeight()) {
						colorDown = map.getRGB(x, y+1);
						if ((colorDown & 0xFFFFFF) == 0x808080)
							down = true;
						else
							down = false;	
					} else
						down = false;
					
					if (x+1 < map.getWidth()) {
						colorRight = map.getRGB(x+1, y);
						if ((colorRight & 0xFFFFFF) == 0x808080)
							right = true;
						else
							right = false;	
					} else
						right = false;

					if (x-1 >= 0) {
						colorLeft = map.getRGB(x-1, y);
						if ((colorLeft & 0xFFFFFF) == 0x808080)
							left = true;
						else
							left = false;	
					} else
						left = false;
					
					BlockType blockType = getBlockType("wall",up, down, left, right);
					
					(TileManeger.blocks[y][x] = 
							new Block(
									new Vector2F(x*Block.getBlockSize(),
											     y*Block.getBlockSize()),
												 blockType)).solidBlock(true);
					
					
					break;
				case 0xd93939:
					if (y-1 >= 0) {
						colorUp = map.getRGB(x, y-1);
						if ((colorUp & 0xFFFFFF) == 0xd93939) 
							up = true;
						else 
							up = false;
					} else
						up = false;
					
					if (y+1 < map.getHeight()) {
						colorDown = map.getRGB(x, y+1);
						if ((colorDown & 0xFFFFFF) == 0xd93939)
							down = true;
						else
							down = false;	
					} else
						down = false;
					
					if (x+1 < map.getWidth()) {
						colorRight = map.getRGB(x+1, y);
						if ((colorRight & 0xFFFFFF) == 0xd93939)
							right = true;
						else
							right = false;	
					} else
						right = false;

					if (x-1 >= 0) {
						colorLeft = map.getRGB(x-1, y);
						if ((colorLeft & 0xFFFFFF) == 0xd93939)
							left = true;
						else
							left = false;	
					} else
						left = false;
					
					BlockType blockType1 = getBlockType("wall2",up, down, left, right);
					
					(TileManeger.blocks[y][x] = 
							new Block(
									new Vector2F(x*Block.getBlockSize(),
											     y*Block.getBlockSize()),
												 blockType1)).solidBlock(true);
					
					
					break;
					case 0xec9626:
						BlockType blockType2 = BlockType.COIN;
						(TileManeger.blocks[y][x] = 
								new Block(
										new Vector2F(x*Block.getBlockSize(),
												     y*Block.getBlockSize()),
													 blockType2)).solidBlock(false).coin(true);
					
					break;
				}
			}
			
		}
	}
	private BlockType getBlockType(String type, boolean up, boolean down, boolean left, boolean right){
		BlockType selectBlock = null;
		if (up || down || left || right) {
			if (up) {
				if (down) {
					if (right) {
						if (left)
							if (type.equals("wall"))
								selectBlock = BlockType.WALL_33;
							else
								selectBlock = BlockType.WALL2_33;
						else
							if (type.equals("wall"))
								selectBlock = BlockType.WALL_32;
							else
								selectBlock = BlockType.WALL2_32;
					} else if (left)
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_34;
						else
							selectBlock = BlockType.WALL2_34;
					else
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_31;
						else
							selectBlock = BlockType.WALL2_31;
				} else if (right) {
					if (left)
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_43;
						else
							selectBlock = BlockType.WALL2_43;
					else
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_42;
						else
							selectBlock = BlockType.WALL2_42;
				} else if (left)
					if (type.equals("wall"))
						selectBlock = BlockType.WALL_44;
					else
						selectBlock = BlockType.WALL2_44;
				else
					if (type.equals("wall"))
						selectBlock = BlockType.WALL_41;
					else
						selectBlock = BlockType.WALL2_41;
			} else {
				if (down) {
					if (right) {
						if (left)
							if (type.equals("wall"))
								selectBlock = BlockType.WALL_23;
							else
								selectBlock = BlockType.WALL2_23;
						else
							if (type.equals("wall"))
								selectBlock = BlockType.WALL_22;
							else
								selectBlock = BlockType.WALL2_22;
					} else if (left)
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_24;
						else
							selectBlock = BlockType.WALL2_24;
					else
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_21;
						else
							selectBlock = BlockType.WALL2_21;
				} else if (right) {
					if (left)
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_13;
						else
							selectBlock = BlockType.WALL2_13;
					else
						if (type.equals("wall"))
							selectBlock = BlockType.WALL_12;
						else
							selectBlock = BlockType.WALL2_12;
				} else
					if (type.equals("wall"))
						selectBlock = BlockType.WALL_14;
					else
						selectBlock = BlockType.WALL2_14;
			}
		} else
			if (type.equals("wall"))
				selectBlock = BlockType.WALL_11;
			else
				selectBlock = BlockType.WALL2_11;
		
		return selectBlock;
	}
	public void tick(double deltaTime) {
		tiles.tick(deltaTime);
	}
	public void render(Graphics2D g) {
		tiles.render(g);
	}
}