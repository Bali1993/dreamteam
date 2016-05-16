package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import ntrfc.Entity;

/*
 * Karakter osztály, a játékosoknak
 * jaffa vagy colonel
 */
public class Character {
	// character koordinátái
	private int x;
	private int y;
	
	/*
	 * a nyitott portálok koordinátái eltárolva
	 * illetve az irány amibe néznek
	 */
	private int PortalBlue_x;
	private int PortalBlue_y;
	private int PortalYellow_x;
	private int PortalYellow_y;
	private int PortalRed_x;
	private int PortalRed_y;
	private int PortalGreen_x;
	private int PortalGreen_y;
	private String PortalBlue_Facing;
	private String PortalYellow_Facing;
	private String PortalRed_Facing;
	private String PortalGreen_Facing;

	//van-e doboz a karakternél
	private boolean haveBox;
	//hány ZPM-et vett fel a karakter
	private int zpmCounter;
	
	//Súlyok a mérlegekhez
	private int weight1;
	private int weight2;
	private int weight3;
	
	//Él-e a karakter, ezt ebben a változóban tároljuk
	private boolean isAlive;
	
	//Szál a bulletnek
	private Thread t;
	
	//adott karakterhez tartozó portálok eltárolása
	private Portal p1;
	private Portal p2;
	
	// bullethez tároljuk azt az irányt amibe utoljára lépett a Character, hogy
	// arra lőjö, default "down" lsd. konsruktor
	private String facing; // up, down, left, right

	private StarGateGame sgg;
	private Bullet b; // Lövedék referenciája
						

	//Karakter egyes állapotaihoz tartozó képek változói
	private Image image_character_up;
	private Image image_character_down;
	private Image image_character_left;
	private Image image_character_right;
	private Image image_character_up_with_box;
	private Image image_character_down_with_box;
	private Image image_character_left_with_box;
	private Image image_character_right_with_box;
	
	/*
	 * Character konstruktora
	 * koordináták beállítása
	 */
	public Character(StarGateGame g, int x, int y) {
		this.sgg = g;
		this.x = x;
		this.y = y;
	
		//Képek betöltése
		Map map = sgg.getMap();
		image_character_up = map.get_image_character_up();
		image_character_down = map.get_image_character_down();
		image_character_left = map.get_image_character_left();
		image_character_right = map.get_image_character_right();
		image_character_up_with_box = map.get_image_character_up_with_box();
		image_character_down_with_box = map.get_image_character_down_with_box();
		image_character_left_with_box = map.get_image_character_left_with_box();
		image_character_right_with_box = map.get_image_character_right_with_box();
		

		// -1-el jelezzük, hogy nincs még portál nyitva
		p1 = null;
		p2 = null;
		this.PortalBlue_x = -1;
		this.PortalBlue_y = -1;
		this.PortalYellow_x = -1;
		this.PortalYellow_y = -1;
		this.PortalRed_x = -1;
		this.PortalRed_y = -1;
		this.PortalGreen_x = -1;
		this.PortalGreen_y = -1;
		PortalBlue_Facing = "nincs még portál";
		PortalYellow_Facing = "nincs még portál";
		PortalRed_Facing = "nincs még portál";
		PortalGreen_Facing = "nincs még portál";

		this.haveBox = false;
		this.facing = "down";
		this.zpmCounter = 0;

		this.weight1 = 0;
		weight2 = 0;
		weight3 = 0;
		this.isAlive = true;
		
		this.b = null;
	}
	
	/*
	 * Karakterrel ütközés vizsgálata
	 * character rectanglejének vizsgálata az elemek rectanglejével
	 * az elem indexével tér visszamivel ütközött
	 * ha nem volt ütközés akkor -1-el
	 */
	public int Coll_Character(Character c, LinkedList<Entity> ll) {

		// Character négyzetét lekérjük
		Rectangle RecOfCharacter = c.getRec();
		
		//És megvizsgáljuk melyik másik elem négyzetével
		// metszik egymást
		for (int i = 0; i < ll.size(); ++i) {
			Rectangle RecOfElement = ll.get(i).getRec();
			if (RecOfCharacter.intersects(RecOfElement)) {
				return i;

			}
		}
		return -1;
	}
	
