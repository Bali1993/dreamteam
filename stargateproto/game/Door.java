package game;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	//private boolean isOpened; nem is használjuk sehol,
	//a láncolt lista segítségével ez lekezelõdik
	//opened: nincs benne a listába
	//closed: benne van a listába
	
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
	
}
