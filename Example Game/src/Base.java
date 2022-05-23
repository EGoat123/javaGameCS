import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Base extends GameObject {

	int baseHealth;
	Image baseImage;
	
	public Base(int x, int y, int w,int h, GamePanel p, int health) {
		super(x, y, w, h, p);
		baseHealth = health;
		
		public takeDamage ( int damage ) {
			health -= damage;
		}
			
		public getHealth() {
			return health;
		}
	}
		
		
	@Override
	public void draw(Graphics g) {
		g.drawImage(baseImage, rectangle.x, rectangle.y, rectangle.width, rectangle.height, game);
	}

	@Override
	public void animate() {
		
	}
}
