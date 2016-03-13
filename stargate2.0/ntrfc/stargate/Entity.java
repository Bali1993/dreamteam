package ntrfc.stargate;

import java.awt.Rectangle;

public interface Entity {
	
	public int getX();
	public int getY();
	
	public void setX(int x2);
	public void setY(int y2);
	/*
	 * deklarálja a getRec() függvényt, hogy a listán tárolt elemeken meghívhassuk
	 */
	public Rectangle getRec();
}
