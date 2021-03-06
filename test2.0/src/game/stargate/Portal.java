package game.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Portal extends Element{
	
	private String colour;
	private String facing;
	public Portal(int x2, int y2, Colonel c, String colour, String facing) {
		super(x2, y2, c);
		
		this.colour = colour;
		this.facing = facing;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Portal].onCollision();");
		
		
		// TODO Auto-generated method stub
		

		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Portal].onCollision():void;");
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Portal].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Portal].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
