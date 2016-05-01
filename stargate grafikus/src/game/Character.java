package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import ntrfc.Entity;

public class Character {
	private int x;
	private int y;

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

	private boolean haveBox;
	private int zpmCounter;

	private int weight1;
	private int weight2;
	private int weight3;

	private boolean isAlive;

	private Thread t;

	private Portal p1;
	private Portal p2;
	
	// bullethez t�roljuk azt az ir�nyt amibe utolj�ra l�pett a Character, hogy
	// arra l�j�n, default "down" lsd. konsruktor
	private String facing; // up, down, left, right

	private StarGateGame sgg;
	private Bullet b; // b�r nem is haszn�lja a Character, f�l�sleges elt�rolni
						// referenciak�nt

	
	Image image_character_up;
	Image image_character_down;
	Image image_character_left;
	Image image_character_right;
	Image image_character_up_with_box;
	Image image_character_down_with_box;
	Image image_character_left_with_box;
	Image image_character_right_with_box;
	
	public Character(StarGateGame g, int x, int y) {
		try{
			File file1 = new File("../stargate grafikus/src/character_up.jpg");
			image_character_up = ImageIO.read(file1);
			
			File file2 = new File("../stargate grafikus/src/character_down.jpg");
			image_character_down = ImageIO.read(file2);
			
			File file3 = new File("../stargate grafikus/src/character_left.jpg");
			image_character_left = ImageIO.read(file3);
			
			File file4 = new File("../stargate grafikus/src/character_right.jpg");
			image_character_right = ImageIO.read(file4);
			
			File file5 = new File("../stargate grafikus/src/character_up_with_box.jpg");
			image_character_up_with_box = ImageIO.read(file5);
			
			File file6 = new File("../stargate grafikus/src/character_down_with_box.jpg");
			image_character_down_with_box = ImageIO.read(file6);
			
			File file7 = new File("../stargate grafikus/src/character_left_with_box.jpg");
			image_character_left_with_box = ImageIO.read(file7);
			
			File file8 = new File("../stargate grafikus/src/character_right_with_box.jpg");
			image_character_right_with_box = ImageIO.read(file8);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		

		// -1-el jelezz�k, hogy nincs m�g port�l nyitva
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

		this.sgg = g;
		this.x = x;
		this.y = y;
		
		this.b = null;
	}
	
	
	public int Coll_Character(Character c, LinkedList<Entity> ll) {

		// Character n�gyzet�t lek�rj�k
		Rectangle RecOfCharacter = c.getRec();

		for (int i = 0; i < ll.size(); ++i) {
			Rectangle RecOfElement = ll.get(i).getRec();
			if (RecOfCharacter.intersects(RecOfElement)) {
				return i;

			}
		}
		return -1;
	}

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

	// A Character koordin��tinak lek�rdez�se, be�ll�t�sa
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

	// Character Facing-j�nek lek�rdez�se vagy be�ll�t�sa
	public String getFacing() {
		return facing;
	}

	public void setFacing(String s) {
		this.facing = s;
	}

	public void shoot(String colour) {
		b = new Bullet(x, y, facing, colour, this);

		this.t = new Thread(b);
		this.t.start();
	}

	public void move(int dx, int dy) {

		x += dx;
		y += dy;

		LinkedList<Entity> ListofElements = sgg.getList();

		int CollisionIndexinListofElements = this.Coll_Character(this, ListofElements);
		// if (CollisionIndexinListofElements < 0) {
		// sgg.getDoor1().setisOpened(false);
		// sgg.getDoor2().setisOpened(false);
		// }
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

		if (sgg.getScale1().getCurrentWeight() >= sgg.getScale1().getWeightLimit()) {
			sgg.getDoor1().setisOpened(true);
		} else {
			sgg.getDoor1().setisOpened(false);
		}

		if (sgg.getScale2().getCurrentWeight() >= sgg.getScale2().getWeightLimit()) {
			sgg.getDoor2().setisOpened(true);
		} else {
			sgg.getDoor2().setisOpened(false);
		}
		if (sgg.getScale3().getCurrentWeight() >= sgg.getScale3().getWeightLimit()) {
			sgg.getDoor3().setisOpened(true);
		} else {
			sgg.getDoor3().setisOpened(false);
		}
		
		if (CollisionIndexinListofElements >= 0) {
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithCharacter(this, dx, dy);
		}
	}

	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	public StarGateGame getSGG() {
		return this.sgg;
	}

	public int getPortalBlue_x() {
		return PortalBlue_x;
	}

	public void setPortalBlue_x(int portalBlue_x) {
		PortalBlue_x = portalBlue_x;
	}

	public int getPortalBlue_y() {
		return PortalBlue_y;
	}

	public void setPortalBlue_y(int portalBlue_y) {
		PortalBlue_y = portalBlue_y;
	}

	public int getPortalYellow_x() {
		return PortalYellow_x;
	}

	public void setPortalYellow_x(int portalYellow_x) {
		PortalYellow_x = portalYellow_x;
	}

	public int getPortalYellow_y() {
		return PortalYellow_y;
	}

	public void setPortalYellow_y(int portalYellow_y) {
		PortalYellow_y = portalYellow_y;
	}

	public int getPortalRed_x() {
		return PortalRed_x;
	}

	public void setPortalRed_x(int portalRed_x) {
		PortalRed_x = portalRed_x;
	}

	public int getPortalRed_y() {
		return PortalRed_y;
	}

	public void setPortalRed_y(int portalRed_y) {
		PortalRed_y = portalRed_y;
	}

	public int getPortalGreen_x() {
		return PortalGreen_x;
	}

	public void setPortalGreen_x(int portalGreen_x) {
		PortalGreen_x = portalGreen_x;
	}

	public int getPortalGreen_y() {
		return PortalGreen_y;
	}

	public void setPortalGreen_y(int portalGreen_y) {
		PortalGreen_y = portalGreen_y;
	}

	public String getPortalBlue_Facing() {
		return PortalBlue_Facing;
	}

	public void setPortalBlue_Facing(String portalBlue_Facing) {
		PortalBlue_Facing = portalBlue_Facing;
	}

	public String getPortalYellow_Facing() {
		return PortalYellow_Facing;
	}

	public void setPortalYellow_Facing(String portaYellow_Facing) {
		PortalYellow_Facing = portaYellow_Facing;
	}

	public String getPortalRed_Facing() {
		return PortalRed_Facing;
	}

	public void setPortalRed_Facing(String portalRed_Facing) {
		PortalRed_Facing = portalRed_Facing;
	}

	public String getPortalGreen_Facing() {
		return PortalGreen_Facing;
	}

	public void setPortalGreen_Facing(String portaGreen_Facing) {
		PortalGreen_Facing = portaGreen_Facing;
	}

	public void pickUp(int index) {
		LinkedList<Entity> lista = sgg.getList();
		Box box = (Box) lista.get(index);
		if (sgg.getScale1().getX() == x && sgg.getScale1().getY() == y) {
			sgg.getScale1().setCurrentWeight(sgg.getScale1().getCurrentWeight() - box.getWeight());
		}
		if (sgg.getScale2().getX() == x && sgg.getScale2().getY() == y) {
			sgg.getScale2().setCurrentWeight(sgg.getScale2().getCurrentWeight() - box.getWeight());
		}

		lista.remove(index);

		this.haveBox = true;

	}

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

	}

	public boolean gethaveBox() {
		return haveBox;
	}

	public int getzpmCounter() {
		return zpmCounter;
	}

	public void setzpmCounter(int i) {
		zpmCounter = zpmCounter + i;
	}

	public boolean getisAlive() {
		return isAlive;
	}

	public void setisAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

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