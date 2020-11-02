import java.awt.Color;
import java.awt.Graphics;

public class Chest extends Entities {
	boolean opened = false;

	public Chest(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
public void draw(Graphics g) {
	if(opened == false) {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
	}else {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	g.setColor(Color.BLACK);
	g.fillRect(x+10, y+10, width-20, height-20);
}
}
