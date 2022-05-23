import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Here is the GamePanel class, this handles the world basically!
 * Note this game is really bad and would not earn many points.
 * It is just a start
 * @author robert.lancaster
 *
 */
public class GamePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;	// I added this to make it shut up about the warning this wasn't there.  It isn't important
	public ArrayList<GameObject> enemies;				// This is a list of enemies or other objects in the game.
	public ArrayList<GameObject> projectiles;			// This is a list of my projectiles in the game.

	public Base tower = new Base(50,50,200,200,this,5);
	boolean gameRunning;				// Whether the game is running or not.  Could be used to stop the thread or display an end game image.
	public GameThread thread;			// The thread that runs the game.
	
	// These keep track of which buttons are pressed right now.
	public boolean pressed;
	
	public Image background;		// This is the background image of the mountains
	private int lastTimeFired = 0;	// This is my way to keep track of the time of the last shot fired, to know if we can fire again.
	
	/**
	 * This constructs a Game Panel
	 */
	public GamePanel(){
		this.setFocusable(true);					// Very important so that we can get the focus on the panel and use arrrow keys.
		enemies = new ArrayList<GameObject>();		// Makes the enemy list	
		projectiles = new ArrayList<GameObject>();	// Makes the projectile list	
        addMouseListener(this);
		this.setBackground(Color.white);						// I set the background to black, but you might never see it anyway
		background=Toolkit.getDefaultToolkit().createImage("src/background2.jpg"); // This loads the image I will use for a background.
	}
	
	/**
	 * This paints the game.  You should never call this method, the program will do it automatically
	 */
	public void paint(Graphics g){
		super.paint(g);
		// The image has to get drawn 3 times for the side scrolling stuff.  And they all have to move when scrolling.
		//g.drawImage(background, 0, 0, 1400, 700, this);
		
		if(gameRunning){
			try{
			for(GameObject object:enemies){
				object.draw(g);
			}
			for(GameObject object:projectiles){
				object.draw(g);
			}
			}catch(Exception e){};
			tower.draw(g);
		}else{
			g.drawString("Click on new game to start the game.",200,200);
			g.drawString("Then use the arrow keys to move and spacebar to shoot.",200,230);
			
			// It would be good to draw an image instead of the things above if the game was over, one if you win, another if you lose
		}
	}
	
	/**
	 * This is how the game gets animated.  This is called by the Thread every "tick" or time
	 * @param time The current time in the game.
	 */
	public void animate(int time){
		if(pressed && time - lastTimeFired > 10){
			lastTimeFired = time;
			//mainCharacter.fire(); more like projectile.create(x,y,w,h)
		}
		for(GameObject object:enemies){
			object.animate();
		}
		for(GameObject object:projectiles){
			object.animate();
		}
		tower.animate();
		removeObjectsifColliding();
	}
	
	/**
	 * This is how I handle collisions between objects.  I determine if their rectangles overlap and then do something if they do.
	 */
	public void removeObjectsifColliding(){
		for(GameObject object:enemies){
			if(tower.rectangle.intersects(object.rectangle))
				System.out.println("OUCH an enemy hit me!");
			// Something else should probably happen here, like points taken away, hit points, moving back to start, or game over.
		}
		
		for(int projectile = 0; projectile<projectiles.size(); projectile++){
			for(int enemy = 0; enemy<enemies.size(); enemy++){
				GameObject p = projectiles.get(projectile);
				GameObject e = enemies.get(enemy);
				
				if(p.rectangle.intersects(e.rectangle)) {
					projectiles.remove(p); 
					enemies.remove(e);
					
					System.out.println("Enemy Eliminated!");
					return;
				}
			}
		}
	}
	
	/**
	 * This starts a game!
	 */
	public void newGame(){
		projectiles = new ArrayList<GameObject>();
		enemies = new ArrayList<GameObject>();
		loadLevel(0);
		gameRunning = true;
		thread = new GameThread(this);
		thread.start();
		
		this.requestFocus();	//It is important to request the focus (or click the panel) so the arrow keys work!
	}
	
	/**
	 * This method loads my levels.  Right now, there is just one level! It is Zero!
	 * @param level The level to load
	 */
	public void loadLevel(int level){
		switch(level){
		case 0:
			for(int i=0; i<1000; i++){
			//spawn enemy 
			}
		}
	}
	

	public void mousePressed(MouseEvent e) {
		pressed = true;
		System.out.println("p");
		int mouseX = e.getXOnScreen();
		int mouseY = e.getYOnScreen();
		//so we create proejctile here somehow
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
		System.out.println("r");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
