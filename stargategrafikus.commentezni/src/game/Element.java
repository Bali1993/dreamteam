package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import ntrfc.Entity;

public abstract class Element implements Entity {
	protected int x;
	protected int y;
	protected Character ch;

	public Element(int x, int y, Character ch) {
		this.x = x;
		this.y = y;
		this.ch = ch;
	}

	// default implemen�ci� minden lesz�rmazott sz�m�ra
	// ha majd sz�ks�ges k�s�bbi tesztel�shez a f�ggv�nykiirat�s, akkor �rdemes
	// absztrakt oszt�lyk�nt felvenni
	// �s minden lesz�rmazottban m�sk�nt megval�s�tani
	@Override
	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	// default implement�ci�, hogy �tk�z�s eset�n a replik�tor lepattan minden
	// elemr�l
	// csak a szakad�k eset�n kell overrideolni, mely szerint megsemmisiti a
	// replik�tort
	// �s a szakad�kb�l �t lesz
	
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	// hasonl�an mint getRec()-n�l �rdemes lenne ezt is felvenni absztrakt
	// oszt�lyk�nt mert
	// k�l�nben csak annyit l�tunk, hogy [:Element] t�pus
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		// TODO:
		// default implement�cio:
		// l�ved�k megsz�ntet�se
		// Wall oszt�ly eset�ben kell csak overrideolni, hogy ha speci�lis,
		// akkor nyisson egy port�lt
		// ch.getBullet().setHit(true);
		
		bullet.setHit(true);
		c.setBullet(null);

	}

	@Override
	public abstract void onCollisionWithCharacter(Character character, int dx, int dy);

	@Override
	public abstract void render(Graphics g);
	
	@Override
	public boolean ifStandingOnBox(Character c){
		return false;
	}
}
