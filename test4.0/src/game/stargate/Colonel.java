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
	private String yellowPortalFacing;
	private String bluePortalFacing;
	
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
	 * bullethez t�roljuk azt az ir�nyt amibe utolj�ra l�pett a colonel, hogy arra l�j�n, default "down" lsd. konsruktor
	 */
	private String facing; //up, down, left, right
	
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
		
		
		//rendes j�t�khoz:
		//-1-el jelezz�k, hogy nincs m�g port�l nyitva
		/*this.x_yellow = -1;
		this.y_yellow = -1;
		this.x_blue = -1;
		this.y_blue = -1;
		yellowPortalFacing = "nincs m�g port�l";
		bluePortalFacing = "nincs m�g port�l";
		*/
		//tesztel�shez el�felt�telek biztos�t�sa:
		//s�rga port�l l�trehoztunk m�r a txt-b�l �s abba megy�nk bele �s teleport�lni akarunk
		//k�k port�lt nem hozzuk l�tre a txt-b�l csak itt be�ll�tjuk a Coloneln�l az �rt�keket
		this.x_blue = 15;
		this.y_blue = 15;
		this.bluePortalFacing = "left";
		
		
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
	
	
	//mivel onCollision-re m�k�dik minden, ez�rt
	//abba maradtunk, hogy a Wall hozza l�tre a Portalt, ha a l�ved�k speci�lis falat �r,
	//nem pedig maga a l�ved�k, ez�rt
	//a Wall-nak tudnia kell, hogy mi a Bullet dir v�ltoz�j�nak �rt�ke �s
	//annak ellentetj�t �tadni a Portal-nak
	public Bullet getBullet(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getBullet();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getBullet():Bullet;");
		return b;
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
	
	public void shoot(String colour){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].shot();");
		
		StarGateGame.tab++;
		//ez a this Colonel obj. megegyezik az sgg-ben elt�rolt c Colonel objektummal, mert
		//csak egy Colonel obj.ot hozunk l�tre
		//right?
		b = new Bullet(x, y, facing, colour, this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].shot():void;");
	}
	
	
	//Box vagy Scale onColl-j�b�l h�v�dik, haveBoxInverter() �ltal
	//sz�ks�ges a listaindex �tad�sa, hogy azon indexen l�v� elemet
	//kiszedj�k a list�b�l
	//de ha a Scale onColl-j�b�l h�v�dik meg, nem szabad t�r�lni, mert a m�rleg van ott
	//ekkor a param�ter �rt�ke -1, ezzel jelezz�k hogy Scale �ltal lett h�vva
	public void pickUp(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].pickUp(int IndexinList);");
		
		//Colonel v�ltoz�j�nak �ll�t�sa
		this.haveBox = true;
		
		//kit�rli mag�t a l�ncolt list�b�l, ha nem a Scale �ltal lett h�vva
		if(IndexinList != -1){
			StarGateGame.tab++;
			LinkedList<Entity> lista = getSGG().getList();
			lista.remove(IndexinList);
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].pickUp(int IndexinList):void;");
	}
	
	
	public void putDown(boolean isCalledByScale){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].putDown(boolean isCalledByScale);");
		
		//Colonel v�ltoz�j�nak �ll�t�sa
		this.haveBox = false;
		
		//az ezredes maga al� rak egy dobozt
		//berakjuk a dobozt a l�ncolt list�ba egy �t helyett
		//kiv�ve ha m�rlegen �llva h�v�dik a putDown(), mert akkor
		//nem szabad a m�rleg helyett egy dobozt berakni a list�ba
		if(isCalledByScale == false){
			StarGateGame.tab++;
			LinkedList<Entity> lista = getSGG().getList();
			//a mez� ahol �llhat egyr�sz �t, de az sincs a list�ba
			//m�rlegen �llva teheti le m�g a boxot, azt m�g le is birjuk kezelni Scale onCollj�b�l.
			lista.add(new Box(x*32, y*32, this));
			//x, y: Colonel aktu�lis koordin�t�i, �gy maga al� rakja a dobozt
			
			//ez a this Colonel obj. megegyezik az sgg-ben elt�rolt c Colonel objektummal, mert
			//csak egy Colonel obj.ot hozunk l�tre
			//right?
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].putDown(boolean isCalledByScale):void;");
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
	
	
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
	
	public String getyellowPortalFacing(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getyellowPortalFacing();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getyellowPortalFacing();");
		return yellowPortalFacing;
	}
	
	public String getbluePortalFacing(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getbluePortalFacing();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getbluePortalFacing();");
		return bluePortalFacing;
	}
	
	
	//�rdemes ezt a f�ggv�nyt haszn�lni, mert
	//ugyanazon gombbal t�rt�nik a box felv�tele �s lerak�sa (SPACE-el)
	public void haveBoxInverter(int indexinList, boolean isCalledByScale){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].haveBoxInverter(int indexinList, boolean isCalledByScale);");
		
		if(haveBox == false){
			StarGateGame.tab++;
			pickUp(indexinList);
			StarGateGame.tab--;
		}
		else{
			StarGateGame.tab++;
			putDown(isCalledByScale);
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].haveBoxInverter(int indexinList, boolean isCalledByScale):void;");
	}
	
	public boolean gethaveBox(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].gethaveBox();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].gethaveBox():boolean;");
		return haveBox;
	}
	
	
	public int getzpmCounter(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].getzpmCounter();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].getzpmCounter():int;");
		return zpmCounter;
	}
	
	public void setzpmCounter(int i){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].setzpmCounter();");
		
		zpmCounter = zpmCounter + i;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].setzpmCounter():void;");
	}
	
	//FONTOS: ez csak a tesztel�shez kell, hogy biztos�tani tudjuk az el�felt�teleket !!!!!!!
	//haveBox v�ltoz� be�ll�t�s�t elv�gzi a putDown(), pickUp()
	public boolean sethaveBox(boolean haveBox){
		//nev�t nem irjuk ki, mert csak tesztel�shez kell
		return this.haveBox = haveBox;
	}
	
	public void render(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
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





















