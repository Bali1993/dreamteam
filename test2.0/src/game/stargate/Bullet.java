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
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].Bullet();");
		
		this.x = x2;
		this.y = y2;
		this.dir = dir;
		this.c = c;
		this.colour = colour;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].Bullet();");
	}

	public int C_Bul(Bullet b, LinkedList<Entity> ll){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].C_Bul();");
		
		//
		//TODO ide
		//
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].C_Bul():int;");		
		return 0;
	}
	
	public void render(Graphics g){
		
	}
	
	public void move(String dir){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].move();");
		
		//
		//ide ha hiv további fv-eket
		//
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].move():void;");
	}

}
