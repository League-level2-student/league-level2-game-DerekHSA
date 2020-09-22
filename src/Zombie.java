import java.awt.Color;
import java.awt.Graphics;

public class Zombie extends Entities{
	
public Zombie(int x, int y, int width, int height) {
	super(x,y,width,height);
	
}
public void draw(Graphics g){
	g.setColor(Color.GREEN);
	g.fillRect(x, y, width, height);
}
}
