import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

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
		 if(isActive==true) {
		 collisionBox.setBounds(x, y, width, height);
		 }
	 }
 public void refresh(int x, int y, int width, int height) {
	 this.x=x;
	 this.y=y;
	 this.width=width;
	 this.height=height;
 }
}
