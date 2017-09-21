package lesson.arv;

import java.awt.Graphics;
import java.awt.Color;
/**
 * Exempel:
 * Anta att vi vill definiera klasser för olika geometriska figurer
 * 
 * (Circle, Square, Triangle)
 * 
 * Alla klasser ska definiera en metod draw().
 * 
 * För att kunna hantera alla likformigt i ett ritprogram definierar vi en abstrakt klass 
 * GeometricShape och låter alla ärva från denna.
 * 
 * 
 * Som en vanlig klass, men 
 * 		Du kan ej skapa instanser av klassen 
 *		Du kan ha abstrakta metoder subklasser till en abstrakt klass måste antingen
 * 		implementera de abstrakta metoderna, eller själva vara abstrakta
 * @author jonas.andree
 *
 */
abstract public class GeometricShape {
	protected int x;
	protected int y;
	protected Color color = new Color(255, 255, 255);
	
	public GeometricShape( int ix, int iy ) {
		x = ix;
		y = iy;
	}
	public void setColor(int r, int g, int b) {
		color = new Color(r, g, b);
	}
	
	abstract public void draw(Graphics g);

	public void move( int dx, int dy )  {
		
	}
}