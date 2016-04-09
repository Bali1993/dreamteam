package game;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

/* TODO: f�jlok beolvas�s�n�nak helye
 * 
 * 
 * */

public class Map{
	private Scanner s;
	
	/*
	 * string t�mb, melyben soronk�nt t�roljuk a p�ly�t
	 * ahogyan beolvassuk txtb�l
	*/
	private String Map[] = new String[30];
	
	/*
	 * egyes k�pek beolvas�sa v�ltoz�kba
	 */
	
	private Image road;
	private Image wall;
	private Image wall_spec;
	private Image box;
	private Image scale;
	private Image door;
	private Image zpm;
	private Image pit;
	
	private Image box_on_scale;
	private Image box_in_hand;
	
	public Map(){
		/*
		 * filekezel�sek
		 */
		openFile();
		readFile();
		closeFile();
		
		/*
		 * k�pbeolvas�sok
		 */
		ImageIcon img = new ImageIcon();
		road = img.getImage();
		img = new ImageIcon();
		wall = img.getImage();
		img = new ImageIcon();
		wall_spec = img.getImage();
		img = new ImageIcon();
		box = img.getImage();
		img = new ImageIcon();
		scale = img.getImage();
		img = new ImageIcon();
		door = img.getImage();
		img = new ImageIcon();
		zpm = img.getImage();
		img = new ImageIcon();
		pit = img.getImage();
		
		img = new ImageIcon();
		box_on_scale = img.getImage();
		img = new ImageIcon();
		box_in_hand = img.getImage();
	}

	//a txt egy sor�nak String-j�b�l vissza adja az adott oszlopban l�v� karaktert
	public char getElement(int x, int y){
		char elem = Map[y].charAt(x);
		return elem;
	}
	
	private void openFile() {
		try{
			//s = new Scanner(new File("src/Map.txt"));
			s = new Scanner(new File("src/forRandomZPM.txt"));
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
	
	/*
	 * image getter-setterek
	 ***/
	public Image getRoad(){
		return road;
	}
	public Image getWall(){
		return wall;
	}
	public Image getWall_Spec(){
		return wall_spec;
	}
	public Image getBox(){
		return box;
	}
	public Image getDoor() {
		return door;
	}
	public Image getZPM() {
		return zpm;
	}
	public Image getScale() {
		return scale;
	}
	public Image getPit() {
		return pit;
	}
	public Image getBoxInHand(){
		return box_in_hand;
	}
	public Image getOnSclae(){
		return box_on_scale;
	}
}
