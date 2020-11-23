import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sword extends Items{
boolean Equipped;
public static BufferedImage image;


	public Sword(int x, int y, int width, int height, boolean Obtained) {
		super(x, y, width, height, Obtained);
		
	}
	void loadImage(String imageFile) {
	    
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    
        } catch (Exception e) {
            
        
       
    }
}
	public void draw(Graphics g) {
	if(Obtained == true) {
		
			g.drawImage(image, x, y, width, height, null);
		
	}
}
}
