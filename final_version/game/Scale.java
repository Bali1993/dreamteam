package game;

import java.awt.Graphics;
import java.awt.Image;
/*
 * Mérleg osztálya
 * Elements ősosztály
 * ajtók nyitására, zárására
 */
public class Scale extends Element {
	//Referencia az ajtóra, amit a mérleg nyit
	private Door d;

	//mérleg aktuális súlya és a súlylimitje 
	//ami alatt nem nyílik a hozzá tartozó ajtó
	private int CurrentWeight;
	private int WeightLimit;
	
	//Mérleghez tartozó képek
	private Image image_scale;
	private Image image_scale_with_box;
	
	/*
	 * Scale konstruktora
	 * súlyhatár beállítása, Elements ősosztály konstruktorának hívása
	 * aktuális súly beállítása 0-ra
	 */
	public Scale(int x, int y, Door d, int WeightLimit, Character ch) {
		super(x, y, ch);
		this.d = d;
		this.CurrentWeight = 0;
		this.WeightLimit = WeightLimit;
		
		//Képek beolvasása
		Map map = ch.getSGG().getMap();
		image_scale = map.get_image_scale();
		image_scale_with_box = map.get_image_scale_with_box();
	}
	
	/*
	 *  Amikor a colonel vagy a jaffa egy mérlegre lép,
	 *   akkor kinyílik az ajtó, ha elég nehéz a karakter
	 *  Felülírja az element osztály onCollisionWithCharacter függvényét
	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

		// if (!d.getisOpened()) {
		// d.setisOpened(true);
		// }

	}
	/*
	 *  Amikor a replikátor rálép a mérlegre 
	 *  nem történik semmmi
	 *  Felülírja az element osztály onCollisionWithReplicator függvényét
	 */
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {

	}
	/*
	 *  A lövedék elrepül a mérleg felett
	 *  Felülírja az element osztály onCollisionWithBullet 
	 *  függvényét
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		/////
	}
	
	//Getter-setterek a Scale attribútumaihoz
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setCurrentWeight(int weight) {
		CurrentWeight = weight;
	}

	public int getCurrentWeight() {
		return CurrentWeight;
	}

	public int getWeightLimit() {
		return WeightLimit;
	}
	
	//A mérleg képeinek kirajzolásáért felelős függvény
	@Override
	public void render(Graphics g) {
		g.drawImage(image_scale, this.x + 1, this.y + 1, 31, 31, null);
		
		if (CurrentWeight > 0) {
			g.drawImage(image_scale_with_box, this.x + 1, this.y + 1, 31, 31, null);
		}
	}

}
