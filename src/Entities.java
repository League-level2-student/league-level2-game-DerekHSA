import java.awt.Graphics;
import java.awt.Rectangle;

public class Entities {
	Rectangle collisionBox;
	int x;
	 int y;
	 int width;
	 int height;
	 int speed = 10;
	 boolean isActive = true;
	 public Entities(int x, int y, int width, int height) {
		 collisionBox = new Rectangle();
		 this.x=x;
		 this.y=y;
		 this.width=width;
		 this.height=height;
		 speed = 10;
		 isActive = true;
		
		 
	 }
	 public void update() {
		 collisionBox.setBounds(x, y, width, height);
	 }
 public void draw(Graphics g) {
		 
	 }
}
