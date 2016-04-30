package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Door extends Element {

	private boolean isOpened;

	private Image image_door_opened;
	private Image image_door_closed;
	
	public Door(int x, int y, Character ch) {
		super(x, y, ch);
		isOpened = false;
		
		try{
			File file1 = new File("../stargate grafikus/src/door_opened.jpg");
			image_door_opened = ImageIO.read(file1);
			
			File file2 = new File("../stargate grafikus/src/door_closed.jpg");
			image_door_closed = ImageIO.read(file2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
