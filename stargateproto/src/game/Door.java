package game;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	//private boolean isOpened; nem is haszn�ljuk sehol,
	//a l�ncolt lista seg�ts�g�vel ez lekezel�dik
	//opened: nincs benne a list�ba
	//closed: benne van a list�ba
	//de a class diagram felvittem, h�tha majd k�s�bb m�gis sz�ks�g�nk lesz r�
	//meg jobban kifejez�, hogy egy v�ltoz�val is jelezz�k, hogy nyitva van-e
	
	public Door(int x, int y, Character ch) {
		super(x, y, ch);
	}
	
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].onCollision();");
		
		StarGateGame.tab++;
		character.setX(character.getX()-dx);
		character.setY(character.getY()-dy);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].onCollision():void;");
	}
	
	public void openDoor(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].openDoor();");
		
		//isOpened v�ltoz� �ll�t�sa
		//isOpened = true;
		
		//�s t�rli mag�t a l�ncolt list�b�l
		StarGateGame.tab++;
		ch.getSGG().getList().remove(this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].openDoor():void;");
	}
	
	public void closeDoor(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].closeDoor();");
		
		//isOpened v�ltoz� �ll�t�sa
		//isOpened = false;
		
		//�s berakja mag�t a l�ncolt list�ba
		StarGateGame.tab++;
		ch.getSGG().getList().add(this);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].closeDoor():void;");	
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}
	
}
