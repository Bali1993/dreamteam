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
		//				rendes j�t�k implement�ci�, sztem mondhatni k�sz:
		//
		///////////////////////////////////////////////////////////////////////////////
		
		//ha a saj�t sz�ne s�rga, akkor lek�rdezi a m�sik k�k port�l helyzet�t �s ir�ny�t
		if(colour == "yellow"){
			StarGateGame.tab++;
				int X_blue = character.getPortalOne_x();
				int Y_blue = character.getPortalOne_y();
				String bluePortalFacing = character.getPortalOne_Facing();
				
				//teh�t ha nyitva van a m�sik port�l,  teleport�lja oda az ezredest
				if(X_blue != -1){
					if(bluePortalFacing == "up"){character.setX(X_blue - 32); character.setY(Y_blue);}
					if(bluePortalFacing == "down"){character.setX(X_blue + 32); character.setY(Y_blue);}
					if(bluePortalFacing == "left"){character.setX(X_blue); character.setY(Y_blue - 32);}
					if(bluePortalFacing == "right"){character.setX(X_blue); character.setY(Y_blue + 32);}
				}
				else{//lepattan mint a falr�l
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		
		//ha a saj�t sz�ne k�k, akkor lek�rdezi a m�sik s�rga port�l helyzet�t �s ir�ny�t
		if(colour == "blue"){
			StarGateGame.tab++;
				int X_yellow = character.getPortalTwo_x();
				int Y_yellow = character.getPortalTwo_y();
				String yellowPortalFacing = character.getPortalTwo_Facing();
				
				//teh�t ha nyitva van a m�sik port�l, teleport�lja oda az ezredest
				if(X_yellow != -1){
					if(yellowPortalFacing == "up"){character.setX(X_yellow - 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "down"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "left"){character.setX(X_yellow); character.setY(Y_yellow - 32);}
					if(yellowPortalFacing == "right"){character.setX(X_yellow); character.setY(Y_yellow + 32);}
				}
				else{//lepattan mint a falr�l
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		//rendes j�t�k impl. v�ge
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
