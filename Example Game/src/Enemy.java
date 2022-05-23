import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Enemy extends GameObject {

	int velocity;
	
	Image baseImage;
	
	public Enemy(int x, int y, int w,int h, GamePanel p, int speed, boolean attacking) {
		super(x, y, w, h, p);
		projectiles=attacking;
		velocity=speed;
		baseImage = Toolkit.getDefaultToolkit().getImage("src/right.gif");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(baseImage, rectangle.x, rectangle.y, rectangle.width, rectangle.height, game);
		
		if (attacking) {
				baseImage = Toolkit.getDefaultToolkit().getImage("src/explosion.gif");
				}
	}


	@Override
	public void animate() {
		
	}
}