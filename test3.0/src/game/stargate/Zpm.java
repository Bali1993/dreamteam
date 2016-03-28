package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Zpm extends Element{

	public Zpm(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}

	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].onCollision();");
		
		
		
		//sgg lekérése
		StarGateGame.tab++;
		StarGateGame VariableForSGG = c.getSGG();
		StarGateGame.tab--;
		
		//ZPM eltávolítása a listából
		StarGateGame.tab++;
		VariableForSGG.getList().remove(i);
		StarGateGame.tab--;
		
		//most a tesztelés miatt feltételezzük, hogy összeszedtük az összes ZPM-et, tehát nyertünk
		//egyébként if(c.zpmCounter == 5)... vizsgálat kellene
		StarGateGame.tab++;
		VariableForSGG.win();
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
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Zpm].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
