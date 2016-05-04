package game;

import java.awt.Graphics;
import java.awt.Image;

public class Scale extends Element {

	private Door d;

	private int CurrentWeight;
	private int WeightLimit;

	private Image image_scale;
	private Image image_scale_with_box;
	
	public Scale(int x, int y, Door d, int WeightLimit, Character ch) {
		super(x, y, ch);
		this.d = d;
		this.CurrentWeight = 0;
		this.WeightLimit = WeightLimit;
		
		//kepek eltarolasa
		Map map = ch.getSGG().getMap();
		image_scale = map.get_image_scale();
		image_scale_with_box = map.get_image_scale_with_box();
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

		// if (!d.getisOpened()) {
		// d.setisOpened(true);
		// }

	}

	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {

	}

	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		/////
	}

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

	@Override
	public void render(Graphics g) {
		g.drawImage(image_scale, this.x + 1, this.y + 1, 31, 31, null);
		
		if (CurrentWeight > 0) {
			g.drawImage(image_scale_with_box, this.x + 1, this.y + 1, 31, 31, null);
		}
	}

}
