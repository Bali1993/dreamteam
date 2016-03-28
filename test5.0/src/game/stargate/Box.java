package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Box extends Element{
	public Box(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}
	
	// Ez a f�ggv�ny adja meg, hogy mit csin�l a doboz, ha vele �tk�z�nk
	@Override
	public void onCollision(int dx, int dy, int i) {
		for (int j = 0; j < StarGateGame.tab; j++) // Ki�ratjuk a megfelel� forrm�ban a nev�t
			System.out.print("\t");
		System.out.println("-> [:Box].onCollision();");
		
		//ez a "Felveszi a dobozt?" k�rd�s csak a tesztel�shez kell,
		//mikor majd j�tszunk egy v�gtelen ciklusba olvasunk itt, m�g el nem l�p a mez�r�l az ezredes
		//-> pickUp(), putDown(), move() megh�v�sa sz�ks�ges
		//eml�keztet�: haveBoxInverter() seg�ts�g�vel lehet pickup() / putDown()-ot megh�vni
		System.out.println("Felveszi a dobozt? I/N"); // Felhaszn�l�t�l
														// megk�rdezz�k, hogy
														// mit csin�ljunk a
														// dobozzal
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			if (input.equals("i") || input.equals("I")) { // Beolvassuk a v�lasz�t
				//el�felt�tel biztos�t�sa a tesztel�shez
				//be�ll�tjuk biztosra h az ezredesn�l nincs dobox, hogy ezut�n fel tudja venni
				//ez a f�ggv�ny csak tesztel�shez kell, ez�rt nem irjuk ki a nev�t!
				c.sethaveBox(false);
				
				StarGateGame.tab++;
				c.haveBoxInverter(i, false); //el�felt�tel biztos�t�sa miatt pickUp()-ot fog h�vni
				StarGateGame.tab--;
			} else if (input.equals("n") || input.equals("N")) {

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].onCollision():void;");
	}

	@Override
	public void render(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Box].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
