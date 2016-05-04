package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;


import ntrfc.Entity;

public class Bullet implements Runnable {
	private int x;
	private int y;
	private String dir;
	private String colour;
	private Character character;
	private boolean hit;
	
	private Image image_bullet_blue;
	private Image image_bullet_yellow;
	private Image image_bullet_red;
	private Image image_bullet_green;

	public Bullet(int x, int y, String facing, String colour, Character character) {
		this.x = x;
		this.y = y;
		this.dir = facing;
		this.character = character;
		this.colour = colour;
		this.hit = false;
		
		//kepek eltarolasa
		Map map = character.getSGG().getMap();
		image_bullet_blue = map.get_image_bullet_blue();
		image_bullet_yellow = map.get_image_bullet_yellow();
		image_bullet_red = map.get_image_bullet_red();
		image_bullet_green = map.get_image_bullet_green();
	}

	@Override
	public void run() {
		StarGateGame VariableForSGG = character.getSGG();

		while (!hit) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			LinkedList<Entity> ListofElements = VariableForSGG.getList();
			move(this.dir);

			int CollisionIndexinListofElements = Coll_Bullet(this, ListofElements);
			if (CollisionIndexinListofElements != 0) {
				ListofElements.get(CollisionIndexinListofElements).onCollisionWithBullet(this, character);
			}
		}

	}

	public boolean getHit() {
		return hit;
	}

	public void setHit(boolean b) {
		hit = b;
	}

	public void setX(int dx) {
		x = dx;
	}

	public void setY(int dy) {
		y = dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Wallnak van r� sz�ks�ge, port�l nyit�s miatt
	public String getBulletdir() {
		return dir;
	}

	// Wallnak van r� sz�ks�ge, port�l nyit�s miatt
	public String getBulletcolour() {
		return colour;
	}

	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	public int Coll_Bullet(Bullet b, LinkedList<Entity> ll) {
		Rectangle RecOfBullet = b.getRec();
		
		//replicator megsemm�s�t�se
		if (RecOfBullet.intersects(character.getSGG().getReplicator().getRec())){
			character.getSGG().getReplicator().destroy();
			this.setHit(true);
			character.setBullet(null);
			
		}else{
			for (int i = 0; i < ll.size(); ++i) {
				Rectangle RecOfElement = ll.get(i).getRec();
				if (RecOfBullet.intersects(RecOfElement)) {
					return i;
				}
			}
		}
		return 0; // 0 if no collision
	}

	public void move(String dir) {
		switch (dir) {
		case "up":
			y -= 32;
			break;
		case "down":
			y += 32;
			break;
		case "left":
			x -= 32;
			break;
		case "right":
			x += 32;
			break;
		default:
			break;
		}
	}

	public void render(Graphics g) {
		if(this.colour == "blue")
			g.drawImage(image_bullet_blue, this.x + 1, this.y + 1, 31, 31, null);
		if(this.colour == "yellow")
			g.drawImage(image_bullet_yellow, this.x + 1, this.y + 1, 31, 31, null);
		if(this.colour == "red")
			g.drawImage(image_bullet_red, this.x + 1, this.y + 1, 31, 31, null);
		if(this.colour == "green")
			g.drawImage(image_bullet_green, this.x + 1, this.y + 1, 31, 31, null);
	}

}
