package game;

import java.awt.Canvas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

/*
 * semmi extra, egyelõre csak az ablakot hozza létre, lehet h nem is lesz itt semmi más
 * talán ha akarunk egy olyat h restart, akk azt itt kéne
 */
public class StarGate extends Canvas {
	private static final long serialVersionUID = 1L;
	public final String TITLE = "StarGate";
	StarGateGame sgg;
	
	public StarGate(StarGateGame g){
		this.sgg = g;
		
		//játékablak leszedése
		
		JFrame frame = new JFrame(this.TITLE);
				
		frame.add(sgg);
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String args[]){
		System.out.println("1. A mozgás tesztelése");	
		System.out.println("2. Doboz lerakásának tesztelése");
		System.out.println("3. Lövedék kilövésének tesztje");
		
		while(true){
		StarGateGame sgg = new StarGateGame();
		StarGate sg = new StarGate(sgg);
		
		/////////////////////////////////SKELETON TEST////////////////////////////////////////
		
		
		
		
		
		try{
			System.out.println("\nAdja meg a teszt sorszámát:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			String input=br.readLine();
			
			//
			//move(x,y) megadásánál
			//x,y 0-tól fut !!!
			//
			
			//F    O     N     T    O    S:
			//move(0,0) index megadása nem szabad
			//mert a 0,0 index arra van lefoglalva, hogy nincs ütközés!
			
			switch(input){
			case "1":
				System.out.println("\t1.1 Ütközés tesztelése");
				break;
			case "1.1":
				System.out.println("\t1.1.1 ZPM-mel");
				System.out.println("\t1.1.2 Szakadékkal");
				System.out.println("\t1.1.3 Portállal");
				System.out.println("\t1.1.4 Dobozzal");
				System.out.println("\t1.1.5 Mérleggel");
				System.out.println("\t1.1.6 Ajtóval");
				System.out.println("\t1.1.7 Fallal");
				break;
			case "1.1.1":
				System.out.println("\t1.1.1.1 ZPM felvétele");
				break;
			case "1.1.1.1":
				System.out.println("\t\t\t1.1.1.1.1 Játékos nyert");
				break;
			case "1.1.1.1.1":
				//A játékos megnyerte a játékot tesztje
				sg.sgg.getColonel().move(0, 3);
				System.out.println("\nTeszt vége");
				break;
			case "buildMap":
				System.out.println("\t\t1.1.2.1 Játékos vesztett");
				break;
			case "1.1.2.1":
				//játékos szakadékba zuhant és vesztett Tesztje
				sg.sgg.getColonel().move(0, 6);
				System.out.println("\nTeszt vége");
				break;
			case "1.1.3":
				System.out.println("\t\t1.1.3.1 Teleport");
				break;
			case "1.1.3.1":
				//Teleportálás tesztje
				sg.sgg.getColonel().move(0, 7);
				System.out.println("\nTeszt vége");
				break;
			case "1.1.4":
				System.out.println("\t\t1.1.4.1 Doboz felvétele");
				break;
			case "1.1.4.1":
				// Doboz felvételének tesztje
				sg.sgg.getColonel().move(0, 4);
				System.out.println("\nTeszt vége");
				break;
			
			case "1.1.5":
				System.out.println("\t\t1.1.5.1 Ajtó nyitás és ajtó zárás");
				break;
			case "1.1.5.1":
				//ajtó nyitás mérleggel és ajtó zárás
				sg.sgg.getColonel().move(0, 1);
				System.out.println("\nTeszt vége");
				break;
			case "1.1.6":
				//Ajtóval ütközés
				sg.sgg.getColonel().move(0, 5);
				System.out.println("\nTeszt vége");
				break;
			case "1.1.7":
				//Fallal való ütközés tesztje
				sg.sgg.getColonel().move(0, 8);
				System.out.println("\nTeszt vége");
				break;
			case "2":
				//Doboz lerakásának tesztje
				System.out.println("\t2 Doboz lerakása");
				sg.sgg.getColonel().putDown(false);
				System.out.println("\nTeszt vége");
				break;
			case "3":
				System.out.println("\t3.1 Speciális falon portálnyitás");
				break;
			case "3.1":
				//Speciális fal portált nyit
				sg.sgg.getColonel().shoot("yellow");
				System.out.println("\nTeszt vége");
				break;
			default:
				System.out.println("1. A mozgás tesztelése");	
				System.out.println("2. Doboz lerakásának tesztelése");
				System.out.println("3. Lövedék kilövésének tesztje");
				break;
			
			}
			
		}catch(IOException io){
			io.printStackTrace();
		}	
		
		
		}
		
		
		
		
	}

	
}
