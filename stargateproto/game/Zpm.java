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
		
		
		//sgg lekérése
		StarGateGame.tab++;
		StarGateGame VariableForSGG = character.getSGG();
		StarGateGame.tab--;
		
		//ZPM eltávolítása a listából
		StarGateGame.tab++;
		VariableForSGG.getList().remove(this);
		StarGateGame.tab--;
		
		//zpmCounter növelése 1-el
		character.setzpmCounter(1);
		
		//ha az egyik karakter begyûjt 2 ZPM-et, akkor keletkezik egy új ZPM egy véletlenszerû helyen
		//adott karakternél számoljuk külön h begyüjtött-e kettõt
		if(character.getzpmCounter() % 2 == 0){
			boolean collision = true; //kezdetben azt mondjuk, hogy ütközés van
			int xForNewZPM = 0; //fordito sir h inicializáljam valamennyire
			int yForNewZPM = 0;
			
			//addig generáljon Rectangle-ket az új ZPM-nek mig ütközés van
			while(collision == true){
				//generálunk egy Rectangle-t az új ZPM-nek
				// min és max számok között generál egy random számot, akár végpontokat is beleértve
				int min = 1; int max = 29;
				Random random1 = new Random();
				xForNewZPM = random1.nextInt(max - min + 1) + min;
				Random random2 = new Random();
				yForNewZPM = random2.nextInt(max - min + 1) + min;
				
				//szorzás 32-vel
				xForNewZPM = xForNewZPM * 32;
				yForNewZPM = yForNewZPM * 32;
				
				//Rectangle képzése a koordinátákból
				Rectangle RecOfNewZPM = new Rectangle( xForNewZPM,  yForNewZPM, 32, 32);
				System.out.println(RecOfNewZPM);
				
				//átállítjuk az ütközés értékét hamisra
				//és végig megyünk a láncolt lista minden elemén
				//intersect esetén az ütközés értéke igaz lesz
				collision = false;
				for(int k=0; k < VariableForSGG.getList().size(); ++k)
				{	
					//adott elem négyzete a láncolt listában
					Rectangle RecOfElement = VariableForSGG.getList().get(k).getRec();
					
					//összehasonlítjuk az új ZPM és adott elem négyzetét, hogy egyezik-e
					//ha igen, akkor ütközés van
					if(RecOfNewZPM.intersects(RecOfElement)){
						collision = true;
					}
				}
				
			}
			

			//bearkjuk a láncolt listába az új ZPM-et
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
