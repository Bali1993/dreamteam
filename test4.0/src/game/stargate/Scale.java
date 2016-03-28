package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scale extends Element{
	
	private Door d;
	//private boolean isPressedByColonel; sztem nem kell
	//private boolean isPressedByBox; //rendes implementációhoz kell majd
	
	public Scale(int x2, int y2, Colonel c, Door d) {
		super(x2, y2, c);
		this.d = d;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].onCollision();");
		
		
		//ütközés hatására ajtó kinyitása
		//itt fontos tab++, tab-- al körbe venni, mert openDoor-on belül történik további függvény hívás
		StarGateGame.tab++;
		d.openDoor();
		StarGateGame.tab--;
		
		
		///////////////////////////////////////////////////////////////////////////////
		//
		//ha majd a rendes játék implementáció lesz, a következõ részt így kéne megirni:
		//
		///////////////////////////////////////////////////////////////////////////////
		/*
					//mivel az ajtó zárás nem ütközésre történik, hanem mérleg->út lépés hatására
					//kénytelenek vagyunk itt egy karaktert olvasni, és aszerint eljárni
			
					//ciklusba kéne tenni...
					
						//lelépés mérlegrõl, ha a nyil billentyûk közül valamelyiket megnyomta a user
						StarGateGame.tab++;
						if(isPressedByBox == false)
							d.closeDoor();
						StarGateGame.tab--;
				
						
						//SPACE betû megnyomása, box felvétele v lerakása
						StarGateGame.tab++;
						c.haveBoxInverter(-1, true); //pickUp() vagy putDown() meghívása
						//-1 index a pickUp() miatt kell, hogy ne törölje ki a mérleget a listából
						if(c.gethaveBox() == true)
							isPressedByBox = false;
						if(c.gethaveBox() == false)
							isPressedByBox = true;
						StarGateGame.tab--;
						
						//stb..
		*/
		//rendes játék impl. vége
		///////////////////////////////////////////////////////////////////////////////////
		
						
						
		///////////////////////////////////////////////////////////////////////////////
		//
		//							teszt implementáció:
		//
		///////////////////////////////////////////////////////////////////////////////				
		System.out.println("Ajtó bezárása? I/N");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		String input = br.readLine();
		if (input.equals("i") || input.equals("I")) { // Beolvassuk a válaszát
		
		StarGateGame.tab++;
		d.closeDoor();
		StarGateGame.tab--;
		} else if (input.equals("n") || input.equals("N")) {
		
		}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}				
						
		//teszt impl. vége
		///////////////////////////////////////////////////////////////////////////////////		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Scale].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}

	@Override
	public Rectangle getRec(){
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].getRec();");
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Scale].getRec():Rectangle;");
		return new Rectangle(x, y, 32, 32);
	}
}
