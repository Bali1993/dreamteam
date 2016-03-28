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
		
		//opendoor, closedoor meghívása
		
		//ütközés hatására ajtó kinyitása
		//itt fontos tab++, tab-- al körbe venni, mert openDoor-on belül történik további függvény hívás
		StarGateGame.tab++;
		d.openDoor(c.getSGG().getList().indexOf(d));
		StarGateGame.tab--;
		
		//mivel az ajtó zárás nem ütközésre történik, hanem mérleg->út lépés hatására
		//kénytelenek vagyunk itt egy karaktert olvasni, és aszerint eljárni
		
		//ciklusba kéne tenni...
		
			//lelépés mérlegrõl
			StarGateGame.tab++;
			d.closeDoor(c.getSGG().getList().indexOf(d));
			StarGateGame.tab--;
	
			
			//b betû megnyomása, box felvétele v lerakása
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
