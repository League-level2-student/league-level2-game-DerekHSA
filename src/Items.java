import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Items {
 boolean Obtained;
 Rectangle collisionBox;
 int x;
 int y;
 int width;
 int height;
 ArrayList<Projectiles> pro;
public Items(int x, int y, int width, int height, boolean Obtained) {
collisionBox = new Rectangle();
	pro = new ArrayList<Projectiles>();
	this.x=x;
	 this.y=y;
	 this.width=width;
	 this.height=height;
	this.Obtained=Obtained;
}
public void shoot() {
	pro.add(new Projectiles(x,y,10,10));
}
public void draw(Graphics g) {
	g.setColor(Color.BLACK);
	g.drawRect(x, y, width, height);
	for (int i = 0; i < pro.size(); i++) {
		
	}
	
}
public void update(int tX, int tY) {
	if(Obtained==true) {
	move(tX,tY);
	collisionBox.setBounds(x, y, width, height);
	}
}
public void move(int tX, int tY) {
	x=tX;
	y=tY;
}
}
