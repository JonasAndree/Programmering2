package lesson.draw.image;

import java.awt.Color;
import java.awt.Graphics;

public class HB {
	private int hP;

	public HB(int hP) {
		this.hP = hP;
	}

	public void init(int hP) {
		this.hP = hP;
	}

	public int getHP() {
		return hP;
	}

	public void setHP(int hP) {
		this.hP = hP;
	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.drawRect(GamePanel.getScreenWidth() - 121, 9, 102, 32);
		g.setColor(Color.GREEN);
		g.fillRect(GamePanel.getScreenWidth() - 120, 10, hP, 30);
	}

}
