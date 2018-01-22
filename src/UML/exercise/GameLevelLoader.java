package UML.exercise;

import java.awt.Graphics2D;
/**
 * Here is where we will generate TileMaps, 
 * add player 
 * and almost everything. This is where we will 
 * start generating our game.
 * @author Jonas
 *
 */
public class GameLevelLoader extends GameState {
	Map map = new Map();
	Player player = new Player();
	Aim aim = new Aim();
	/**
	 * 
	 * @param gsm
	 */
	public GameLevelLoader(GameStateManager gsm) {
		super(gsm);
	}
	/**
	 * 
	 */
	@Override
	public void init() {
		player.init();
		map.init();
		aim.init();
	}
	/**
	 * 
	 */
	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
		player.tick(deltaTime);
		aim.tick(deltaTime);
	}
	/**
	 * 
	 */
	@Override
	public void render(Graphics2D g) {
		map.render(g);
		player.render(g);
		aim.render(g);
	}
}
