package game;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	//private boolean isOpened; nem is haszn�ljuk sehol,
	//a l�ncolt lista seg�ts�g�vel ez lekezel�dik
	//opened: nincs benne a list�ba
	//closed: benne van a list�ba
	
	Character ch;
	
	public Door(int x2, int y2, Character ch) {
		super(x2, y2);
		this.ch = ch;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i, game.Character character) {
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
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
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
	
}
