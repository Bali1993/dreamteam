package game;

import java.awt.Color;
import java.awt.Graphics;

public class Pit extends Element {

	//nem képet olvasunk be, csak egy fekete négyzetet rajzolunk ki
	//private Image image_pit;
	
	public Pit(int x, int y, Character ch) {
		super(x, y, ch);
		
		/*
		try{
			File file = new File("../stargate grafikus/src/pit.jpg");
			image_pit = ImageIO.read(file);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/
		
	}

	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		StarGateGame VariableForSGG = ch.getSGG();
		VariableForSGG.getList().remove(this);
		replicator.destroy();
	}

	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		StarGateGame VariableForSGG = ch.getSGG();
		character.setisAlive(false);
		VariableForSGG.EndofGame();
	}

	@Override
	public void onCollisionWithBullet(Bullet bullet, Character c) {

	}

	@Override
	public void render(Graphics g) {
	
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		
		//g.drawImage(image_pit, this.x + 1, this.y + 1, 31, 31, null);
	}

}
