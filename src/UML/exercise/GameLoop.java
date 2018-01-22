package UML.exercise;

public class GameLoop extends MainGameLoop {
	GameStateManager gsm;
	public static Assets assets = new Assets();
	
	private Camera camera = new Camera();
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("Initializes");
		assets.init();
		camera.init();
		
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}
	@Override
	public void tick(double deltaTime) {
		gsm.tick(deltaTime);
		camera.tick(deltaTime);
	}
	@Override
	public void render() {
		camera.render(graphics2D);
		super.render();
		gsm.render(graphics2D);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}
}
