package game.stargate;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Elements{
	
	private Door d;
	
	public Scale(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	@Override
	public void onCollision(int dx, int dy, int i) {
		//TODO
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}
	
	public void openDoor(){
		
	}

}
