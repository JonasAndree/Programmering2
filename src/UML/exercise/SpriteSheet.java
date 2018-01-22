package UML.exercise;

import java.awt.image.BufferedImage;
/**
 * 
 * @author Jonas
 *
 */
public class SpriteSheet {
	private BufferedImage spriteSheet;
	/**
	 * 
	 * @param spriteSheet
	 */
	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	/**
	 * Gets an area from a buffered Image
	 * @param tileX
	 * @param tileY
	 * @param tileWidth
	 * @param tileHeight
	 * @return
	 */
	public BufferedImage getTile(int tileX, int tileY, int tileWidth, int tileHeight) {
		BufferedImage sprite = spriteSheet.getSubimage(tileX, tileY, tileWidth, tileHeight);
		return sprite;
	}
}
