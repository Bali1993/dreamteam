package game.stargate;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Element{
	
	private Door d;
	
	public Scale(int x2, int y2, Colonel c, Door d) {
		super(x2, y2, c);
		this.d = d;
	}
	@Override
	public void onCollision(int dx, int dy, int i) {
		//TODO
		
		//opendoor, closedoor meghívása
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}
	@Override
	public void onCollisionWithBullet() {
		// TODO Auto-generated method stub
		
	}

}
