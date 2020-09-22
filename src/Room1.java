import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Room1 extends Entities{
Zombie a;
public Room1(int x,int y,int width,int height) {
	super(x,y,width,height);
	a = new Zombie(10, 10,10,10);
}
public void draw(Graphics g) {
	a.draw(g);
	g.setColor(Color.GRAY);
	g.fillRect(0, 0, MainTab.WIDTH, 20);
	g.setColor(Color.GRAY);
	g.fillRect(0, 20, 20, MainTab.HEIGHT);
	g.setColor(Color.GRAY);
	g.fillRect(MainTab.WIDTH-36, 20, 20, MainTab.HEIGHT);
	g.setColor(Color.GRAY);
	g.fillRect(0, MainTab.HEIGHT-59, MainTab.WIDTH, 20);
}

}
