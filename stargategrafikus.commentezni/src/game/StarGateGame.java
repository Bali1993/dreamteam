package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import ntrfc.Entity;

public class StarGateGame extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Timer timer;
	private Map m;
	
	//összes felvehetõ ZPM szám
	private int zpmdb;

	private Character ch;

	//referencia a létrehozott colonelre
	private Character c;
	//referencia a létrehozott jaffara
	private Character j;
	//referencia a létrehozott replicatorra
	private Replicator replicator;

	//a pálya elemeit tartalmazó lámcolt lista
	private LinkedList<Entity> ll;
	
	/*
	 * mérleg-ajtó párosok referenciái
	 */
	private Scale scale1;
	private Scale scale2;
	private Scale scale3;
	private Door door1;
	private Door door2;
	private Door door3;
	
	//popupwindow gombja
	private Object[] options = { "QUIT" };
	
    /*
     * A StarGateGame osztály konstruktora
     * Attribútumok inicializálása
     * Pálya építése
     * 
     * Karakterek létrehozása
     */
	public StarGateGame() {
		door1 = null;
		door2 = null;
		door3 = null;
		scale1 = null;
		scale2 = null;
		scale3 = null;
		zpmdb = 0;
		m = new Map();
		ll = new LinkedList<Entity>();
		ch = new Character(this, 96, 96);
		// pálya építése
		buildMAP();
		/*
		 * colonel és jaffa létrehozása, berakása a pályára
		 */
		c = new Character(this, 32, 32);
		j = new Character(this, 896, 32);
		
		//replikátor létrehozása
		replicator = new Replicator(this, 32, 896);

		//keylistener hozzáadása
		addKeyListener(new Cntrl());
		setFocusable(true);

		//timer hozzáadása, indítása
		timer = new Timer(25, this);
		timer.start();
	}
	
	/*
	 * Pálya újrarajzolása, ha valami interakció történik
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	/*
	 * A txtbõl feltöltött tömb gettere
	 */
	public Map getMap(){
		return this.m;
	}

	/*
	 * A 3 ajtó gettere
	 */
	public Door getDoor1() {
		return door1;
	}

	public Door getDoor2() {
		return door2;
	}
	public Door getDoor3() {
		return door3;
	}

	/*
	 * A 3 mérleg gettere
	 */
	public Scale getScale1() {
		return scale1;
	}

	public Scale getScale2() {
		return scale2;
	}
	
	public Scale getScale3() {
		return scale3;
	}

	/*
	 * colonel gettere
	 */
	public Character getColonel() {
		return this.c;
	}
	/*
	 * jaffa gettere
	 */
	public Character getJaffa() {
		return this.j;
	}
	/*
	 * replicator gettere
	 */
	public Replicator getReplicator() {
		return this.replicator;
	}
    
	/*
	 * popupwindowt létrehozó függvény
	 */
    private void popupwindow(String message) {
        int n = JOptionPane.showOptionDialog(null, message, "End of Game", JOptionPane.PLAIN_MESSAGE,
                                             JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      
        if (n == 0 || n == -1) {
            System.exit(0);
        }
    }

    /*
     * Játék befejezéséért felelõs függvény
     * Meghívódik, ha meghal egy játékos, vagy zpm felvétel történik
     * Meghívja a popupwindowt
     */
    public void EndofGame() {
    	/*
    	 * kiírjuk a játék végeredményét
    	 */
    	String Zpm = new String("\nColonel's ZPM: " + c.getzpmCounter() + "\nJaffa's ZPM: " +j.getzpmCounter());
    	/*
    	 * Ha mind a 2 karakter halott, akkor game over, senki sem nyer
    	 */
        if ((j.getisAlive() == false) && (c.getisAlive() == false)) {
            popupwindow("Game Over" + Zpm);
        }
        /*
         * Ha elérjük a felvehetõ zpm-ek összes számát, és
         * Ha a colonel vett fel több zpm-et, és életben van, akkor a Colonel nyert, egyébként a Jaffa 
         */
        if ((j.getzpmCounter() + c.getzpmCounter()) == zpmdb) {
            if (c.getzpmCounter() > j.getzpmCounter()) {
                if (c.getisAlive()) {
                    popupwindow("Colonel wins" + Zpm);
                    
                } else {
                    popupwindow("Jaffa wins" + Zpm);
                }
            } 
            
            /*
             * Ha ugyanannyi zpm-et vett fel a két karakter, és mindketten életben vannak, akkor döntetlen
             */
            if (c.getzpmCounter() == j.getzpmCounter()) {
                if (c.getisAlive()) {
                    if (j.getisAlive()) {
                        popupwindow("Draw" + Zpm);
                    } else {
                        popupwindow("Colonel wins" + Zpm );
                    }
                } else {
                    popupwindow("Jaffa wins" + Zpm);
                }
            }
            
            /*
             * Ha a jaffa vett fel több zpm-et, és életben van, akkor a jaffa nyert, egyébként a colonel 
             */
            if (j.getzpmCounter() > c.getzpmCounter()) {
                if (j.getisAlive()) {
                    popupwindow("Jaffa wins" + Zpm );
                } else {
                    popupwindow("Colonel wins" + Zpm);
                }
            }
        }
        
    }
    
    /*
     * elemeket tartalamzó lista gettere
     */
	public LinkedList<Entity> getList() {
		return ll;
	}

	public void buildMAP() {

		/*
		 *  txt-ben:
		 *  1 - ajto1
		 *	2 - merleg1
		 *
		 * 	3 - ajto2
		 * 	4 - merleg2
		 * 	
		 * 	5 - ajto3
		 * 	6 - merleg3
		 * stb..
		 */ 

		/*
		 * Pálya felépítése a beolvasott txt alapján
		 * elemek egyesével történõ hozzáadásával
		 * 
		 * 30x30-as pálya
		 */
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				switch (m.getElement(x, y)) {
				//ajtó hozzáadása (1)
				case '1':
					door1 = new Door(x * 32, y * 32, ch);
					ll.add(door1);
					break;
				//ajtó hozzáadása (2)
				case '3':
					door2 = new Door(x * 32, y * 32, ch);
					ll.add(door2);
					break;
				//ajtó hozzáadása (3)
				case '5':
					door3 = new Door(x * 32, y * 32, ch);
					ll.add(door3);
					break;
				//fal hozzáadása
				case 'w':
					ll.add(new Wall(x * 32, y * 32, false, ch));
					break;
				//speciális fal hozzáadása
				case 'q':
					ll.add(new Wall(x * 32, y * 32, true, ch));
					break;
				//zpm hozzáadása
				case 'z':
					ll.add(new Zpm(x * 32, y * 32, ch));
					zpmdb++;
					break;
				//doboz hozzáadása
				case 'b':
					ll.add(new Box(x * 32, y * 32, ch));
					break;
				//szakadék hozzáadása
				case 'p':
					ll.add(new Pit(x * 32, y * 32, ch));
					break;
				/*
				 * Portálok hozzáadása
				 */
				case 'y':
					ll.add(new Portal(x * 32, y * 32, "yellow", ch));
					break;
				case 'k':
					ll.add(new Portal(x * 32, y * 32, "blue", ch));
					break;
				case 'g':
					ll.add(new Portal(x * 32, y * 32, "green", ch));
					break;
				case 'x':
					ll.add(new Portal(x * 32, y * 32, "red", ch));
					break;
				}
			} // for x
		} // for y

		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				switch (m.getElement(x, y)) {
				/*
				 * Mérlegek hozzáadása, ajtókkal párosítva
				 */
				
				// Mérleg hozzáadása (1)
				case '2':
					scale1 = new Scale(x * 32, y * 32, door1, 2, ch);
					ll.add(scale1);
					break;
				// Mérleg hozzáadása (2)
				case '4':
					scale2 = new Scale(x * 32, y * 32, door2, 1, ch);
					ll.add(scale2);
					break;
				// Mérleg hozzáadása (3)
				case '6':
					scale3 = new Scale(x * 32, y * 32, door3, 1, ch);
					ll.add(scale3);
					break;
					
				}
			} //for y
		} //for x
	}

	/*
	 * Grafikus megjelenítés
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		/*
		 * pálya kirajzolása
		 * ahol nincs elem ott alapszínnel való kitöltése
		 */
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				g.setColor(Color.WHITE);
				g.fillRect(x * 32, y * 32, 32, 32);
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(x * 32, y * 32, 32, 32);
			}
		}
		
		//colonel által kilõtt lövedék kirajzolása
		if (c.getBullet() != null) {
			c.getBullet().render(g);
		}
		
		//jaffa által kilõtt lövedék kirajzolása
		if (j.getBullet() != null) {
			j.getBullet().render(g);
		}
	
		//replicator kirajzolása
		replicator.render(g);
		
		//pálya elemeintek kirajzolása
		for (int i = 0; i < ll.size(); ++i) {
			ll.get(i).render(g);
		}
		
		//Colonel kirajzolása
		c.render(g);
		//Jaffa kirajzolása
		j.render(g);
		
		
	}

	/*
	 * ZMP darabszám gettere
	 */
	public int getZpmdb() {
		return zpmdb;
	}

	/*
	 * ZPM darabszám settere
	 */
	public void setZpmdb(int i) {
		this.zpmdb = i;
	}

	/*
	 * Cntrl belsõ osztály
	 * Felhasználói input kezeléséhez
	 */
	public class Cntrl extends KeyAdapter {
		/*
		 * Colonel illetve Jaffa lenyomva tart-e egy gombot
		 */
		boolean keypressedC = false;
		boolean keypressedJ = false;
		
		/*
		 * Billentyûparancsok:
		 * Karakterek irányítása,
		 * Replikátor léptetése, ha egy karakter lép,
		 * Doboz felvétele,
		 * Lövedékek lövése
		 * 
		 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			
			//Ha él a Colonel, akkor léphetünk vele
			if (c.getisAlive()) {
				/*
				 * Lépés felfelé
				 */
				if (keycode == KeyEvent.VK_UP) {
					//Ha nincs lenyomva billentyû akkor lépünk a Colonellel
					//beállítjuk milyen irányba néz
					if(keypressedC == false){
						c.move(0, -32);
						c.setFacing("up");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedC = true;
				}
				/*
				 * Lépés lefelé
				 */
				if (keycode == KeyEvent.VK_DOWN) {
					//Ha nincs lenyomva billentyû akkor lépünk a Colonellel
					//beállítjuk milyen irányba néz
					if(keypressedC == false){
						c.move(0, 32);
						c.setFacing("down");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedC = true;
				}
				/*
				 * Lépés balra
				 */
				if (keycode == KeyEvent.VK_LEFT) {
					//Ha nincs lenyomva billentyû akkor lépünk a Colonellel
					//beállítjuk milyen irányba néz
					if(keypressedC == false){
						c.move(-32, 0);
						c.setFacing("left");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedC = true;
				}
				/*
				 * Lépés jobbra
				 */
				if (keycode == KeyEvent.VK_RIGHT) {
					//Ha nincs lenyomva billentyû akkor lépünk a Colonellel
					//beállítjuk milyen irányba néz
					if(keypressedC == false){
						c.move(32, 0);
						c.setFacing("right");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedC = true;
					
				}
				/*
				 * Sárga lövedék lövése
				 */
				if (keycode == KeyEvent.VK_N) {
					//ha volt már portál adott koordinátán, akkor megszüntetjük, falat rakunk a helyére
					if (c.getPortalYellow_y() != -1 && c.getPortalYellow_x() != -1) {
						ll.remove(c.getP2());
						ll.add(new Wall(c.getPortalYellow_x(), c.getPortalYellow_y(), true, ch));
						//-1-el jelezzük, hogy nincs nyitott portál
						c.setPortalYellow_x(-1);
						c.setPortalYellow_y(-1);
					}
					//lövedék színének beállítása, kilövése
					c.shoot("yellow");

				}
				/*
				 * Kék lövedék lövése
				 */
				if (keycode == KeyEvent.VK_M) {
					//ha volt már portál adott koordinátán, akkor megszüntetjük, falat rakunk a helyére
					if (c.getPortalBlue_y() != -1 && c.getPortalBlue_x() != -1) {
						ll.remove(c.getP1());
						ll.add(new Wall(c.getPortalBlue_x(), c.getPortalBlue_y(), true, ch));
						//-1-el jelezzük, hogy nincs nyitott portál
						c.setPortalBlue_x(-1);
						c.setPortalBlue_y(-1);
					}
					//lövedék színének beállítása, kilövése
					c.shoot("blue");

				}
				/*
				 * Doboz felvétele, lerakása
				 */
				if (keycode == KeyEvent.VK_B) {
					boolean chechIfStangindOnBox = false;
					
					
					int CollisionIndexinListofElements = c.Coll_Character(c, ll);
					
					//vizsgáljuk, hogy dobozon állunk-e
					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(c);
					}
					//ha dobozzon állunk, és nincs a kezünkben még doboz, akkor felvesszük,
					//ha van a kezünkben akkor rárakjuk a másik dobozra, vagy a helyen még nincs doboz, akkor
					//simán lerakjuk, és lesz ott egy doboz
					if (chechIfStangindOnBox) {
						if (c.gethaveBox()) {
							c.putDown();
						} else {
							c.pickUp(CollisionIndexinListofElements);
							chechIfStangindOnBox = false;
						}
					} else {
						if (c.gethaveBox()) {
							c.putDown();
						}
					}
				}

			}
			
			//Ha él a Jaffa, akkor léphetünk vele
			if (j.getisAlive()) {
				/*
				 * Lépés felfelé
				 */
				if (keycode == KeyEvent.VK_W) {
					//Ha nincs lenyomva billentyû akkor lépünk a Jaffaval
					//beállítjuk milyen irányba néz
					if(keypressedJ == false){
						j.move(0, -32);
						j.setFacing("up");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedJ = true;
				}
				/*
				 * Lépés lefelé
				 */
				if (keycode == KeyEvent.VK_S) {
					//Ha nincs lenyomva billentyû akkor lépünk a Jaffaval
					//beállítjuk milyen irányba néz
					if(keypressedJ == false){
						j.move(0, 32);
						j.setFacing("down");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedJ = true;
				}
				/*
				 * Lépés balra
				 */
				if (keycode == KeyEvent.VK_A) {
					//Ha nincs lenyomva billentyû akkor lépünk a Jaffaval
					//beállítjuk milyen irányba néz
					if(keypressedJ == false){
						j.move(-32, 0);
						j.setFacing("left");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedJ = true;
				}
				/*
				 * Lépés jobbra
				 */
				if (keycode == KeyEvent.VK_D) {
					//Ha nincs lenyomva billentyû akkor lépünk a Jaffaval
					//beállítjuk milyen irányba néz
					if(keypressedJ == false){
						j.move(32, 0);
						j.setFacing("right");
					}
					//Ha él a replikátor, akkor léptetjük random irányba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billentyûzet jelzése
					keypressedJ = true;
				}
				/*
				 * Zöld lövedék lövése
				 */
				if (keycode == KeyEvent.VK_Q){
					//ha volt már portál adott koordinátán, akkor megszüntetjük, falat rakunk a helyére
					if (j.getPortalGreen_y() != -1 && j.getPortalGreen_x() != -1) {
						ll.remove(j.getP2());
						ll.add(new Wall(j.getPortalGreen_x(), j.getPortalGreen_y(), true, ch));
						//-1-el jelezzük, hogy nincs nyitott portál
						j.setPortalGreen_x(-1);
						j.setPortalGreen_y(-1);
					}
					//lövedék színének beállítása, kilövése
					j.shoot("green");	
				}
				/*
				 * Piros lövedék lövése
				 */
				if (keycode == KeyEvent.VK_E) {
					//ha volt már portál adott koordinátán, akkor megszüntetjük, falat rakunk a helyére
					if (j.getPortalRed_y() != -1 && j.getPortalRed_x() != -1) {
						ll.remove(j.getP1());
						ll.add(new Wall(j.getPortalRed_x(), j.getPortalRed_y(), true, ch));
						//-1-el jelezzük, hogy nincs nyitott portál
						j.setPortalRed_x(-1);
						j.setPortalRed_y(-1);

					}
					//lövedék színének beállítása, kilövése
					j.shoot("red");
				}
				/*
				 * Doboz felvétele, lerakása
				 */
				if (keycode == KeyEvent.VK_F) {
					boolean chechIfStangindOnBox = false;

					int CollisionIndexinListofElements = j.Coll_Character(j, ll);
					
					//vizsgáljuk, hogy dobozon állunk-e
					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(j);
					}
					
					//ha dobozzon állunk, és nincs a kezünkben még doboz, akkor felvesszük,
					//ha van a kezünkben akkor rárakjuk a másik dobozra, vagy a helyen még nincs doboz, akkor
					//simán lerakjuk, és lesz ott egy doboz
					if (chechIfStangindOnBox) {
						if (j.gethaveBox()) {
							j.putDown();
						} else {
							j.pickUp(CollisionIndexinListofElements);
							chechIfStangindOnBox = false;
						}
					} else {
						if (j.gethaveBox()) {
							j.putDown();
						}
					}
					
				}

			}
		}
		
		
		/*
		 * Karakterek mozgatásakor a léptetõ billentyûzetek
		 * lenyomásakor a keypressedC és keypressedJ változókat
		 * true-ra állítjuk, hogy ne lehessen lenyomva tartani a billentyût
		 * és folyton lépni a karakterrel.
		 * Ezt felengedéskor false-ra álíltjuk, hogy léphessünk megint a következõ lenyomáskor.
		 * 
		 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
		 */
		public void keyReleased(KeyEvent e){
			int keycode = e.getKeyCode();
			//Ha él a colonel akkor figyeljük a billentyûfelengedést, úgy mint a lenyomást
			if (c.getisAlive()) {
				if (keycode == KeyEvent.VK_UP) {
					keypressedC = false;
				}
				if (keycode == KeyEvent.VK_DOWN) {
					keypressedC = false;
				}
				if (keycode == KeyEvent.VK_LEFT) {
					keypressedC = false;
				}
				if (keycode == KeyEvent.VK_RIGHT) {
					keypressedC = false;
				}
			}
			//Ha él a jaffa akkor figyeljük a billentyûfelengedést, úgy mint a lenyomást
			if(j.getisAlive()){
				if (keycode == KeyEvent.VK_W) {
					keypressedJ = false;
				}
				if (keycode == KeyEvent.VK_S) {
					keypressedJ = false;
				}
				if (keycode == KeyEvent.VK_A) {
					keypressedJ = false;
				}
				if (keycode == KeyEvent.VK_D) {
					keypressedJ = false;
				}
		}
			
		}
		
	
	}

}
