package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import ntrfc.Entity;

public abstract class Element implements Entity{
	protected int x;
	protected int y;
	protected Character ch;
	
	public Element(int x, int y, Character ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	
	//default implemenáció minden leszármazott számára
	//ha majd szükséges késõbbi teszteléshez a függvénykiiratás, akkor érdemes absztrakt osztályként felvenni
	//és minden leszármazottban másként megvalósítani
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
	
	//default implementáció, hogy ütközés esetén a repliktor lepattan minden elemröl
	//csak a szakadék esetén kell overrideolni, mely szerint megsemmisiti a replikátort
	//és a szakadékból út lesz
	public void onCollisionWithReplicator(Replicator replicator, int dx, int dy){
		replicator.setX(replicator.getX()-dx);
		replicator.setY(replicator.getY()-dy);
	}
	
	
	
	//hasonlóan mint getRec()-nél érdemes lenne ezt is felvenni absztrakt osztályként mert
	//különben csak annyit látunk, hogy [:Element] típus
	public void onCollisionWithBullet(Bullet bullet){
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
	
	public abstract void onCollisionWithCharacter(Character character, int dx, int dy);
	public abstract void render(Graphics g);
	
}
