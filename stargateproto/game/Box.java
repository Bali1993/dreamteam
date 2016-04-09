package game;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends Element{
	private int weight;
	
	public Box(int x, int y, Character ch) {
		super(x, y, ch);
		this.weight = 30;
	}
	
	// Ez a f�ggv�ny adja meg, hogy mit csin�l a doboz, ha vele �tk�z�nk
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for (int j = 0; j < StarGateGame.tab; j++) // Ki�ratjuk a megfelel� forrm�ban a nev�t
			System.out.print("\t");
		System.out.println("-> [:Box].onCollision();");
		
		//mikor majd j�tszunk egy v�gtelen ciklusba olvasunk itt, m�g el nem l�p a mez�r�l a karakter
		//-> pickUp(), putDown(), move() megh�v�sa sz�ks�ges
		//eml�keztet�: haveBoxInverter() seg�ts�g�vel lehet pickup() / putDown()-ot megh�vni

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
