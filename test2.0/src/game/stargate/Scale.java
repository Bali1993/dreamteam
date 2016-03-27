package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Scale extends Element{
	
	private Door d;
	private boolean isPressed;
	private boolean pressedByBox;
	
	public Scale(int x2, int y2, Colonel c, Door d) {
		super(x2, y2, c);
		this.d = d;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].onCollision();");
		
		//TODO
		//opendoor, closedoor meghívása
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Scale].onCollision():void;");
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}

	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Scale].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
