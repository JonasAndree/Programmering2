package lesson.granssnitt;

import java.awt.Graphics;

public class Rectangle implements GeometricShape {

	private int x, y, width, height;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

}