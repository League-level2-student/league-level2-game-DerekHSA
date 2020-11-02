import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends Entities{

	public Projectiles(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	public void move() {
		
	}
public void draw(Graphics g) {
	g.setColor(Color.PINK);
	g.drawRect(x, y, width, height);
}
}
