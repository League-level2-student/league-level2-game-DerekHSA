import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LilJumper extends JPanel implements ActionListener, KeyListener, MouseListener{

EntitieManager em;

public static final int ROOM1 = 1;
public static final int ROOM2 = 2;
public static final int ROOM3 = 3;
public static final int ROOM4 = 4;
JFrame Inven;
JPanel panel;
JLabel label;
Sword s;
int sX;
int sY;
int swordDirect = 1;

Font title;
Font instructions;
int gravity = 10;
public int currentRoom = 1;
int currentState = 0;
final int GAME = 1;
final int MENU = 0;
final int END = 2;
Timer frameDraw;
Character c;
Dimension d;
	public LilJumper() {
		title = new Font(Font.MONOSPACED, Font.BOLD, 100);
		instructions = new Font(Font.MONOSPACED, Font.ITALIC , 25);
		c  =new Character(300,500,50,50);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		Inven = new JFrame();
		Inven.setVisible(false);
		panel = new JPanel();
		d = new Dimension(500,500);
		Inven.setSize(d);
		Inven.add(panel);
		s = new Sword(c.x,c.y,10,50, false);
		em = new EntitieManager(c,s);
		
		sY=c.y-50;
		sX=c.x;
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
		if(currentRoom==1) {
		g.setColor(Color.BLACK);
		}else if(currentRoom==2) {
			g.setColor(Color.LIGHT_GRAY);
		}else if(currentRoom==4) {
			g.setColor(Color.CYAN);
			g.setColor(Color.LIGHT_GRAY);
		}
		g.fillRect(0,0,MainTab.WIDTH,MainTab.HEIGHT);
		s.draw(g);
		c.draw(g);
		
		em.draw(g);
		
		//s.bottomInts(swordDirect);
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, MainTab.WIDTH, MainTab.HEIGHT);
		g.setFont(title);
		g.setColor(Color.RED);
		g.drawString("Room Wreckers", 375, 300);
		g.setFont(instructions);
		g.drawString("Press Space for controls", 550, 500);
		g.drawString("Press enter to start", 575, 600);
		
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MainTab.WIDTH, MainTab.HEIGHT);
		g.setFont(title);
		g.setColor(Color.GREEN);
		g.drawString("You Win!", 500, 300);
		g.setFont(instructions);
		g.drawString("There will be more soon!", 550, 500);
	}
	
	public void updateGameState() { 
		em.update(currentRoom);
		if(currentRoom!=em.currentRoom) {
			currentRoom=em.currentRoom;
		}
		if(swordDirect==1) {
			sX = c.x+2;
			sY = c.y-50;
			s.width = 10;
			s.height = 50;
		}else if(swordDirect==2) {
			sX=c.x-50;
			sY=c.y+38;
			s.width = 50;
			s.height = 10;
		}else if(swordDirect==3) {
			sX=c.x+50;
			sY=c.y+2;
			s.width = 50;
			s.height = 10;
		}else if(swordDirect==4) {
			sX=c.x+38;
			sY=c.y+50;
			s.width = 10;
			s.height = 50;
		}
		s.update(sX, sY);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
				if (arg0.getSource()==frameDraw) {
					if(currentState == MENU){
					    
					}else if(currentState == GAME){
					    updateGameState();
					    if(c.isActive==false) {
					    	currentState=END;
					    }
					}else if(currentState == END){
					  
					}}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState==1) {
		if (arg0.getKeyCode()==KeyEvent.VK_D) {
			c.right=true;
			swordDirect=3;
			
		}else if (arg0.getKeyCode()==KeyEvent.VK_A){
			c.left=true;
			swordDirect=2;
		}else if (arg0.getKeyCode()==KeyEvent.VK_W){
			c.up=true;
			swordDirect=1;
		}else if (arg0.getKeyCode()==KeyEvent.VK_S){
			c.down=true;
			swordDirect=4;
		}else if(arg0.getKeyCode()==KeyEvent.VK_E) {
			Inven.setVisible(true);
		}
		}else if(currentState==0) {
			if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
				JOptionPane.showMessageDialog(null, "WASD for movement\nSpace key to attack\nE to open inventory");
			}else if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
				currentState=1;
				em.room1();
			}
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


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getY()<=c.y&&arg0.getX()>c.x&&arg0.getY()<c.x+50) {
			
			
		}if(arg0.getY()>=c.y+50&&arg0.getX()>c.x&&arg0.getY()<c.x+50) {
			
			
		}if(arg0.getX()>=c.x+50&&arg0.getY()<c.y+50&&arg0.getY()>c.y) {
			
		}if(arg0.getX()<=c.x&&arg0.getY()<c.y+50&&arg0.getY()>c.y) {
			
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

}
