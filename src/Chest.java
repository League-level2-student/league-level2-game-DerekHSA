import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Chest extends Entities {
	boolean opened = false;
	public static BufferedImage image;
	
	public Chest(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void loadImage(String imageFile) {
	    
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    
	        } catch (Exception e) {
	            
	        }
	       
	    }
	
public void draw(Graphics g) {
	if(opened==false) {
		loadImage("ChestF.png");
	}else {
		loadImage("ChestT.png");
	}
	g.drawImage(image, x, y, width, height, null);
	
}
}
