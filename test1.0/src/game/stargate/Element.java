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
	/* kikommentezve, tesztelés miatt, normál progban elementsben lesz csak def a getRec elementekre, nem saját osztban
	public Rectangle getRec(){
		System.out.println("-> [:Wall].getRec();");
		
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	*/
	public abstract Rectangle getRec();
	public void onCollisionWithBullet(){
		//bullet destro
	}
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
	
}
