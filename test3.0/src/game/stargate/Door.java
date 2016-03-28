package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Door extends Element{

	//private boolean isOpened; nem is haszn�ljuk sehol,
	//a l�ncolt lista seg�ts�g�vel ez lekezel�dik
	//opened: benne van a list�ba
	//closed: nincs benne
	
	public Door(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].onCollision();");
		
		StarGateGame.tab++;
		c.setX(c.getX()-dx);
		c.setY(c.getY()-dy);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}
	
	public void openDoor(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].openDoor();");
		
		//isOpened v�ltoz� �ll�t�sa
		//isOpened = true;
		//�s t�rli mag�t a l�ncolt list�b�l
		StarGateGame.tab++;
		c.getSGG().getList().remove(IndexinList);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].openDoor():void;");
	}
	
	public void closeDoor(int IndexinList){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].closeDoor();");
		
		//isOpened v�ltoz� �ll�t�sa
		//isOpened = false;
		//�s berakja mag�t a l�ncolt list�ba
		StarGateGame.tab++;
		c.getSGG().getList().add(IndexinList, this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].closeDoor():void;");	
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
}
