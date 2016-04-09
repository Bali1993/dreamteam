package game;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Element{
	
	private Door d;
	//private boolean isPressedByColonel; sztem nem kell
	//private boolean isPressedByBox; // ez se kell
	private int CurrentWeight; //aktualis súly összesen a mérlegen
	private int WeightLimit;
	
	public Scale(int x, int y, Door d, int WeightLimit, Character ch) {
		super(x, y, ch);
		this.d = d;
		this.CurrentWeight = 0;
		this.WeightLimit = WeightLimit;
	}
	
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
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
		// mivel a program változott, ez már nem vmi jó..
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
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Scale].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getScale(), x*32, y*32, null);
	}

}
