package game.stargate;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends Elements{

	public Box(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		//TODO
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
	
}
