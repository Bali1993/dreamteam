package game;

import java.awt.Graphics;

public class Portal extends Element{
	
	private String colour; //yellow or blue
	public Portal(int x2, int y2, String colour) {
		super(x2, y2);
		this.colour = colour;
	}
	
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("-> [:Portal].onCollision();");
		
		///////////////////////////////////////////////////////////////////////////////
		//
		//				rendes játék implementáció, sztem mondhatni kész:
		//
		///////////////////////////////////////////////////////////////////////////////
		
		//ha a saját színe sárga, akkor lekérdezi a másik kék portál helyzetét és irányát
		if(colour == "yellow"){
			StarGateGame.tab++;
				int X_blue = character.getPortalOne_x();
				int Y_blue = character.getPortalOne_y();
				String bluePortalFacing = character.getPortalOne_Facing();
				
				//tehát ha nyitva van a másik portál,  teleportálja oda az ezredest
				if(X_blue != -1){
					if(bluePortalFacing == "up"){character.setX(X_blue - 32); character.setY(Y_blue);}
					if(bluePortalFacing == "down"){character.setX(X_blue + 32); character.setY(Y_blue);}
					if(bluePortalFacing == "left"){character.setX(X_blue); character.setY(Y_blue - 32);}
					if(bluePortalFacing == "right"){character.setX(X_blue); character.setY(Y_blue + 32);}
				}
				else{//lepattan mint a falról
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		
		//ha a saját színe kék, akkor lekérdezi a másik sárga portál helyzetét és irányát
		if(colour == "blue"){
			StarGateGame.tab++;
				int X_yellow = character.getPortalTwo_x();
				int Y_yellow = character.getPortalTwo_y();
				String yellowPortalFacing = character.getPortalTwo_Facing();
				
				//tehát ha nyitva van a másik portál, teleportálja oda az ezredest
				if(X_yellow != -1){
					if(yellowPortalFacing == "up"){character.setX(X_yellow - 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "down"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "left"){character.setX(X_yellow); character.setY(Y_yellow - 32);}
					if(yellowPortalFacing == "right"){character.setX(X_yellow); character.setY(Y_yellow + 32);}
				}
				else{//lepattan mint a falról
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		//rendes játék impl. vége
		///////////////////////////////////////////////////////////////////////////////////	
		
		
		for(int j = 0; j < StarGateGame.tab; j++)
			System.out.print("\t");
		System.out.println("<- [:Portal].onCollision():void;");
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
