package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import ntrfc.Entity;

public class Bullet{
	private int x;
	private int y;
	private String dir;
	private String colour;
	private Character character; //melyik karakter hozta létre a lövedéket
	
	
	public Bullet(int x, int y, String facing, String colour, Character character) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].Bullet();");
		
		this.x = x;
		this.y = y;
		this.dir = facing;
		this.character = character;
		this.colour = colour;
		
		//ahogy létrehozódik a lövedék, el is inditjuk az útjára
		StarGateGame.tab++;
		this.move(dir);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].Bullet();");
	}

	//Wallnak van rá szüksége, portál nyitás miatt
	public String getBulletdir(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletdir();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].getBulletdir:String;");
		return dir;
	}
	
	//Wallnak van rá szüksége, portál nyitás miatt
	public String getBulletcolour(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletcolour();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].getBulletcolour:String();");
		return colour;
	}
	
	
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
	public int Coll_Bullet(Bullet b, LinkedList<Entity> ll){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].C_Bul(Bullet b, LinkedList<Entity> ll);");
		
		//Bullet négyzetét lekérjük
		StarGateGame.tab++;
		Rectangle RecOfBullet = b.getRec();
		StarGateGame.tab--;
				
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem négyzete a láncolt listában
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			
			//összehasonlítjuk a Bullet és adott elem négyzetét, hogy egyezik-e
			//ha igen, akkor ütközés van
			if(RecOfBullet.intersects(RecOfElement)){ //ez kell majd a rendes játékhoz !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
				
			}
			//i == 2 csak tesztelés miatt van !!! if(RecOfBullet.intersects(RecOfElement)) kell majd a rendes játékhoz
			if(i == 2){
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Bullet].C_Bul(Bullet b, LinkedList<Entity> ll):int;");
				return i;   //index of element in list
			}
			
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].C_Bul(Bullet b, LinkedList<Entity> ll):int;");		
		return 0; //0 if no collision
	}
	
	
	public void move(String dir){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].move();");
		
		//T   O         D O:
		//a mozgást vhogy meg kéne valósítani, mondjuk egy idõzitõvel léptetni dir irányban x, y koordinátákat
		//és ütközés esetén onCollsisionWithBullet()-et hívni
	
		//mivel nem akarunk többszálú programozást, ezért
		//mig mozog a lövedék, az ezredest nem tudjuk mozgatni
		
		//vagy esetleg ugy lehetne megoldani a mozgását, mint a replikátornak, hogy bármilyen bill. leütésre mozog
		//és akkor nem a konstruktorból kéne elínditani
		
		//while(){ amig nem ütközik akadályba a lövedék, növeljük koordinátáját és ütközésvizsgálat
			
			StarGateGame.tab++;
			LinkedList<Entity> ListofElements = character.getSGG().getList();
			StarGateGame.tab--;
			
			StarGateGame.tab++;
			int CollisionIndexinListofElements = Coll_Bullet(this, ListofElements); 
			StarGateGame.tab--;
			
			if(CollisionIndexinListofElements!=0){
				StarGateGame.tab++;
				ListofElements.get(CollisionIndexinListofElements).onCollisionWithBullet(this);
				StarGateGame.tab--;
			}
			
		//} while vége
			
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].move():void;");
	}
	
	public void render(Graphics g){
		
	}

}
