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
	
	//default implemen�ci� minden lesz�rmazott sz�m�ra
	//ha majd sz�ks�ges k�s�bbi tesztel�shez a f�ggv�nykiirat�s, akkor �rdemes absztrakt oszt�lyk�nt felvenni
	//�s minden lesz�rmazottban m�sk�nt megval�s�tani
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
	
	//default implement�ci�, hogy �tk�z�s eset�n a repliktor lepattan minden elemr�l
	//csak a szakad�k eset�n kell overrideolni, mely szerint megsemmisiti a replik�tort
	//�s a szakad�kb�l �t lesz
	public void onCollisionWithReplicator(Replicator replicator, int dx, int dy){
		replicator.setX(replicator.getX()-dx);
		replicator.setY(replicator.getY()-dy);
	}
	
	
	
	//hasonl�an mint getRec()-n�l �rdemes lenne ezt is felvenni absztrakt oszt�lyk�nt mert
	//k�l�nben csak annyit l�tunk, hogy [:Element] t�pus
	public void onCollisionWithBullet(Bullet bullet){
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
	
	public abstract void onCollisionWithCharacter(Character character, int dx, int dy);
	public abstract void render(Graphics g);
	
}
