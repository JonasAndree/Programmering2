package UML.exercise;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * NOT COMPLEATE
 * @author jonan_000
 *
 */
public class Assets {
	private static ArrayList<ArrayList<BufferedImage>> wall = new ArrayList<>();
	private static ArrayList<ArrayList<BufferedImage>> wall2 = new ArrayList<>();
	private static ArrayList<ArrayList<BufferedImage>> coin = new ArrayList<>();
	/**
	 * This calls will load our images.
	 * This will be called in the the beginning. 
	 * before everything else starts otherwise it will slow the main loop. 
	 */
	public void init(){
		System.out.println("Initializes Assets");
		populateImages("Images/TilesforJonas.png", wall, 4, 4);
		populateImages("Images/TilesforJonasRed.png", wall2, 4, 4);
		populateImages("Images/animated-coin.png", coin, 240, 0);
	}
	
	private void populateImages(String url, ArrayList<ArrayList<BufferedImage>> wall, int rowW, int colH){
		SpriteSheet blocks = new SpriteSheet();
		blocks.setSpriteSheet(LoadImages.LoadImage(Main.class, url));
		
		ArrayList<BufferedImage> row = new ArrayList<>();
		for (int y = 0; y <= colH * Block.getBlockSize(); y += Block.getBlockSize()){
			for (int x = 0; x <= rowW * Block.getBlockSize(); x += Block.getBlockSize())
				row.add(blocks.getTile(x,y,Block.getBlockSize(),Block.getBlockSize()));
			wall.add(row);
			row = new ArrayList<>();
		}
	}
	
	public static BufferedImage getWall(int y, int x, int i){
		if (i == 1) 
			return wall.get(y).get(x);
		if (i == 2) 
			return wall2.get(y).get(x);
		if (i == 3) 
			return coin.get(y).get(x);
		return null;
	}
}
