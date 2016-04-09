package game;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Element{
	
	private Door d;
	//private boolean isPressedByColonel; sztem nem kell
	//private boolean isPressedByBox; //rendes implement�ci�hoz kell majd
	
	public Scale(int x2, int y2, Door d) {
		super(x2, y2);
		this.d = d;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i, Character character) {
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
