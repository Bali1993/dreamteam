package game;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	//private boolean isOpened; nem is használjuk sehol,
	//a láncolt lista segítségével ez lekezelõdik
	//opened: nincs benne a listába
	//closed: benne van a listába
	//de a class diagram felvittem, hátha majd késõbb mégis szükségünk lesz rá
	//meg jobban kifejezõ, hogy egy változóval is jelezzük, hogy nyitva van-e
	
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
		
		//isOpened változó állítása
		//isOpened = true;
		
		//és törli magát a láncolt listából
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
		
		//isOpened változó állítása
		//isOpened = false;
		
		//és berakja magát a láncolt listába
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
