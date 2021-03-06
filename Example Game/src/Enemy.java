import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Enemy extends GameObject {

	int velocity;
	
	Image baseImage;
	
	public Enemy(int x, int y, int w,int h, GamePanel p, int speed) {
		super(x, y, w, h, p);
		velocity=speed;
		baseImage = Toolkit.getDefaultToolkit().getImage("src/right.gif");
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(baseImage, rectangle.x, rectangle.y, rectangle.width, rectangle.height, game);
	}

	@Override
	public void animate() {
		// movement x,y
		
	}
}