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
	
	private Timer timer;
	
	private Map m;
	private Colonel c;
	/*
	 * Entity az�rt kell mert sima <object>-et kap, annak nincs defini�lva a getRec() f�ggv�nye, �gy nem tudn�nk emgh�vni
	 * minden elemre egyes�vel a lek�rdez�st.
	 */
	private LinkedList<Entity> ll;
	
	
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
	
	public LinkedList<Entity> getList(){
		return ll;
	}
	/*
	 * fel�p�ti a p�ly�t, v�gigmegy a map[ t�mb�n �s v�giggelen�rzi a stringek karaktereit, majd az alapj�n 
	 * berakja a l�ncolt list�ba
	 * 
	 *egyel�re csak fal 
	 */
	public void buildMAP(){
		for(int y=0; y<30; y++){
			for(int x=0; x<30; x++){				
				switch (m.getElement(x, y)){
				case "w": 					
					ll.add(new Wall(x*32, y*32, c));
					break;
				case "z":
					ll.add(new Zpm(x*32, y*32, c));
					break;
				case "b":
					ll.add(new Box(x*32, y*32, c));
					break;
				case "s":
					ll.add(new Scale(x*32, y*32, c));
					break;
				case "q":
					break;
				case "d":
					ll.add(new Door(x*32, y*32, c));
					break;
				case "p":
					ll.add(new Pit(x*32, y*32, c));
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
		for(int y=0; y<30; y++){
			for(int x=0; x<30; x++){								
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
				c.move(0, -32);	
				c.setFacing("up");
			}	
			if(keycode == KeyEvent.VK_DOWN){
				c.move(0, 32);
				c.setFacing("down");
			}
			if(keycode == KeyEvent.VK_LEFT){
				c.move(-32, 0);
				c.setFacing("left");
			}
			if(keycode == KeyEvent.VK_RIGHT){
				c.move(32, 0);
				c.setFacing("right");
			}
			if(keycode == KeyEvent.VK_SPACE){
				
			}
		}
	}

	
}
