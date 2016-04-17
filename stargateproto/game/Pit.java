package game;

import java.awt.Color;
import java.awt.Graphics;

public class Pit extends Element{

	public Pit(int x, int y, Character ch) {
		super(x, y, ch);
	}
	

	@Override
	public void onCollisionWithReplicator(Replicator replicator, int dx, int dy){
		//sgg lek�r�se
		StarGateGame VariableForSGG = ch.getSGG();
		
		//szakad�k elt�vol�t�sa a list�b�l, saj�t mag�t elt�vol�tja
		VariableForSGG.getList().remove(this);
		
		//replik�tor megsemmisit�se
		replicator.destroy();
	}
	
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Pit].onCollision();");
		
		//
		StarGateGame.tab++;
		character.setisAlive(false);
		StarGateGame.tab--;
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Pit].onCollision():void;");
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 32, 32);
		//g.drawImage(m.getPit(), x*32, y*32, null);
	}
	
}
