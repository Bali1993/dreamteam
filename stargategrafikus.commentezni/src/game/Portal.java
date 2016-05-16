package game;

import java.awt.Graphics;

import java.awt.Image;

/*
 * Portál osztálya
 * Element ősosztály
 */
public class Portal extends Element {
	// private String facing; felesleges, mert a Colonelnél el van tárolva, és
	// a saját facingjét a portál nem használja, csak a párjáét
	private String colour; // yellow / blue / red / green
	
	//Képeknek fenntartott változók
	private Image image_portal_blue;
	private Image image_portal_yellow;
	private Image image_portal_red;
	private Image image_portal_green;
	
	/*
	 * Portal konstruktora 
	 * Element ősosztály konstruktorának hívása
	 * szín és referencia beállítása
	 */
	public Portal(int x, int y, String colour, Character ch) {
		super(x, y, ch);
		this.colour = colour;
		
		//Képek beolvasása
		Map map = ch.getSGG().getMap();
		image_portal_blue = map.get_image_portal_blue();
		image_portal_yellow = map.get_image_portal_yellow();
		image_portal_red = map.get_image_portal_red();
		image_portal_green = map.get_image_portal_green();
	}
	
	/*
 	 * Ha egy karakter ütközik egy portállal akkor teleportál, 
 	 * ha nyitva van a portál párja, ezt itt vizsgáljuk
 	 * majd megnézzük, hogy merre néz a portál
 	 * amerre néz arra léptetjük ki a karaktereket
 	 * ha nincs nyitva a párja, akkor nem teleportál, hanem sima falként viselkedik
 	 */
	@Override
	public void onCollisionWithCharacter(Character character, int dx, int dy) {

		if (colour == "yellow") {
			int X_blue = character.getPortalBlue_x();
			int Y_blue = character.getPortalBlue_y();
			String bluePortalFacing = character.getPortalBlue_Facing();
			// tehát ha nyitva van a másik portál, teleportálja oda az ezredest
			if (X_blue != -1) {
				if (bluePortalFacing == "up") {
					character.setX(X_blue);
					character.setY(Y_blue - 32);
				}
				if (bluePortalFacing == "down") {
					character.setX(X_blue);
					character.setY(Y_blue + 32);
				}
				if (bluePortalFacing == "left") {
					character.setX(X_blue - 32);
					character.setY(Y_blue);
				}
				if (bluePortalFacing == "right") {
					character.setX(X_blue + 32);
					character.setY(Y_blue);
				}
			} else { //Lepattan, mint a falról
				character.setX(character.getX() - dx);
				character.setY(character.getY() - dy);
			}
		}

		// ha a saját színe kék, akkor lekérdezi a másik sárga portál helyzetét
		// és irányát
		if (colour == "blue") {
			int X_yellow = character.getPortalYellow_x();
			int Y_yellow = character.getPortalYellow_y();
			String yellowPortalFacing = character.getPortalYellow_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda az ezredest
			if (X_yellow != -1) {
				if (yellowPortalFacing == "up") {
					character.setX(X_yellow);
					character.setY(Y_yellow - 32);
				}
				if (yellowPortalFacing == "down") {
					character.setX(X_yellow);
					character.setY(Y_yellow + 32);
				}
				if (yellowPortalFacing == "left") {
					character.setX(X_yellow - 32);
					character.setY(Y_yellow);
				}
				if (yellowPortalFacing == "right") {
					character.setX(X_yellow + 32);
					character.setY(Y_yellow);
				}
			} else {// Lepattan mint a falról
				character.setX(character.getX() - dx);
				character.setY(character.getY() - dy);
			}
		}

		if (colour == "green") {
			int X_red = character.getPortalRed_x();
			int Y_red = character.getPortalRed_y();
			String redPortalFacing = character.getPortalRed_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda az ezredest
			if (X_red != -1) {
				if (redPortalFacing == "up") {
					character.setX(X_red);
					character.setY(Y_red - 32);
				}
				if (redPortalFacing == "down") {
					character.setX(X_red);
					character.setY(Y_red + 32);
				}
				if (redPortalFacing == "left") {
					character.setX(X_red - 32);
					character.setY(Y_red);
				}
				if (redPortalFacing == "right") {
					character.setX(X_red + 32);
					character.setY(Y_red);
				}
			} else {  // lepattan mint a falról
				character.setX(character.getX() - dx);
				character.setY(character.getY() - dy);
			
		}

		if (colour == "red") {
			int X_green = character.getPortalGreen_x();
			int Y_green = character.getPortalGreen_y();
			String greenPortalFacing = character.getPortalGreen_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda az ezredest
			if (X_green != -1) {
				if (greenPortalFacing == "up") {
					character.setX(X_green);
					character.setY(Y_green - 32);
				}
				if (greenPortalFacing == "down") {
					character.setX(X_green);
					character.setY(Y_green + 32);
				}
				if (greenPortalFacing == "left") {
					character.setX(X_green - 32);
					character.setY(Y_green);
				}
				if (greenPortalFacing == "right") {
					character.setX(X_green + 32);
					character.setY(Y_green);
				}
			} else {  // lepattan mint a falról
				character.setX(character.getX() - dx);
				character.setY(character.getY() - dy);
			}
		}
		}
	}
	
	
	//Replikátor portállal ütközését kezelő függvény
	//Hasonló a karakteréhez
	@Override
	public void onCollisionWithReplicator(Replicator replicator, Character c, Character j, int dx, int dy) {
		if (colour == "yellow") {
			int X_blue = c.getPortalBlue_x();
			int Y_blue = c.getPortalBlue_y();
			String bluePortalFacing = c.getPortalBlue_Facing();
			// tehát ha nyitva van a másik portál, teleportálja oda a replikátort
			if (X_blue != -1) {
				if (bluePortalFacing == "up") {
					replicator.setX(X_blue);
					replicator.setY(Y_blue - 32);
				}
				if (bluePortalFacing == "down") {
					replicator.setX(X_blue);
					replicator.setY(Y_blue + 32);
				}
				if (bluePortalFacing == "left") {
					replicator.setX(X_blue - 32);
					replicator.setY(Y_blue);
				}
				if (bluePortalFacing == "right") {
					replicator.setX(X_blue + 32);
					replicator.setY(Y_blue);
				}
			} else {  // lepattan mint a falról
				replicator.setX(replicator.getX() - dx);
				replicator.setY(replicator.getY() - dy);
			}
		}

		// ha a saját színe kék, akkor lekérdezi a másik sárga portál helyzetét
		// és irányát
		if (colour == "blue") {
			int X_yellow = c.getPortalYellow_x();
			int Y_yellow = c.getPortalYellow_y();
			String yellowPortalFacing = c.getPortalYellow_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda a replikátort
			if (X_yellow != -1) {
				if (yellowPortalFacing == "up") {
					replicator.setX(X_yellow);
					replicator.setY(Y_yellow - 32);
				}
				if (yellowPortalFacing == "down") {
					replicator.setX(X_yellow);
					replicator.setY(Y_yellow + 32);
				}
				if (yellowPortalFacing == "left") {
					replicator.setX(X_yellow - 32);
					replicator.setY(Y_yellow);
				}
				if (yellowPortalFacing == "right") {
					replicator.setX(X_yellow + 32);
					replicator.setY(Y_yellow);
				}
			} else {// lepattan mint a falról
				replicator.setX(replicator.getX() - dx);
				replicator.setY(replicator.getY() - dy);
			}
		}
			//Ha zöld portálnak ütközött
		if (colour == "green") {
			int X_red = j.getPortalRed_x();
			int Y_red = j.getPortalRed_y();
			String redPortalFacing = j.getPortalRed_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda a replikátort
			if (X_red != -1) {
				if (redPortalFacing == "up") {
					replicator.setX(X_red);
					replicator.setY(Y_red - 32);
				}
				if (redPortalFacing == "down") {
					replicator.setX(X_red);
					replicator.setY(Y_red + 32);
				}
				if (redPortalFacing == "left") {
					replicator.setX(X_red - 32);
					replicator.setY(Y_red);
				}
				if (redPortalFacing == "right") {
					replicator.setX(X_red + 32);
					replicator.setY(Y_red);
				}
			} else {   // lepattan mint a falról
				replicator.setX(replicator.getX() - dx);
				replicator.setY(replicator.getY() - dy);
			}
		}

		if (colour == "red") {
			int X_green = j.getPortalGreen_x();
			int Y_green = j.getPortalGreen_y();
			String greenPortalFacing = j.getPortalGreen_Facing();

			// tehát ha nyitva van a másik portál, teleportálja oda a replikátort
			if (X_green != -1) {
				if (greenPortalFacing == "up") {
					replicator.setX(X_green);
					replicator.setY(Y_green - 32);
				}
				if (greenPortalFacing == "down") {
					replicator.setX(X_green);
					replicator.setY(Y_green + 32);
				}
				if (greenPortalFacing == "left") {
					replicator.setX(X_green - 32);
					replicator.setY(Y_green);
				}
				if (greenPortalFacing == "right") {
					replicator.setX(X_green + 32);
					replicator.setY(Y_green);
				}
			} else {// lepattan mint a falról
				replicator.setX(replicator.getX() - dx);
				replicator.setY(replicator.getY() - dy);
			}
		}
	}
	
	//A megfelelő portálképek kirajzolásáért felelős függvény
	@Override
	public void render(Graphics g) {
		if (colour == "blue") {
			g.drawImage(image_portal_blue, this.x + 1, this.y + 1, 31, 31, null);
		}
		if (colour == "yellow") {
			g.drawImage(image_portal_yellow, this.x + 1, this.y + 1, 31, 31, null);
		}
		if (colour == "red") {
			g.drawImage(image_portal_red, this.x + 1, this.y + 1, 31, 31, null);
		}
		if (colour == "green") {
			g.drawImage(image_portal_green, this.x + 1, this.y + 1, 31, 31, null);
		}
	}

}
