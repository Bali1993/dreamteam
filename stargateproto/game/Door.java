package game;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	private boolean isOpened;
	//csinálhatnánk azt is h a láncolt lista segítségével lekezeljük
	//opened: nincs benne a listába
	//closed: benne van a listába
	//ez azért nem jó mert random zpm generálódhat az ajtó helyére, mig nyitva van, szóval maradjon az isOpened változó állítása
	//a láncolt listában pedig mindig benne marad az ajtó
	
	public Door(int x, int y, Character ch) {
		super(x, y, ch);
		isOpened = false;
	}
	
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Door].onCollision();");
		
		StarGateGame.tab++;
		//ha nincs nyitva az ajtó, akkor lepattanunk róla, különben nem történik semmi
		if(isOpened == false){
			character.setX(character.getX()-dx);
			character.setY(character.getY()-dy);
		}
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
		StarGateGame.tab++;
		isOpened = true;
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
		StarGateGame.tab++;
		isOpened = false;
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Door].closeDoor():void;");	
	}
	
	@Override
	public void render(Graphics g){
		if(isOpened == false){
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
		}
		
		if(isOpened == true){
			g.setColor(Color.WHITE);
			g.fillRect(this.x,this.y, 32, 32);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(this.x,this.y, 32, 32);
		}
	}
	
}
