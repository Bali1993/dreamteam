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
	
	// Ez a függvény adja meg, hogy mit csinál a doboz, ha vele ütközünk
	@Override
	public void onCollision(int dx, int dy, int i) {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			if (input.equals("i") || input.equals("I")) { // Beolvassuk a válaszát
				//elõfeltétel biztosítása a teszteléshez
				//beállítjuk biztosra h az ezredesnél nincs dobox, hogy ezután fel tudja venni
				//ez a függvény csak teszteléshez kell, ezért nem irjuk ki a nevét!
				c.sethaveBox(false);
				
				StarGateGame.tab++;
				c.haveBoxInverter(i, false); //elõfeltétel biztosítása miatt pickUp()-ot fog hívni
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
