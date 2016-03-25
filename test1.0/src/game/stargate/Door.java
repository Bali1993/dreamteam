package game.stargate;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Element{

	private boolean isOpened;
	public Door(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	@Override
	public void onCollision(int dx, int dy, int i) {
		//TODO
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}
	
	public void openDoor(){
		//töröl, cserél útra
	}
	
	public void closeDoor(){
		//visszarajzl, rak egy ajtót
	}

	
}
