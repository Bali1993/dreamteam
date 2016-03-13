package ntrfc.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public interface Entity {
	/*
	 * deklarálja a getRec() függvényt, hogy a listában tárolt elemeken meghívhassuk
	 */
	public abstract Rectangle getRec();
	
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
		
}
