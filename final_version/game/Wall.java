package game;

import java.awt.Graphics;
import java.awt.Image;
/*
 * Fal osztálya
 * Speciális falra lehet portált létrehozni
 */
public class Wall extends Element {
	//speciális e a fal
	private boolean isSpecial;
	//portálra referencia
	private Portal p;
	
	private Image image_wall_normal;
	private Image image_wall_special;
	
	/*
	 * Wall konstruktora
	 * Element ősosztály konstruktor hívása
	 * isSpecial fal -> isSpecial = true 
	 */
	public Wall(int x, int y, boolean b, Character ch) {
		super(x, y, ch);
		this.isSpecial = b;
		
		//Képek eltárolása
		Map map = ch.getSGG().getMap();
		image_wall_normal = map.get_image_wall_normal();
		image_wall_special = map.get_image_wall_special();
	}
	/*
	 *  Amikor a karakterünk a falnak ütközik visszaléptetjük arra a mezőre amiről előzőleg léptünk el
	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		character.setX(character.getX() - dx);
		character.setY(character.getY() - dy);
	}

	/*
	 *  Fal és lövedék ütközése
	 *  Ha speciális a fal akkor portál nyitása
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {
		bullet.setHit(true);

		// ha specialis fal, akkor portál nyitás, ott ahol maga a fal van
		if (isSpecial) {
			//bullet irányának és színének lekérdezése
			String Bulletdir = bullet.getBulletdir();
			String Bulletcolour = bullet.getBulletcolour();

			String Portaldir;
			
			// a portált a jövő bullet irányával ellentés irányba nyitjuk, hogy a
			//portál elé lépjen ki a akrakterünk teleportáláskor		
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
				Portaldir = "nincs más eset csak irni kell ide vmit, hogy a fordito ne sirjon, hogy Portaldir nem kap értéket";
				break;
			}
			// új portál létrehozása, színt és irányt átadva
			p = new Portal(x, y, Bulletcolour, c);

			// be is kell jegyezni a láncolt listába:
			// saját indexére rakja be
			ch.getSGG().getList().add(ch.getSGG().getList().indexOf(this), p);
			// fal kivétele a listából
			ch.getSGG().getList().remove(this);
			
			//Ha a lövedék kék volt
			if (Bulletcolour == "blue") {
				c.setP1(p);
				c.setPortalBlue_x(x);
				c.setPortalBlue_y(y);
				c.setPortalBlue_Facing(Portaldir);
			}
			//Ha a lövedék piros volt
			if (Bulletcolour == "red") {
				c.setP1(p);
				c.setPortalRed_x(x);
				c.setPortalRed_y(y);
				c.setPortalRed_Facing(Portaldir);
			}
			//Ha a lövedék sárga volt
			if (Bulletcolour == "yellow") {
				c.setP2(p);
				c.setPortalYellow_x(x);
				c.setPortalYellow_y(y);
				c.setPortalYellow_Facing(Portaldir);
			}
			//Ha a lövedék zöld volt
			if (Bulletcolour == "green") {
				c.setP2(p);
				c.setPortalGreen_x(x);
				c.setPortalGreen_y(y);
				c.setPortalGreen_Facing(Portaldir);
			}
		}

	}
	/*
	 * Ha nekimegy a replikátor a falnak akkor visszalép az előző mezőre
	 */
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		replicator.setX(replicator.getX() - dx);
		replicator.setY(replicator.getY() - dy);
	}
	/*
	 * Megfelelő faltípus képének megjelenítése
	 */
	@Override
	public void render(Graphics g) {
		if (isSpecial) {
			g.drawImage(image_wall_special, this.x, this.y, 32, 32, null);
		} else {
			g.drawImage(image_wall_normal, this.x, this.y, 32, 32, null);
		}
	}

}
