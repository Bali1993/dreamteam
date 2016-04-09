package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Zpm extends Element{

	public Zpm(int x2, int y2) {
		super(x2, y2);
	}

	@Override
	public void onCollision(int dx, int dy, int i, Character character) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].onCollision();");
		
		
		//sgg lek�r�se
		StarGateGame.tab++;
		StarGateGame VariableForSGG = character.getSGG();
		StarGateGame.tab--;
		
		//ZPM elt�vol�t�sa a list�b�l
		StarGateGame.tab++;
		VariableForSGG.getList().remove(i);
		StarGateGame.tab--;
		
		//zpmCounter n�vel�se 1-el
		character.setzpmCounter(1);
		
		//ha az egyik karakter begy�jt 2 ZPM-et, akkor keletkezik egy �j ZPM egy v�letlenszer� helyen
		//adott karaktern�l sz�moljuk k�l�n h begy�jt�tt-e kett�t
		if(character.getzpmCounter() % 2 == 0){
			boolean collision = true;
			int xForNewZPM = 0; //fordito sir h inicializ�ljam valamennyire
			int yForNewZPM = 0;
			
			while(collision == true){
				//gener�lunk egy Rectangle-t az �j ZPM-nek
				// min �s max sz�mok k�z�tt gener�l egy random sz�mot, ak�r v�gpontokat is bele�rtve
				int min = 1; int max = 29;
				Random random1 = new Random();
				xForNewZPM = random1.nextInt(max - min + 1) + min;
				Random random2 = new Random();
				yForNewZPM = random2.nextInt(max - min + 1) + min;
				
				//Rectangle k�pz�se a koordin�t�kb�l
				Rectangle RecOfNewZPM = new Rectangle( xForNewZPM,  yForNewZPM, 32, 32);
				
				for(int k=0; k < VariableForSGG.getList().size(); ++k)
				{	
					//adott elem n�gyzete a l�ncolt list�ban
					Rectangle RecOfElement = VariableForSGG.getList().get(k).getRec();
					//�sszehasonl�tjuk az �j ZPM �s adott elem n�gyzet�t, hogy egyezik-e
					//ha igen, akkor �tk�z�s van
					if(RecOfNewZPM.intersects(RecOfElement) == false){
						collision = false;
						break;
					}
					
				}
			}
			
			//bearkjuk a l�ncolt list�ba az �j ZPM-et
			VariableForSGG.getList().add(new Zpm(xForNewZPM*32, yForNewZPM*32));
			
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
}
