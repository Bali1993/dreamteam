package game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.LinkedList;
//majd a grafikushoz
//import java.awt.Image;
//import javax.swing.ImageIcon;

import ntrfc.Entity;

public class Character{	
	private int x;
	private int y;
	
	//FONTOS:
	//Colonel esetében:
	//		PortalOne: kék portál		PortalTwo: sárga portál
	//Jaffa esetében
	//		PortalOne: piros portál		PortalTwo: 	zöld portál
	private int PortalOne_x;
	private int PortalOne_y;
	private int PortalTwo_x;
	private int PortalTwo_y;
	private String PortalOne_Facing;
	private String PortalTwo_Facing;
	
	private boolean haveBox;
	private int zpmCounter;
	
	private int weight;
	private boolean isAlive;
	
	//majd a grafikushoz
	/*
	private Image character_U;
	private Image character_D;
	private Image character_L;
	private Image character_R;
	private Image character_atBox;
	private Image character_U_Box;
	private Image character_D_Box;
	private Image character_L_Box;
	private Image character_R_Box;
	*/
	
	 //bullethez tároljuk azt az irányt amibe utoljára lépett a Character, hogy arra lõjön, default "down" lsd. konsruktor
	private String facing; //up, down, left, right
	
	private StarGateGame sgg;
	private Bullet b; // bár nem is használja a Character, fölösleges eltárolni referenciaként

	public Character(StarGateGame g, int x, int y){
		//majd a grafikushoz
		/*
		ImageIcon img = new ImageIcon();
		character_U = img.getImage();
		img = new ImageIcon();
		character_D = img.getImage();
		img = new ImageIcon();
		character_L = img.getImage();
		img = new ImageIcon();
		character_R = img.getImage();
		img = new ImageIcon();
		character_atBox = img.getImage();
		img = new ImageIcon();
		character_U_Box = img.getImage();
		img = new ImageIcon();
		character_D_Box = img.getImage();
		img = new ImageIcon();
		character_L_Box = img.getImage();
		img = new ImageIcon();
		character_R_Box = img.getImage();
		*/
		
		
		//-1-el jelezzük, hogy nincs még portál nyitva
		this.PortalOne_x = -1;
		this.PortalOne_y = -1;
		this.PortalTwo_x = -1;
		this.PortalTwo_y = -1;
		PortalOne_Facing = "nincs még portál";
		PortalTwo_Facing = "nincs még portál";
		
		this.haveBox = false;
		this.facing = "down";
		this.zpmCounter = 0;
		
		this.weight = 50;
		this.isAlive = true;
		
		this.sgg = g;
		this.x = x;
		this.y = y;
	}

	public int Coll_Character(Character c, LinkedList<Entity> ll){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].C_Col(Character e, LinkedList<Entity> ll);");
		
