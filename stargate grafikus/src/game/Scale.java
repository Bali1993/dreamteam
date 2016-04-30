package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

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
		
		try{
			File file1 = new File("../stargate grafikus/src/scale.jpg");
			image_scale = ImageIO.read(file1);
			
			File file2 = new File("../stargate grafikus/src/scale_with_box.jpg");
			image_scale_with_box = ImageIO.read(file2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
