package game.stargate;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
/*
 * semmi extra, egyelõre csak az ablakot hozza létre, lehet h nem is lesz itt semmi más
 * talán ha akarunk egy olyat h restart, akk azt itt kéne
 */
public class StarGate extends Canvas {
	public final String TITLE = "StarGate";	
	
	StarGateGame sgg;
	
	public StarGate(StarGateGame g){
		this.sgg = g;
		JFrame frame = new JFrame(this.TITLE);
				
		frame.add(sgg);
		//frame.pack();
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		StarGateGame sgg = new StarGateGame();
		StarGate sg = new StarGate(sgg);
		
	}

	
}
