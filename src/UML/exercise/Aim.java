package UML.exercise;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Aim implements MouseListener {
	private static Point aim = null;
	private static boolean aiming = false;
	private static int aimingTime = 0;
	public void init(){
		
	}
	public void tick(double deltaTime){
		if (aimingTime > 0){
			aimingTime--;
		} else {
			aim = null;
			aiming = false;
			aimingTime = 0;
		}
	}
	public void render(Graphics2D g){
		g.setColor(Color.RED);
		if (aiming)
			g.fillRect((int)aim.getX(), (int)aim.getY(), 10, 10);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3){
			aim = e.getPoint();
			aiming = true;
			aimingTime = 400;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
