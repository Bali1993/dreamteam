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
		
		//mivel ezek fv-ek nem hivnak tov�bbi fv-eket
		//ez�rt f�l�sleges mindegyikn�l k�l�n tab++ �s tab--
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
	//"i" param�ter: az �tk�z�s helye a l�ncolt list�ban
	//(ezen Wall saj�t indexe a l�ncolt list�ban)
	public void onCollisionWithBullet(int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor port�l nyit�s, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden f�ggv�nyre k�l�n a tab++, tab--, mert ezen f�ggv�nyeken bel�l nem t�rt�nik tov�bbi fv h�v�s
			StarGateGame.tab++;
				Bullet bullet = c.getBullet();
				String Bulletdir = bullet.getBulletdir();
				String Bulletcolour = bullet.getBulletcolour();
				String Portaldir;
				//ir�ny csere
				//ha pl. up ir�nyb�l j�tt a l�ved�k, a port�l ir�nya down lesz
				//igy teleport�l�skor tudni fogja a port�l, hogy down ir�nyba kell kiraknia az ezredest
				//(down ir�nyba l�v� �tra)
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
					Portaldir = "nincs m�s eset csak irni kell ide vmit, hogy a fordito ne sirjon, hogy Portaldir nem kap �rt�ket";
				break;
				}
				
				p = new Portal (x, y, c, Bulletcolour);
				
				//be is kell jegyezni a l�ncolt list�ba:
				c.getSGG().getList().add(i, p);
				
				//�s fontos, hogy a Coloneln�l is jelezni kell
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
 