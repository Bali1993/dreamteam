package game;

import java.awt.Graphics;
import java.awt.Image;

public class Wall extends Element {
	private boolean isSpecial;
	private Portal p;
	
	private Image image_wall_normal;
	private Image image_wall_special;

	public Wall(int x, int y, boolean b, Character ch) {
		super(x, y, ch);
		this.isSpecial = b;
		
		//kepek eltarolasa
		Map map = ch.getSGG().getMap();
		image_wall_normal = map.get_image_wall_normal();
		image_wall_special = map.get_image_wall_special();
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		character.setX(character.getX() - dx);
		character.setY(character.getY() - dy);
	}

	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		bullet.setHit(true);

		// ha specialis fal, akkor port�l nyit�s, ott ahol maga a fal van
		if (isSpecial) {
			String Bulletdir = bullet.getBulletdir();
			String Bulletcolour = bullet.getBulletcolour();

			String Portaldir;

			switch (Bulletdir) {
			case "up":
				Portaldir = "down";
				break;
			case "down":
				Portaldir = "up";
				break;
			case "left":
				Portaldir = "right";
				break;
			case "right":
				Portaldir = "left";
				break;
			default:
				Portaldir = "nincs m�s eset csak irni kell ide vmit, hogy a fordito ne sirjon, hogy Portaldir nem kap �rt�ket";
				break;
			}

			p = new Portal(x, y, Bulletcolour, c);

			// be is kell jegyezni a l�ncolt list�ba:
			// saj�t index�re rakja be
			ch.getSGG().getList().add(ch.getSGG().getList().indexOf(this), p);
			ch.getSGG().getList().remove(this);
			
			
			if (Bulletcolour == "blue") {
				c.setP1(p);
				c.setPortalBlue_x(x);
				c.setPortalBlue_y(y);
				c.setPortalBlue_Facing(Portaldir);
			}
			if (Bulletcolour == "red") {
				c.setP1(p);
				c.setPortalRed_x(x);
				c.setPortalRed_y(y);
				c.setPortalRed_Facing(Portaldir);
			}
			if (Bulletcolour == "yellow") {
				c.setP2(p);
				c.setPortalYellow_x(x);
				c.setPortalYellow_y(y);
				c.setPortalYellow_Facing(Portaldir);
			}
			if (Bulletcolour == "green") {
				c.setP2(p);
				c.setPortalGreen_x(x);
				c.setPortalGreen_y(y);
				c.setPortalGreen_Facing(Portaldir);
			}
		}

	}

	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		replicator.setX(replicator.getX() - dx);
		replicator.setY(replicator.getY() - dy);
	}

	@Override
	public void render(Graphics g) {
		if (isSpecial) {
			g.drawImage(image_wall_special, this.x, this.y, 32, 32, null);
		} else {
			g.drawImage(image_wall_normal, this.x, this.y, 32, 32, null);
		}
	}

}
