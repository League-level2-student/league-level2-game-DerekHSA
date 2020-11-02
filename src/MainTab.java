import javax.swing.JFrame;

public class MainTab {
LilJumper lj;
JFrame frame;

public static final int HEIGHT = 1000;
public static final int WIDTH = 1500;
public static void main(String[] args) {
	MainTab mt = new MainTab();
	mt.setup();
}
public MainTab() {
	frame = new JFrame();
	lj = new LilJumper();
}
public void setup() {
	frame.add(lj);
	frame.setSize(WIDTH,HEIGHT);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.addKeyListener(lj);
	frame.addMouseListener(lj);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
}
}
