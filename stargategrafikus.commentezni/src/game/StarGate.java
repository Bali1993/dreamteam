package game;

import java.awt.Canvas;

import javax.swing.JFrame;

public class StarGate extends Canvas {
	private static final long serialVersionUID = 1L;
	public final String TITLE = "StarGate";
	private StarGateGame sgg;

	public StarGate(StarGateGame g) {
		this.sgg = g;

		JFrame frame = new JFrame(this.TITLE);

		frame.add(sgg);
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		StarGateGame sgg = new StarGateGame();
		StarGate sg = new StarGate(sgg);

	}

}