		//Character négyzetét lekérjük
		StarGateGame.tab++;
		Rectangle RecOfCharacter = c.getRec();
		StarGateGame.tab--;
		
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem négyzete a láncolt listában
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			//összehasonlítjuk a Character és adott elem négyzetét, hogy egyezik-e
			//ha igen, akkor ütközés van
			if(RecOfCharacter.intersects(RecOfElement)){
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Character].C_Col(Character e, LinkedList<Entity> ll):int;");
				return i;   //index of element in list
			}
			
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].C_Col(Character e, LinkedList<Entity> ll):int;");
		return 0;
		//0 if no collision
		//a listában a 0. indexen a txt beolvasásból adódóan biztos, hogy fal van,
		//amnivel nem tudunk ütközni, mert a sarokban van, és további falakkal van körül véve
		//ezért vissza adhatunk 0-t, ha nem történt ütközés
	}
	
	//A Character koordináátinak lekérdezése, beállítása
	public int getX(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getX();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getX():int;");
		return this.x;
	}
	public int getY(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getY();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getY():int;");
		return this.y;
	}
	
	public void setX(int x2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].setX(int x2);");
		
		this.x = x2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].setX(int x2):void;");
	}
	public void setY(int y2){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].setY(int y2);");
		
		this.y = y2;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].setY(int y2):void;");
	}
	
	//Character Facing-jének lekérdezése vagy beállítása
	public String getFacing(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getFacing();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getFacing():String;");
		return facing;
	}
	public void setFacing(String s){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].setFacing();");
		
		this.facing = s;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].setFacing():void;");
	}
	

	public void shoot(String colour){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].shoot();");
		
		StarGateGame.tab++;
		b = new Bullet(x, y, facing, colour, this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].shoot():void;");
	}
	
	
	
	public void move(int dx,int dy){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].move();");
		
		//a move() függvényt a tesztelés miatt megváltoztattuk
		//most nem mozgatjuk, hanem egybõl konkrét cellára pozícionáljuk
		//ezért lett az alábbi rész kikommentezve
		 x += dx;
		 y += dy;
		 
		
		
		//fontos, hogy
		//a következõ rész, a *32 csak a teszteléshez szükséges
		//dx = dx * 32;
		//dy = dy * 32;
		// ez is csak teszthez
		//x= dx;
		//y= dy;
		
		StarGateGame.tab++;
		LinkedList<Entity> ListofElements = sgg.getList();
		StarGateGame.tab--;
		
		StarGateGame.tab++;
		int CollisionIndexinListofElements = Coll_Character(this, ListofElements); 
		StarGateGame.tab--;
		
		if(CollisionIndexinListofElements!=0){
			StarGateGame.tab++;
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithCharacter(this, dx, dy);
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].move():void;");
		
	}
	
	//Rectangle lekérdezése
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
	//SGG lekérdezése
	public StarGateGame getSGG(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getSGG();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getSGG():StarGateGame;");
		return this.sgg;
	}
	
	//Portálok koordinátáival kapcsolatos metódusok:
	public int getPortalOne_x(){
		return PortalOne_x;
	}
	public int getPortalOne_y(){
		return PortalOne_y;	
	}
	public void setPortalOne_x(int x){
		this.PortalOne_x = x;
	}
	public void setPortalOne_y(int y){
		this.PortalOne_y = y;
	}
	public int getPortalTwo_x(){
		return PortalTwo_x;
	}
	public int getPortalTwo_y(){
		return PortalTwo_y;	
	}
	public void setPortalTwo_x(int x){
		this.PortalTwo_x = x;
	}
	public void setPortalTwo_y(int y){
		this.PortalTwo_y = y;
	}
	
	//Portálok Facing-jével kapcsolatos metódusok:
	public String getPortalOne_Facing(){
		return PortalOne_Facing;
	}
	public void setPortalOne_Facing(String facing){
		this.PortalOne_Facing = facing;
	}
	public String getPortalTwo_Facing(){
		return PortalTwo_Facing;
	}
	public void setPortalTwo_Facing(String facing){
		this.PortalTwo_Facing = facing;
	}
	
	
	//érdemes ezt a függvényt használni, mert
	//ugyanazon gombbal történik a box felvétele és lerakása (SPACE-el)
	public void haveBoxInverter(int indexinList, boolean isCalledByScale){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].haveBoxInverter(int indexinList, boolean isCalledByScale);");
		
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
		System.out.println("<- [:Character].haveBoxInverter(int indexinList, boolean isCalledByScale):void;");
	}
	
	
	//Box vagy Scale onColl-jébõl hívódik, haveBoxInverter() által
	//szükséges a listaindex átadása, hogy azon indexen lévõ elemet
	//kiszedjük a listából
	//de ha a Scale onColl-jébõl hívódik meg, nem szabad törölni, mert a mérleg van ott
	//ekkor a paraméter értéke -1, ezzel jelezzük hogy Scale által lett hívva
	public void pickUp(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].pickUp(int IndexinList);");
		
		//Character változójának állítása
		this.haveBox = true;
		
		//kitörli magát a láncolt listából, ha nem a Scale által lett hívva
		if(IndexinList != -1){
			StarGateGame.tab++;
			LinkedList<Entity> lista = sgg.getList();
			lista.remove(IndexinList);
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].pickUp(int IndexinList):void;");
	}
	
	
	public void putDown(boolean isCalledByScale){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].putDown(boolean isCalledByScale);");
		
		//Character változójának állítása
		this.haveBox = false;
		
		//az ezredes maga alá rak egy dobozt
		//berakjuk a dobozt a láncolt listába egy út helyett
		//kivéve ha mérlegen állva hívódik a putDown(), mert akkor
		//nem szabad a mérleg helyett egy dobozt berakni a listába
		if(isCalledByScale == false){
			StarGateGame.tab++;
			LinkedList<Entity> lista = sgg.getList();
			//a mezõ ahol állhat egyrész út, illetve
			//mérlegen állva teheti le még a boxot, amit le kell kezelni a Scale onColljébõl.
			lista.add(new Box(x*32, y*32,this)); 
			//utolsó paraméterként vár Character-t, StarGateGame-be lévõ ch-t most nem tudjuk átadni
			//fölös egy getter rá, mert igazából sztem a Box-nak am se kell a ch, hogy onColl-en KÍVÜL elérje a listát
			//szóval átadjuk magát a Colonelt vagy Jaffa-t this-el
			//x, y: Character aktuális koordinátái, így maga alá rakja a dobozt
			
			//ez a this Character obj. megegyezik az sgg-ben eltárolt c Character objektummal, mert
			//csak egy Character obj.ot hozunk létre
			//right?
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].putDown(boolean isCalledByScale):void;");
	}
	
	public boolean gethaveBox(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].gethaveBox();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].gethaveBox():boolean;");
		return haveBox;
	}
	
	public int getzpmCounter(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getzpmCounter();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getzpmCounter():int;");
		return zpmCounter;
	}
	
	public void setzpmCounter(int i){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].setzpmCounter();");
		
		zpmCounter = zpmCounter + i;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].setzpmCounter():void;");
	}
	
	public boolean getisAlive(){
		return isAlive;
	}
	
	public void setisAlive(boolean isAlive){
		this.isAlive = isAlive;
	}

	
	public void render(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
	} 
	
	
	//majd a grafikushoz
	/*
	public Image getCharacter_up(){
		return this.character_U;
	}
	public Image getCharacter_down(){
		return this.character_D;
	}
	public Image getCharacter_left(){
		return this.character_L;
	}
	public Image getCharacter_right(){
		return this.character_R;
	}
	public Image getCharacter_up_box(){
		return this.character_U_Box;
	}
	public Image getCharacter_down_box(){
		return this.character_D_Box;
	}
	public Image getCharacter_left_box(){
		return this.character_L_Box;
	}
	public Image getCharacter_right_box(){
		return this.character_R_Box;
	}
	public Image Character_atBox(){
		return this.character_atBox;
	}
	*/
}