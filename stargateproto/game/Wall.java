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
		
		//mivel ezek fv-ek nem hivnak további fv-eket
		//ezért fölösleges mindegyiknél külön tab++ és tab--
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
	//ha pl kék színû portál nyitva de nyitunk egy új kék színû portált, akkor
	// a régi eltûnik
	
	//mivel onCollision-re müködik minden, ezért
	//abba maradtunk, hogy a Wall hozza létre a Portalt, ha a lövedék speciális falat ér,
	//nem pedig maga a lövedék, ezért
	//a Wall-nak tudnia kell, hogy mi a Bullet dir változójának értéke és
	//annak ellentetjét átadni a Portal-nak
	//illetve tudnia kell a Bullet színét is
	public void onCollisionWithBullet(Bullet bullet) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor portál nyitás, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden függvényre külön a tab++, tab--, mert ezen függvényeken belül nem történik további fv hívás
			StarGateGame.tab++;
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
				
				
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("-> [:Portal].Portal();");
				p = new Portal (x, y, Bulletcolour, ch);
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Portal].Portal();");
				
				
				//be is kell jegyezni a láncolt listába:
				//saját indexére rakja be
				ch.getSGG().getList().add(ch.getSGG().getList().indexOf(this), p);
				
				//és fontos, hogy a karakternél is jelezni kell
				//emlékeztetõ:
				//		Colonel esetében:
				//		PortalOne: kék portál		PortalTwo: sárga portál
				//		Jaffa esetében
				//		PortalOne: piros portál		PortalTwo: 	zöld portál
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
 