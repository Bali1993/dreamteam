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
	
	//�sszes felvehet� ZPM sz�m
	private int zpmdb;

	private Character ch;

	//referencia a l�trehozott colonelre
	private Character c;
	//referencia a l�trehozott jaffara
	private Character j;
	//referencia a l�trehozott replicatorra
	private Replicator replicator;

	//a p�lya elemeit tartalmaz� l�mcolt lista
	private LinkedList<Entity> ll;
	
	/*
	 * m�rleg-ajt� p�rosok referenci�i
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
     * A StarGateGame oszt�ly konstruktora
     * Attrib�tumok inicializ�l�sa
     * P�lya �p�t�se
     * 
     * Karakterek l�trehoz�sa
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
		// p�lya �p�t�se
		buildMAP();
		/*
		 * colonel �s jaffa l�trehoz�sa, berak�sa a p�ly�ra
		 */
		c = new Character(this, 32, 32);
		j = new Character(this, 896, 32);
		
		//replik�tor l�trehoz�sa
		replicator = new Replicator(this, 32, 896);

		//keylistener hozz�ad�sa
		addKeyListener(new Cntrl());
		setFocusable(true);

		//timer hozz�ad�sa, ind�t�sa
		timer = new Timer(25, this);
		timer.start();
	}
	
	/*
	 * P�lya �jrarajzol�sa, ha valami interakci� t�rt�nik
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	/*
	 * A txtb�l felt�lt�tt t�mb gettere
	 */
	public Map getMap(){
		return this.m;
	}

	/*
	 * A 3 ajt� gettere
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
	 * A 3 m�rleg gettere
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
	 * popupwindowt l�trehoz� f�ggv�ny
	 */
    private void popupwindow(String message) {
        int n = JOptionPane.showOptionDialog(null, message, "End of Game", JOptionPane.PLAIN_MESSAGE,
                                             JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      
        if (n == 0 || n == -1) {
            System.exit(0);
        }
    }

    /*
     * J�t�k befejez�s��rt felel�s f�ggv�ny
     * Megh�v�dik, ha meghal egy j�t�kos, vagy zpm felv�tel t�rt�nik
     * Megh�vja a popupwindowt
     */
    public void EndofGame() {
    	/*
    	 * ki�rjuk a j�t�k v�geredm�ny�t
    	 */
    	String Zpm = new String("\nColonel's ZPM: " + c.getzpmCounter() + "\nJaffa's ZPM: " +j.getzpmCounter());
    	/*
    	 * Ha mind a 2 karakter halott, akkor game over, senki sem nyer
    	 */
        if ((j.getisAlive() == false) && (c.getisAlive() == false)) {
            popupwindow("Game Over" + Zpm);
        }
        /*
         * Ha el�rj�k a felvehet� zpm-ek �sszes sz�m�t, �s
         * Ha a colonel vett fel t�bb zpm-et, �s �letben van, akkor a Colonel nyert, egy�bk�nt a Jaffa 
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
             * Ha ugyanannyi zpm-et vett fel a k�t karakter, �s mindketten �letben vannak, akkor d�ntetlen
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
             * Ha a jaffa vett fel t�bb zpm-et, �s �letben van, akkor a jaffa nyert, egy�bk�nt a colonel 
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
     * elemeket tartalamz� lista gettere
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
		 * P�lya fel�p�t�se a beolvasott txt alapj�n
		 * elemek egyes�vel t�rt�n� hozz�ad�s�val
		 * 
		 * 30x30-as p�lya
		 */
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				switch (m.getElement(x, y)) {
				//ajt� hozz�ad�sa (1)
				case '1':
					door1 = new Door(x * 32, y * 32, ch);
					ll.add(door1);
					break;
				//ajt� hozz�ad�sa (2)
				case '3':
					door2 = new Door(x * 32, y * 32, ch);
					ll.add(door2);
					break;
				//ajt� hozz�ad�sa (3)
				case '5':
					door3 = new Door(x * 32, y * 32, ch);
					ll.add(door3);
					break;
				//fal hozz�ad�sa
				case 'w':
					ll.add(new Wall(x * 32, y * 32, false, ch));
					break;
				//speci�lis fal hozz�ad�sa
				case 'q':
					ll.add(new Wall(x * 32, y * 32, true, ch));
					break;
				//zpm hozz�ad�sa
				case 'z':
					ll.add(new Zpm(x * 32, y * 32, ch));
					zpmdb++;
					break;
				//doboz hozz�ad�sa
				case 'b':
					ll.add(new Box(x * 32, y * 32, ch));
					break;
				//szakad�k hozz�ad�sa
				case 'p':
					ll.add(new Pit(x * 32, y * 32, ch));
					break;
				/*
				 * Port�lok hozz�ad�sa
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
				 * M�rlegek hozz�ad�sa, ajt�kkal p�ros�tva
				 */
				
				// M�rleg hozz�ad�sa (1)
				case '2':
					scale1 = new Scale(x * 32, y * 32, door1, 2, ch);
					ll.add(scale1);
					break;
				// M�rleg hozz�ad�sa (2)
				case '4':
					scale2 = new Scale(x * 32, y * 32, door2, 1, ch);
					ll.add(scale2);
					break;
				// M�rleg hozz�ad�sa (3)
				case '6':
					scale3 = new Scale(x * 32, y * 32, door3, 1, ch);
					ll.add(scale3);
					break;
					
				}
			} //for y
		} //for x
	}

	/*
	 * Grafikus megjelen�t�s
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		/*
		 * p�lya kirajzol�sa
		 * ahol nincs elem ott alapsz�nnel val� kit�lt�se
		 */
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				g.setColor(Color.WHITE);
				g.fillRect(x * 32, y * 32, 32, 32);
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(x * 32, y * 32, 32, 32);
			}
		}
		
		//colonel �ltal kil�tt l�ved�k kirajzol�sa
		if (c.getBullet() != null) {
			c.getBullet().render(g);
		}
		
		//jaffa �ltal kil�tt l�ved�k kirajzol�sa
		if (j.getBullet() != null) {
			j.getBullet().render(g);
		}
	
		//replicator kirajzol�sa
		replicator.render(g);
		
		//p�lya elemeintek kirajzol�sa
		for (int i = 0; i < ll.size(); ++i) {
			ll.get(i).render(g);
		}
		
		//Colonel kirajzol�sa
		c.render(g);
		//Jaffa kirajzol�sa
		j.render(g);
		
		
	}

	/*
	 * ZMP darabsz�m gettere
	 */
	public int getZpmdb() {
		return zpmdb;
	}

	/*
	 * ZPM darabsz�m settere
	 */
	public void setZpmdb(int i) {
		this.zpmdb = i;
	}

	/*
	 * Cntrl bels� oszt�ly
	 * Felhaszn�l�i input kezel�s�hez
	 */
	public class Cntrl extends KeyAdapter {
		/*
		 * Colonel illetve Jaffa lenyomva tart-e egy gombot
		 */
		boolean keypressedC = false;
		boolean keypressedJ = false;
		
		/*
		 * Billenty�parancsok:
		 * Karakterek ir�ny�t�sa,
		 * Replik�tor l�ptet�se, ha egy karakter l�p,
		 * Doboz felv�tele,
		 * L�ved�kek l�v�se
		 * 
		 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			
			//Ha �l a Colonel, akkor l�phet�nk vele
			if (c.getisAlive()) {
				/*
				 * L�p�s felfel�
				 */
				if (keycode == KeyEvent.VK_UP) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Colonellel
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedC == false){
						c.move(0, -32);
						c.setFacing("up");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedC = true;
				}
				/*
				 * L�p�s lefel�
				 */
				if (keycode == KeyEvent.VK_DOWN) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Colonellel
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedC == false){
						c.move(0, 32);
						c.setFacing("down");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedC = true;
				}
				/*
				 * L�p�s balra
				 */
				if (keycode == KeyEvent.VK_LEFT) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Colonellel
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedC == false){
						c.move(-32, 0);
						c.setFacing("left");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedC = true;
				}
				/*
				 * L�p�s jobbra
				 */
				if (keycode == KeyEvent.VK_RIGHT) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Colonellel
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedC == false){
						c.move(32, 0);
						c.setFacing("right");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedC = true;
					
				}
				/*
				 * S�rga l�ved�k l�v�se
				 */
				if (keycode == KeyEvent.VK_N) {
					//ha volt m�r port�l adott koordin�t�n, akkor megsz�ntetj�k, falat rakunk a hely�re
					if (c.getPortalYellow_y() != -1 && c.getPortalYellow_x() != -1) {
						ll.remove(c.getP2());
						ll.add(new Wall(c.getPortalYellow_x(), c.getPortalYellow_y(), true, ch));
						//-1-el jelezz�k, hogy nincs nyitott port�l
						c.setPortalYellow_x(-1);
						c.setPortalYellow_y(-1);
					}
					//l�ved�k sz�n�nek be�ll�t�sa, kil�v�se
					c.shoot("yellow");

				}
				/*
				 * K�k l�ved�k l�v�se
				 */
				if (keycode == KeyEvent.VK_M) {
					//ha volt m�r port�l adott koordin�t�n, akkor megsz�ntetj�k, falat rakunk a hely�re
					if (c.getPortalBlue_y() != -1 && c.getPortalBlue_x() != -1) {
						ll.remove(c.getP1());
						ll.add(new Wall(c.getPortalBlue_x(), c.getPortalBlue_y(), true, ch));
						//-1-el jelezz�k, hogy nincs nyitott port�l
						c.setPortalBlue_x(-1);
						c.setPortalBlue_y(-1);
					}
					//l�ved�k sz�n�nek be�ll�t�sa, kil�v�se
					c.shoot("blue");

				}
				/*
				 * Doboz felv�tele, lerak�sa
				 */
				if (keycode == KeyEvent.VK_B) {
					boolean chechIfStangindOnBox = false;
					
					
					int CollisionIndexinListofElements = c.Coll_Character(c, ll);
					
					//vizsg�ljuk, hogy dobozon �llunk-e
					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(c);
					}
					//ha dobozzon �llunk, �s nincs a kez�nkben m�g doboz, akkor felvessz�k,
					//ha van a kez�nkben akkor r�rakjuk a m�sik dobozra, vagy a helyen m�g nincs doboz, akkor
					//sim�n lerakjuk, �s lesz ott egy doboz
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
			
			//Ha �l a Jaffa, akkor l�phet�nk vele
			if (j.getisAlive()) {
				/*
				 * L�p�s felfel�
				 */
				if (keycode == KeyEvent.VK_W) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Jaffaval
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedJ == false){
						j.move(0, -32);
						j.setFacing("up");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedJ = true;
				}
				/*
				 * L�p�s lefel�
				 */
				if (keycode == KeyEvent.VK_S) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Jaffaval
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedJ == false){
						j.move(0, 32);
						j.setFacing("down");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedJ = true;
				}
				/*
				 * L�p�s balra
				 */
				if (keycode == KeyEvent.VK_A) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Jaffaval
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedJ == false){
						j.move(-32, 0);
						j.setFacing("left");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedJ = true;
				}
				/*
				 * L�p�s jobbra
				 */
				if (keycode == KeyEvent.VK_D) {
					//Ha nincs lenyomva billenty� akkor l�p�nk a Jaffaval
					//be�ll�tjuk milyen ir�nyba n�z
					if(keypressedJ == false){
						j.move(32, 0);
						j.setFacing("right");
					}
					//Ha �l a replik�tor, akkor l�ptetj�k random ir�nyba
					if (replicator.getisAlive() == true)
						replicator.move();
					//Lenyomott billenty�zet jelz�se
					keypressedJ = true;
				}
				/*
				 * Z�ld l�ved�k l�v�se
				 */
				if (keycode == KeyEvent.VK_Q){
					//ha volt m�r port�l adott koordin�t�n, akkor megsz�ntetj�k, falat rakunk a hely�re
					if (j.getPortalGreen_y() != -1 && j.getPortalGreen_x() != -1) {
						ll.remove(j.getP2());
						ll.add(new Wall(j.getPortalGreen_x(), j.getPortalGreen_y(), true, ch));
						//-1-el jelezz�k, hogy nincs nyitott port�l
						j.setPortalGreen_x(-1);
						j.setPortalGreen_y(-1);
					}
					//l�ved�k sz�n�nek be�ll�t�sa, kil�v�se
					j.shoot("green");	
				}
				/*
				 * Piros l�ved�k l�v�se
				 */
				if (keycode == KeyEvent.VK_E) {
					//ha volt m�r port�l adott koordin�t�n, akkor megsz�ntetj�k, falat rakunk a hely�re
					if (j.getPortalRed_y() != -1 && j.getPortalRed_x() != -1) {
						ll.remove(j.getP1());
						ll.add(new Wall(j.getPortalRed_x(), j.getPortalRed_y(), true, ch));
						//-1-el jelezz�k, hogy nincs nyitott port�l
						j.setPortalRed_x(-1);
						j.setPortalRed_y(-1);

					}
					//l�ved�k sz�n�nek be�ll�t�sa, kil�v�se
					j.shoot("red");
				}
				/*
				 * Doboz felv�tele, lerak�sa
				 */
				if (keycode == KeyEvent.VK_F) {
					boolean chechIfStangindOnBox = false;

					int CollisionIndexinListofElements = j.Coll_Character(j, ll);
					
					//vizsg�ljuk, hogy dobozon �llunk-e
					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(j);
					}
					
					//ha dobozzon �llunk, �s nincs a kez�nkben m�g doboz, akkor felvessz�k,
					//ha van a kez�nkben akkor r�rakjuk a m�sik dobozra, vagy a helyen m�g nincs doboz, akkor
					//sim�n lerakjuk, �s lesz ott egy doboz
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
		 * Karakterek mozgat�sakor a l�ptet� billenty�zetek
		 * lenyom�sakor a keypressedC �s keypressedJ v�ltoz�kat
		 * true-ra �ll�tjuk, hogy ne lehessen lenyomva tartani a billenty�t
		 * �s folyton l�pni a karakterrel.
		 * Ezt felenged�skor false-ra �l�ltjuk, hogy l�phess�nk megint a k�vetkez� lenyom�skor.
		 * 
		 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
		 */
		public void keyReleased(KeyEvent e){
			int keycode = e.getKeyCode();
			//Ha �l a colonel akkor figyelj�k a billenty�felenged�st, �gy mint a lenyom�st
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
			//Ha �l a jaffa akkor figyelj�k a billenty�felenged�st, �gy mint a lenyom�st
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
