
public class EntitieManager {
Character c;
Room1 r1;
Zombie a;
public EntitieManager(Character c, Room1 r1) {
	this.c=c;
	this.r1=r1;
}
public void update(){
	
	checkCollision();
}
public void checkCollision() {
if (c.collisionBox.intersects(r1.collisionBox)) {
	c.up=false;
	System.out.println("lol");
	
}
}
}
