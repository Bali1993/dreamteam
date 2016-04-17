package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Box extends Element{ 
	private int weight;
	private KeyListener keylistener;
	private Character character; //akivel �tk�zik a doboz, jaffa vagy colonel, onCollWithCharacter-be adunk neki �rt�ket
	int boxIndex; 
	//a box saj�t indexe a list�ban, nem szabad konstruktorban (�s CntrlForBox-ban sem) mert
	//a list�ba rak�sa, csak a l�trehoz�sa (�s konstruktor lefut�s) ut�n t�rt�nik!
	//ez�rt inicializ�lom az onCollWithCharacter()-ben, mert ott m�r biztos hogy a megfelel� �rt�ket kapja
	
	public Box(int x, int y, Character ch) { 
		super(x, y, ch);
		System.out.println("l�trejott egy doboz");
		this.weight = 30;
		
		keylistener = new CntrlForBox();
	
	}
	
	
	// Ez a f�ggv�ny adja meg, hogy mit csin�l a doboz, ha vele �tk�z�nk
	@Override
	public  void onCollisionWithCharacter(Character character, int dx, int dy) {
		for (int j = 0; j < StarGateGame.tab; j++) // Ki�ratjuk a megfelel� forrm�ban a nev�t
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
	} // cntrl v�ge
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 32, 32);
		//g.drawImage(m.getBox(), x*32, y*32, null);
	}
	
}
