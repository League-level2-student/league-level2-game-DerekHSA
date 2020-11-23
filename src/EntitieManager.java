import java.awt.Graphics;
import java.util.ArrayList;

public class EntitieManager {
	boolean remove = false;
	int xK;
	int yK;
	int currentRoom;
	boolean scissors=false;
	boolean key1 = false;
	boolean Key2 = false;
	boolean unlocked = false;
	boolean unlocked2 = false;
	boolean passed = false;
	int rightWallX = MainTab.WIDTH-35-25;
	int rightWallY = MainTab.HEIGHT/4+100;
	int upperWallX = MainTab.WIDTH/4+100;
	//int upperWallY = 0;
	int lowerWallX = MainTab.WIDTH/4+250;
	int lowerWallY = MainTab.HEIGHT-87;
	//int leftWallX = 0;
	int leftWallY = MainTab.HEIGHT/4+100;
	int offScreenX = MainTab.WIDTH+1000000;
	int offScreenY = MainTab.HEIGHT+1000000;
	 Wall wall1;
	 Wall wall2;
	 Wall wall3;
	 Wall wall4;
	 Zombie zombie1;
	 Zombie zombie2;
	 Chest chest;
	 int zom1X;
	 int zom2X;
	 int zom1Y;
	 int zom2Y;
	 Key key;
	 Key key2;
Character c;
Sword s;

Zombie a;
public EntitieManager(Character c, Sword s) {
	this.c=c;
this.s=s;
zombie1 = new Zombie(offScreenX, offScreenY, 1, 1);
zombie2 = new Zombie(offScreenX, offScreenY, 1, 1);
chest = new Chest(offScreenX,offScreenY,1,1);

}
public void room1() {
	wall1 = new Wall(upperWallX+150,-4,250,50,false);
	wall1.loadImage("DoorUF.png");
	if (unlocked==false) {
	wall2 = new Wall(rightWallX,rightWallY,50,250,true);
	wall2.loadImage("DoorRT.png");
	}else if(unlocked==true) {
		wall2 = new Wall(rightWallX,rightWallY,50,250,false);	
		wall2.loadImage("DoorRF.png");
	}
	
	zombie1.refresh(offScreenX,offScreenY,1,1);
	zombie2.refresh(offScreenX,offScreenY,1,1);
	wall3 = new Wall(offScreenX,offScreenY,1,1,false);
	wall4 = new Wall(offScreenX,offScreenY,1,1,false);
	key = new Key(offScreenX,offScreenY,1,1);
	key2 = new Key(offScreenX,offScreenY,1,1);
	currentRoom=1;
	
}
public void room2() {
	wall1 = new Wall(offScreenX,offScreenY,1,1,false);
	wall2 = new Wall(offScreenX,offScreenY,1,1,false);
	wall3 = new Wall(lowerWallX,lowerWallY,250,50,false);
	wall3.loadImage("DoorDF.png");
	wall4 = new Wall(offScreenX,offScreenY,1,1,false);
	zombie1.refresh(500,500,50,50);
	zombie2.refresh(500,250,50,50);
	if(zombie2.isActive==true) {
	key2 = new Key(offScreenX,offScreenY,1,1);
	}else {
		if(Key2==false) {
		key2 = new Key(xK,yK,18,40);
		}else {
			key2 = new Key(offScreenX,offScreenY,1,1);
		}
	}
	if(key1==false) {
	key = new Key(100,100,18,40);
	key.loadImage("Key.png");
	}else {
	key = new Key(offScreenX,offScreenY,1,1);
	}
	currentRoom=2;
	
}
public void room3() {
	wall1 = new Wall(offScreenX,offScreenY,1,1,false);
	if(unlocked2==false) {
	wall2 = new Wall(rightWallX,rightWallY,50,250,true);
	wall2.loadImage("DoorRT.png");
	}else {
		wall2 = new Wall(rightWallX,rightWallY,50,250,false);
		wall2.loadImage("DoorRF.png");
	}
	wall3 = new Wall(offScreenX,offScreenY,250,50,false);
	wall4 = new Wall(0,leftWallY,50,250,false);
	wall4.loadImage("DoorLF.png");
	zombie1.refresh(offScreenX,offScreenY,1,1);
	zombie2.refresh(offScreenX,offScreenY,1,1);
	key2 = new Key(offScreenX,offScreenY,1,1);
	chest.x = 1200;
	chest.y = 100;
	chest.width = 75;
	chest.height = 75;
	
	currentRoom=3;
}
public void room4() {
	wall4 = new Wall(0,leftWallY,50,250,false);
	wall2 = new Wall(offScreenX,offScreenY,1,1,false);
	zombie1.refresh(offScreenX,offScreenY,1,1);
	zombie2.refresh(offScreenX,offScreenY,1,1);
	chest.x=offScreenX;
	chest.y=offScreenY;
	chest.width=1;
	chest.height=1;
	currentRoom=4;
	c.isActive=false;
}
public void update(int currentRoom){
	this.currentRoom=currentRoom;
	wall1.update();
	wall2.update();
	wall3.update();
	wall4.update();
	zombie1.update();
	zombie2.update();
	zombie1.aUpdate(c);
	zombie2.aUpdate(c);
	key.update();
	key2.update();
	c.update();
	chest.update();
	
	
	checkCollision();
	
}
public void checkCollision() {
	if(currentRoom==1) {
	if(c.collisionBox.intersects(wall1.collisionBox)) {
		c.y=lowerWallY-55;
		room2();
		
	}else if(c.collisionBox.intersects(wall2.collisionBox)&& key1==true) {
		if(wall2.locked==true) {
			c.items--;
			wall2 = new Wall(rightWallX,rightWallY,20,500,false);
			unlocked=true;
			
		}else if(wall2.locked==false) {
			c.x=55;
			room3();
		}
	}
	}else if(currentRoom==2) {
		if(c.collisionBox.intersects(wall3.collisionBox)) {
			
			c.y=50;
			room1();
			
			
		}else if(c.collisionBox.intersects(key.collisionBox)) {
			key1=true;
			key = new Key(offScreenX,offScreenY,1,1);
			c.items++;
		}else if(c.collisionBox.intersects(zombie1.collisionBox)) {
			
			c.x=300;
			c.y=500;
		    zombie1.isActive=true;
		    zombie2.isActive=true;
			key1=false;
			unlocked=false;
			currentRoom=1;
			chest.opened=false;
			s.Obtained=false;
			c.items=0;
			remove = true;
			room1();
			remove = false;
			
		}else if(c.collisionBox.intersects(zombie2.collisionBox)) {
			
			c.x=300;
			c.y=500;
			key1=false;
			unlocked=false;
			zombie1.isActive=true;
		    zombie2.isActive=true;
			currentRoom=1;
			chest.opened=false;
			s.x=offScreenX;
			s.Obtained=false;
			c.items=0;
			remove = true;
			room1();
			remove = false;
			
		}else if(s.collisionBox.intersects(zombie1.collisionBox)) {
			zombie1.isActive=false;
		    zombie1.collisionBox.x=10000;
		zombie1.x=10000;
		}else if(s.collisionBox.intersects(zombie2.collisionBox)) {
			key2.width=18;
			key2.height=40;
			
			key2.loadImage("Key.png");
			xK=zombie2.x;
			yK=zombie2.y;
			key2.x = xK;
			key2.y = yK;
			zombie2.collisionBox.x=10000;
		    zombie2.isActive=false;
			zombie2.x=10000;
			
			
			}else if(c.collisionBox.intersects(key2.collisionBox)) {
				Key2=true;
				key2 = new Key(offScreenX,offScreenY,1,1);
				c.items++;
			}
	}else if(currentRoom==3) {
if(c.collisionBox.intersects(wall4.collisionBox)) {
			
			c.x=rightWallX-c.width;
			room1();
			chest.x=offScreenX;
			chest.y=offScreenY;
			chest.width=1;
			chest.height=1;
			
		}else if(c.collisionBox.intersects(chest.collisionBox)) {
			if(s.Obtained==false) {
				c.items++;
			}
			s.Obtained=true;
			chest.opened=true;
			
			
		}else if(c.collisionBox.intersects(wall2.collisionBox)&& Key2==true) {
			if(wall2.locked==true) {
				c.items--;
				wall2 = new Wall(rightWallX,rightWallY,20,500,false);
				unlocked2=true;
				
			}else if(wall2.locked==false) {
				c.x=25;
				room4();
			}
		}
		
	}else if(currentRoom==4) {
		
	}
	
	
	
	
	}

public void draw(Graphics g) {
	wall1.draw(g);
	wall2.draw(g);
	wall3.draw(g);
	wall4.draw(g);
	zombie1.draw(g);
	zombie2.draw(g);
	key.draw(g);
	key2.draw(g);
	chest.draw(g);
	
}
}
