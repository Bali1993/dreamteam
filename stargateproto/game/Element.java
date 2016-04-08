package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import ntrfc.Entity;

public abstract class Element implements Entity{
	protected int x;
	protected int y;
	
	public Element(int x2, int y2){
		this.x = x2;
		this.y = y2;
	}
	/* kikommentezve, tesztelés miatt, normál progban elementsben lesz csak default implementáció a getRec elementekre, nem saját osztban
	public Rectangle getRec(){
		System.out.println("-> [:Wall].getRec();");
		
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	*/
	public abstract Rectangle getRec();
	
	
	//default implementáció, hogy ütközés esetén a repliktor lepattan minden elemröl
	//csak a szakadék esetén kell overrideolni, mely szerint megsemmisiti a replikátort
	//és a szakadékból út lesz
	public void onCollisionWithReplicator(int dx, int dy, Replicator replicator){
		replicator.setX(replicator.getX()-dx);
		replicator.setY(replicator.getY()-dy);
	}
	
	
	
	//hasonlóan mint getRec()-nél érdemes lenne ezt is felvenni absztrakt osztályként mert
	//különben csak annyit látunk, hogy [:Element] típus
	public void onCollisionWithBullet(int i){
		//i változót paraméterként felvettem, hogy a Wall tudja hol történt ütközés, melyik láncolt lista indexen
		//igy portál nyitáskor azon az indexen tudjon nyitni egy portált (saját maga helyén)
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Element].onCollisionWithBullet(int i);");
		
		//TODO:
		//default implementácio:
		//lövedék megszüntetése
		//Wall osztály esetében kell csak overrideolni, hogy ha speciális, akkor nyisson egy portált
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Element].onCollisionWithBullet(int i):void;");
	}
	
	public abstract void onCollision(int dx, int dy, int i, game.Character charachter);
	public abstract void render(Graphics g);
	
}
