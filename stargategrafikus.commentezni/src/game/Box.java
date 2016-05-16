package game;

import java.awt.Graphics;
import java.awt.Image;

public class Box extends Element {
	private int weight;
	
	private Image image_box;
	
	public Box(int x, int y, Character ch) {
		super(x, y, ch);
		this.weight = 1;
		
		//kep eltarolasa
		image_box = ch.getSGG().getMap().get_image_box();
		
	}

	// Ez a f�ggv�ny adja meg, hogy mit csin�l a doboz, ha vele �tk�z�nk
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

	}

	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {

	}

	@Override
	public boolean ifStandingOnBox(Character c) {
		return true;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image_box, this.x + 1, this.y + 1, 31, 31, null);
	}

}
