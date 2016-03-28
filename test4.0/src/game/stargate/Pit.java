package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pit extends Element{

	public Pit(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Pit].onCollision();");
		
		StarGateGame.tab++;
		c.getSGG().gameover();
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Pit].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getPit(), x*32, y*32, null);
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Pit].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Pit].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
	
}
