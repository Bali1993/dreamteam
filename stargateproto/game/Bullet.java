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
	private Character character; //melyik karakter hozta l�tre a l�ved�ket
	
	
	public Bullet(int x, int y, String facing, String colour, Character character) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Bullet].Bullet();");
		
		this.x = x;
		this.y = y;
		this.dir = facing;
		this.character = character;
		this.colour = colour;
		
		//ahogy l�trehoz�dik a l�ved�k, el is inditjuk az �tj�ra
		StarGateGame.tab++;
		this.move(dir);
		StarGateGame.tab--;
		
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
		System.out.println("<- [:Bullet].getBulletdir:String;");
		return dir;
	}
	
	//Wallnak van r� sz�ks�ge, port�l nyit�s miatt
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
			if(RecOfBullet.intersects(RecOfElement)){ //ez kell majd a rendes j�t�khoz !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
				
			}
			//i == 2 csak tesztel�s miatt van !!! if(RecOfBullet.intersects(RecOfElement)) kell majd a rendes j�t�khoz
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
		//a mozg�st vhogy meg k�ne val�s�tani, mondjuk egy id�zit�vel l�ptetni dir ir�nyban x, y koordin�t�kat
		//�s �tk�z�s eset�n onCollsisionWithBullet()-et h�vni
	
		//mivel nem akarunk t�bbsz�l� programoz�st, ez�rt
		//mig mozog a l�ved�k, az ezredest nem tudjuk mozgatni
		
		//vagy esetleg ugy lehetne megoldani a mozg�s�t, mint a replik�tornak, hogy b�rmilyen bill. le�t�sre mozog
		//�s akkor nem a konstruktorb�l k�ne el�nditani
		
		//while(){ amig nem �tk�zik akad�lyba a l�ved�k, n�velj�k koordin�t�j�t �s �tk�z�svizsg�lat
			
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
			
		//} while v�ge
			
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Bullet].move():void;");
	}
	
	public void render(Graphics g){
		
	}

}
