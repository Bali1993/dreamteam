package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends Element{
	public Box(int x2, int y2) {
		super(x2, y2);
	}
	
	// Ez a f�ggv�ny adja meg, hogy mit csin�l a doboz, ha vele �tk�z�nk
	@Override
	public void onCollision(int dx, int dy, int i, Character charachter) {
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
