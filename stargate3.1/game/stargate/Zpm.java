package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


public class Zpm extends Element{

	public Zpm(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}

	@Override
	public void onCollision(int dx, int dy, int i) {
		c.sgg.getList().remove(i);
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
	public void onCollisionWithBullet() {
		// TODO Auto-generated method stub
		
	}
	
}
