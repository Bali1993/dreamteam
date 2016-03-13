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
					ll.add(new Wall(x*32, y*32));
					break;
				case "r":
					break;
				case "z":
					break;
				case "b":
					break;
				case "s":
					break;
				case "q":
					break;
				case "d":
					break;
				case "p":
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
		for(int y=0; y<30; y++){
			for(int x=0; x<30; x++){				
				switch (m.getElement(x, y)){
				case "w": 					
					g.setColor(Color.BLACK);
					g.fillRect(x*32,y*32,32,32);
					g.setColor(Color.WHITE);
					g.drawRect(x*32,y*32,32,32);
					//g.drawImage(m.getWall(), x*32, y*32, null);
					break;
				case "r":
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(x*32,y*32,32,32);
					g.setColor(Color.WHITE);
					g.drawRect(x*32,y*32,32,32);
					//g.drawImage(m.getRoad(), x*32, y*32, null);
					break;
				case "z":
					//g.drawImage(m.getZPM(), x*32, y*32, null);
					break;
				case "b":
					//g.drawImage(m.getBox(), x*32, y*32, null);
					break;
				case "s":
					//g.drawImage(m.getScale(), x*32, y*32, null);
					break;
				case "q": //wall_spec
					//g.drawImage(m.getWall_Spec(), x*32, y*32, null);
					break;
				case "d":
					//g.drawImage(m.getDoor(), x*32, y*32, null);
					break;
				case "p":
					//g.drawImage(m.getPit(), x*32, y*32, null);
					break;
				default: 
					g.setColor(Color.RED);
					g.fillRect(x*32,y*32,32,32);
					break;
				}
			}//for x
		}//for y
		g.setColor(Color.MAGENTA);
		g.fillRect(c.getX(),c.getY(), 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(c.getX(),c.getY(), 32, 32);
	}
	
	
	/*
	 * egyszer� billenty�zetkezel�s, WASD
	 */
	public class Cntrl extends KeyAdapter{		
	
		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_W){
				c.move(0, -32, 0, -1);	
			}	
			if(keycode == KeyEvent.VK_S){
				c.move(0, 32, 0, 1);
			}
			if(keycode == KeyEvent.VK_A){
				c.move(-32, 0, -1, 0);
			}
			if(keycode == KeyEvent.VK_D){
				c.move(32, 0, 32, 0);
			}
		}
		public void keyReleased(KeyEvent e){
			
		}
	}

	
}
