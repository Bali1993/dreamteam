package ntrfc.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {
	/*
	 * deklar�lja a getRec() f�ggv�nyt, hogy a list�ban t�rolt elemeken megh�vhassuk
	 */
	public abstract Rectangle getRec();
	
	public void onCollisionWithBullet(int i);
	public void onCollision(int dx, int dy, int i);
	public void render(Graphics g);
		
}
