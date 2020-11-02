import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Skeleton extends Entities implements ActionListener {
	boolean impass = false;
	Timer fire;
Arrow arrow;
	public Skeleton(int x, int y, int width, int height, boolean isActive) {
		super(x, y, width, height);
		this.isActive=isActive;
		
		fire = new Timer(4000, this);
	}
	public void UPDate() {
		update();
		arrow.update();
	}
	public void attack(Character c) {
		shoot();
		arrow.flying(c);
	}
	public void shoot() {
		if(isActive==true) {
		arrow = new Arrow(x,y,10,10);
		if(impass==false) {
			fire.start();
			impass=true;
		}else {
			fire.restart();
		}
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(x+5, y+5, width-10, height-10);
		arrow.draw(g);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		shoot();
	}
}
