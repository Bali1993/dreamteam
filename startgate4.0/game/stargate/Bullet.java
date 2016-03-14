package game.stargate;

import java.awt.Graphics;
import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Bullet{
	private int x;
	private int y;
	private String dir;
	private Colonel c;
	
	public Bullet(int x2, int y2, String facing, Colonel c) {
		this.x = x2;
		this.y = y2;
		this.dir = dir;
		this.c = c;
	}

	public int C_Bul(Bullet b, LinkedList<Entity> ll){
		return 0;
	}
	
	public void render(Graphics g){
		
	}
	public void move(String dir){
		
	}

}
