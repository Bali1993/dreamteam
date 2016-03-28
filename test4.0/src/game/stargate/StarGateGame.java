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
	 * Entity az�rt kell mert sima <object>-et kap, annak nincs defini�lva a getRec() f�ggv�nye, �gy nem tudn�nk emgh�vni
	 * minden elemre egyes�vel a lek�rdez�st.
	 */
	private LinkedList<Entity> ll;
	
	
	//tesztel�shez
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
	
	//CSAK A TESZTEL�SHEZ SZ�KSG�GES
	//hogy a StarGate-b�l is el�rj�k a Colonel-t
	//ez�rt nem iratjuk ki a nev�t
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
	 * fel�p�ti a p�ly�t, v�gigmegy a map[] t�mb�n �s v�giggelen�rzi a stringek karaktereit, majd az alapj�n 
	 * berakja a l�ncolt list�ba
	 * 
	 *egyel�re csak fal 
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
				//TODO: m�rleg-ajt� p�rosit�s elv�gz�se beolvas�skor
				//el�sz�r v�gig kell menni a teljes txt-n �s kigy�jteni az �sszes doort �s l�trehozni, �gy
				//mikor �jra v�gig megy�nk a txt-n m�r a scalek is l�trehozhat�k, a konstruktor�ba hozz�adhat� a
				//hozz� tartoz� ajt�, �gy ID sem kell, mert a m�rlegnek lesz egy referenci�ja a 
				//hozz� tartoz� ajt�r�l
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
	 * itt rajzoljuk ki, az�rt k�l�n mert k�l�nben mindig �jrat�lten� fel a list�nkat a k�l. elemekkel
	 * 
	 * TODO:k�pek sz�nes n�gyzetek helyett
	 */
	public void paint(Graphics g){
		super.paint(g);
		/*
		 * alapsz�n, ha elt�nik valami, akkor ne legyen lyuk
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
	 * egyszer� billenty�zetkezel�s, WASD
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
			//TODO: putDown(), pickUp(), shoot() megh�v�sa
			//shoot()
				//s�rga l�ved�k l�trehoz�sa: bal eg�rgomb
				//k�k l�ved�k l�trehoz�sa: jobb eg�rgomb
			//putDown(), pickUp()legyen SPACE
			
			//v�rjunk csak! 
			//pickUp()-ot nem itt hivjuk meg, hanem mikor �tk�z�nk a box-al, annak onColl.j�be
			//illetve m�g akkor, ha rajta �llunk a m�rlegen �s felvessz�k a dobozt
			
			//putDown() h�v�sa alapb�l itt t�rt�nik, de
			//m�g a m�rlegen �llva is lehet h�vni (Scale onColl), vagy Box onColl sor�n (felveszi, majd �jra le is rakja ott a dobozt)
		}
	}

	
}
