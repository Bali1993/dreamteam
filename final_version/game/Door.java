package game;

import java.awt.Graphics;

import java.awt.Image;

/*
 * Ajtó osztálya
 */
public class Door extends Element {
	
	// boolean változó, ami true, 
	//ha nyitva van az ajót és false ha nincs
	private boolean isOpened;
	
	//Zárt és nyitott ajtóhoz tartozó képek változói
	private Image image_door_opened;
	private Image image_door_closed;
	
	
	/*
	 * Door konstruktora
	 * Element ősosztály konstruktorának meghívása
	 * isOpened falsera állítása, alapméretezetten 
	 * zárva van minden ajtó
	 */
	public Door(int x, int y, Character ch) {
		super(x, y, ch);
		isOpened = false;
		
		//Képek eltárolása
		Map map = ch.getSGG().getMap();
		image_door_opened = map.get_image_door_opened();
		image_door_closed = map.get_image_door_closed();
	}
	
	
	/*
	 * Ha Characterrel lépünk ajtó mezőre, akkor vagy átlépünk rajta, vagy visszalépünk az ajtó elé mivel nincs nyitva
	 * (azonos a fallal való ütközéssel, ha zárt ajtónak megyünk)
	 * Felülírja az element osztály onCollisionWithCharacter függvényét 
	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		if (isOpened == false) {
			//karakter visszaléptetése az előző
			//(lépés előtti) koordinátáira, zárt ajtó esetén
			character.setX(character.getX() - dx);
			character.setY(character.getY() - dy);
		}
	}
	
	
	/*
	 * Ha zárva van az ajtó akkor megállítja a lövedéket
	 * Ha nyitva van az ajtó akkor a lövedék áthalad rajta
	 * Felülírja az element osztály onCollisionWithBullet függvényét 
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		if (!isOpened) {
			// bullet találat -> true
			bullet.setHit(true); 
			// bullet megszüntetése
			c.setBullet(null);
	
		}
	}
	
	/*
	 * Ha zárva van az ajtó akkor megállítja a replikátort, nem engedi át(mint a fal)
	 * Ha nyitva van az ajtó akkor átengedi a replikátort
	 * Felülírja az element osztály onCollisionWithReplicator függvényét 
	 */
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		if (!isOpened) {
			//replikátor visszaléptetése zárt ajtó esetén
			replicator.setX(replicator.getX() - dx);
			replicator.setY(replicator.getY() - dy);
		}
	}
	//Getter-setter ajtó nyitásához
	public void setisOpened(boolean b){
		this.isOpened = b;
	}
	
	public boolean getisOpened(){
		return this.isOpened;
	}
	
	//Ajtóhoz tartozó képek megjelenítése
	@Override
	public void render(Graphics g) {
		if (isOpened == false) {
			g.drawImage(image_door_closed, this.x, this.y, 33, 33, null);
		}
		
		//Ha nyitva van az ajtó kicseréljük a képet.
		if (isOpened == true) {
			g.drawImage(image_door_opened, this.x, this.y, 33, 33, null);
		}
	}

}
