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

	// maximum zpm szÃ¡m amit fel lehet venni!!!
	private int zpmdb;

	private Character ch;

	private Character c;
	private Character j;
	private Replicator replicator;

	private LinkedList<Entity> ll;
	private Scale scale1;
	private Scale scale2;
	private Scale scale3;
	private Door door1;
	private Door door2;
	private Door door3;
    private Object[] options = { "QUIT" };
	
	public StarGateGame() {
		door1 = null;
		door2 = null;
		door3 = null;
		scale1 = null;
		scale2 = null;
		scale3 = null;
		zpmdb = 0;

		m = new Map();
		c = new Character(this, 32, 32);
		j = new Character(this, 896, 32);

		ch = new Character(this, 96, 96);
		
		int Replicator_x = 32;
		int Replicator_y = 896;
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

	public Door getDoor1() {
		return door1;
	}

	public Door getDoor2() {
		return door2;
	}
	public Door getDoor3() {
		return door3;
	}

	public Scale getScale1() {
		return scale1;
	}

	public Scale getScale2() {
		return scale2;
	}
	
	public Scale getScale3() {
		return scale3;
	}

	public Character getColonel() {
		return this.c;
	}

	public Character getJaffa() {
		return this.j;
	}

	public Replicator getReplicator() {
		return this.replicator;
	}
    
    private void popupwindow(String message) {
        int n = JOptionPane.showOptionDialog(null, message, "End of Game", JOptionPane.PLAIN_MESSAGE,
                                             JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        System.out.println(n);
        if (n == 0 || n == -1) {
            System.exit(0);
        }
    }

    public void EndofGame() {
    	String Zpm = new String("\nColonel's ZPM: " + c.getzpmCounter() + "\nJaffa's ZPM: " +j.getzpmCounter());
        if ((j.getisAlive() == false) && (c.getisAlive() == false)) {
        	
            System.out.println("game over" + Zpm);
            popupwindow("Game Over" + Zpm);
            
            
        }
        if ((j.getzpmCounter() + c.getzpmCounter()) == zpmdb) {
            if (c.getzpmCounter() > j.getzpmCounter()) {
                if (c.getisAlive()) {
                    System.out.println("colonel wins" + Zpm);
                    popupwindow("Colonel wins" + Zpm);
                    
                } else {
                    System.out.println("jaffa wins" + Zpm);
                    popupwindow("Jaffa wins" + Zpm);
                }
            }
            if (c.getzpmCounter() == j.getzpmCounter()) {
                if (c.getisAlive()) {
                    if (j.getisAlive()) {
                        popupwindow("Draw" + Zpm);
                        System.out.println("Draw" + Zpm);
                    } else {
                        popupwindow("Colonel wins" + Zpm );
                        System.out.println("colonel wins" + Zpm );
                    }
                } else {
                    popupwindow("Jaffa wins" + Zpm);
                    System.out.println("Jaffa wins" + Zpm);
                }
            }
            if (j.getzpmCounter() > c.getzpmCounter()) {
                if (j.getisAlive()) {
                    System.out.println("Jaffa wins" + Zpm);
                    popupwindow("Jaffa wins" + Zpm );
                } else {
                    popupwindow("Colonel wins" + Zpm);
                    System.out.println("colonel wins" + Zpm);
                }
            }
        }
        
    }

	public LinkedList<Entity> getList() {
		return ll;
	}

	public void buildMAP() {

		// txt-ben:
		// 1 - ajto1
		// 2 - mï¿½rleg1
		

		// 3 - ajto2
		// 4 - mï¿½rleg2
		
		// 5 - ajto3
		// 6 - mérleg3
		// stb..

		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				switch (m.getElement(x, y)) {
				case '1':
					door1 = new Door(x * 32, y * 32, ch);
					ll.add(door1);
					break;
				case '3':
					door2 = new Door(x * 32, y * 32, ch);
					ll.add(door2);
					break;
				case '5':
					door3 = new Door(x * 32, y * 32, ch);
					ll.add(door3);
					break;
				case 'w':
					ll.add(new Wall(x * 32, y * 32, false, ch));
					break;
				case 'q':
					ll.add(new Wall(x * 32, y * 32, true, ch));
					break;
				case 'z':
					ll.add(new Zpm(x * 32, y * 32, ch));
					zpmdb++;
					break;
				case 'b':
					ll.add(new Box(x * 32, y * 32, ch));
					break;
				case 'p':
					ll.add(new Pit(x * 32, y * 32, ch));
					break;
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
				/*
				 * case '2': ll.add(new Scale(x*32, y*32, door1, 100, ch));
				 * break; case '4': ll.add(new Scale(x*32, y*32, door2, 100,
				 * ch)); break;
				 */
				}
			} // for x
		} // for y

		// majd ï¿½jra vï¿½gig megyï¿½nk a pï¿½lyï¿½n ï¿½s most mï¿½r lï¿½trehozzuk a mï¿½rlegeket
		// is
		// a mï¿½rleg konstruktorï¿½ba mï¿½r ï¿½t tudjuk adni a megfelelï¿½ ajtï¿½t is
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				switch (m.getElement(x, y)) {
				case '2':
					scale1 = new Scale(x * 32, y * 32, door1, 2, ch);
					ll.add(scale1);
					break;
				case '4':
					scale2 = new Scale(x * 32, y * 32, door2, 1, ch);
					ll.add(scale2);
					break;
				case '6':
					scale3 = new Scale(x * 32, y * 32, door3, 1, ch);
					ll.add(scale3);
					break;
					
				}
			}
		}
	}

	/*
	 * itt rajzoljuk ki, azï¿½rt kï¿½lï¿½n mert kï¿½lï¿½nben mindig ï¿½jratï¿½ltenï¿½ fel a
	 * listï¿½nkat a kï¿½l. elemekkel
	 * 
	 * TODO:kï¿½pek szï¿½nes nï¿½gyzetek helyett
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 30; y++) {
				g.setColor(Color.WHITE);
				g.fillRect(x * 32, y * 32, 32, 32);
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(x * 32, y * 32, 32, 32);
			}
		}
		
		if (c.getBullet() != null) {
			c.getBullet().render(g);
			}
			
		if (j.getBullet() != null) {
			j.getBullet().render(g);
		}
	
		replicator.render(g);
		for (int i = 0; i < ll.size(); ++i) {
			ll.get(i).render(g);
		}
		
		c.render(g);
		j.render(g);
		
		
	}

	public int getZpmdb() {
		return zpmdb;
	}

	public void setZpmdb(int i) {
		this.zpmdb = i;
	}

	public class Cntrl extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			if (c.getisAlive()) {
				if (keycode == KeyEvent.VK_UP) {
					c.move(0, -32);
					c.setFacing("up");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_DOWN) {
					c.move(0, 32);
					c.setFacing("down");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_LEFT) {
					c.move(-32, 0);
					c.setFacing("left");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_RIGHT) {
					c.move(32, 0);
					c.setFacing("right");
					if (replicator.getisAlive() == true)
						replicator.move();
				}

				if (keycode == KeyEvent.VK_N) {
					if (c.getPortalYellow_y() != -1 && c.getPortalYellow_x() != -1) {
						ll.remove(c.getP2());
						ll.add(new Wall(c.getPortalYellow_x(), c.getPortalYellow_y(), true, ch));
						c.setPortalYellow_x(-1);
						c.setPortalYellow_y(-1);
					}
					c.shoot("yellow");

				}
				if (keycode == KeyEvent.VK_M) {
					if (c.getPortalBlue_y() != -1 && c.getPortalBlue_x() != -1) {
						ll.remove(c.getP1());
						ll.add(new Wall(c.getPortalBlue_x(), c.getPortalBlue_y(), true, ch));
						c.setPortalBlue_x(-1);
						c.setPortalBlue_y(-1);
					}
					c.shoot("blue");

				}
				if (keycode == KeyEvent.VK_B) {
					boolean chechIfStangindOnBox = false;

					int CollisionIndexinListofElements = c.Coll_Character(c, ll);

					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(c);
					}

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
			if (j.getisAlive()) {
				if (keycode == KeyEvent.VK_W) {
					j.move(0, -32);
					j.setFacing("up");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_S) {
					j.move(0, 32);
					j.setFacing("down");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_A) {
					j.move(-32, 0);
					j.setFacing("left");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_D) {
					j.move(32, 0);
					j.setFacing("right");
					if (replicator.getisAlive() == true)
						replicator.move();
				}
				if (keycode == KeyEvent.VK_Q){
					if (j.getPortalGreen_y() != -1 && j.getPortalGreen_x() != -1) {
						ll.remove(j.getP2());
						ll.add(new Wall(j.getPortalGreen_x(), j.getPortalGreen_y(), true, ch));
						j.setPortalGreen_x(-1);
						j.setPortalGreen_y(-1);
					}
					j.shoot("green");	
				}
				if (keycode == KeyEvent.VK_E) {
					if (j.getPortalRed_y() != -1 && j.getPortalRed_x() != -1) {
						ll.remove(j.getP1());
						ll.add(new Wall(j.getPortalRed_x(), j.getPortalRed_y(), true, ch));
						j.setPortalRed_x(-1);
						j.setPortalRed_y(-1);

					}
					j.shoot("red");
				}
				if (keycode == KeyEvent.VK_F) {
					boolean chechIfStangindOnBox = false;

					int CollisionIndexinListofElements = j.Coll_Character(j, ll);

					if (CollisionIndexinListofElements >= 0) {
						chechIfStangindOnBox = ll.get(CollisionIndexinListofElements).ifStandingOnBox(j);
					}

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
	}

}
