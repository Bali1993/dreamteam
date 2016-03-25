package game.stargate;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
/*
 * semmi extra, egyelõre csak az ablakot hozza létre, lehet h nem is lesz itt semmi más
 * talán ha akarunk egy olyat h restart, akk azt itt kéne
 */
public class StarGate extends Canvas {
	public final String TITLE = "StarGate";	
	
	StarGateGame sgg;
	
	public StarGate(StarGateGame g){
		this.sgg = g;
		/*JFrame frame = new JFrame(this.TITLE);
				
		frame.add(sgg);
		frame.setSize(980, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	
	public static void main(String args[]){
		StarGateGame sgg = new StarGateGame();
		StarGate sg = new StarGate(sgg);
		
		/////////////////////////////////SKELETON TEST////////////////////////////////////////
		
	
		System.out.println("1. A mozgás tesztelése");	
		System.out.println("2. Ütközés tesztelése");
		System.out.println("3. Lövedék kilövésének tesztje");
		
		
		while(true){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			String input=br.readLine();
				
			switch(input){
			case "1":
				System.out.println("\t1.1 Ajtó zárás tesztje");
				break;
			case "2":
				System.out.println("\t2.1 ZPM-mel");
				System.out.println("\t2.2 Szakadékkal");
				System.out.println("\t2.3 Portállal");
				System.out.println("\t2.4 Dobozzal");
				System.out.println("\t2.5 Mérleggel");
				System.out.println("\t2.6 Ajtóval");
				System.out.println("\t2.7 Fallal");
				break;
			case "2.1":
				System.out.println("\t2.1.1 ZPM felvétele");
				break;
			case "2.1.1":
				System.out.println("\t\t\t2.1.1 Játékos nyert");
				break;
			case "2.2":
				System.out.println("\t\t2.2.1 Játékos vesztett");
				break;
			case "2.3":
				System.out.println("\t\t2.3.1 Teleport");
				break;
			case "2.4":
				System.out.println("\t\t2.4.1 Doboz felvétele");
				System.out.println("\t\t2.4.2 Doboz lerakása");
				break;
			case "2.4.1":
				System.out.println("\t\t2.4.1 Doboz felvétele");
				break;
			case "2.4.2":
				System.out.println("\t\t2.4.2 Doboz lerakása");
				break;
			case "2.5":
				System.out.println("\t\t2.5.1 Ajtó nyitás");
				break;
			case "3":
				System.out.println("\t3.1 Speciális falon portálnyitás");
				break;
			case "2.6":
				System.out.println("\t2.6 Ajtóval");
				break;
			case "2.7":
				System.out.println("\t2.7 Fallal");
				sg.sgg.getColonel().move(32, 32);
				break;
			
			}
			
		}catch(IOException io){
			io.printStackTrace();
		}	
		
		
		}
		
		
		
		
	}

	
}
