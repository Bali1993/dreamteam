package ntrfc.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {
	/*
	 * deklarálja a getRec() függvényt, hogy a listában tárolt elemeken meghívhassuk
	 */
	public abstract Rectangle getRec();
	
	public void onCollisionWithBullet(int i);
	public void onCollision(int dx, int dy, int i);
	public void render(Graphics g);
		
}
