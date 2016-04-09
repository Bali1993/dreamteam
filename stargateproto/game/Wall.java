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
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getWall(), x*32, y*32, null);
	}

	@Override
	//TODO:
	//ha pl kék színû portál nyitva de nyitunk egy új kék színû portált, akkor
	// a régi eltûnik
	
	//"i" paraméter: az ütközés helye a láncolt listában
	//(ezen Wall saját indexe a láncolt listában)
	//ja.. de akkor lehet nem is kéne átvenni i paramétert, simán lekérdezi saját indexét a Wall
	//indexOf()-al
	public void onCollisionWithBullet(int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Wall].onCollisionWithBullet();");

		//ha specialis fal, akkor portál nyitás, ott ahol maga a fal van
		if(isSpecial){
			//nem kell minden függvényre külön a tab++, tab--, mert ezen függvényeken belül nem történik további fv hívás
			StarGateGame.tab++;
				//Bullet bullet = c.getBullet();
				//String Bulletdir = bullet.getBulletdir(); //vmiért nem müködik nullpointerexceptiont ad!
				String Bulletdir = "down";
				//String Bulletcolour = bullet.getBulletcolour();  //vmiért nem müködik nullpointerexceptiont ad!
				String Bulletcolour = "yellow";
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
				p = new Portal (x, y, Bulletcolour);
				for(int j = 0; j < StarGateGame.tab; j++)
					System.out.print("\t");
				System.out.println("<- [:Portal].Portal();");
				
				
				//be is kell jegyezni a láncolt listába:
				ch.getSGG().getList().add(i, p);
				
				//és fontos, hogy a Colonelnél is jelezni kell
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
 