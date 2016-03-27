package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Wall extends Element{

	private boolean isSpecial;
	private Portal p;
	
	public Wall(int x2, int y2, Colonel c, boolean b) {
		super(x2, y2, c);
		this.isSpecial = b;
	}

	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollision();");
		
		//mivel ezek fv-ek nem hivnak további fv-eket
		//ezért fölösleges mindegyiknél külön tab++ és tab--
		StarGateGame.tab++;
		c.setX(c.getX()-dx);
		c.setY(c.getY()-dy);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Wall].onCollision():void;");
	}
	@Override
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getWall(), x*32, y*32, null);
	}

	@Override
	public void onCollisionWithBullet() {
		// TODO Auto-generated method stub
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//
		//ide ha hiv további fv-eket
		//
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Wall].onCollisionWithBullet():void;");
		
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Wall].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}

}
 