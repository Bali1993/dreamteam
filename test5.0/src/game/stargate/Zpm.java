package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Zpm extends Element{

	public Zpm(int x2, int y2, Colonel c) {
		super(x2, y2, c);
	}

	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].onCollision();");
		
		
		//sgg lek�r�se
		StarGateGame.tab++;
		StarGateGame VariableForSGG = c.getSGG();
		StarGateGame.tab--;
		
		//ZPM elt�vol�t�sa a list�b�l
		StarGateGame.tab++;
		VariableForSGG.getList().remove(i);
		StarGateGame.tab--;
		
		//zpmCounter n�vel�se, alapesetben 1-el de most 5-el n�velj�k �s
		//ezzel biztos�tj�k az el�felt�teleket is a tesztel�shez
		//ez�rt a teszthez nem is irjuk ki az int i param�tert
		StarGateGame.tab++;
		c.setzpmCounter(5);
		StarGateGame.tab--;
		
		System.out.println("J�t�k megnyer�se? I/N");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		String input = br.readLine();
		if (input.equals("i") || input.equals("I")) { // Beolvassuk a v�lasz�t			
			StarGateGame.tab++;
			if(c.getzpmCounter() == 5)
				VariableForSGG.win();
			StarGateGame.tab--;
		} else if (input.equals("n") || input.equals("N")) {
		
		}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Zpm].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getZPM(), x*32, y*32, null);
	}
	
	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Zpm].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
