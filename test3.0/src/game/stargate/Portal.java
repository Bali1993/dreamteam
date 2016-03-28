package game.stargate;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Portal extends Element{
	
	private String colour; //yellow or blue
	public Portal(int x2, int y2, Colonel c, String colour) {
		super(x2, y2, c);
		
		this.colour = colour;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Portal].onCollision();");
		
		//ha a saj�t sz�ne s�rga, akkor lek�rdezi a m�sik k�k port�l helyzet�t �s ir�ny�t
		if(colour == "yellow"){
			StarGateGame.tab++;
				int X_blue = c.getX_blue();
				int Y_blue = c.getY_blue();
				String bluePortalFacing = c.getbluePortalFacing();
				
				//teh�t ha nyitva van a m�sik port�l,  teleport�lja oda az ezredest
				if(X_blue != -1){
					if(bluePortalFacing == "up"){c.setX(X_blue - 32); c.setY(Y_blue);}
					if(bluePortalFacing == "down"){c.setX(X_blue + 32); c.setY(Y_blue);}
					if(bluePortalFacing == "left"){c.setX(X_blue); c.setY(Y_blue - 32);}
					if(bluePortalFacing == "right"){c.setX(X_blue); c.setY(Y_blue + 32);}
				}
			StarGateGame.tab--;
		}
		
		//ha a saj�t sz�ne k�k, akkor lek�rdezi a m�sik s�rga port�l helyzet�t �s ir�ny�t
		if(colour == "blue"){
			StarGateGame.tab++;
				int X_yellow = c.getX_yellow();
				int Y_yellow = c.getY_yellow();
				String yellowPortalFacing = c.getyellowPortalFacing();
				
				//teh�t ha nyitva van a m�sik port�l, teleport�lja oda az ezredest
				if(X_yellow != -1){
					if(yellowPortalFacing == "up"){c.setX(X_yellow - 32); c.setY(Y_yellow);}
					if(yellowPortalFacing == "down"){c.setX(X_yellow + 32); c.setY(Y_yellow);}
					if(yellowPortalFacing == "left"){c.setX(X_yellow); c.setY(Y_yellow - 32);}
					if(yellowPortalFacing == "right"){c.setX(X_yellow); c.setY(Y_yellow + 32);}
				}
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Portal].onCollision():void;");
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Portal].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Portal].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
