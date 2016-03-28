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
	 * bullethez tároljuk azt az irányt amibe utoljára lépett a colonel, hogy arra lõjön, default "down" lsd. konsruktor
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
		
		
		//rendes játékhoz:
		//-1-el jelezzük, hogy nincs még portál nyitva
		/*this.x_yellow = -1;
		this.y_yellow = -1;
		this.x_blue = -1;
		this.y_blue = -1;
		yellowPortalFacing = "nincs még portál";
		bluePortalFacing = "nincs még portál";
		*/
		//teszteléshez elõfeltételek biztosítása:
		//sárga portál létrehoztunk már a txt-bõl és abba megyünk bele és teleportálni akarunk
		//kék portált nem hozzuk létre a txt-bõl csak itt beállítjuk a Colonelnél az értékeket
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
		
		//Colonel négyzetét lekérjük
		StarGateGame.tab++;
		Rectangle RecOfColonel = e.getRec();
		StarGateGame.tab--;
		
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem négyzete a láncolt listában
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			
			//összehasonlítjuk a Colonel és adott elem négyzetét, hogy egyezik-e
			//ha igen, akkor ütközés van
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
		//a listában a 0. indexen a txt beolvasásból adódóan biztos, hogy fal van,
		//amnivel nem tudunk ütközni, mert a sarokban van, és további falakkal van körül véve
		//ezért vissza adhatunk 0-t, ha nem történt ütközés
	}
	
	/*
	 * ezt a függvényt hívjuk meg a cntrl osztályban, és itt nézem egyelõre a collisiont, mert még csak a falra vizsgáljuk
	 * ha ütközik akkor egyszerûen visszalép, egyébként a collision feltételként bárhol vizsgálhatjuk, csk még nem látom át h hogyan
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
	
	
	//mivel onCollision-re müködik minden, ezért
	//abba maradtunk, hogy a Wall hozza létre a Portalt, ha a lövedék speciális falat ér,
	//nem pedig maga a lövedék, ezért
	//a Wall-nak tudnia kell, hogy mi a Bullet dir változójának értéke és
	//annak ellentetjét átadni a Portal-nak
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
		//ez a this Colonel obj. megegyezik az sgg-ben eltárolt c Colonel objektummal, mert
		//csak egy Colonel obj.ot hozunk létre
		//right?
		b = new Bullet(x, y, facing, colour, this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Colonel].shot():void;");
	}
	
	
	//Box vagy Scale onColl-jébõl hívódik, haveBoxInverter() által
	//szükséges a listaindex átadása, hogy azon indexen lévõ elemet
	//kiszedjük a listából
	//de ha a Scale onColl-jébõl hívódik meg, nem szabad törölni, mert a mérleg van ott
	//ekkor a paraméter értéke -1, ezzel jelezzük hogy Scale által lett hívva
	public void pickUp(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Colonel].pickUp(int IndexinList);");
		
		//Colonel változójának állítása
		this.haveBox = true;
		
		//kitörli magát a láncolt listából, ha nem a Scale által lett hívva
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
		
		//Colonel változójának állítása
		this.haveBox = false;
		
		//az ezredes maga alá rak egy dobozt
		//berakjuk a dobozt a láncolt listába egy út helyett
		//kivéve ha mérlegen állva hívódik a putDown(), mert akkor
		//nem szabad a mérleg helyett egy dobozt berakni a listába
		if(isCalledByScale == false){
			StarGateGame.tab++;
			LinkedList<Entity> lista = getSGG().getList();
			//a mezõ ahol állhat egyrész út, de az sincs a listába
			//mérlegen állva teheti le még a boxot, azt még le is birjuk kezelni Scale onColljébõl.
			lista.add(new Box(x*32, y*32, this));
			//x, y: Colonel aktuális koordinátái, így maga alá rakja a dobozt
			
			//ez a this Colonel obj. megegyezik az sgg-ben eltárolt c Colonel objektummal, mert
			//csak egy Colonel obj.ot hozunk létre
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
		
		//a move() függvényt a tesztelés miatt megváltoztattuk
		//most nem mozgatjuk, hanem egybõl konkrét cellára pozícionáljuk
		//ezért lett az alábbi rész kikommentezve
		/*
		 * x += dx;
		 * y += dy;
		 */
		
		
		//fontos, hogy
		//a következõ rész, a *32 csak a teszteléshez szükséges
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
	
	
	//érdemes ezt a függvényt használni, mert
	//ugyanazon gombbal történik a box felvétele és lerakása (SPACE-el)
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
	
	//FONTOS: ez csak a teszteléshez kell, hogy biztosítani tudjuk az elõfeltételeket !!!!!!!
	//haveBox változó beállítását elvégzi a putDown(), pickUp()
	public boolean sethaveBox(boolean haveBox){
		//nevét nem irjuk ki, mert csak teszteléshez kell
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





















