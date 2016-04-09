package ntrfc;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Character;
import game.Replicator;

public interface Entity {
	
	//deklarálja a getRec() függvényt, hogy a listában tárolt elemeken meghívhassuk
	public Rectangle getRec();
	
	//elsõ paraméter
	//		azt adjuk meg, hogy Repliator, Character vagy Bullet - el történt az ütközés
	//CollisionIndexinListofElements (korábban "i" paraméter volt)
	//		a listában mely indexen történt az ütközés
	//		rájöttem erre a paraméterre nincs is szükség, mert az adott elem, amivel történik az ütközés
	//		tudja a saját indexét a listában, nem kell neki átadni
	//		csak simán lekérdezi indexOf(this) beépített függvénnyel
	//dx, dy
	//		az azt adja, meg hogy mely irányból történt az ütközés
	//		0, -32, +32 lehet az értéke
	//		leginább arra használjuk, hogy az adott elem lepattintsa magáról a Replicatort vagy Charactert
	//		ezért nincs rá szükség a Bullet-nél
	public void onCollisionWithReplicator(Replicator replicator, int dx, int dy);
	public void onCollisionWithBullet(game.Bullet bullet);
	public void onCollisionWithCharacter(Character character, int dx, int dy);
	public void render(Graphics g);
		
}
