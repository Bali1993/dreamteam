package game.stargate;

import java.awt.Color;
import java.awt.Graphics;

public class Pit extends Element{

	public Pit(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	@Override
	public void onCollision(int dx, int dy, int i) {
		//TODO
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getPit(), x*32, y*32, null);
	}
	
}
