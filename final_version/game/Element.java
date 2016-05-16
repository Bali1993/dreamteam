package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import ntrfc.Entity;

/*
 * Element abstract ősosztály
 * implementálja az általunk készített entity interfacet
 * pályaelemekhez
 */
public abstract class Element implements Entity {
	// Egy elem koordinátái
	protected int x;
	protected int y;
	// Karakter referencia
	protected Character ch;

	
	/*
	 * Element osztály konstruktora
	 * koordináták beállítása, játékhoz hozzárendelése
	 */
	public Element(int x, int y, Character ch) {
		this.x = x;
		this.y = y;
		this.ch = ch;
	}

	// default implementáció minden leszármazott számára
	// ha majd szükséges későbbi teszteléshez a függvénykiiratás, akkor érdemes
	// absztrakt osztályként felvenni
	// és minden leszármazottban másként megvalósítani
	/*
	 * Rectangle készítésének default implementációja,
	 * mivel négyzetekből áll majd a pálya így ez egységesen használható az öszes elemhez
	 */
	@Override
	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	
	
	// Default implementáció, hogy ütközés esetén a replikátor lepattan minden
	// elemről
	// csak a szakadék esetén kell overrideolni, mely szerint megsemmisiti a
	// replikátort
	// és a szakadékból út lesz
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		
	}

	/*
	 * Ha lövedék ütközik egy elemmel, akkor alapméretezetten
	 *  megszüntetjuk, bizonyos esetekben ezt felüldefiniáljuk,
	 * hogy ne álljon meg az elemnél hanem repüljön tovább
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		
		bullet.setHit(true);
		c.setBullet(null);

	}
	
	/*
	 * Ha a karaktér ütközik valamilyen elemmel,
	 * abstract, mivel minden elem esetén eléggé 
	 * eltérő dolog történik
	 */
	@Override
	public abstract void onCollisionWithCharacter(Character character, int dx, int dy);
	
	//A kirajzolásért felelős függvény, minden leszámazott majd
	//megvalósítja, ahogy neki kell
	@Override
	public abstract void render(Graphics g);
	
	/*
	 * Vizsgáljuk, hogy dobozon állunk e, ez csak a doboz esetében írodik felül,
	 * alapméretezetten false a visszatérése 
	 */
	@Override
	public boolean ifStandingOnBox(Character c){
		return false;
	}
}
