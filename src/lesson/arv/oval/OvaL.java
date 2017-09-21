package lesson.arv.oval;

import java.awt.Graphics;

import lesson.arv.GeometricShape;

public class OvaL extends GeometricShape {
	private int width;
	private int height;
	
	public OvaL(int ix, int iy, int width, int height) {
		super(ix, iy);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}


}
