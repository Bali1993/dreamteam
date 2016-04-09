package game;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Element{
	private boolean isSpecial;
	private Portal p;
	
	public Wall(int x, int y, boolean b, Character ch) {
		super(x, y, ch);
		this.isSpecial = b;
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
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
	//TODO:
	//ha pl k�k sz�n� port�l nyitva de nyitunk egy �j k�k sz�n� port�lt, akkor
	// a r�gi elt�nik
	
	//mivel onCollision-re m�k�dik minden, ez�rt
	//abba maradtunk, hogy a Wall hozza l�tre a Portalt, ha a l�ved�k speci�lis falat �r,
	//nem pedig maga a l�ved�k, ez�rt
	//a Wall-nak tudnia kell, hogy mi a Bullet dir v�ltoz�j�nak �rt�ke �s
	//annak ellentetj�t �tadni a Portal-nak
	//illetve tudnia kell a Bullet sz�n�t is
	public void onCollisionWithBullet(Bullet bullet) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor port�l nyit�s, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden f�ggv�nyre k�l�n a tab++, tab--, mert ezen f�ggv�nyeken bel�l nem t�rt�nik tov�bbi fv h�v�s
			StarGateGame.tab++;
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
				
				
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("-> [:Portal].Portal();");
				p = new Portal (x, y, Bulletcolour, ch);
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Portal].Portal();");
				
				
				//be is kell jegyezni a l�ncolt list�ba:
				//saj�t index�re rakja be
				ch.getSGG().getList().add(ch.getSGG().getList().indexOf(this), p);
				
				//�s fontos, hogy a karaktern�l is jelezni kell
				//eml�keztet�:
				//		Colonel eset�ben:
				//		PortalOne: k�k port�l		PortalTwo: s�rga port�l
				//		Jaffa eset�ben
				//		PortalOne: piros port�l		PortalTwo: 	z�ld port�l
				if(Bulletcolour == "blue" || Bulletcolour == "red"){
					ch.setPortalOne_x(x);
					ch.setPortalOne_y(y);
					ch.setPortalOne_Facing(Portaldir);
				}
					
				if(Bulletcolour == "yellow" || Bulletcolour == "green"){
					ch.setPortalTwo_x(x);
					ch.setPortalTwo_y(y);
					ch.setPortalTwo_Facing(Portaldir);
				}
			StarGateGame.tab--;
		}
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Wall].onCollisionWithBullet():void;");
		
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
 