package game.stargate;

import java.awt.Graphics;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
