package ntrfc.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public interface Entity {
	/*
	 * deklar�lja a getRec() f�ggv�nyt, hogy a list�ban t�rolt elemeken megh�vhassuk
	 */
	public abstract Rectangle getRec();
	
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
		
}
