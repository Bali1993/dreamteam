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
	//private boolean isPressedByBox; //rendes implement�ci�hoz kell majd
	
	public Scale(int x2, int y2, Colonel c, Door d) {
		super(x2, y2, c);
		this.d = d;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].onCollision();");
		
		
		//�tk�z�s hat�s�ra ajt� kinyit�sa
		//itt fontos tab++, tab-- al k�rbe venni, mert openDoor-on bel�l t�rt�nik tov�bbi f�ggv�ny h�v�s
		StarGateGame.tab++;
		d.openDoor();
		StarGateGame.tab--;
		
		
		///////////////////////////////////////////////////////////////////////////////
		//
		//ha majd a rendes j�t�k implement�ci� lesz, a k�vetkez� r�szt �gy k�ne megirni:
		//
		///////////////////////////////////////////////////////////////////////////////
		/*
					//mivel az ajt� z�r�s nem �tk�z�sre t�rt�nik, hanem m�rleg->�t l�p�s hat�s�ra
					//k�nytelenek vagyunk itt egy karaktert olvasni, �s aszerint elj�rni
			
					//ciklusba k�ne tenni...
					
						//lel�p�s m�rlegr�l, ha a nyil billenty�k k�z�l valamelyiket megnyomta a user
						StarGateGame.tab++;
						if(isPressedByBox == false)
							d.closeDoor();
						StarGateGame.tab--;
				
						
						//SPACE bet� megnyom�sa, box felv�tele v lerak�sa
						StarGateGame.tab++;
						c.haveBoxInverter(-1, true); //pickUp() vagy putDown() megh�v�sa
						//-1 index a pickUp() miatt kell, hogy ne t�r�lje ki a m�rleget a list�b�l
						if(c.gethaveBox() == true)
							isPressedByBox = false;
						if(c.gethaveBox() == false)
							isPressedByBox = true;
						StarGateGame.tab--;
						
						//stb..
		*/
		//rendes j�t�k impl. v�ge
		///////////////////////////////////////////////////////////////////////////////////
		
						
						
		///////////////////////////////////////////////////////////////////////////////
		//
		//							teszt implement�ci�:
		//
		///////////////////////////////////////////////////////////////////////////////				
		System.out.println("Ajt� bez�r�sa? I/N");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		String input = br.readLine();
		if (input.equals("i") || input.equals("I")) { // Beolvassuk a v�lasz�t
		
		StarGateGame.tab++;
		d.closeDoor();
		StarGateGame.tab--;
		} else if (input.equals("n") || input.equals("N")) {
		
		}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}				
						
		//teszt impl. v�ge
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
