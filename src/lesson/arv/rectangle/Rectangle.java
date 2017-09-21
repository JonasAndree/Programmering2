package lesson.arv.rectangle;

import java.awt.Graphics;

import lesson.arv.GeometricShape;

public class Rectangle extends GeometricShape {
	private int width;
	private int height;
	
	public Rectangle(int ix, int iy, int width, int height) {
		super(ix, iy);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}


}
