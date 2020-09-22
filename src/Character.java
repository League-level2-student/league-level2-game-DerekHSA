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
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
	
}
public void update() {
	super.update();
	
	if (right==true) {
		
		right();
	}if (left==true) {
		left();
	}if (up==true) {
		up();
	}if (down==true) {
		down();
	}
}
public void up() {
	if (LilJumper.CURRENTROOM==LilJumper.ROOM1) {
	if (y>=20) {
		y-=speed;
	}
	}
	
}
public void right() {
	if (LilJumper.CURRENTROOM==LilJumper.ROOM1) {
	if (x<=1420) {
	x+=speed;
	}
	}
}
public void left() {
	if (LilJumper.CURRENTROOM==LilJumper.ROOM1) {
		if (x>=20) {
			x-=speed;
		}
	}
}
public void down() {
	if (LilJumper.CURRENTROOM==LilJumper.ROOM1) {	
		if(y<=881) {
	y+=speed;
		}
	}
}
}
