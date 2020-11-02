import java.awt.Graphics;
import java.util.ArrayList;

public class EntitieManager {
	int currentRoom;
	boolean key1 = false;
	boolean Key2 = false;
	boolean unlocked = false;
	boolean unlocked2 = false;
	boolean passed = false;
	int rightWallX = MainTab.WIDTH-35;
	int rightWallY = MainTab.HEIGHT/4;
	int upperWallX = MainTab.WIDTH/4+100;
	//int upperWallY = 0;
	int lowerWallX = MainTab.WIDTH/4+100;
	int lowerWallY = MainTab.HEIGHT-57;
	//int leftWallX = 0;
	int leftWallY = MainTab.HEIGHT/4;
	int offScreenX = MainTab.WIDTH+100;
	int offScreenY = MainTab.HEIGHT+100;
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
	wall1 = new Wall(upperWallX,0,500,20,false);
	if (unlocked==false) {
	wall2 = new Wall(rightWallX,rightWallY,20,500,true);
	}else if(unlocked==true) {
		wall2 = new Wall(rightWallX,rightWallY,20,500,false);	
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
	wall3 = new Wall(lowerWallX,lowerWallY,500,20,false);
	wall4 = new Wall(offScreenX,offScreenY,1,1,false);
	zombie1.refresh(500,500,50,50);
	zombie2.refresh(500,250,50,50);
	key2 = new Key(offScreenX,offScreenY,1,1);
	if(key1==false) {
	key = new Key(100,100,40,40);
	}else {
	key = new Key(offScreenX,offScreenY,1,1);
	}
	currentRoom=2;
	
}
public void room3() {
	wall1 = new Wall(offScreenX,offScreenY,1,1,false);
	if(unlocked2==false) {
	wall2 = new Wall(rightWallX,rightWallY,20,500,true);
	}else {
		wall2 = new Wall(rightWallX,rightWallY,20,500,false);
	}
	wall3 = new Wall(offScreenX,offScreenY,500,20,false);
	wall4 = new Wall(0,leftWallY,20,500,false);
	zombie1.refresh(offScreenX,offScreenY,1,1);
	zombie2.refresh(offScreenX,offScreenY,1,1);
	key2 = new Key(offScreenX,offScreenY,1,1);
	chest.x = 1200;
	chest.y = 100;
	chest.width = 100;
	chest.height = 100;
	currentRoom=3;
}
public void room4() {
	wall4 = new Wall(0,leftWallY,20,500,false);
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
			wall2 = new Wall(rightWallX,rightWallY,20,500,false);
			unlocked=true;
		}else if(wall2.locked==false) {
			c.x=25;
			room3();
		}
	}
	}else if(currentRoom==2) {
		if(c.collisionBox.intersects(wall3.collisionBox)) {
			
			c.y=30;
			room1();
			
			
		}else if(c.collisionBox.intersects(key.collisionBox)) {
			key1=true;
			key = new Key(offScreenX,offScreenY,1,1);
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
			room1();
			
		}else if(c.collisionBox.intersects(zombie2.collisionBox)) {
			
			c.x=300;
			c.y=500;
			key1=false;
			unlocked=false;
			zombie1.isActive=true;
		    zombie2.isActive=true;
			currentRoom=1;
			chest.opened=false;
			s.Obtained=false;
			room1();
			
		}else if(s.collisionBox.intersects(zombie1.collisionBox)) {
			zombie1.isActive=false;
		    zombie1.collisionBox.x=10000;
		zombie1.x=10000;
		}else if(s.collisionBox.intersects(zombie2.collisionBox)) {
			key2.width=40;
			key2.height=40;
			key2.x = zombie2.x;
			key2.y = zombie2.y;
			zombie2.collisionBox.x=10000;
		    zombie2.isActive=false;
			zombie2.x=10000;
			
			
			}else if(c.collisionBox.intersects(key2.collisionBox)) {
				Key2=true;
				key2 = new Key(offScreenX,offScreenY,1,1);
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
			s.Obtained=true;
			chest.opened=true;
		}else if(c.collisionBox.intersects(wall2.collisionBox)&& Key2==true) {
			if(wall2.locked==true) {
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
