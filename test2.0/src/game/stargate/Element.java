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
	/* kikommentezve, tesztel�s miatt, norm�l progban elementsben lesz csak default implement�ci� a getRec elementekre, nem saj�t osztban
	public Rectangle getRec(){
		System.out.println("-> [:Wall].getRec();");
		
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	*/
	public abstract Rectangle getRec();
	
	
	//hasonl�an mint getRec()-n�l �rdemes lenne ezt is felvenni absztrakt oszt�lyk�nt mert
	//k�l�nben csak annyit l�tunk, hogy [:Element] t�pus
	public void onCollisionWithBullet(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Element].onCollisionWithBullet();");
		
		//default implement�cio:
		//l�ved�k megsz�ntet�se
		//Wall oszt�ly eset�ben kell csak overrideolni, hogy ha speci�lis, akkor nyisson egy port�lt
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Element].onCollisionWithBullet():void;");
	}
	
	public abstract void onCollision(int dx, int dy, int i);
	public abstract void render(Graphics g);
	
}
