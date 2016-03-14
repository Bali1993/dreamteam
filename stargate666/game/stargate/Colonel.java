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
	
	private int x_yellow;
	private int y_yellow;
	private int x_blue;
	private int y_blue;
	
	private boolean haveBox;
	private int zpmCounter;
	
	private Image colonel_U;
	private Image colonel_D;
	private Image colonel_L;
	private Image colonel_R;
	private Image colonel_atBox;
	private Image colonel_U_Box;
	private Image colonel_D_Box;
	private Image colonel_L_Box;
	private Image colonel_R_Box;
	/*
	 * bullethez tároljuk azt az irányt amibe utojára lépett a colonel, hogy arra lõjön, default "down" lsd. konsruktor
	 */
	private String facing; //left,right,up,down
	
	private StarGateGame sgg;
	private Bullet b;

	public Colonel(StarGateGame g){		
		ImageIcon img = new ImageIcon();
		colonel_U = img.getImage();
		img = new ImageIcon();
		colonel_D = img.getImage();
		img = new ImageIcon();
		colonel_L = img.getImage();
		img = new ImageIcon();
		colonel_R = img.getImage();
		img = new ImageIcon();
		colonel_atBox = img.getImage();
		img = new ImageIcon();
		colonel_U_Box = img.getImage();
		img = new ImageIcon();
		colonel_D_Box = img.getImage();
		img = new ImageIcon();
		colonel_L_Box = img.getImage();
		img = new ImageIcon();
		colonel_R_Box = img.getImage();
		
		this.haveBox = false;
		this.facing = "down";
		this.zpmCounter = 0;
		
		this.sgg = g;
		x = 32;
		y = 32;
	}

	public int C_Col(Colonel e, LinkedList<Entity> ll){
		for(int i=0; i < ll.size(); ++i)
		{
			if(e.getRec().intersects(ll.get(i).getRec()))
				return i;   //index of element in list
		}
		return 0;			//0 if no collision
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
	public StarGateGame getSGG(){
		return this.sgg;
	}
	public String getFacing(){
		return facing;	
	}
	public void setFacing(String s){
		this.facing = s;
	}
	
	public void shot(String colour){
		b = new Bullet(x, y, facing, colour, this);
	}
	
	public void pickUp(){
		//if keypressed....
		this.haveBox = true;
	}
	public void putdown(){
		//if keypressed.....
		this.haveBox = false;
	}
	
	public void move(int dx,int dy){
		x += dx;
		y += dy;

		if(C_Col(this, sgg.getList())!=0){
			int i = C_Col(this, sgg.getList()); 
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
	public Image getColonel_up(){
		return this.colonel_U;
	}
	public Image getColonel_down(){
		return this.colonel_D;
	}
	public Image getColonel_left(){
		return this.colonel_L;
	}
	public Image getColonel_right(){
		return this.colonel_R;
	}
	public Image getColonel_up_box(){
		return this.colonel_U_Box;
	}
	public Image getColonel_down_box(){
		return this.colonel_D_Box;
	}
	public Image getColonel_left_box(){
		return this.colonel_L_Box;
	}
	public Image getColonel_right_box(){
		return this.colonel_R_Box;
	}
}





















