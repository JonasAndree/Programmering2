package UML.exercise;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player implements KeyListener{

	private Vector2F playerPosition = new Vector2F();
	
	private int width = 30;
	private int height = 30;
	
	// Used to see if 
	private static boolean up, down, left, right, space;
	
	// Speed of the character
	private float fixedDeltaTime = 1f/60f;
	private float topSpeed = 32*9F;
	
	private float gainSpeed = 3.5F;
	private float decreesSpeed = 3.1F;

	// used to add acceleration
	private float speedUp = 0, speedDown = 0, speedLeft = 0, speedRight = 0;
	
	// jump
	private boolean inAir = false;
	private float maxJumpSpeed = 32*9F;
	private float gravity = 8F;
	
	// GameType
	private boolean freeMode = false;
    
	private int coins = 0;
	/**
	 * 
	 */
	public void init(){
		System.out.println("Initializes Player");
		playerPosition.xPosition = MainGameLoop.width/2;
		playerPosition.yPosition = MainGameLoop.height/2;
	}
	/**
	 * 
	 * @param deltaTime
	 */
	public void tick(double deltaTime){
		float moveAmountLeft = speedLeft * fixedDeltaTime;
		float moveAmountRight = speedRight * fixedDeltaTime;
		float moveAmountUp = speedUp * fixedDeltaTime;
		float moveAmountDown = speedDown * fixedDeltaTime;
		
		if(right)
			moveRight(moveAmountRight);
		else
			glideRight(moveAmountRight);
		if(left)
			moveLeft(moveAmountLeft);
		else
			glideLeft(moveAmountLeft);
		if(up)
			moveUp(moveAmountUp);
		else
			glideUp(moveAmountUp);
		if(down)
			moveDown(moveAmountDown);
		else
			glideDown(moveAmountDown);
		if(space)
			jump(moveAmountUp);
		
		gravity(moveAmountDown);
		if ((int)Camera.map.yPosition > 4000)
			System.exit(0);
	}
	
	private void coinTaken(Block detectedBlock){
		coins += 1;
		detectedBlock.isTaken = true;
		AudioPlayer player = new AudioPlayer();
		player.play("Sounds/coin.wav");
	}

	/**
	 * 
	 */
	private void gravity(float moveAmountDown){
		Block detectedBlock = Detect.playerCollision("down", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountDown);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			speedDown += gravity;
		}
	}
	
	/**
	 * 
	 * @param moveAmountUp
	 * @param moveMap
	 */
	private void jump(float moveAmountUp){
		if(!inAir) {
			inAir = true;
			speedUp += maxJumpSpeed;

			Block detectedBlock = Detect.playerCollision("up", 
					 playerPosition.xPosition + Camera.map.xPosition,
					 playerPosition.yPosition + Camera.map.yPosition,
					 width, height, moveAmountUp);
			if (detectedBlock == null || detectedBlock.isCoin()){
				if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
					coinTaken(detectedBlock);
				}
				Camera.map.yPosition -= moveAmountUp;
			}
		} else {
			if(speedUp > 0){
				Block detectedBlock = Detect.playerCollision("up", 
						 playerPosition.xPosition + Camera.map.xPosition,
						 playerPosition.yPosition + Camera.map.yPosition,
						 width, height, moveAmountUp);
				if (detectedBlock == null || detectedBlock.isCoin()){
					if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
						coinTaken(detectedBlock);
					}
					Camera.map.yPosition -= moveAmountUp;
				}
			} else {
				speedUp = 0;
				inAir = false;
				space = false;
			}
		}
	}
	private void moveUp(float moveAmountUp){
		Block detectedBlock = Detect.playerCollision("up", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountUp);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedUp <= topSpeed)
				speedUp += gainSpeed;
			else 
				speedUp = topSpeed;
			
			Camera.map.yPosition -= moveAmountUp;
		} else
			speedUp = 0;
	}
	/**
	 * 
	 * @param moveAmountUp
	 * @param moveMa
	 */
	private void glideUp(float moveAmountUp){
		Block detectedBlock = Detect.playerCollision("up", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountUp);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedUp > 0)
				speedUp -= decreesSpeed;
			else
				speedUp = 0;
			Camera.map.yPosition -= moveAmountUp;
		} else
			speedUp = 0;
		
	}
	/**
	 * 
	 * @param moveAmountDown
	 */
	private void moveDown(float moveAmountDown){
		Block detectedBlock = Detect.playerCollision("down", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountDown);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedDown <= topSpeed)
				speedDown += gainSpeed;
			else 
				speedDown = topSpeed;
			
			Camera.map.yPosition += moveAmountDown;
		} else
			speedDown = 0;
	}
	/**
	 * 
	 * @param moveAmountDown
	 * @param moveMap
	 */
	private void glideDown(float moveAmountDown){
		Block detectedBlock = Detect.playerCollision("down", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountDown);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedDown > 0)
				speedDown -= decreesSpeed;
			else
				speedDown = 0;
			Camera.map.yPosition += moveAmountDown;
		} else
			speedDown = 0;
	}
	/**
	 * 
	 * @param moveAmountRight
	 * @param moveMap
	 */
	private void moveRight(float moveAmountRight){
		Block detectedBlock = Detect.playerCollision("right", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountRight);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedRight <= topSpeed)
				speedRight += gainSpeed;
			else 
				speedRight = topSpeed;
			Camera.map.xPosition += moveAmountRight;
		} else 
			speedRight = 0;
		
	}
	/**
	 * 
	 * @param moveAmountRight
	 * @param moveMap
	 */
	private void glideRight(float moveAmountRight){
		Block detectedBlock = Detect.playerCollision("right", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountRight);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedRight > 0)
				speedRight -= decreesSpeed;
			else
				speedRight = 0;
			
			Camera.map.xPosition += moveAmountRight;
		} else 
			speedRight = 0;
		
	}
	/**
	 * 
	 * @param moveAmountLeft
	 * @param moveMap
	 */
	private void moveLeft(float moveAmountLeft){
		Block detectedBlock = Detect.playerCollision("left", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountLeft);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
			if (speedLeft <= topSpeed)
				speedLeft += gainSpeed;
			else 
				speedLeft = topSpeed;
			
			Camera.map.xPosition -= moveAmountLeft;
		} else 
			speedLeft = 0;

	}
	/**
	 * 
	 * @param moveAmountLeft
	 * @param moveMap
	 */
	private void glideLeft(float moveAmountLeft){
		Block detectedBlock = Detect.playerCollision("left", 
				 playerPosition.xPosition + Camera.map.xPosition,
				 playerPosition.yPosition + Camera.map.yPosition,
				 width, height, moveAmountLeft);
		if (detectedBlock == null || detectedBlock.isCoin()){
			if (detectedBlock != null && detectedBlock.isCoin() && !detectedBlock.isTaken){
				coinTaken(detectedBlock);
			}
				
			if (speedLeft > 0)
				speedLeft -= decreesSpeed;
			else
				speedLeft = 0;
			
			Camera.map.xPosition -= moveAmountLeft;
		} else 
			speedLeft = 0;
		
	}
	public Vector2F getPlayerPosition() {
		return playerPosition;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillRect((int)playerPosition.xPosition, (int)playerPosition.yPosition, width, height);
		if ((int)Camera.map.yPosition > 3000) {
			g.setColor(Color.RED);
			g.drawString("GG", (int)playerPosition.xPosition-30, (int)playerPosition.yPosition - height/2);
		}

		g.drawImage(Assets.getWall(0,0,3), 10, 10, 32, 32, null);
		g.drawString(""+coins, 44, 30);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_D)
			right = true;
		if (keyCode == KeyEvent.VK_A)
			left = true;
		if (keyCode == KeyEvent.VK_W)
			if (freeMode)
				up = true;
		if (keyCode == KeyEvent.VK_S)
			if (freeMode)
				down = true;
		if (keyCode == KeyEvent.VK_SPACE)
			if (!freeMode)
				space = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_D)
			right = false;
		if (keyCode == KeyEvent.VK_A)
			left = false;
		if (keyCode == KeyEvent.VK_W)
			if (freeMode)
				up = false;
		if (keyCode == KeyEvent.VK_S)
			if (freeMode)
				down = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {}
}
