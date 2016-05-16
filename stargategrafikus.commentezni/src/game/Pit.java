package game;

import java.awt.Color;
import java.awt.Graphics;

/*
 *	Szakadék osztálya 
 */
public class Pit extends Element {

	//nem képet olvasunk be, csak egy fekete négyzetet rajzolunk ki
	//private Image image_pit;
	
	public Pit(int x, int y, Character ch) {
		super(x, y, ch);
		
		
	}
	
	/*
	 * Ha a replikátor belelép a szakadékba
	 * a listából kivesszük a szakadékot és utat rakunk a helyére
	 * és a replikátort megsemmisítjük
	 */
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		StarGateGame VariableForSGG = ch.getSGG();
		VariableForSGG.getList().remove(this);
		replicator.destroy();
	}
	
	/*
	 * Ha a karakterrel lépünk a szakadékba akkor 
	 * meghal és meghívjuk az EndOfGame függvényt
	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		StarGateGame VariableForSGG = ch.getSGG();
		character.setisAlive(false);
		VariableForSGG.EndofGame();
	}
	
	/*
	 * A lövedék átrepül a szakadék felett
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {

	}
	//A szakadék képének kirajzolása, vagyis egy fekete négyzetet 
	//teszünk a szakadék helyére.
	@Override
	public void render(Graphics g) {
	
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		
		//g.drawImage(image_pit, this.x + 1, this.y + 1, 31, 31, null);
	}

}
