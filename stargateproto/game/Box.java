package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Box extends Element{ 
	private int weight;
	private KeyListener keylistener;
	private Character character; //akivel ütközik a doboz, jaffa vagy colonel, onCollWithCharacter-be adunk neki értéket
	int boxIndex; 
	//a box saját indexe a listában, nem szabad konstruktorban (és CntrlForBox-ban sem) mert
	//a listába rakása, csak a létrehozása (és konstruktor lefutás) után történik!
	//ezért inicializálom az onCollWithCharacter()-ben, mert ott már biztos hogy a megfelelõ értéket kapja
	
	public Box(int x, int y, Character ch) { 
		super(x, y, ch);
		System.out.println("létrejott egy doboz");
		this.weight = 30;
		
		keylistener = new CntrlForBox();
	
	}
	
	
	// Ez a függvény adja meg, hogy mit csinál a doboz, ha vele ütközünk
	@Override
	public  void onCollisionWithCharacter(Character character, int dx, int dy) {
		for (int j = 0; j < StarGateGame.tab; j++) // Kiíratjuk a megfelelõ forrmában a nevét
			System.out.print("\t");
		System.out.println("-> [:Box].onCollision();");
		
		this.character = character;
		this.character.getSGG().addKeyListener(keylistener);
		
		boxIndex = ch.getSGG().getList().indexOf(this);
		System.out.println(boxIndex);
		
		for (int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Box].onCollision():void;");
	}

	
	public class CntrlForBox extends KeyAdapter{	
		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			
			if(keycode == KeyEvent.VK_F || keycode == KeyEvent.VK_NUMPAD0){
				character.pickUp(boxIndex);
				ch.getSGG().removeKeyListener(keylistener);
			}
			else {
				ch.getSGG().removeKeyListener(keylistener);
			}
		}	
	} // cntrl vége
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
	
}
