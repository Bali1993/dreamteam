package game.stargate;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

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
