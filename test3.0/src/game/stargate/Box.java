package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends Element{

	public Box(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Box].onCollision();");
		
		//TODO
		//pickUp() implementálása
		//itt is karakter olvasás kell
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].onCollision():void;");
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Box].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
