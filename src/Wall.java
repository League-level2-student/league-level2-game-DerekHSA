import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Wall extends Entities{
	boolean locked;
	public BufferedImage image;
public Wall(int x, int y, int width, int height, boolean locked) {
	super(x,y,width,height);
	
	this.locked=locked;
}
void loadImage(String imageFile) {
    
    try {
        image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
    
    } catch (Exception e) {
        
    }
   
}

public void draw(Graphics g) {
	
	g.drawImage(image, x, y, width, height, null);
	
}
}
