package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StarGateGame extends JPanel implements ActionListener{
	
	
	
	/*TODO
	 * mérleg-ajtó class
	 * bullet-portal class
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	private Timer timer;
	
	private Map m;
	private Colonel c;
	
	public StarGateGame(){
		
		m = new Map();
		c = new Colonel();
		
		addKeyListener(new Cntrl());
		setFocusable(true);
		
		timer = new Timer(25, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public Colonel getColonel(){
		return this.c;
	}
	public void setColonel(Colonel cc){
		this.c = cc;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for(int y=0; y<30; y++){
			for(int x=0; x<30; x++){				
				switch (m.getElement(x, y)){
				case "w": 
					g.setColor(Color.BLACK);
					g.fillRect(x*32,y*32,32,32);
					//g.drawImage(m.getWall(), x*32, y*32, null);
					break;
				case "r":
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(x*32,y*32,32,32);
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
		g.setColor(Color.YELLOW);
		g.fillRect(c.getX(),c.getY(), 32, 32);
	
	}
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
