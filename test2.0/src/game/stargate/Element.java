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
	/* kikommentezve, tesztelés miatt, normál progban elementsben lesz csak default implementáció a getRec elementekre, nem saját osztban
	public Rectangle getRec(){
		System.out.println("-> [:Wall].getRec();");
		
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	*/
	public abstract Rectangle getRec();
	
	
	//hasonlóan mint getRec()-nél érdemes lenne ezt is felvenni absztrakt osztályként mert
	//különben csak annyit látunk, hogy [:Element] típus
	public void onCollisionWithBullet(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Element].onCollisionWithBullet();");
		
		//default implementácio:
		//lövedék megszüntetése
		//Wall osztály esetében kell csak overrideolni, hogy ha speciális, akkor nyisson egy portált
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Element].onCollisionWithBullet():void;");
	}
	
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
	
}
