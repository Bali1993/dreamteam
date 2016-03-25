package game.stargate;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
/*
 * semmi extra, egyel�re csak az ablakot hozza l�tre, lehet h nem is lesz itt semmi m�s
 * tal�n ha akarunk egy olyat h restart, akk azt itt k�ne
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
		
	
		System.out.println("1. A mozg�s tesztel�se");	
		System.out.println("2. �tk�z�s tesztel�se");
		System.out.println("3. L�ved�k kil�v�s�nek tesztje");
		
		
		while(true){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			String input=br.readLine();
				
			switch(input){
			case "1":
				System.out.println("\t1.1 Ajt� z�r�s tesztje");
				break;
			case "2":
				System.out.println("\t2.1 ZPM-mel");
				System.out.println("\t2.2 Szakad�kkal");
				System.out.println("\t2.3 Port�llal");
				System.out.println("\t2.4 Dobozzal");
				System.out.println("\t2.5 M�rleggel");
				System.out.println("\t2.6 Ajt�val");
				System.out.println("\t2.7 Fallal");
				break;
			case "2.1":
				System.out.println("\t2.1.1 ZPM felv�tele");
				break;
			case "2.1.1":
				System.out.println("\t\t\t2.1.1 J�t�kos nyert");
				break;
			case "2.2":
				System.out.println("\t\t2.2.1 J�t�kos vesztett");
				break;
			case "2.3":
				System.out.println("\t\t2.3.1 Teleport");
				break;
			case "2.4":
				System.out.println("\t\t2.4.1 Doboz felv�tele");
				System.out.println("\t\t2.4.2 Doboz lerak�sa");
				break;
			case "2.4.1":
				System.out.println("\t\t2.4.1 Doboz felv�tele");
				break;
			case "2.4.2":
				System.out.println("\t\t2.4.2 Doboz lerak�sa");
				break;
			case "2.5":
				System.out.println("\t\t2.5.1 Ajt� nyit�s");
				break;
			case "3":
				System.out.println("\t3.1 Speci�lis falon port�lnyit�s");
				break;
			case "2.6":
				System.out.println("\t2.6 Ajt�val");
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
