package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;

import ntrfc.Entity;

public class Replicator {
	private int x;
	private int y;
	StarGateGame sgg;
	private boolean isAlive;

	private Image image_replicator;
	
	public Replicator(StarGateGame sgg, int x, int y) {
		this.x = x;
		this.y = y;
		this.sgg = sgg;
		isAlive = true;
		
		try{
			File file = new File("../stargate grafikus/src/replicator.jpg");
			image_replicator = ImageIO.read(file);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public int Coll_Replicator(Replicator r, LinkedList<Entity> ll) {
		Rectangle RecOfReplicator = r.getRec();
		for (int i = 0; i < ll.size(); ++i) {
			Rectangle RecOfElement = ll.get(i).getRec();
			if (RecOfReplicator.intersects(RecOfElement)) {
				return i;
			}
		}
		return 0;
	}

	public void move() {
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		int dx = 0;
		int dy = 0;

		switch (n) {
		case 1:
			x += 32;
			dx = 32;
			break;
		case 2:
			x -= 32;
			dx = -32;
			break;
		case 3:
			y += 32;
			dy = 32;
			break;
		case 4:
			y -= 32;
			dy = -32;
			break;
		default:
			System.out.println("REPLICATOR MOVE HIBBABABABAB nagy a baj more");
			break;

		}

		LinkedList<Entity> ListofElements = sgg.getList();

		int CollisionIndexinListofElements = Coll_Replicator(this, ListofElements);

		if (CollisionIndexinListofElements != 0) {
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithReplicator(this, sgg.getColonel(),
					sgg.getJaffa(), dx, dy);
		}
	}

	// megsemmisiti �nmag�t, ha szakad�kba l�p
	// Pit oszt�ly h�vja, ha onColl-ja aktiv�l�dik azaz �tk�z�s t�rt�nik
	public void destroy() {
		this.x = -1;
		this.y = -1;
		this.isAlive = false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getRec() {
		return new Rectangle(x, y, 32, 32);
	}

	public boolean getisAlive() {
		return isAlive;
	}

	public void render(Graphics g) {
		if (isAlive) {
			g.drawImage(image_replicator, this.x + 1, this.y + 1, 31, 31, null);
		}
	}
}
