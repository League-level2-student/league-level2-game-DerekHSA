import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Sword extends Items{
boolean Equipped;
//Rectangle bottom;
//int bX;
//int bY;
//int bW;
//int bH;
	public Sword(int x, int y, int width, int height, boolean Obtained) {
		super(x, y, width, height, Obtained);
	
	}
	//public void bottomInts(int swordDirect) {
		//if(swordDirect==1) {
			//bW=30;
			//bH=20;
			//bX=x-10;
			//bY=y+30;
		//}else if(swordDirect==2) {
			//bW=20;
			//bH=30;
			//bX=x+30;
			//bY=y-10;
		//}else if(sword)
	//}
	public void draw(Graphics g) {
	if(Obtained == true) {
		
	g.setColor(Color.GRAY);
	g.fillRect(x, y, width, height);
	g.setColor(Color.DARK_GRAY);
	g.drawRect(x, y, width, height);
	//bottom.setBounds(bX,bY,bW,bH);
	}
}
}
