package game.stargate;

import java.awt.Color;
import java.awt.Graphics;


public class Wall extends Elements{

	public Wall(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}

	@Override
	public void onCollision(int dx, int dy, int i) {
		c.setX(c.getX()-dx);
		c.setY(c.getY()-dy);
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getWall(), x*32, y*32, null);
	}

}
 