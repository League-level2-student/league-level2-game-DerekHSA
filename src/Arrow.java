import java.awt.Color;
import java.awt.Graphics;

public class Arrow extends Entities {
	Color brown = new Color(100,100,100);
	boolean impass = false;
	int targetX;
	int targetY;
public Arrow(int x, int y, int width, int height) {
	super(x,y,width,height);
	speed = 20;
}
public void flying(Character c) {
	if(impass==false) {
		targetX=c.x;
		targetY=c.y;
		impass=true;
	}else {
		if(x>=targetX) {
			x-=speed;
		}if(y>=targetY) {
			y-=speed;
		}
	}
}
public void draw(Graphics g) {
	g.setColor(brown);
	g.drawRect(x,y,width,height);
	
}
}
