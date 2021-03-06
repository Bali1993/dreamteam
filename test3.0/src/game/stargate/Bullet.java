package game.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Bullet{
	private int x;
	private int y;
	private String dir;
	private String colour;
	private Colonel c;
	
	
	public Bullet(int x2, int y2, String facing, String colour, Colonel c) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].Bullet();");
		
		this.x = x2;
		this.y = y2;
		this.dir = c.getFacing();
		this.c = c;
		this.colour = colour;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].Bullet();");
	}

	//Wallnak van r� sz�ks�ge, port�l nyit�s miatt
	public String getBulletdir(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletdir();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletdir:String;");
		return dir;
	}
	
	//Wallnak van r� sz�ks�ge, port�l nyit�s miatt
	public String getBulletcolour(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletcolour();");
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].getBulletcolour:String();");
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
	
	public int C_Bul(Bullet b, LinkedList<Entity> ll){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].C_Bul(Bullet b, LinkedList<Entity> ll);");
		
		//Bullet n�gyzet�t lek�rj�k
		StarGateGame.tab++;
		Rectangle RecOfBullet = b.getRec();
		StarGateGame.tab--;
				
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem n�gyzete a l�ncolt list�ban
			StarGateGame.tab++;
			Rectangle RecOfElement = ll.get(i).getRec();
			StarGateGame.tab--;
			
			//�sszehasonl�tjuk a Bullet �s adott elem n�gyzet�t, hogy egyezik-e
			//ha igen, akkor �tk�z�s van
			if(RecOfBullet.intersects(RecOfElement)){
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Bullet].C_Col(Bullet b, LinkedList<Entity> ll):int;");
				return i;   //index of element in list
			}
			
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].C_Bul(Bullet b, LinkedList<Entity> ll):int;");		
		return 0; //0 if no collision
	}
	
	public void render(Graphics g){
		
	}
	
	public void move(String dir){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].move();");
		
		//T   O         D O:
		//a mozg�st vhogy meg k�ne val�s�tani, mondjuk egy id�zit�vel l�ptetni dir ir�nyban x, y koordin�t�kat
		//�s �tk�z�s eset�n onCollsisionWithBullet()-et h�vni
	
		//mivel nem akarunk t�bbsz�l� programoz�st, ez�rt
		//mig mozog a l�ved�k, az ezredest nem tudjuk mozgatni
		
		//while(){ amig nem �tk�zik akad�lyba a l�ved�k, n�velj�k koordin�t�j�t �s �tk�z�svizsg�lat
			
			StarGateGame.tab++;
			LinkedList<Entity> ListofElements = c.getSGG().getList();
			StarGateGame.tab--;
			
			StarGateGame.tab++;
			int CollisionIndexinListofElements = C_Bul(this, ListofElements); 
			StarGateGame.tab--;
			
			if(CollisionIndexinListofElements!=0){
				StarGateGame.tab++;
				ListofElements.get(CollisionIndexinListofElements).onCollisionWithBullet(CollisionIndexinListofElements);
				StarGateGame.tab--;
			}
			
		//} while v�ge
			
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].move():void;");
	}

}
