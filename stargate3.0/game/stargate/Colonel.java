package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import ntrfc.stargate.Entity;

public class Colonel{	
	private int x;
	private int y;

	private Image colonel;
	//Image colonel direction...
	
	
	/*
	 * bullethez tároljuk azt az irányt amibe utojára lépett a colonel, hogy arra lõjön, default "down" lsd. konsruktor
	 */
	private String facing; //left,right,up,down
	
	StarGateGame sgg;


	public Colonel(StarGateGame g){		
		ImageIcon img = new ImageIcon();
		colonel = img.getImage();
		
		this.sgg = g;
		this.facing = "down";
		
		x = 32;
		y = 32;
	}
	public Image getColonel(){
		return this.colonel;
	}
	
	
	/*
	 * ezt a függvényt hívjuk meg a cntrl osztályban, és itt nézem egyelõre a collisiont, mert még csak a falra vizsgáljuk
	 * ha ütközik akkor egyszerûen visszalép, egyébként a collision feltételként bárhol vizsgálhatjuk, csk még nem látom át h hogyan
	 * 
	 */
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public void setX(int x2){
		this.x = x2;
	}
	public void setY(int y2){
		this.y = y2;
	}
	
	public String getFacing(){
		return facing;	
	}
	public void setFacing(String s){
		this.facing = s;
	}
	
	public void move(int dx,int dy){
		x += dx;
		y += dy;

		if(Collision.C_Col(this, sgg.getList())!=0){
			int i = Collision.C_Col(this, sgg.getList()); 
			sgg.getList().get(i).onCollision(dx, dy, i);
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
	}
	
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
}





















