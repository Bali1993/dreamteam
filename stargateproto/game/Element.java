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
	/* kikommentezve, tesztel�s miatt, norm�l progban elementsben lesz csak default implement�ci� a getRec elementekre, nem saj�t osztban
	public Rectangle getRec(){
		System.out.println("-> [:Wall].getRec();");
		
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	*/
	public abstract Rectangle getRec();
	
	
	//default implement�ci�, hogy �tk�z�s eset�n a repliktor lepattan minden elemr�l
	//csak a szakad�k eset�n kell overrideolni, mely szerint megsemmisiti a replik�tort
	//�s a szakad�kb�l �t lesz
	public void onCollisionWithReplicator(int dx, int dy, Replicator replicator){
		replicator.setX(replicator.getX()-dx);
		replicator.setY(replicator.getY()-dy);
	}
	
	
	
	//hasonl�an mint getRec()-n�l �rdemes lenne ezt is felvenni absztrakt oszt�lyk�nt mert
	//k�l�nben csak annyit l�tunk, hogy [:Element] t�pus
	public void onCollisionWithBullet(int i){
		//i v�ltoz�t param�terk�nt felvettem, hogy a Wall tudja hol t�rt�nt �tk�z�s, melyik l�ncolt lista indexen
		//igy port�l nyit�skor azon az indexen tudjon nyitni egy port�lt (saj�t maga hely�n)
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Element].onCollisionWithBullet(int i);");
		
		//TODO:
		//default implement�cio:
		//l�ved�k megsz�ntet�se
		//Wall oszt�ly eset�ben kell csak overrideolni, hogy ha speci�lis, akkor nyisson egy port�lt
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Element].onCollisionWithBullet(int i):void;");
	}
	
	public abstract void onCollision(int dx, int dy, int i, game.Character charachter);
	public abstract void render(Graphics g);
	
}
