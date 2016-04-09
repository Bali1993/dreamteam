package game;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Element{
	
	private Door d;
	//private boolean isPressedByColonel; sztem nem kell
	//private boolean isPressedByBox; // ez se kell
	private int CurrentWeight; //aktualis s�ly �sszesen a m�rlegen
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
		
		
		//�tk�z�s hat�s�ra ajt� kinyit�sa
		//itt fontos tab++, tab-- al k�rbe venni, mert openDoor-on bel�l t�rt�nik tov�bbi f�ggv�ny h�v�s
		StarGateGame.tab++;
		d.openDoor();
		StarGateGame.tab--;
		
		
		///////////////////////////////////////////////////////////////////////////////
		//
		//ha majd a rendes j�t�k implement�ci� lesz, a k�vetkez� r�szt �gy k�ne megirni:
		// mivel a program v�ltozott, ez m�r nem vmi j�..
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
