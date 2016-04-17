package game;

import java.awt.Graphics;

public class Portal extends Element{
	//private String facing; fölöesleges, mert a Colonelnél el van tárolva, és a saját facingjét a portál nem használja, csak a párjáét	
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
		//				rendes játék implementáció, sztem mondhatni kész:
		//
		///////////////////////////////////////////////////////////////////////////////
		
		//ha a saját színe sárga, akkor lekérdezi a másik kék portál helyzetét és irányát
				if(colour == "yellow"){
			StarGateGame.tab++;
				int X_blue = character.getPortalBlue_x();
				int Y_blue = character.getPortalBlue_y();
				String bluePortalFacing = character.getPortalBlue_Facing();
				System.out.println(X_blue);
				//tehát ha nyitva van a másik portál,  teleportálja oda az ezredest
				if(X_blue != -1){
				System.out.println(X_blue);
				System.out.println(bluePortalFacing);
					if(bluePortalFacing == "up"){character.setX(X_blue - 32); character.setY(Y_blue);}
					if(bluePortalFacing == "down"){character.setX(X_blue); character.setY(Y_blue + 32);}
					if(bluePortalFacing == "left"){character.setX(X_blue + 32); character.setY(Y_blue - 32);}
					if(bluePortalFacing == "right"){character.setX(X_blue + 32); character.setY(Y_blue + 32);}
				}
				else{//lepattan mint a falról
					System.out.println(X_blue);
					character.setX(character.getX()-dx);
					character.setY(character.getY()-dy);
				}
			StarGateGame.tab--;
		}

		
		//ha a saját színe kék, akkor lekérdezi a másik sárga portál helyzetét és irányát
		if(colour == "blue"){
			StarGateGame.tab++;
				int X_yellow = character.getPortalYellow_x();
				int Y_yellow = character.getPortalYellow_y();
				String yellowPortalFacing = character.getPortalYellow_Facing();
				
				//tehát ha nyitva van a másik portál, teleportálja oda az ezredest
				if(X_yellow != -1){
					if(yellowPortalFacing == "up"){character.setX(X_yellow - 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "down"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
					if(yellowPortalFacing == "left"){character.setX(X_yellow); character.setY(Y_yellow - 32);}
					if(yellowPortalFacing == "right"){character.setX(X_yellow + 32); character.setY(Y_yellow);}
				}
				else{//lepattan mint a falról
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
				
				//tehát ha nyitva van a másik portál,  teleportálja oda az ezredest
				if(X_red != -1){
					if(redPortalFacing == "up"){character.setX(X_red - 32); character.setY(Y_red);}
					if(redPortalFacing == "down"){character.setX(X_red); character.setY(Y_red + 32);}
					if(redPortalFacing == "left"){character.setX(X_red + 32); character.setY(Y_red - 32);}
					if(redPortalFacing == "right"){character.setX(X_red + 32); character.setY(Y_red + 32);}
				}
				else{//lepattan mint a falról
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
				
				//tehát ha nyitva van a másik portál, teleportálja oda az ezredest
				if(X_green != -1){
					if(greenPortalFacing == "up"){character.setX(X_green - 32); character.setY(Y_green);}
					if(greenPortalFacing == "down"){character.setX(X_green); character.setY(Y_green + 32);}
					if(greenPortalFacing == "left"){character.setX(X_green); character.setY(Y_green - 32);}
					if(greenPortalFacing == "right"){character.setX(X_green + 32); character.setY(Y_green);}
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
