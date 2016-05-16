package game;

import java.awt.Canvas;

import javax.swing.JFrame;

public class StarGate extends Canvas {
	private static final long serialVersionUID = 1L;
	//Játék programunk fejlécének szövege
	public final String TITLE = "StarGate";
	//Referencia egy StarGateGame objektumra, 
	//hogy elérjük azon keresztül a függvényeit
	private StarGateGame sgg;
	
	//Az osztály konstruktora, melyben értéket adunk az sgg változónak
	public StarGate(StarGateGame g) {
		this.sgg = g;
		
		// És inicializáljuk az ablakunkat
		JFrame frame = new JFrame(this.TITLE);

		frame.add(sgg);
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//A main függvény, ami példányosítja a két szükséges objektumot,
	// ezzel elindítva a játékot.
	public static void main(String[] args) {
		StarGateGame sgg = new StarGateGame();
		StarGate sg = new StarGate(sgg);

	}

}
