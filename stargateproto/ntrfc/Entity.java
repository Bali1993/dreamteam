package ntrfc;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Replicator;

public interface Entity {
	/*
	 * deklar�lja a getRec() f�ggv�nyt, hogy a list�ban t�rolt elemeken megh�vhassuk
	 */
	public abstract Rectangle getRec();
	
	public void onCollisionWithReplicator(int dx, int dy, Replicator replicator);
	public void onCollisionWithBullet(int i);
	public void onCollision(int dx, int dy, int i, game.Character character);
	public void render(Graphics g);
		
}
