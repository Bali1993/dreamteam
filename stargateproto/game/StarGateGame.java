package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

import ntrfc.Entity;

public class StarGateGame extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Timer timer;
	
	private Map m;
	
	//ch változó csak azért szükséges, mert pl:
	//a Door osztály openDoor()-jában van egy ilyen sor:
	//c.getSGG().getList().remove(this);
	//le akarja kérdezni a listát de a láthatóság miatt csak egy Charahteren keresztül tudja (jelenleg c - Colonel)
	//de Character átadása csak az onColl-ba történik
	//és mivel mind1 h milyen karakteren keresztül kérdezi le a listát
	//ezért a Character ch-val biztositunk csak egy referenciát, amin keresztül ezt mindig megteheti onColl() függvényen kivül
	//ezt a ch referenciát az elemek konstruktorába adjuk át
	//Megjegyzés: ugye onColl esetében nem mind1 h milyen karakter megy neki az adott elemnek, ott is átadjuk, hogy Jaffa vagy Colonel megy neki
	private Character ch;
	//Wall osztályban az onCollwithBulletben is szükséges
	//Pit osztályba is kéne a onCollisinWithReplicator miatt, hogy szakadékot útra cserélje
	
	//update: közbe rájöttem hogy sgg-t és átadhatnánk, nem kéne Character ch-t
	//de akkor csúnyább lenne a class diagram és nincs kedvem mindenhol átirni már ezt :D
	
	
	private Character c;
	private Character j;
	private Replicator replicator;

	//Entity azért kell mert sima <object>-et kap, annak nincs definiálva a getRec() függvénye, így nem tudnánk meghívni
	//minden elemre egyesével a lekérdezést.
	private LinkedList<Entity> ll;
	
	
	//teszteléshez
	public static int tab = 0;
	
	public StarGateGame(){
		
		m = new Map();
		c = new Character(this, 32, 32);
		j = new Character(this, 64, 64);
		ch = new Character(this, 96,96 ); //mind1 h mi a koordinátája, nem használjuk csak a fent emlitett referencia miatt kell
		int Replicator_x = 224; int Replicator_y = 640; 
		//int Replicator_x = 32; int Replicator_y = 384; 
		replicator = new Replicator(this, Replicator_x, Replicator_y);
		
		ll = new LinkedList<Entity>();
		buildMAP();
		
		addKeyListener(new Cntrl());
		setFocusable(true);
		
		timer = new Timer(25, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	//CSAK A TESZTELÉSHEZ SZÜKSGÉGES
	//hogy a StarGate-bõl is elérjük a Colonel-t
	//ezért nem iratjuk ki a nevét
	public Character getColonel(){
		return this.c;
	}
	
	//A játék véget ér, ha mind a két felhasználó az általuk irányított karakterrel a szakadékba lép vagy
	//ha az utolsó ZPM is fel lett véve a pályáról. 
	//Utóbbi esetben a képernyõre kiíródik, hogy a két felhasználó egyenként mennyi ZPMet gyûjtött össze, 
	//és akinek többet sikerült, az a nyertes. 
	///Ha az egyik játékos meghal, de a másiknak sikerül felvennie az utolsó ZPM-et, 
	//akkor mindenképp õ lesz a nyertes, függetlenül attól, hogy mennyi ZPM van nála.
	public void EndofGame(){
		//TODO
	}
	
	public LinkedList<Entity> getList(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:StarGateGame].getList();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:StarGateGame].getList:LinkedList<Entity>();");
		return ll;
	}
	
	
	//mérleg-ajtó párositás elvégzése beolvasáskor
	//elöször végig kell menni a teljes txt-n és kigyûjteni az összes doort és létrehozni, így
	//mikor újra végig megyünk a txt-n már a scalek is létrehozhatók, a konstruktorába hozzáadható a
	//hozzá tartozó ajtó, így ID sem kell, mert a mérlegnek lesz egy referenciája a 
	//hozzá tartozó ajtóról
	public void buildDoorsandScales(){
		//txt-ben:
		//1 - ajto1
		//2 - mérleg1

		//3 - ajto2
		//4 - mérleg2
		//stb..
		//TODO..
	}
	
	 //felépíti a pályát, végigmegy a map[] tömbön és végiggelenõrzi a stringek karaktereit, 
	//majd az alapján berakja a láncolt listába
	public void buildMAP(){
		Door door = null;
		
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){				
				switch (m.getElement(x, y)){
				case 'd': 	
					door = new Door(x*32,y*32, ch);
					ll.add(door);
				}
			}//for x
		}//for y
		
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){				
				switch (m.getElement(x, y)){
				case 'w': 					
					ll.add(new Wall(x*32, y*32, false, ch));
					break;
				case 'q': 
					ll.add(new Wall(x*32, y*32, true, ch));
					break;
				case 'z':
					ll.add(new Zpm(x*32, y*32, ch));
					break;
				case 'b':
					ll.add(new Box(x*32, y*32, ch));
					break;
				case 'p':
					ll.add(new Pit(x*32, y*32, ch));
					break;
				case 'g':
					ll.add(new Portal(x*32, y*32, "yellow", ch));
					break;
				case 's':
					ll.add(new Scale(x*32, y*32, door, 100, ch));
					break;
				default: 

					break;
				}
			}//for x
		}//for y
	}
	
	/*
	 * itt rajzoljuk ki, azért külön mert különben mindig újratöltené fel a listánkat a kül. elemekkel
	 * 
	 * TODO:képek színes négyzetek helyett
	 */
	public void paint(Graphics g){
		super.paint(g);
		/*
		 * alapszín, ha eltûnik valami, akkor ne legyen lyuk
		 * illetve ha a replikátort megszüntetjük, akkor is fontos
		 */
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){								
					g.setColor(Color.WHITE);
					g.fillRect(x*32,y*32,32,32);
					g.setColor(Color.LIGHT_GRAY);
					g.drawRect(x*32,y*32,32,32);
			}
		}
		for(int i=0; i < ll.size(); ++i)
		{
			ll.get(i).render(g);
		}
		c.render(g);
		j.render(g);
		replicator.render(g);
		
		/*
		 *g.drawImage(m.getBox(), x*32, y*32, null);
		 *g.drawImage(m.getScale(), x*32, y*32, null);
		 *g.drawImage(m.getWall_Spec(), x*32, y*32, null);
		 *g.drawImage(m.getDoor(), x*32, y*32, null);
		 *g.drawImage(m.getPit(), x*32, y*32, null) 
		 */
	}
	
	/*
	 * egyszerû billentyûzetkezelés
	 */
	public class Cntrl extends KeyAdapter{		
		
		public void keyPressed(KeyEvent e){
			
			int keycode = e.getKeyCode();
			
			if(keycode == KeyEvent.VK_UP){
				c.move(0, -32);	
				c.setFacing("up");
				if(replicator.getisAlive() == true)
					replicator.move();
			}	
			if(keycode == KeyEvent.VK_DOWN){
				c.move(0, 32);
				c.setFacing("down");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			if(keycode == KeyEvent.VK_LEFT){
				c.move(-32, 0);
				c.setFacing("left");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			if(keycode == KeyEvent.VK_RIGHT){
				c.move(32, 0);
				c.setFacing("right");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			if(keycode == KeyEvent.VK_L){
		
			}
			if(keycode == KeyEvent.VK_W){
				j.move(0, -32);	
				j.setFacing("up");
				if(replicator.getisAlive() == true)
					replicator.move();
			}	
			if(keycode == KeyEvent.VK_S){
				j.move(0, 32);
				j.setFacing("down");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			if(keycode == KeyEvent.VK_A){
				j.move(-32, 0);
				j.setFacing("left");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			if(keycode == KeyEvent.VK_D){
				j.move(32, 0);
				j.setFacing("right");
				if(replicator.getisAlive() == true)
					replicator.move();
			}
			
			if(keycode == KeyEvent.VK_G){
				
			}
			//TODO: putDown(), pickUp(), shoot() meghívása
			//shoot()
				//sárga lövedék létrehozása: bal egérgomb
				//kék lövedék létrehozása: jobb egérgomb
			//putDown(), pickUp()legyen SPACE
			
			//várjunk csak! 
			//pickUp()-ot nem itt hivjuk meg, hanem mikor ütközünk a box-al, annak onColl.jébe
			//illetve még akkor, ha rajta állunk a mérlegen és felvesszük a dobozt
			
			//putDown() hívása alapból itt történik, de
			//még a mérlegen állva is lehet hívni (Scale onColl), vagy Box onColl során (felveszi, majd újra le is rakja ott a dobozt)
		}
	}

	
}
