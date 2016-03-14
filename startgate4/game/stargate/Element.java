package game.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;

import ntrfc.stargate.Entity;

public abstract class Element implements Entity{
	protected int x;
	protected int y;
	protected Colonel c;
	
	public Element(int x2, int y2, Colonel c){
		this.x = x2;
		this.y = y2;
		this.c = c;
	}
	
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	public void onCollisionWithBullet(){
		
	}
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
	
}
