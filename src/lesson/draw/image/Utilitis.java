package lesson.draw.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utilitis {
	public static BufferedImage loadImages(String url) {
		BufferedImage temp = null;
		try {
			temp = ImageIO.read(new File(url));
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
