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
	
	//ch v�ltoz� csak az�rt sz�ks�ges, mert pl:
	//a Door oszt�ly openDoor()-j�ban van egy ilyen sor:
	//c.getSGG().getList().remove(this);
	//le akarja k�rdezni a list�t de a l�that�s�g miatt csak egy Charahteren kereszt�l tudja (jelenleg c - Colonel)
	//de Character �tad�sa csak az onColl-ba t�rt�nik
	//�s mivel mind1 h milyen karakteren kereszt�l k�rdezi le a list�t
	//ez�rt a Character ch-val biztositunk csak egy referenci�t, amin kereszt�l ezt mindig megteheti onColl() f�ggv�nyen kiv�l
	//ezt a ch referenci�t az elemek konstruktor�ba adjuk �t
	//Megjegyz�s: ugye onColl eset�ben nem mind1 h milyen karakter megy neki az adott elemnek, ott is �tadjuk, hogy Jaffa vagy Colonel megy neki
	private Character ch;
	//Wall oszt�lyban az onCollwithBulletben is sz�ks�ges
	//Pit oszt�lyba is k�ne a onCollisinWithReplicator miatt, hogy szakad�kot �tra cser�lje
	
	//update: k�zbe r�j�ttem hogy sgg-t �s �tadhatn�nk, nem k�ne Character ch-t
	//de akkor cs�ny�bb lenne a class diagram �s nincs kedvem mindenhol �tirni m�r ezt :D
	
	
	private Character c;
	private Character j;
	private Replicator replicator;

	//Entity az�rt kell mert sima <object>-et kap, annak nincs defini�lva a getRec() f�ggv�nye, �gy nem tudn�nk megh�vni
	//minden elemre egyes�vel a lek�rdez�st.
	private LinkedList<Entity> ll;
	
	
	//tesztel�shez
	public static int tab = 0;
	
	public StarGateGame(){
		
		m = new Map();
		c = new Character(this, 32, 32);
		c.setPortalBlue_x(0);
		c.setPortalBlue_y(128);
		c.setPortalBlue_Facing("right");
		c.setPortalYellow_x(0);
		c.setPortalYellow_y(224);
		c.setPortalYellow_Facing("right");
		j = new Character(this, 64, 64);
		j.setPortalRed_x(256);
		j.setPortalRed_y(0);
		j.setPortalRed_Facing("down");
		j.setPortalGreen_x(160);
		j.setPortalGreen_y(0);
		j.setPortalGreen_Facing("down");
		ch = new Character(this, 96,96 ); //mind1 h mi a koordin�t�ja, nem haszn�ljuk csak a fent emlitett referencia miatt kell
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
	
	//CSAK A TESZTEL�SHEZ SZ�KSG�GES
	//hogy a StarGate-b�l is el�rj�k a Colonel-t
	//ez�rt nem iratjuk ki a nev�t
	public Character getColonel(){
		return this.c;
	}
	
	//A j�t�k v�get �r, ha mind a k�t felhaszn�l� az �ltaluk ir�ny�tott karakterrel a szakad�kba l�p vagy
	//ha az utols� ZPM is fel lett v�ve a p�ly�r�l. 
	//Ut�bbi esetben a k�perny�re ki�r�dik, hogy a k�t felhaszn�l� egyenk�nt mennyi ZPMet gy�jt�tt �ssze, 
	//�s akinek t�bbet siker�lt, az a nyertes. 
	///Ha az egyik j�t�kos meghal, de a m�siknak siker�l felvennie az utols� ZPM-et, 
	//akkor mindenk�pp � lesz a nyertes, f�ggetlen�l att�l, hogy mennyi ZPM van n�la.
	public void EndofGame(){
		//TODO
	}
	
	public LinkedList<Entity> getList(){
		//kiirat�s kiv�ve, mert
		//nagyon lelass�tja a programot a zpm random gener�l�sakor
		
		/*for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:StarGateGame].getList();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:StarGateGame].getList:LinkedList<Entity>();"); 
		*/
		return ll;
	}
	
	
	 //fel�p�ti a p�ly�t, v�gigmegy a map[] t�mb�n �s v�giggelen�rzi a stringek karaktereit, 
	//majd az alapj�n berakja a l�ncolt list�ba
	public void buildMAP(){
		
		Door door1 = null ;
		Door door2 = null ;
		
		//txt-ben:
		//1 - ajto1
		//2 - m�rleg1
	
		//3 - ajto2
		//4 - m�rleg2
		//stb..
		
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){				
				switch (m.getElement(x, y)){
				case '1': 	
					door1 = new Door(x*32,y*32, ch);
					ll.add(door1);
				break;
				case '3': 	
					door2 = new Door(x*32,y*32, ch);
					ll.add(door2);
				break;
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
				case 'y':
					ll.add(new Portal(x*32, y*32, "yellow", ch));
					break;
				case 'k':
					ll.add(new Portal(x*32, y*32, "blue", ch));
					break;
				case 'g':
					ll.add(new Portal(x*32, y*32, "green", ch));
					break;
				case 'x':
					ll.add(new Portal(x*32, y*32, "red", ch));
					break;
				/*case '2':
					ll.add(new Scale(x*32, y*32, door1, 100, ch));
					break;
				case '4':
					ll.add(new Scale(x*32, y*32, door2, 100, ch));
					break;*/
				}
			}//for x
		}//for y
		
		//majd �jra v�gig megy�nk a p�ly�n �s most m�r l�trehozzuk a m�rlegeket is
		//a m�rleg konstruktor�ba m�r �t tudjuk adni a megfelel� ajt�t is
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){				
				switch (m.getElement(x, y)){
				case '2':
					ll.add(new Scale(x*32, y*32, door1, 100, ch));
					break;
				case '4':
					ll.add(new Scale(x*32, y*32, door2, 100, ch));
					break;
				}
			}
		}
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
		 * illetve ha a replik�tort megsz�ntetj�k, akkor is fontos
		 */
		for(int x=0; x<30; x++){
			for(int y=0; y<30; y++){								
					g.setColor(Color.WHITE);
					g.fillRect(x*32,y*32,32,32);
					g.setColor(Color.LIGHT_GRAY);
					g.drawRect(x*32,y*32,32,32);
			}
		}
		
		
		//fontos, hogy legel�sz�r a replicatort renderelj�k, mert 
		//mikor a replicator meghal, egy feh�r h�tteret rajzolok ki helyette
		replicator.render(g); 
		
		
		//elemek kirajzol�sa
		for(int i=0; i < ll.size(); ++i)
		{
			ll.get(i).render(g);
		}
		
		//karakterek kirajzol�sa
		c.render(g);
		j.render(g);
		
		
		/*
		 *g.drawImage(m.getBox(), x*32, y*32, null);
		 *g.drawImage(m.getScale(), x*32, y*32, null);
		 *g.drawImage(m.getWall_Spec(), x*32, y*32, null);
		 *g.drawImage(m.getDoor(), x*32, y*32, null);
		 *g.drawImage(m.getPit(), x*32, y*32, null) 
		 */
	}
	
	/*
	 * egyszer� billenty�zetkezel�s
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
			if(keycode == KeyEvent.VK_NUMPAD0){
				c.putDown(false);
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
			
			if(keycode == KeyEvent.VK_F){
				j.putDown(false);
			}
			//TODO: putDown(), pickUp(), shoot() megh�v�sa
			//shoot()
				//s�rga l�ved�k l�trehoz�sa ezredessel: bal eg�rgomb
				//k�k l�ved�k l�trehoz�sa ezredessel: jobb eg�rgomb
				//piros l�ved�k l�trehoz�sa jaffaval: O bill.
				//z�ld l�ved�k l�trehoz�sa jaffaval: P bill.
			//putDown(), pickUp()
				//ezredes: 0-s bill a numpadon
				//jaffa: F bill.
			
			//v�rjunk csak! 
			//pickUp()-ot nem itt hivjuk meg, hanem mikor �tk�z�nk a box-al, annak onColl.j�be
			//illetve m�g akkor, ha rajta �llunk a m�rlegen �s felvessz�k a dobozt
			
			//putDown() h�v�sa alapb�l itt t�rt�nik, de
			//m�g a m�rlegen �llva is lehet h�vni (Scale onColl)
		}
	}

	
}
