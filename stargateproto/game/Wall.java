package game;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Element{
	private boolean isSpecial;
	private Portal p;
	private Character ch;
	
	public Wall(int x2, int y2, boolean b, Character ch) {
		super(x2, y2);
		this.isSpecial = b;
		this.ch = ch;
	}

	@Override
	public void onCollision(int dx, int dy, int i, game.Character character) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollision();");
		
		//mivel ezek fv-ek nem hivnak tov�bbi fv-eket
		//ez�rt f�l�sleges mindegyikn�l k�l�n tab++ �s tab--
		StarGateGame.tab++;
		character.setX(character.getX()-dx);
		character.setY(character.getY()-dy);
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
	//TODO:
	//ha pl k�k sz�n� port�l nyitva de nyitunk egy �j k�k sz�n� port�lt, akkor
	// a r�gi elt�nik
	
	//"i" param�ter: az �tk�z�s helye a l�ncolt list�ban
	//(ezen Wall saj�t indexe a l�ncolt list�ban)
	//ja.. de akkor lehet nem is k�ne �tvenni i param�tert, sim�n lek�rdezi saj�t index�t a Wall
	//indexOf()-al
	public void onCollisionWithBullet(int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor port�l nyit�s, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden f�ggv�nyre k�l�n a tab++, tab--, mert ezen f�ggv�nyeken bel�l nem t�rt�nik tov�bbi fv h�v�s
			StarGateGame.tab++;
				//Bullet bullet = c.getBullet();
				//String Bulletdir = bullet.getBulletdir(); //vmi�rt nem m�k�dik nullpointerexceptiont ad!
				String Bulletdir = "down";
				//String Bulletcolour = bullet.getBulletcolour();  //vmi�rt nem m�k�dik nullpointerexceptiont ad!
				String Bulletcolour = "yellow";
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
				
				
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("-> [:Portal].Portal();");
				p = new Portal (x, y, Bulletcolour);
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Portal].Portal();");
				
				
				//be is kell jegyezni a l�ncolt list�ba:
				ch.getSGG().getList().add(i, p);
				
				//�s fontos, hogy a Coloneln�l is jelezni kell
				if(Bulletcolour == "yellow"){
					ch.setX_yellow(x);
					ch.setY_yellow(y);
					ch.setyellowPortalFacing(Portaldir);
				}
					
				if(Bulletcolour == "blue"){
					ch.setX_blue(x);
					ch.setY_blue(y);
					ch.setbluePortalFacing(Portaldir);
				}
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Wall].onCollisionWithBullet():void;");
		
	}

}
 