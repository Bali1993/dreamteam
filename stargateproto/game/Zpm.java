package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Zpm extends Element{

	public Zpm(int x, int y, Character ch) {
		super(x, y, ch);
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Zpm].onCollision();");
		
		
		//sgg lek�r�se
		StarGateGame.tab++;
		StarGateGame VariableForSGG = character.getSGG();
		StarGateGame.tab--;
		
		//ZPM elt�vol�t�sa a list�b�l
		StarGateGame.tab++;
		VariableForSGG.getList().remove(this);
		StarGateGame.tab--;
		
		//zpmCounter n�vel�se 1-el
		character.setzpmCounter(1);
		
		//ha az egyik karakter begy�jt 2 ZPM-et, akkor keletkezik egy �j ZPM egy v�letlenszer� helyen
		//adott karaktern�l sz�moljuk k�l�n h begy�jt�tt-e kett�t
		if(character.getzpmCounter() % 2 == 0){
			boolean collision = true; //kezdetben azt mondjuk, hogy �tk�z�s van
			int xForNewZPM = 0; //fordito sir h inicializ�ljam valamennyire
			int yForNewZPM = 0;
			
			//addig gener�ljon Rectangle-ket az �j ZPM-nek mig �tk�z�s van
			while(collision == true){
				//gener�lunk egy Rectangle-t az �j ZPM-nek
				// min �s max sz�mok k�z�tt gener�l egy random sz�mot, ak�r v�gpontokat is bele�rtve
				int min = 1; int max = 29;
				Random random1 = new Random();
				xForNewZPM = random1.nextInt(max - min + 1) + min;
				Random random2 = new Random();
				yForNewZPM = random2.nextInt(max - min + 1) + min;
				
				//szorz�s 32-vel
				xForNewZPM = xForNewZPM * 32;
				yForNewZPM = yForNewZPM * 32;
				
				//Rectangle k�pz�se a koordin�t�kb�l
				Rectangle RecOfNewZPM = new Rectangle( xForNewZPM,  yForNewZPM, 32, 32);
				System.out.println(RecOfNewZPM);
				
				//�t�ll�tjuk az �tk�z�s �rt�k�t hamisra
				//�s v�gig megy�nk a l�ncolt lista minden elem�n
				//intersect eset�n az �tk�z�s �rt�ke igaz lesz
				collision = false;
				for(int k=0; k < VariableForSGG.getList().size(); ++k)
				{	
					//adott elem n�gyzete a l�ncolt list�ban
					Rectangle RecOfElement = VariableForSGG.getList().get(k).getRec();
					
					//�sszehasonl�tjuk az �j ZPM �s adott elem n�gyzet�t, hogy egyezik-e
					//ha igen, akkor �tk�z�s van
					if(RecOfNewZPM.intersects(RecOfElement)){
						collision = true;
					}
				}
				
			}
			

			//bearkjuk a l�ncolt list�ba az �j ZPM-et
			VariableForSGG.getList().add(new Zpm(xForNewZPM, yForNewZPM, ch));
			
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
