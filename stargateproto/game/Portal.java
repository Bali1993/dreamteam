package game;

import java.awt.Graphics;

public class Portal extends Element{
	//private String facing; f�l�esleges, mert a Coloneln�l el van t�rolva, �s a saj�t facingj�t a port�l nem haszn�lja, csak a p�rj��t	
	private String colour; //yellow / blue / red / green

	public Portal(int x, int y, String colour, Character ch) {
		super(x, y, ch);
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
				int X_blue = character.getPortalBlue_x();
				int Y_blue = character.getPortalBlue_y();
				String bluePortalFacing = character.getPortalBlue_Facing();
				System.out.println(X_blue);
				//teh�t ha nyitva van a m�sik port�l,  teleport�lja oda az ezredest
				if(X_blue != -1){
				System.out.println(X_blue);
				System.out.println(bluePortalFacing);
					if(bluePortalFacing == "up"){character.setX(X_blue - 32); character.setY(Y_blue);}
					if(bluePortalFacing == "down"){character.setX(X_blue); character.setY(Y_blue + 32);}
					if(bluePortalFacing == "left"){character.setX(X_blue + 32); character.setY(Y_blue - 32);}
					if(bluePortalFacing == "right"){character.setX(X_blue + 32); character.setY(Y_blue + 32);}
				}
				else{//lepattan mint a falr�l
					System.out.println(X_blue);
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}

		
		//ha a saj�t sz�ne k�k, akkor lek�rdezi a m�sik s�rga port�l helyzet�t �s ir�ny�t
		if(colour == "blue"){
			StarGateGame.tab++;
				int X_yellow = character.getPortalYellow_x();
				int Y_yellow = character.getPortalYellow_y();
				String yellowPortalFacing = character.getPortalYellow_Facing();
				
				//teh�t ha nyitva van a m�sik port�l, teleport�lja oda az ezredest
				if(X_yellow != -1){
					if(yellowPortalFacing == "up"){character.setX(X_yellow - 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "down"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "left"){character.setX(X_yellow); character.setY(Y_yellow - 32);}
					if(yellowPortalFacing == "right"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
				}
				else{//lepattan mint a falr�l
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		
		if(colour == "green"){
			StarGateGame.tab++;
				int X_red = character.getPortalRed_x();
				int Y_red = character.getPortalRed_y();
				String redPortalFacing = character.getPortalRed_Facing();
				
				//teh�t ha nyitva van a m�sik port�l,  teleport�lja oda az ezredest
				if(X_red != -1){
					if(redPortalFacing == "up"){character.setX(X_red - 32); character.setY(Y_red);}
					if(redPortalFacing == "down"){character.setX(X_red); character.setY(Y_red + 32);}
					if(redPortalFacing == "left"){character.setX(X_red + 32); character.setY(Y_red - 32);}
					if(redPortalFacing == "right"){character.setX(X_red + 32); character.setY(Y_red + 32);}
				}
				else{//lepattan mint a falr�l
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}
		
		if(colour == "red"){
			StarGateGame.tab++;
				int X_green = character.getPortalGreen_x();
				int Y_green = character.getPortalGreen_y();
				String greenPortalFacing = character.getPortalGreen_Facing();
				
				//teh�t ha nyitva van a m�sik port�l, teleport�lja oda az ezredest
				if(X_green != -1){
					if(greenPortalFacing == "up"){character.setX(X_green - 32); character.setY(Y_green);}
					if(greenPortalFacing == "down"){character.setX(X_green); character.setY(Y_green + 32);}
					if(greenPortalFacing == "left"){character.setX(X_green); character.setY(Y_green - 32);}
					if(greenPortalFacing == "right"){character.setX(X_green + 32); character.setY(Y_green);}
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
