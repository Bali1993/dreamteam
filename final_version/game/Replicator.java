package game;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import ntrfc.Entity;

/*
 * Replikátor osztálya
 * random mozog a pályán, ha meglőjük megsemmisül
 * teleportál, használja a mérleget
 */
public class Replicator {
	
	//Replikátor koordinátái
	private int x;
	private int y;
	StarGateGame sgg;
	
	//Él-e a replikátor, ha él true
	private boolean isAlive;

	private Image image_replicator;
	
	/*
	 * replikátor konstruktora
	 * isalive->true
	 * koordinátái beállítása
	 */
	public Replicator(StarGateGame sgg, int x, int y) {
		this.x = x;
		this.y = y;
		this.sgg = sgg;
		isAlive = true;
		
		//Kép eltárolása
		image_replicator = sgg.getMap().get_image_replicator();
	}
	
	/*
	 * Replikátor ütköztetése elemekkel
	 * visszatér az elem indexével a listában ha ütközött
	 * 0-val ha semmivel nem ütközött
	 */
	public int Coll_Replicator(Replicator r, LinkedList<Entity> ll) {
		Rectangle RecOfReplicator = r.getRec();
		for (int i = 0; i < ll.size(); ++i) {
			Rectangle RecOfElement = ll.get(i).getRec();
			if (RecOfReplicator.intersects(RecOfElement)) {
				return i;
			}
		}
		return 0;
	}
	
	/*
	 * Replikátor random mozgása a pályán
	 * és ütközés vizsgálata
	 */
	public void move() {
		Random rand = new Random();
		
		//random szám generálása 1 és 4 között, 
		//ami alapján +x,-x,+y,-y irányba léptetjük		
		int n = rand.nextInt(4) + 1;
		int dx = 0;
		int dy = 0;

		switch (n) {
		case 1:
			x += 32;
			dx = 32;
			break;
		case 2:
			x -= 32;
			dx = -32;
			break;
		case 3:
			y += 32;
			dy = 32;
			break;
		case 4:
			y -= 32;
			dy = -32;
			break;
		default:
			System.out.println("REPLICATOR MOVE ERROR");
			break;

		}

		LinkedList<Entity> ListofElements = sgg.getList();

		int CollisionIndexinListofElements = Coll_Replicator(this, ListofElements);

		if (CollisionIndexinListofElements != 0) {
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithReplicator(this, sgg.getColonel(),
					sgg.getJaffa(), dx, dy);
		}
	}

	// megsemmisiti önmagát, ha szakadékba lép
	// Pit osztály hívja, ha onColl-ja aktiválódik azaz ütközés történik
	public void destroy() {
		this.x = -1;
		this.y = -1;
		this.isAlive = false;
	}
	//Replikátor attributumainak getterei, setterei
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * rectangle készítése a replikátor koordinátáival
	 */
	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	public boolean getisAlive() {
		return isAlive;
	}
	
	//Replikátor képének kirajzolása.
	public void render(Graphics g) {
		if (isAlive) {
			g.drawImage(image_replicator, this.x + 1, this.y + 1, 31, 31, null);
		}
	}
}
