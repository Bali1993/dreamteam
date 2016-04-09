package game;

import java.awt.Color;
import java.awt.Graphics;

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
		
		
		//mikor majd játszunk egy végtelen ciklusba olvasunk itt, míg el nem lép a mezõrõl az ezredes
		//-> pickUp(), putDown(), move() meghívása szükséges
		//emlékeztetõ: haveBoxInverter() segítségével lehet pickup() / putDown()-ot meghívni

		for (int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].onCollision():void;");
	}

	@Override
	public void render(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
}
