package game.stargate;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
/*
 * semmi extra, egyel�re csak az ablakot hozza l�tre, lehet h nem is lesz itt semmi m�s
 * tal�n ha akarunk egy olyat h restart, akk azt itt k�ne
 */
public class StarGate extends Canvas {
	public final String TITLE = "StarGate";	
	
	public StarGate(){
		JFrame frame = new JFrame(this.TITLE);
				
		frame.add(new StarGateGame());
		//frame.pack();
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void start() {
		// TODO Auto-generated method stub
	}
	
	public static void main(String args[]){
		StarGate sg = new StarGate();
		
		
		sg.start();
			
	}

	
}
