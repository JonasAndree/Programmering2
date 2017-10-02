package lesson.eventlistener.mainloop.part4.loop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements KeyListener {
	// Data for our game character.
	private double x = 450;
	private double y = 800;
	private int width = 32;
	private int height = 32;

	private int startY = 800;
	private boolean jump = false;
	private boolean jump2 = false;
	private boolean jumpUp = false;
	private boolean jumpNoMore = false;
	private boolean jump2Posible = false;
	private boolean inAir = false;
	private double jumpSpeedMax = -28.0;
	private double addJumpSpeed = -3.0;
	private double gravity = 1.4;
	private double currentSpeedDown = 0;
	private double currentSpeedUp = 0;

	private double movementSpeed = 3;
	private double runSpeed = 7;
	private boolean moveRight = false;
	private boolean moveLeft = false;

	private double accelerateRight = 0;
	private double accelerateLeft = 0;
	private double glideLeft = 0;
	private double glideRight = 0;
	private double glideFriktion = 0.2;
	private double speedUp = 0.2 * 0.5;

	private boolean shift = false;

	BufferedImage img = null;

	public Player() {
		try {
			img = ImageIO.read(new File("src/lesson/eventlistener/mainloop/part4/loop/PlayerforJonas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Generally you do not want variables to be directly accessible from other
	 * classes. But if you want an other class to be able to change them you create
	 * getters and setters. like the two bellow.
	 */
	public void moveRight() {
		if (accelerateRight < movementSpeed) {
			accelerateRight += speedUp;
			x += accelerateRight;
		} else {
			x += movementSpeed;
		}
		accelerateLeft = 0;

	}

	public void moveRight(double movementSpeed) {
		if (accelerateRight < movementSpeed) {
			accelerateRight += speedUp;
			x += accelerateRight;
		} else {
			x += movementSpeed;
		}
		accelerateLeft = 0;
	}

	public void runRight() {
		if (accelerateRight < runSpeed) {
			accelerateRight += speedUp;
			x += accelerateRight;
		} else {
			x += runSpeed;
		}
		accelerateLeft = 0;
	}

	public void runRight(double runSpeed) {
		if (accelerateRight < runSpeed) {
			accelerateRight += speedUp;
			x += accelerateRight;
		} else {
			x += runSpeed;
		}
		accelerateLeft = 0;
	}

	/**
	 * 
	 */
	public void moveLeft() {
		if (accelerateLeft < movementSpeed) {
			accelerateLeft += speedUp;
			x -= accelerateLeft;
		} else {
			x -= movementSpeed;
		}
		accelerateRight = 0;
	}

	public void moveLeft(double movementSpeed) {
		if (accelerateLeft < movementSpeed) {
			accelerateLeft += speedUp;
			x -= accelerateLeft;
		} else {
			x -= movementSpeed;
		}
		accelerateRight = 0;
	}

	public void runLeft() {
		if (accelerateLeft < runSpeed) {
			accelerateLeft += speedUp;
			x -= accelerateLeft;
		} else {
			x -= runSpeed;
		}
		accelerateRight = 0;
	}

	public void runLeft(double runSpeed) {
		if (accelerateLeft < runSpeed) {
			accelerateLeft += speedUp;
			x -= accelerateLeft;
		} else {
			x -= runSpeed;
		}
		accelerateRight = 0;
	}

	/**
	 * The jump function starts a thread.
	 */
	public void jump() {
		if (!inAir) {
			System.out.println(inAir);
			inAir = true;
			currentSpeedDown = gravity;
			currentSpeedUp = addJumpSpeed;
			y += currentSpeedDown + currentSpeedUp;
		} else if (inAir) {
			if (y <= startY) {
				if (jump2 == true && !jumpNoMore) {
					jumpNoMore = true;
					currentSpeedDown = 0;
					currentSpeedUp = 0;
					jump2 = false;
				}
				if (moveRight) {
					if (shift) {
						if (currentSpeedUp >= jumpSpeedMax * (accelerateRight / runSpeed) && jumpUp) {
							currentSpeedUp += addJumpSpeed;
						}
					}
					else {
						if (currentSpeedUp >= jumpSpeedMax * (accelerateRight / movementSpeed) && jumpUp) {
							currentSpeedUp += addJumpSpeed;
						}
					}
				} else if (moveLeft) {
					if (currentSpeedUp >= jumpSpeedMax * (accelerateLeft / runSpeed) && jumpUp) {
						currentSpeedUp += addJumpSpeed;
					}
				} else {
					if (currentSpeedUp >= jumpSpeedMax * 0.8 && jumpUp) {
						currentSpeedUp += addJumpSpeed;
					}
				}
				currentSpeedDown += gravity;
				if (currentSpeedDown > 20 && currentSpeedDown < 60) {
					y += (currentSpeedDown + currentSpeedUp) * 0.5;
				} else {
					y += (currentSpeedDown + currentSpeedUp);
				}
			} else {
				inAir = false;
				y = startY;
				currentSpeedDown = 0;
				currentSpeedUp = 0;
				jump = false;
				jumpUp = false;
				jumpNoMore = false;
				jump2 = false;
				jump2Posible = false;
			}
		}
	}

	public void tick(double deltaTime) {
		if (shift && moveRight) {
			runRight();
			jumpSpeedMax = -38;
			glideRight = runSpeed;
		} else if (moveRight) {
			moveRight();
			jumpSpeedMax = -28;
			glideRight = movementSpeed;
		}
		if (shift && moveLeft) {
			runLeft();
			jumpSpeedMax = -38;
			glideLeft = runSpeed;
		} else if (moveLeft) {
			moveLeft();
			jumpSpeedMax = -28;
			glideLeft = movementSpeed;
		}

		if (!moveLeft && !moveRight) {
			accelerateRight = 0;
			accelerateLeft = 0;
			jumpSpeedMax = -28;
			if (glideLeft > 0) {
				glideLeft -= glideFriktion;
				moveLeft(glideLeft);
			}
			if (glideRight > 0) {
				glideRight -= glideFriktion;
				moveRight(glideRight);
			}
		}

		if (jump) {
			jump();
		}
		if (x > GamePanel.getScreenWidth() - width)
			x = GamePanel.getScreenWidth() - width;
		if (x < 0)
			x = 0;

	}

	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawImage(img, (int) x, (int) y, width, height, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump = true;
			jumpUp = true;
			if (jump2Posible)
				jump2 = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jumpUp = false;
			jump2Posible = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

		}
	}
}
