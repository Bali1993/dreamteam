package game.stargate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Scale extends Element{
	
	private Door d;
	//private boolean isPressedByColonel; sztem nem kell
	private boolean isPressedByBox;
	
	public Scale(int x2, int y2, Colonel c, Door d) {
		super(x2, y2, c);
		this.d = d;
	}
	
	@Override
	public void onCollision(int dx, int dy, int i) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Scale].onCollision();");
		
		//opendoor, closedoor megh�v�sa
		
		//�tk�z�s hat�s�ra ajt� kinyit�sa
		//itt fontos tab++, tab-- al k�rbe venni, mert openDoor-on bel�l t�rt�nik tov�bbi f�ggv�ny h�v�s
		StarGateGame.tab++;
		d.openDoor(c.getSGG().getList().indexOf(d));
		StarGateGame.tab--;
		
		//mivel az ajt� z�r�s nem �tk�z�sre t�rt�nik, hanem m�rleg->�t l�p�s hat�s�ra
		//k�nytelenek vagyunk itt egy karaktert olvasni, �s aszerint elj�rni
		
		//ciklusba k�ne tenni...
		
			//lel�p�s m�rlegr�l
			StarGateGame.tab++;
			d.closeDoor(c.getSGG().getList().indexOf(d));
			StarGateGame.tab--;
	
			
			//b bet� megnyom�sa, box felv�tele v lerak�sa
			StarGateGame.tab++;
			c.haveBoxInverter();
			if(c.gethaveBox() == true)
				isPressedByBox = false;
			if(c.gethaveBox() == false)
				isPressedByBox = true;
			StarGateGame.tab--;
			
			//stb..
		
		
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