	/*
	 * getter-setter függvények a character attribútumaihoz
	 */
	public Bullet getBullet() {
		return this.b;
	}

	public Portal getP1() {
		return p1;
	}

	public Portal getP2() {
		return p2;
	}

	public void setP1(Portal p) {
		p1 = p;
	}

	public void setP2(Portal p) {
		p2 = p;
	}

	public void setBullet(Bullet n) {
		b = n;
	}

	// A Character koordinátáinak lekérdezése, beállítása
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x2) {
		this.x = x2;
	}

	public void setY(int y2) {
		this.y = y2;
	}

	// Character Facing-jének lekérdezése, beállítása
	public String getFacing() {
		return facing;
	}

	public void setFacing(String s) {
		this.facing = s;
	}
	
	//Lövés a karakterrel, paraméterben kapja a színt
	public void shoot(String colour) {
		b = new Bullet(x, y, facing, colour, this);
			
		//Elindítunk egy szálat a lövedéknek
		this.t = new Thread(b);
		this.t.start();
	}
	
	/*
	 * character mozgatása
	 * és ütközés vizsgálata, hogy lépéskor bekövetkezett-e
	 */
	public void move(int dx, int dy) {

		x += dx;
		y += dy;

		LinkedList<Entity> ListofElements = sgg.getList();

		int CollisionIndexinListofElements = this.Coll_Character(this, ListofElements);
		// if (CollisionIndexinListofElements < 0) {
		// sgg.getDoor1().setisOpened(false);
		// sgg.getDoor2().setisOpened(false);
		// }
		
		//A mérlegekre való rálépést is itt kezeljük
		if (sgg.getScale1().getX() == x && sgg.getScale1().getY() == y) {
			if (haveBox) {
				weight1 = 2;
			} else {
				weight1 = 1;
			}
			sgg.getScale1().setCurrentWeight(sgg.getScale1().getCurrentWeight() + weight1);
		} else {
			sgg.getScale1().setCurrentWeight(sgg.getScale1().getCurrentWeight() - weight1);
			weight1 = 0;
		}
		if (sgg.getScale2().getX() == x && sgg.getScale2().getY() == y) {
			if (haveBox) {
				weight2 = 2;
			} else {
				weight2 = 1;
			}
			sgg.getScale2().setCurrentWeight(sgg.getScale2().getCurrentWeight() + weight2);
		} else {
			sgg.getScale2().setCurrentWeight(sgg.getScale2().getCurrentWeight() - weight2);
			weight2 = 0;
		}
		
		if (sgg.getScale3().getX() == x && sgg.getScale3().getY() == y) {
			if (haveBox) {
				weight3 = 2;
			} else {
				weight3 = 1;
			}
			sgg.getScale3().setCurrentWeight(sgg.getScale3().getCurrentWeight() + weight3);
		} else {
			sgg.getScale3().setCurrentWeight(sgg.getScale3().getCurrentWeight() - weight3);
			weight3 = 0;
		}
		//Ha elég a súly kinyílik az ajtó
		if (sgg.getScale1().getCurrentWeight() >= sgg.getScale1().getWeightLimit()) {
			sgg.getDoor1().setisOpened(true);
		} else {
			sgg.getDoor1().setisOpened(false);
		}
		//Ha elég a súly kinyílik az ajtó
		if (sgg.getScale2().getCurrentWeight() >= sgg.getScale2().getWeightLimit()) {
			sgg.getDoor2().setisOpened(true);
		} else {
			sgg.getDoor2().setisOpened(false);
		}
		//Ha elég a súly kinyílik az ajtó
		if (sgg.getScale3().getCurrentWeight() >= sgg.getScale3().getWeightLimit()) {
			sgg.getDoor3().setisOpened(true);
		} else {
			sgg.getDoor3().setisOpened(false);
		}
		
		if (CollisionIndexinListofElements >= 0) {
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithCharacter(this, dx, dy);
		}
	}
	
	//Character rectanglejének képzése
	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}
	
	//A többi elem így érheti el a listát, 
	//ezzel a lekérdező függvénnyel
	public StarGateGame getSGG() {
		return this.sgg;
	}
	
	//A kék portál X koordinátáját adja vissza
	public int getPortalBlue_x() {
		return PortalBlue_x;
	}
	
	//A kék portál X koordinátáját állítja be
	public void setPortalBlue_x(int portalBlue_x) {
		PortalBlue_x = portalBlue_x;
	}
	
	//A kék portál Y koordinátáját adja vissza
	public int getPortalBlue_y() {
		return PortalBlue_y;
	}
	
	//A kék portál Y koordinátáját állítja be
	public void setPortalBlue_y(int portalBlue_y) {
		PortalBlue_y = portalBlue_y;
	}
	
	//A sárga portál X koordinátáját adja vissza
	public int getPortalYellow_x() {
		return PortalYellow_x;
	}
	//A sárga portál X koordinátáját állítja be
	public void setPortalYellow_x(int portalYellow_x) {
		PortalYellow_x = portalYellow_x;
	}
	
	//A sárga portál y adja vissza
	public int getPortalYellow_y() {
		return PortalYellow_y;
	}
	
	//A sárga portál Y koordinátáját állítja be
	public void setPortalYellow_y(int portalYellow_y) {
		PortalYellow_y = portalYellow_y;
	}
	
	//A piros portál X koordinátáját adja vissza
	public int getPortalRed_x() {
		return PortalRed_x;
	}
	//A piros portál X koordinátáját állítja be
	public void setPortalRed_x(int portalRed_x) {
		PortalRed_x = portalRed_x;
	}
	
	//A piros portál Y koordinátáját adja vissza
	public int getPortalRed_y() {
		return PortalRed_y;
	}
	
	//A piros portál Y koordinátáját állítja be
	public void setPortalRed_y(int portalRed_y) {
		PortalRed_y = portalRed_y;
	}
	
	//A zöld portál x koordinátáját adja vissza
	public int getPortalGreen_x() {
		return PortalGreen_x;
	}
	
	//A zöld portál x koordinátáját állítja be
	public void setPortalGreen_x(int portalGreen_x) {
		PortalGreen_x = portalGreen_x;
	}
	
	//A zöld portál Y koordinátáját adja vissza
	public int getPortalGreen_y() {
		return PortalGreen_y;
	}
	
	//A zöld portál Y koordinátáját állítja be
	public void setPortalGreen_y(int portalGreen_y) {
		PortalGreen_y = portalGreen_y;
	}
	
	//A kék portál facingjét adja vissza
	public String getPortalBlue_Facing() {
		return PortalBlue_Facing;
	}
	//A kék portál facingjét állítja be
	public void setPortalBlue_Facing(String portalBlue_Facing) {
		PortalBlue_Facing = portalBlue_Facing;
	}
	//A sárga portál facingjét adja vissza
	public String getPortalYellow_Facing() {
		return PortalYellow_Facing;
	}
	//A sárga portál facingjét állítja be
	public void setPortalYellow_Facing(String portaYellow_Facing) {
		PortalYellow_Facing = portaYellow_Facing;
	}
	//A piros portál facingjét adja vissza
	public String getPortalRed_Facing() {
		return PortalRed_Facing;
	}
	//A piros portál facingjét állítja be
	public void setPortalRed_Facing(String portalRed_Facing) {
		PortalRed_Facing = portalRed_Facing;
	}
	//A zöld portál facingjét adja vissza
	public String getPortalGreen_Facing() {
		return PortalGreen_Facing;
	}
	//A zöld portál facingjét állítja be
	public void setPortalGreen_Facing(String portaGreen_Facing) {
		PortalGreen_Facing = portaGreen_Facing;
	}
	
	/*
	 * Doboz felvétele characterrel
	 * doboz kivétele a listából
	 * havebox változó true-ba állítása
	 * 
	 */
	public void pickUp(int index) {
		LinkedList<Entity> lista = sgg.getList();
		Box box = (Box) lista.get(index);
		if (sgg.getScale1().getX() == x && sgg.getScale1().getY() == y) {
			sgg.getScale1().setCurrentWeight(sgg.getScale1().getCurrentWeight() - box.getWeight());
		}
		if (sgg.getScale2().getX() == x && sgg.getScale2().getY() == y) {
			sgg.getScale2().setCurrentWeight(sgg.getScale2().getCurrentWeight() - box.getWeight());
		}
		if (sgg.getScale3().getX() == x && sgg.getScale3().getY() == y) {
			sgg.getScale3().setCurrentWeight(sgg.getScale3().getCurrentWeight() - box.getWeight());
		}
		lista.remove(index);

		this.haveBox = true;

	}
	
	/*
	 * doboz lerakása
	 * új dobozt hoz létre a koordinátán ahol áll a character
	 * doboz berakása a listába
	 */
	public void putDown() {

		LinkedList<Entity> lista = sgg.getList();
		Box box = new Box(x, y, this);
		lista.offerFirst(box);
		this.haveBox = false;
		if (sgg.getScale1().getX() == x && sgg.getScale1().getY() == y) {
			sgg.getScale1().setCurrentWeight(sgg.getScale1().getCurrentWeight() + box.getWeight());
		}
		if (sgg.getScale2().getX() == x && sgg.getScale2().getY() == y) {
			sgg.getScale2().setCurrentWeight(sgg.getScale2().getCurrentWeight() + box.getWeight());
		}
		if (sgg.getScale3().getX() == x && sgg.getScale3().getY() == y) {
			sgg.getScale3().setCurrentWeight(sgg.getScale3().getCurrentWeight() + box.getWeight());
		}

	}
	//Visszaadja van-e nála doboz
	public boolean gethaveBox() {
		return haveBox;
	}
	//Visszaadja mennyi ZPM-et szedett eddig össze
	public int getzpmCounter() {
		return zpmCounter;
	}
	
	//Beállítja hány ZPM-et szedett össze
	public void setzpmCounter(int i) {
		zpmCounter = zpmCounter + i;
	}
	
	//Megadja él-e még a character
	public boolean getisAlive() {
		return isAlive;
	}
	//Beállítja él-e még a character
	public void setisAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	//A karakter egyes képeinek megfelelő
	//megjelenítéséért felelős függvény
	public void render(Graphics g) {
		if(facing == "up")
			g.drawImage(image_character_up, this.x + 1, this.y + 1, 31, 31, null);
	
		if(facing == "down")
			g.drawImage(image_character_down, this.x + 1, this.y + 1, 31, 31, null);
		
		if(facing == "left")
			g.drawImage(image_character_left, this.x + 1, this.y + 1, 31, 31, null);
		
		if(facing == "right")
			g.drawImage(image_character_right, this.x + 1, this.y + 1, 31, 31, null);
		
		if (haveBox) {
			if(facing == "up")
				g.drawImage(image_character_up_with_box, this.x + 1, this.y + 1, 31, 31, null);
		
			if(facing == "down")
				g.drawImage(image_character_down_with_box, this.x + 1, this.y + 1, 31, 31, null);
			
			if(facing == "left")
				g.drawImage(image_character_left_with_box, this.x + 1, this.y + 1, 31, 31, null);
			
			if(facing == "right")
				g.drawImage(image_character_right_with_box, this.x + 1, this.y + 1, 31, 31, null);
		}
		
		if (!isAlive) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 32, 32);
		}
	}
}