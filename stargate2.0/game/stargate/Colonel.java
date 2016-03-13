package game.stargate;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import ntrfc.stargate.Entity;

public class Colonel implements Entity{	
	private int x;
	private int y;

	private Image colonel;
	//Image colonel direction...
	
	StarGateGame sgg;


	public Colonel(StarGateGame g){		
		ImageIcon img = new ImageIcon();
		colonel = img.getImage();
		this.sgg = g;
		
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
	public void move(int dx,int dy,int tx,int ty){
		x += dx;
		y += dy;

		if(Collision.Coll(this, sgg.getList())){
			x -= dx;
			y -= dy;
			
		}
	}
	
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
	
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
}





















