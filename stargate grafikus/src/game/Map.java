package game;

import java.io.File;
import java.util.Scanner;


public class Map{
	private Scanner s;
	
	/*
	 * string tömb, melyben soronként tároljuk a pályát
	 * ahogyan beolvassuk txtbõl
	*/
	private String Map[] = new String[30];
	
	/*
	 * egyes képek beolvasása változókba
	 */
	
	public Map(){
		/*
		 * filekezelések
		 */
		openFile();
		readFile();
		closeFile();
	}

	//a txt egy sorának String-jébõl vissza adja az adott oszlopban lévõ karaktert
	public char getElement(int x, int y){
		char elem = Map[y].charAt(x);
		return elem;
	}
	
	private void openFile() {
		try{
			s = new Scanner(new File("src/Map.txt"));
			//s = new Scanner(new File("src/forRandomZPM.txt"));
		}catch(Exception e){
			System.out.println("error during loading file");
		}
	}
	private void readFile() {
		while(s.hasNext()){
			for(int i=0; i<30; i++){
				Map[i] = s.next();
			}
		}
	}
	private void closeFile() {
		s.close();
	}
	
}
