package game;

import java.awt.Color;
import java.awt.Graphics;

public class Zpm extends Element{

	public Zpm(int x2, int y2) {
		super(x2, y2);
	}

	@Override
	public void onCollision(int dx, int dy, int i, Character character) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].onCollision();");
		
		
		//sgg lekérése
		StarGateGame.tab++;
		StarGateGame VariableForSGG = character.getSGG();
		StarGateGame.tab--;
		
		//ZPM eltávolítása a listából
		StarGateGame.tab++;
		VariableForSGG.getList().remove(i);
		StarGateGame.tab--;
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Zpm].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getZPM(), x*32, y*32, null);
	}
}
