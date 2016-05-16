package ntrfc;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Character;
import game.Replicator;

public interface Entity {

	// deklar�lja a getRec() f�ggv�nyt, hogy a list�ban t�rolt elemeken
	// megh�vhassuk
	public Rectangle getRec();

	// els� param�ter
	// azt adjuk meg, hogy Repliator, Character vagy Bullet - el t�rt�nt az
	// �tk�z�s
	// CollisionIndexinListofElements (kor�bban "i" param�ter volt)
	// a list�ban mely indexen t�rt�nt az �tk�z�s
	// r�j�ttem erre a param�terre nincs is sz�ks�g, mert az adott elem, amivel
	// t�rt�nik az �tk�z�s
	// tudja a saj�t index�t a list�ban, nem kell neki �tadni
	// csak sim�n lek�rdezi indexOf(this) be�p�tett f�ggv�nnyel
	// dx, dy
	// az azt adja, meg hogy mely ir�nyb�l t�rt�nt az �tk�z�s
	// 0, -32, +32 lehet az �rt�ke
	// legin�bb arra haszn�ljuk, hogy az adott elem lepattintsa mag�r�l a
	// Replicatort vagy Charactert
	// ez�rt nincs r� sz�ks�g a Bullet-n�l
	
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy);

	public void onCollisionWithBullet(game.Bullet bullet, Character c);

	public void onCollisionWithCharacter(Character character, int dx, int dy);

	public boolean ifStandingOnBox(Character c);
	
	public void render(Graphics g);

}
