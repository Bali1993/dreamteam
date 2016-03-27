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
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].C_Col(Colonel e, LinkedList<Entity> ll);");
		
		//Colonel n�gyzet�t lek�rj�k
		StarGateGame.tab++;
		Rectangle RecOfColonel = e.getRec();
		StarGateGame.tab--;
		
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem n�gyzete a l�ncolt list�ban
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			
			//�sszehasonl�tjuk a Colonel �s adott elem n�gyzet�t, hogy egyezik-e
			//ha igen, akkor �tk�z�s van
			if(RecOfColonel.intersects(RecOfElement)){
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Colonel].C_Col(Colonel e, LinkedList<Entity> ll):int;");
				return i;   //index of element in list
			}
			
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].C_Col(Colonel e, LinkedList<Entity> ll):int;");
		return 0;
		//0 if no collision
		//a list�ban a 0. indexen a txt beolvas�sb�l ad�d�an biztos, hogy fal van,
		//amnivel nem tudunk �tk�zni, mert a sarokban van, �s tov�bbi falakkal van k�r�l v�ve
		//ez�rt vissza adhatunk 0-t, ha nem t�rt�nt �tk�z�s
	}
	
	/*
	 * ezt a f�ggv�nyt h�vjuk meg a cntrl oszt�lyban, �s itt n�zem egyel�re a collisiont, mert m�g csak a falra vizsg�ljuk
	 * ha �tk�zik akkor egyszer�en visszal�p, egy�bk�nt a collision felt�telk�nt b�rhol vizsg�lhatjuk, csk m�g nem l�tom �t h hogyan
	 * 
	 */
	public int getX(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getX();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getX():int;");
		return this.x;
	}
	public int getY(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getY();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getY():int;");
		return this.y;
	}
	
	public void setX(int x2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setX(int x2);");
		
		this.x = x2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setX(int x2):void;");
	}
	public void setY(int y2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setY(int y2);");
		
		this.y = y2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setY(int y2):void;");
	}
	
	public int getX_yellow(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getX_yellow();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getX_yellow():int;");
		return this.x_yellow;
	}
	public int getY_yellow(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getY_yellow();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getY_yellow():int;");
		return this.y_yellow;	
	}
	
	public void setX_yellow(int x2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setX_yellow();");
		
		this.x_yellow = x2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setX_yellow():void;");
	}
	public void setY_yellow(int y2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setY_yellow();");
		
		this.y_yellow = y2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setY_yellow():void;");
	}
	
	
	public int getX_blue(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getX_blue();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getX_blue():int;");
		return this.x_blue;
	}
	public int getY_blue(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getY_blue();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getY_blue():int;");
		return this.y_blue;	
	}
	
	public void setX_blue(int x2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setX_blue();");
		
		this.x_blue = x2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setX_blue():void;");
	}
	public void setY_blue(int y2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setY_blue();");
		
		this.y_blue = y2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setY_blue():void;");
	}
	
	
	public StarGateGame getSGG(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getSGG();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getSGG():StarGateGame;");
		return this.sgg;
	}
	
	public String getFacing(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getFacing();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getFacing():String;");
		return facing;
	}
	public void setFacing(String s){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setFacing();");
		
		this.facing = s;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setFacing():void;");
	}
	
	public void shot(String colour){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].shot();");
		
		StarGateGame.tab++;
		b = new Bullet(x, y, facing, colour, this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].shot():void;");
	}
	
	public void pickUp(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].pickUp();");
		
		//if keypressed....
		this.haveBox = true;
	
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].pickUp():void;");
	}
	public void putDown(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].putDown();");
		
		//if keypressed....
		this.haveBox = false;
	
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].putDown():void;");
	}
	
	public void move(int dx,int dy){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].move();");
		
		//a move() f�ggv�nyt a tesztel�s miatt megv�ltoztattuk
		//most nem mozgatjuk, hanem egyb�l konkr�t cell�ra poz�cion�ljuk
		//ez�rt lett az al�bbi r�sz kikommentezve
		/*
		 * x += dx;
		 * y += dy;
		 */
		
		
		//fontos, hogy
		//a k�vetkez� r�sz, a *32 csak a tesztel�shez sz�ks�ges
		dx = dx * 32;
		dy = dy * 32;
		//////
		
		
		x= dx;
		y= dy;
		
		StarGateGame.tab++;
		LinkedList<Entity> ListofElements = sgg.getList();
		StarGateGame.tab--;
		
		StarGateGame.tab++;
		int CollisionIndexinListofElements = C_Col(this, ListofElements); 
		StarGateGame.tab--;
		
		if(CollisionIndexinListofElements!=0){
			StarGateGame.tab++;
			ListofElements.get(CollisionIndexinListofElements).onCollision(dx, dy, CollisionIndexinListofElements);
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].move():void;");
		
	}
	
	
	public void render(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
	} 

	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getRec():Rectangle;");
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
	public Image colonel_atBox(){
		return this.colonel_atBox;
	}
}





















