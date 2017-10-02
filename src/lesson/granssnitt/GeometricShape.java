package lesson.granssnitt;

import java.awt.Graphics;

/**
 * En slags 'lättviktsklasser'—ungefär som abstrakta klasser. Definierar ett
 * gränssnitt (eller protokoll) Ett interface består av ett antal metodnamn med
 * argumenttyper och resultattyper. Ett interface innehåller inte några
 * datastrukturer eller någon programkod.
 * 
 * Vi säger att en klass implementerar ett interface. En klass kan bara ärva en
 * annan klass men implementera många interface. En 'vanlig' variabeldeklaration
 * beskriver hur det data som variabeln lagrar ser ut En variabel deklareras att
 * vara av ett visst interface: varje objekt som variabeln refererar måste
 * implementera gränssnittet.
 * 
 * 
 * @author jonas.andree
 *
 */
interface GeometricShape {
	public void draw(Graphics g);

	public void move(int dx, int dy);
}