package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends Element{
	public Box(int x2, int y2) {
		super(x2, y2);
	}
	
	// Ez a függvény adja meg, hogy mit csinál a doboz, ha vele ütközünk
	@Override
	public void onCollision(int dx, int dy, int i, Character charachter) {
		for (int j = 0; j < StarGateGame.tab; j++) // Kiíratjuk a megfelelõ forrmában a nevét
			System.out.print("\t");
		System.out.println("-> [:Box].onCollision();");
		
		//ez a "Felveszi a dobozt?" kérdés csak a teszteléshez kell,
		//mikor majd játszunk egy végtelen ciklusba olvasunk itt, míg el nem lép a mezõrõl az ezredes
		//-> pickUp(), putDown(), move() meghívása szükséges
		//emlékeztetõ: haveBoxInverter() segítségével lehet pickup() / putDown()-ot meghívni
		System.out.println("Felveszi a dobozt? I/N"); // Felhasználótól
														// megkérdezzük, hogy
														// mit csináljunk a
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
