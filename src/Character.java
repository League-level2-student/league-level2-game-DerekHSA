import java.awt.Color;
import java.awt.Graphics;

public class Character extends Entities {
boolean right = false;
boolean left = false;
boolean down = false;
boolean up = false;


public Character(int x, int y, int height, int width) {
	super(x,y,height,width);
	speed = 10;
}
int fo=0;
public void draw(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(x, y, width, height);
	g.setColor(Color.BLUE);
	g.fillRect(x+5, y+5, width-10, height-10);
	
}
public void update() {
	super.update();
	
	
	if (right==true&&x<=MainTab.WIDTH-width-21) {
		
		right();
	}if (left==true&&x>=7) {
		left();
	}if (up==true&&y>=7) {
		up();
	}if (down==true&&y<=MainTab.HEIGHT-92) {
		down();
	}}

public void up() {
	
y-=speed;
	}

public void right() {
	
x+=speed;
	
}
public void left() {
	
x-=speed;
	
}
public void down() {
	
y+=speed;	
	
}
}
