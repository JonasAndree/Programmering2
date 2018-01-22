package UML.exercise;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImages {
	
	public static BufferedImage LoadImage(Class<?> classFile, String path) {
		System.out.println("Path: " + path);
		URL url = classFile.getResource(path);
		System.out.println("URL: " + url);
		BufferedImage img = null; 

		System.out.println("ImageIO.read: ...");
		try {
			System.out.println("ImageIO.read: read");
			img = ImageIO.read(url);
			
		} catch (IOException e1) {
			System.out.println("ImageIO.read: faild");
			e1.printStackTrace();
			System.exit(1);
		}
		
		return img;
	}
}