package ntrfc.stargate;

import java.awt.Rectangle;

public interface Entity {
	
	public int getX();
	public int getY();
	
	public void setX(int x2);
	public void setY(int y2);
	/*
	 * deklar�lja a getRec() f�ggv�nyt, hogy a list�n t�rolt elemeken megh�vhassuk
	 */
	public Rectangle getRec();
}
