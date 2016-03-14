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

	private Image colonel_U;
	private Image colonel_D;
	private Image colonel_L;
	private Image colonel_R;
	
	/*
	 * bullethez t�roljuk azt az ir�nyt amibe utoj�ra l�pett a colonel, hogy arra l�j�n, default "down" lsd. konsruktor
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

		this.facing = "down";
		this.sgg = g;
		x = 32;
		y = 32;
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
	public int C_Col(Colonel e, LinkedList<Entity> ll){
		for(int i=0; i < ll.size(); ++i)
		{
			if(e.getRec().intersects(ll.get(i).getRec()))
				return i;   //index of element in list
		}
		return 0;			//0 if no collision
	}
	
	/*
	 * ezt a f�ggv�nyt h�vjuk meg a cntrl oszt�lyban, �s itt n�zem egyel�re a collisiont, mert m�g csak a falra vizsg�ljuk
	 * ha �tk�zik akkor egyszer�en visszal�p, egy�bk�nt a collision felt�telk�nt b�rhol vizsg�lhatjuk, csk m�g nem l�tom �t h hogyan
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
	
	public void shot(){
		b = new Bullet(x, y, facing, this);
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
	
}





















