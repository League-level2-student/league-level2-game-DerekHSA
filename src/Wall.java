import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Entities{
	boolean locked;
public Wall(int x, int y, int width, int height, boolean locked) {
	super(x,y,width,height);
	
	this.locked=locked;
}

public void draw(Graphics g) {
	if (locked==false) {
	g.setColor(Color.GREEN);
	}else if(locked==true) {
		g.setColor(Color.RED);
	}
	g.fillRect(x, y, width, height);
}
}
