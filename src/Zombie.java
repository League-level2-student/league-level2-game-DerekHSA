import java.awt.Color;
import java.awt.Graphics;

public class Zombie extends Entities{
	
public Zombie(int x, int y, int width, int height) {
	super(x,y,width,height);
	this.isActive=isActive;
	speed = 5;
}
public void draw(Graphics g){
	if(isActive==true) {
	g.setColor(Color.BLACK);
	g.fillRect(x, y, width, height);
	g.setColor(Color.RED);
	g.fillRect(x+5, y+5, width-10, height-10);
	}
}
public void aUpdate(Character c) {
	attack(c);
	if(x>=MainTab.WIDTH) {
		x-=speed+1;
	}else if(x<=0) {
		x+=speed+1;
	}if(y>=MainTab.HEIGHT) {
		y-=speed+1;
	}else if(y<=0) {
		y+=speed+1;
	}
}
public void attack(Character c) {
	
	if(x>=c.x) {
		
		x-=speed;
	}else if(x<=c.x) {
		x+=speed;
	}
	if(y>=c.y) {
		y-=speed;
	}else if(y<=c.y) {
		y+=speed;
	}
}
}
