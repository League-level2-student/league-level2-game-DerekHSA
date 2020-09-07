import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LilJumper extends JPanel implements KeyListener{
Font title;
int gravity = 10;
Character c;
	public LilJumper() {
		title = new Font(Font.SANS_SERIF, Font.PLAIN, 48);
		c  =new Character(10,10,10,10);
	}
	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
