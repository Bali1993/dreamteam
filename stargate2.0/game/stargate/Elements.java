package game.stargate;

import java.awt.Rectangle;

import ntrfc.stargate.Entity;

public abstract class Elements  implements Entity{
	private int x;
	private int y;
	
	public Elements(int x2, int y2){
		this.x = x2;
		this.y = y2;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
	
}
