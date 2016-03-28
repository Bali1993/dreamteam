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
	//"i" paraméter: az ütközés helye a láncolt listában
	//(ezen Wall saját indexe a láncolt listában)
	public void onCollisionWithBullet(int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor portál nyitás, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden függvényre külön a tab++, tab--, mert ezen függvényeken belül nem történik további fv hívás
			StarGateGame.tab++;
				Bullet bullet = c.getBullet();
				String Bulletdir = bullet.getBulletdir();
				String Bulletcolour = bullet.getBulletcolour();
				String Portaldir;
				//irány csere
				//ha pl. up irányból jött a lövedék, a portál iránya down lesz
				//igy teleportáláskor tudni fogja a portál, hogy down irányba kell kiraknia az ezredest
				//(down irányba lévõ útra)
				switch(Bulletdir){
				case "up":
					Portaldir = "down";
				break;
				case "down":
					Portaldir = "up";
				break;
				case "left":
					Portaldir = "right";
				break;
				case "right":
					Portaldir = "left";
				break;
				default:
					Portaldir = "nincs más eset csak irni kell ide vmit, hogy a fordito ne sirjon, hogy Portaldir nem kap értéket";
				break;
				}
				
				p = new Portal (x, y, c, Bulletcolour);
				
				//be is kell jegyezni a láncolt listába:
				c.getSGG().getList().add(i, p);
				
				//és fontos, hogy a Colonelnél is jelezni kell
				if(Bulletcolour == "yellow"){
					c.setX_yellow(x);
					c.setY_yellow(y);
					c.setFacing(Portaldir);
				}
					
				if(Bulletcolour == "blue"){
					c.setX_blue(x);
					c.setY_blue(y);
					c.setFacing(Portaldir);
				}
			StarGateGame.tab--;
		}
		
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
 