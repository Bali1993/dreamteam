package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;


import ntrfc.Entity;

/*
 *  Lövedék osztálya, implementűlja a runanble interfacet
 */
public class Bullet implements Runnable {
	
	// Lövedék x,y koordinátái
	private int x;
	private int y;
	
	// Lövedék iránya és színe
	private String dir;
	private String colour;
	
	// referencia a akarakterre aki létrehozta 
	//a bullet egy példányát
	private Character character;
	
	//volt-e találat, boolean változó
	private boolean hit;
	
	//A lövedékek képeinek változói
	private Image image_bullet_blue;
	private Image image_bullet_yellow;
	private Image image_bullet_red;
	private Image image_bullet_green;
	
	/*
	 * Bullet konstruktora, ahol beállítjuk az irányát, 
	 * színét és a referenciát a karakterre aki kilőtte
	 */
	public Bullet(int x, int y, String facing, String colour, Character character) {
		this.x = x;
		this.y = y;
		this.dir = facing;
		this.character = character;
		this.colour = colour;
		this.hit = false;
		
		//Képek eltárolása
		Map map = character.getSGG().getMap();
		image_bullet_blue = map.get_image_bullet_blue();
		image_bullet_yellow = map.get_image_bullet_yellow();
		image_bullet_red = map.get_image_bullet_red();
		image_bullet_green = map.get_image_bullet_green();
	}
	
	/*
	 * Runnable run() függvényék felülírása, 
	 * amiben külön szálba rendeljük a lövedéket 
	 * és ott léptetjük, amíg
	 * bele nem ütközik valamibe és szűnik meg
	 */
	@Override
	public void run() {
		StarGateGame VariableForSGG = character.getSGG();
		
		// Addig léptetjük, amíg nem ütközik 
		//valamibe (onCollisionWithBulletben hit = true)
		while (!hit) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// láncolt lista (amiben az elemek vannak) lekrédezése
			LinkedList<Entity> ListofElements = VariableForSGG.getList();
			
			// bullet léptetése 
			//(abban az irányban indítva amerre a karakter utoljára nézett)
			move(this.dir);
			
			// ütközés vizsgálata, amennyiben volt ütközés meghívjuk az element azon függvényét amivel 
			// az adott bullet ütközött, és adott elem felülír			
			int CollisionIndexinListofElements = Coll_Bullet(this, ListofElements);
			if (CollisionIndexinListofElements != 0) {
				ListofElements.get(CollisionIndexinListofElements).onCollisionWithBullet(this, character);
			}
		}

	}
	/*
	 * Getter-setter függvények a bullet osztály 
	 * private attribútuumaihoz
	 */
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

	// Wallnak van rá szüksége, portál nyitás miatt
	//Hogy melyik irányba nézzen a portál
	public String getBulletdir() {
		return dir;
	}

	// Wallnak van rá szüksége, portál nyitás miatt
	//Hogy milyen szinű legyen a portál
	public String getBulletcolour() {
		return colour;
	}
	
	// rectangle képzése a bulet koordinátáinak 
	//felhasználásával az ütközés vizsgálatához
	public Rectangle getRec() {
		
		// visszatér egy 32*32 pixeles Rectangle-vel
		return new Rectangle(x, y, 32, 32);
	}
	
	/*
	 * lövedékkel való ütköztetés
	 * a lövedék Rectanglejének összehasonlítása a listában lévő elemekével, ha egyezés van, akkor ütközés történt
	 * visszatér az elem indexével a listában ha volt ütközés, ha nem volt 0-val tér vissza
	 */
	public int Coll_Bullet(Bullet b, LinkedList<Entity> ll) {
		Rectangle RecOfBullet = b.getRec();
		
		//replicator megsemmisítése
		if (RecOfBullet.intersects(character.getSGG().getReplicator().getRec())){
			character.getSGG().getReplicator().destroy();
			this.setHit(true);
			character.setBullet(null);
			
		}else{
			//végiglépkedünk a láncolt listán 
			//és minden elemnek elkészítjük a rectanglejét, 
			//amivel vizsgáljuk a bulletét
			for (int i = 0; i < ll.size(); ++i) {
				Rectangle RecOfElement = ll.get(i).getRec();
				if (RecOfBullet.intersects(RecOfElement)) {
					return i;
				}
			}
		}
		
		//0-val térünk vissza ha nem volt ütközés
		return 0;
	}
	
	/*
	 * Bullet léptetése az irányának megfelelően növelve a koordinátáit
	 * up,down,left,right
	 */
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
	
	//Bullet képének megfelelő kirajzolása
	//Attól függően milyen színű a lövedék
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
