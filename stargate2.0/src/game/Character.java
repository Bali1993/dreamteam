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
	//Colonel eset�ben:
	//		PortalOne: k�k port�l		PortalTwo: s�rga port�l
	//Jaffa eset�ben
	//		PortalOne: piros port�l		PortalTwo: 	z�ld port�l
	private int PortalBlue_x;
	private int PortalBlue_y;
	private int PortalYellow_x;
	private int PortalYellow_y;
	private int PortalRed_x;
	private int PortalRed_y;
	private int PortalGreen_x;
	private int PortalGreen_y;
	private String PortalBlue_Facing;
	private String PortalYellow_Facing;
	private String PortalRed_Facing;
	private String PortalGreen_Facing;
	
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
	
	 //bullethez t�roljuk azt az ir�nyt amibe utolj�ra l�pett a Character, hogy arra l�j�n, default "down" lsd. konsruktor
	private String facing; //up, down, left, right
	
	private StarGateGame sgg;
	private Bullet b; // b�r nem is haszn�lja a Character, f�l�sleges elt�rolni referenciak�nt

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
		
		
		//-1-el jelezz�k, hogy nincs m�g port�l nyitva
		this.PortalBlue_x = -1;
		this.PortalBlue_y = -1;
		this.PortalYellow_x = -1;
		this.PortalYellow_y = -1;
		this.PortalRed_x = -1;
		this.PortalRed_y = -1;
		this.PortalGreen_x = -1;
		this.PortalGreen_y = -1;
		PortalBlue_Facing = "nincs m�g port�l";
		PortalYellow_Facing = "nincs m�g port�l";
		PortalRed_Facing = "nincs m�g port�l";
		PortalGreen_Facing = "nincs m�g port�l";
		
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
		
		//Character n�gyzet�t lek�rj�k
		StarGateGame.tab++;
		Rectangle RecOfCharacter = c.getRec();
		StarGateGame.tab--;
		
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem n�gyzete a l�ncolt list�ban
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			//�sszehasonl�tjuk a Character �s adott elem n�gyzet�t, hogy egyezik-e
			//ha igen, akkor �tk�z�s van
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
		//a list�ban a 0. indexen a txt beolvas�sb�l ad�d�an biztos, hogy fal van,
		//amnivel nem tudunk �tk�zni, mert a sarokban van, �s tov�bbi falakkal van k�r�l v�ve
		//ez�rt vissza adhatunk 0-t, ha nem t�rt�nt �tk�z�s
	}
	
	//A Character koordin��tinak lek�rdez�se, be�ll�t�sa
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
	
	//Character Facing-j�nek lek�rdez�se vagy be�ll�t�sa
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
		
		//a move() f�ggv�nyt a tesztel�s miatt megv�ltoztattuk
		//most nem mozgatjuk, hanem egyb�l konkr�t cell�ra poz�cion�ljuk
		//ez�rt lett az al�bbi r�sz kikommentezve
		 x += dx;
		 y += dy;
		 
		
		
		//fontos, hogy
		//a k�vetkez� r�sz, a *32 csak a tesztel�shez sz�ks�ges
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
	
	//Rectangle lek�rdez�se
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
	//SGG lek�rdez�se
	public StarGateGame getSGG(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].getSGG();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Character].getSGG():StarGateGame;");
		return this.sgg;
	}
	

	
	
	//�rdemes ezt a f�ggv�nyt haszn�lni, mert
	//ugyanazon gombbal t�rt�nik a box felv�tele �s lerak�sa (SPACE-el)
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
	
	
	//Box vagy Scale onColl-j�b�l h�v�dik, haveBoxInverter() �ltal
	//sz�ks�ges a listaindex �tad�sa, hogy azon indexen l�v� elemet
	//kiszedj�k a list�b�l
	//de ha a Scale onColl-j�b�l h�v�dik meg, nem szabad t�r�lni, mert a m�rleg van ott
	//ekkor a param�ter �rt�ke -1, ezzel jelezz�k hogy Scale �ltal lett h�vva
	public void pickUp(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Character].pickUp(int IndexinList);");
		
		//Character v�ltoz�j�nak �ll�t�sa
		this.haveBox = true;
		
		//kit�rli mag�t a l�ncolt list�b�l, ha nem a Scale �ltal lett h�vva
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
		
		//Character v�ltoz�j�nak �ll�t�sa
		this.haveBox = false;
		
		//az ezredes maga al� rak egy dobozt
		//berakjuk a dobozt a l�ncolt list�ba egy �t helyett
		//kiv�ve ha m�rlegen �llva h�v�dik a putDown(), mert akkor
		//nem szabad a m�rleg helyett egy dobozt berakni a list�ba
		if(isCalledByScale == false){
			StarGateGame.tab++;
			LinkedList<Entity> lista = sgg.getList();
			//a mez� ahol �llhat egyr�sz �t, illetve
			//m�rlegen �llva teheti le m�g a boxot, amit le kell kezelni a Scale onCollj�b�l.
			lista.add(new Box(x*32, y*32,this)); 
			//utols� param�terk�nt v�r Character-t, StarGateGame-be l�v� ch-t most nem tudjuk �tadni
			//f�l�s egy getter r�, mert igaz�b�l sztem a Box-nak am se kell a ch, hogy onColl-en K�V�L el�rje a list�t
			//sz�val �tadjuk mag�t a Colonelt vagy Jaffa-t this-el
			//x, y: Character aktu�lis koordin�t�i, �gy maga al� rakja a dobozt
			
			//ez a this Character obj. megegyezik az sgg-ben elt�rolt c Character objektummal, mert
			//csak egy Character obj.ot hozunk l�tre
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

	
	public void render(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
	} 
	

	public int getPortalBlue_x() {
		return PortalBlue_x;
	}

	public void setPortalBlue_x(int portalBlue_x) {
		PortalBlue_x = portalBlue_x;
	}

	public int getPortalBlue_y() {
		return PortalBlue_y;
	}

	public void setPortalBlue_y(int portalBlue_y) {
		PortalBlue_y = portalBlue_y;
	}

	public int getPortalYellow_x() {
		return PortalYellow_x;
	}

	public void setPortalYellow_x(int portalYellow_x) {
		PortalYellow_x = portalYellow_x;
	}

	public int getPortalYellow_y() {
		return PortalYellow_y;
	}

	public void setPortalYellow_y(int portalYellow_y) {
		PortalYellow_y = portalYellow_y;
	}

	public int getPortalRed_x() {
		return PortalRed_x;
	}

	public void setPortalRed_x(int portalRed_x) {
		PortalRed_x = portalRed_x;
	}

	public int getPortalRed_y() {
		return PortalRed_y;
	}

	public void setPortalRed_y(int portalRed_y) {
		PortalRed_y = portalRed_y;
	}

	public int getPortalGreen_x() {
		return PortalGreen_x;
	}

	public void setPortalGreen_x(int portalGreen_x) {
		PortalGreen_x = portalGreen_x;
	}

	public int getPortalGreen_y() {
		return PortalGreen_y;
	}

	public void setPortalGreen_y(int portalGreen_y) {
		PortalGreen_y = portalGreen_y;
	}

	public String getPortalBlue_Facing() {
		return PortalBlue_Facing;
	}

	public void setPortalBlue_Facing(String portalBlue_Facing) {
		PortalBlue_Facing = portalBlue_Facing;
	}

	public String getPortalYellow_Facing() {
		return PortalYellow_Facing;
	}

	public void setPortalYellow_Facing(String portaYellow_Facing) {
		PortalYellow_Facing = portaYellow_Facing;
	}

	public String getPortalRed_Facing() {
		return PortalRed_Facing;
	}

	public void setPortalRed_Facing(String portalRed_Facing) {
		PortalRed_Facing = portalRed_Facing;
	}

	public String getPortalGreen_Facing() {
		return PortalGreen_Facing;
	}

	public void setPortalGreen_Facing(String portaGreen_Facing) {
		PortalGreen_Facing = portaGreen_Facing;
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