import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Key extends Entities {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public Key(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
public void draw(Graphics g) {
	g.drawImage(image, x, y, width, height, null);
}
}
