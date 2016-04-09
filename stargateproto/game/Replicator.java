package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import ntrfc.Entity;

public class Replicator{
	private int x;
	private int y;
	private Character ch;
	private boolean isAlive;
	
	public Replicator(Character ch){
		x = 224; y = 640; 
		//x=32;y=384;
		this.ch = ch;
		isAlive = true;
	}
	
	
	public int C_Rep(Replicator r, LinkedList<Entity> ll){
		//Replicator n�gyzet�t lek�rj�k
		Rectangle RecOfReplicator = r.getRec();
		
		for(int i=0; i < ll.size(); ++i)
		{	
			//adott elem n�gyzete a l�ncolt list�ban
			Rectangle RecOfElement = ll.get(i).getRec();
			
			//�sszehasonl�tjuk a Replicator �s adott elem n�gyzet�t, hogy egyezik-e
			//ha igen, akkor �tk�z�s van
			if(RecOfReplicator.intersects(RecOfElement)){ 
				return i;
			}
			
		}
			
		return 0; //0 if no collision
	}
	
	public void move(){
		//V�letlenszer� mozg�s a p�ly�n
		x += 32;
		
		LinkedList<Entity> ListofElements = ch.getSGG().getList();
		
		int CollisionIndexinListofElements = C_Rep(this, ListofElements); 
		
		
		if(CollisionIndexinListofElements!=0){
			int dx = 32; int dy = 0; //mert folyamatosan megy jobbra, az most a random mozg�s
			ListofElements.get(CollisionIndexinListofElements).onCollisionWithReplicator(dx, dy, this);
		}
	}
	
	//megsemmisiti �nmag�t, ha szakad�kba l�p
	//Pit oszt�ly h�vja, ha onColl-ja aktiv�l�dik azaz �tk�z�s t�rt�nik
	public void destroy(){
		isAlive = false;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public Rectangle getRec(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public boolean getisAlive(){
		return isAlive;
	}
	
	public void render(Graphics g){
		//replik�tor �l
		if(isAlive == true){
		g.setColor(Color.YELLOW);
		g.fillRect(this.x,this.y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(this.x,this.y, 32, 32);
		}
		
		//replik�tor megsemmis�lt
		if(isAlive == false){
			g.setColor(Color.WHITE);
			g.fillRect(this.x,this.y, 32, 32);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(this.x,this.y, 32, 32);
		}
	}

}
