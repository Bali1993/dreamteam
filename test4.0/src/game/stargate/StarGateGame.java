package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

import ntrfc.stargate.Entity;

public class StarGateGame extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Timer timer;
	
	private Map m;
	private Colonel c;
	/*
	 * Entity azért kell mert sima <object>-et kap, annak nincs definiálva a getRec() függvénye, így nem tudnánk emghívni
	 * minden elemre egyesével a lekérdezést.
	 */
	private LinkedList<Entity> ll;
	
	
	//teszteléshez
	public static int tab = 0;
	
	public StarGateGame(){
		
		m = new Map();
		c = new Colonel(this);
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
	public Colonel getColonel(){
		return this.c;
	}
	
	public void win(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:StarGateGame].win();");
		
		//called by zpm obj itself
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:StarGateGame].win():void;");
	}
	
	public void gameover(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:StarGateGame].gameover();");
		
		//called by pit
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:StarGateGame].gameover():void;");
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
	
	/*
	 * felépíti a pályát, végigmegy a map[] tömbön és végiggelenõrzi a stringek karaktereit, majd az alapján 
	 * berakja a láncolt listába
	 * 
	 *egyelõre csak fal 
	 */
	public void buildMAP(){
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){				
				switch (m.getElement(x, y)){
				case 'w': 					
					ll.add(new Wall(x*32, y*32, c, false));
					break;
				case 'q': 					
					ll.add(new Wall(x*32, y*32, c, true));
					break;
				case 'z':
					ll.add(new Zpm(x*32, y*32, c));
					break;
				case 'b':
					ll.add(new Box(x*32, y*32, c));
					break;
				//TODO: mérleg-ajtó párositás elvégzése beolvasáskor
				//elöször végig kell menni a teljes txt-n és kigyûjteni az összes doort és létrehozni, így
				//mikor újra végig megyünk a txt-n már a scalek is létrehozhatók, a konstruktorába hozzáadható a
				//hozzá tartozó ajtó, így ID sem kell, mert a mérlegnek lesz egy referenciája a 
				//hozzá tartozó ajtóról
				case 's':
					ll.add(new Scale(x*32, y*32, c, new Door(y,y,c)));
					break;
				case 'd':
					ll.add(new Door(x*32, y*32, c));
					break;
				case 'p':
					ll.add(new Pit(x*32, y*32, c));
					break;
				case 'g':
					ll.add(new Portal(x*32, y*32, c, "yellow"));
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
		
		/*
		 *g.drawImage(m.getBox(), x*32, y*32, null);
		 *g.drawImage(m.getScale(), x*32, y*32, null);
		 *g.drawImage(m.getWall_Spec(), x*32, y*32, null);
		 *g.drawImage(m.getDoor(), x*32, y*32, null);
		 *g.drawImage(m.getPit(), x*32, y*32, null) 
		 */
	}
	/*
	 * egyszerû billentyûzetkezelés, WASD
	 */
	
	public class Cntrl extends KeyAdapter{		
		
		public void keyPressed(KeyEvent e){
			
			int keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_UP){
				c.move(-32, 0);	
				c.setFacing("up");
			}	
			if(keycode == KeyEvent.VK_DOWN){
				c.move(32, 0);
				c.setFacing("down");
			}
			if(keycode == KeyEvent.VK_LEFT){
				c.move(0, -32);
				c.setFacing("left");
			}
			if(keycode == KeyEvent.VK_RIGHT){
				c.move(0, 32);
				c.setFacing("right");
			}
			if(keycode == KeyEvent.VK_SPACE){
				
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
