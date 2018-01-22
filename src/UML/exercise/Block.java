package UML.exercise;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Vector2F position = new Vector2F();
	private static final int BLOCK_SIZE = 32;
	private BlockType blocktype;
	private BufferedImage blockImage;
	private boolean solidBlock;
	public boolean isActive;
	public boolean isCoin = false;
	public boolean isTaken = false;
	public int currentImage = 0;
	
	public static int getBlockSize() {
		return BLOCK_SIZE;
	}
	
	public Block(Vector2F position, BlockType blocktype ) {
		setBounds((int)position.xPosition, (int)position.yPosition, BLOCK_SIZE, BLOCK_SIZE);
		this.position = position;
		this.blocktype = blocktype;
		init();
	}
	
	public Block solidBlock(boolean solidBlock){
		this.solidBlock = solidBlock;
		return this;
	}

	public Block coin(boolean isCoin){
		this.isCoin = isCoin;
		return this;
	}
	public void init(){
		isActive = true;
		switch(blocktype){
		case WALL_11:
			blockImage = Assets.getWall(0,0,1); break;
		case WALL_12:
			blockImage = Assets.getWall(0,1,1); break;
		case WALL_13:
			blockImage = Assets.getWall(0,2,1); break;
		case WALL_14:
			blockImage = Assets.getWall(0,3,1); break;
		case WALL_21:
			blockImage = Assets.getWall(1,0,1); break;
		case WALL_22:
			blockImage = Assets.getWall(1,1,1); break;
		case WALL_23:
			blockImage = Assets.getWall(1,2,1); break;
		case WALL_24:
			blockImage = Assets.getWall(1,3,1); break;
		case WALL_31:
			blockImage = Assets.getWall(2,0,1); break;
		case WALL_32:
			blockImage = Assets.getWall(2,1,1); break;
		case WALL_33:
			blockImage = Assets.getWall(2,2,1); break;
		case WALL_34:
			blockImage = Assets.getWall(2,3,1); break;
		case WALL_41:
			blockImage = Assets.getWall(3,0,1); break;
		case WALL_42:
			blockImage = Assets.getWall(3,1,1); break;
		case WALL_43:
			blockImage = Assets.getWall(3,2,1); break;
		case WALL_44:
			blockImage = Assets.getWall(3,3,1); break;

		case WALL2_11:
			blockImage = Assets.getWall(0,0,2); break;
		case WALL2_12:
			blockImage = Assets.getWall(0,1,2); break;
		case WALL2_13:
			blockImage = Assets.getWall(0,2,2); break;
		case WALL2_14:
			blockImage = Assets.getWall(0,3,2); break;
		case WALL2_21:
			blockImage = Assets.getWall(1,0,2); break;
		case WALL2_22:
			blockImage = Assets.getWall(1,1,2); break;
		case WALL2_23:
			blockImage = Assets.getWall(1,2,2); break;
		case WALL2_24:
			blockImage = Assets.getWall(1,3,2); break;
		case WALL2_31:
			blockImage = Assets.getWall(2,0,2); break;
		case WALL2_32:
			blockImage = Assets.getWall(2,1,2); break;
		case WALL2_33:
			blockImage = Assets.getWall(2,2,2); break;
		case WALL2_34:
			blockImage = Assets.getWall(2,3,2); break;
		case WALL2_41:
			blockImage = Assets.getWall(3,0,2); break;
		case WALL2_42:
			blockImage = Assets.getWall(3,1,2); break;
		case WALL2_43:
			blockImage = Assets.getWall(3,2,2); break;
		case WALL2_44:
			blockImage = Assets.getWall(3,3,2); break;

		case COIN:
			blockImage = Assets.getWall(0,0,3);
			currentImage = (int)(Math.random() * 240);
			break;
		}
	}
	
	public void tick(double deltaTime) {
		if (isActive && !isTaken){
			setBounds((int)position.xPosition, (int)position.yPosition, BLOCK_SIZE, BLOCK_SIZE);
			if (this.blocktype == BlockType.COIN){
				blockImage = Assets.getWall(0,currentImage,3);	
				currentImage++;
			}
			if(currentImage == 240)
				currentImage = 0;
		}
	}
	public void render(Graphics2D g) {
		if (isActive && !isTaken)
			g.drawImage(blockImage, (int) position.getWorldLocation().xPosition, 
					   (int) position.getWorldLocation().yPosition, 
					   BLOCK_SIZE, BLOCK_SIZE, null);
	}
	
	public enum BlockType {
		WALL_11,
		WALL_12,
		WALL_13,
		WALL_14,
		WALL_21,
		WALL_22,
		WALL_23,
		WALL_24,
		WALL_31,
		WALL_32,
		WALL_33,
		WALL_34,
		WALL_41,
		WALL_42,
		WALL_43,
		WALL_44,
		WALL2_11,
		WALL2_12,
		WALL2_13,
		WALL2_14,
		WALL2_21,
		WALL2_22,
		WALL2_23,
		WALL2_24,
		WALL2_31,
		WALL2_32,
		WALL2_33,
		WALL2_34,
		WALL2_41,
		WALL2_42,
		WALL2_43,
		WALL2_44, 
		COIN
	}

	public boolean isSolid() {
		return solidBlock;
	}
	public boolean isCoin() {
		return isCoin;
	}
	public boolean isActive(){
		return isActive;
	}
	public void setActive(boolean isActive){
		this.isActive = isActive;
	}
}