import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LilJumper extends JPanel implements ActionListener, KeyListener{
Room1 room1;
EntitieManager em;
public static final int CURRENTROOM = 1;
public static final int ROOM1 = 1;
public static final int ROOM2 = 2;
public static final int ROOM3 = 3;
Font title;
int gravity = 10;
int currentState = 1;
final int GAME = 1;
final int MENU = 0;
final int END = 2;
Timer frameDraw;
Character c;
	public LilJumper() {
		title = new Font(Font.SANS_SERIF, Font.PLAIN, 48);
		c  =new Character(300,500,50,50);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		room1 = new Room1(0,0,MainTab.WIDTH,20);
		em = new EntitieManager(c,room1);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		if (currentState==MENU) {
			drawMenuState(g);
		}else if (currentState==GAME) {
			drawGameState(g);
			
		}else if (currentState==END) {
			drawEndState(g);
		}
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,MainTab.WIDTH,MainTab.HEIGHT);
		c.draw(g);
		if (CURRENTROOM==ROOM1) {
		room1.draw(g);
		}
	}
	public void drawMenuState(Graphics g) {
		
	}
	public void drawEndState(Graphics g) {
		
	}
	public void updateGameState() { 
		em.update();
		c.update();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
				if (arg0.getSource()==frameDraw) {
					if(currentState == MENU){
					    
					}else if(currentState == GAME){
					    updateGameState();
					}else if(currentState == END){
					   
					}}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_D) {
			c.right=true;
		}else if (arg0.getKeyCode()==KeyEvent.VK_A){
			c.left=true;
		}else if (arg0.getKeyCode()==KeyEvent.VK_W){
			c.up=true;
		}else if (arg0.getKeyCode()==KeyEvent.VK_S){
			c.down=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_D) {
			c.right=false;
		}else if (arg0.getKeyCode()==KeyEvent.VK_A){
			c.left=false;
		}else if (arg0.getKeyCode()==KeyEvent.VK_W){
			c.up=false;
		}else if (arg0.getKeyCode()==KeyEvent.VK_S){
			c.down=false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

}
