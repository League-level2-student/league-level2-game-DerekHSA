import java.awt.Color;
import java.awt.Graphics;

public class Key extends Entities {

	public Key(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
public void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}
}
