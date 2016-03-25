package game.stargate;

import java.awt.Graphics;
import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Bullet{
	private int x;
	private int y;
	private String dir;
	private String colour;
	private Colonel c;
	
	public Bullet(int x2, int y2, String facing, String colour, Colonel c) {
		this.x = x2;
		this.y = y2;
		this.dir = dir;
		this.c = c;
		this.colour = colour;
	}

	public int C_Bul(Bullet b, LinkedList<Entity> ll){
		return 0;
	}
	
	public void render(Graphics g){
		
	}
	public void move(String dir){
		
	}

}
