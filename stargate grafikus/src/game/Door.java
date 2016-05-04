package game;

import java.awt.Graphics;
import java.awt.Image;

public class Door extends Element {

	private boolean isOpened;

	private Image image_door_opened;
	private Image image_door_closed;
	
	public Door(int x, int y, Character ch) {
		super(x, y, ch);
		isOpened = false;
		
		//kepek eltarolasa
		Map map = ch.getSGG().getMap();
		image_door_opened = map.get_image_door_opened();
		image_door_closed = map.get_image_door_closed();
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		if (isOpened == false) {
			character.setX(character.getX() - dx);
			character.setY(character.getY() - dy);
		}
	}

	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		if (!isOpened) {
			bullet.setHit(true); 
			c.setBullet(null);
			System.out.println("anyád");
		}
	}
	
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		if (!isOpened) {
			replicator.setX(replicator.getX() - dx);
			replicator.setY(replicator.getY() - dy);
		}
	}
	
	public void setisOpened(boolean b){
		this.isOpened = b;
	}
	
	public boolean getisOpened(){
		return this.isOpened;
	}

	@Override
	public void render(Graphics g) {
		if (isOpened == false) {
			g.drawImage(image_door_closed, this.x, this.y, 33, 33, null);
		}

		if (isOpened == true) {
			g.drawImage(image_door_opened, this.x, this.y, 33, 33, null);
		}
	}

}
