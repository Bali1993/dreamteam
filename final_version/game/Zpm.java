package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Zpm extends Element {

	private Image image_zpm;
	
	public Zpm(int x, int y, Character ch) {
		super(x, y, ch);
		
		//kep eltarolasa
		image_zpm = ch.getSGG().getMap().get_image_zpm();
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

		StarGateGame VariableForSGG = character.getSGG();
        character.setzpmCounter(1);
        
		VariableForSGG.getList().remove(this);
		

		// ha az egyik karakter begyűjt 2 ZPM-et, akkor keletkezik egy új ZPM
		// egy véletlenszerű helyen
		// adott karakternél számoljuk közben, hogy begyűjtött-e kettőt
		if (character.getzpmCounter() % 2 == 0) {
			boolean collision = true; // kezdetben azt mondjuk, hogy ütközés van
			int xForNewZPM = 0; // Inicializálás egy alapértelmezett értékkel
			int yForNewZPM = 0;

			// addig generáljon Rectangle-ket az új ZPM-nek mig ütközés van
			while (collision == true) {
				// generálunk egy Rectangle-t az új ZPM-nek
				// min és max számok között generál egy random számot, akár
				// végpontokat is beleértve
				int min = 1;
				int max = 29;
				Random random1 = new Random();
				xForNewZPM = random1.nextInt(max - min + 1) + min;
				Random random2 = new Random();
				yForNewZPM = random2.nextInt(max - min + 1) + min;

				// szorzás 32-vel
				xForNewZPM = xForNewZPM * 32;
				yForNewZPM = yForNewZPM * 32;

				// Rectangle készítése a koordinátákból
				Rectangle RecOfNewZPM = new Rectangle(xForNewZPM, yForNewZPM, 32, 32);
				
				//atallitjuk az utkozés erteket hamisra
				// és végig megyünk a láncolt lista minden elemén
				// intersect esetén az ütközés értéke igaz lesz
				collision = false;
				for (int k = 0; k < VariableForSGG.getList().size(); ++k) {
					// adott elem négyzete a láncolt listában
					Rectangle RecOfElement = VariableForSGG.getList().get(k).getRec();

					// összehasonlítjuk az adott elem, és az új ZPM négyzetét, hogy
					// egyezik-e
					// ha igen, akkor ütközés van
					if (RecOfNewZPM.intersects(RecOfElement)) {
						collision = true;
					}
				}

			}
			// bearkjuk a láncolt listába az új ZPM-et
			VariableForSGG.setZpmdb(VariableForSGG.getZpmdb() + 1);
			VariableForSGG.getList().add(new Zpm(xForNewZPM, yForNewZPM, ch));

		}
		VariableForSGG.EndofGame(); //Vizsgáljuk hogy van e még zpm a pályán, ha nincs, nyertest hirdetünk
	}
	
	/*
	 * A lövedék átrepül a zpm-ek felett
	 */
	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image_zpm, this.x + 1, this.y + 1, 31, 31, null);
	}


}
