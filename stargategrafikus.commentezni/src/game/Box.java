package game;

import java.awt.Graphics;
import java.awt.Image;

/*
 * Doboz osztálya
 */
public class Box extends Element {
	
	//Doboz súlya
	private int weight;
	
	//A doboz képének fenntartott változó
	private Image image_box;
	
	//Doboz konstruktora, ahol meghívjuk az element 
	//ős konstruktorát és beállítjuk a doboz súlyát
	public Box(int x, int y, Character ch) {
		super(x, y, ch);
		this.weight = 1;
		
		//Kép betöltése
		image_box = ch.getSGG().getMap().get_image_box();
		
	}
	
	/*
	 *  Amikor a colonel vagy a jaffa egy olyan mezőre lép
	 *   ahol doboz van, azt az esetet itt kezeljük
	 *   Nem történik különösebben semmi, mivel a characternél kezeljük
	 *   le, hogy felvesszük a dobozt, vagy továbblépünk innen.
	 *  Felülírja az element osztály onCollisionWithCharacter függvényét
	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

	}
	
	/*
	 * Ha egy lövedékkel eltalálunk egy dobozt 
	 * akkor semmi se történik, elhalad felette
	 * Felülírja az element osztály
	 *  onCollisionWithBullet függvényét
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {

	}
	
	/*
 	 * Doboz felvétele, ellenőrzés hogy egy dobozon állunk e	
 	 * Felülírja az element osztály ifStandingOnBox függvényét
 	 */
	@Override
	public boolean ifStandingOnBox(Character c) {
		return true;
	}
	
	//A súlyt visszaadó függvény
	public int getWeight() {
		return weight;
	}

	//A dobozok megfelelő képét rajzolja ki ez a függvény.
	@Override
	public void render(Graphics g) {
		g.drawImage(image_box, this.x + 1, this.y + 1, 31, 31, null);
	}

}
