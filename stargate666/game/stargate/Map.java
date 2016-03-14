package game.stargate;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

/* TODO: fájlok beolvasásánának helye
 * 
 * 
 * */

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
		 * filekezelések
		 */
		openFile();
		readFile();
		closeFile();
		
		/*
		 * képbeolvasások
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

	/*
	 * egy mezõt ad vissza, y sor száma, x (subtring), x-edik elem a sorban
	 */
	public String getElement(int x, int y){
		String elem = Map[y].substring(x, x+1);
		return elem;
		}
	
	private void openFile() {
		try{
			s = new Scanner(new File("C:/Users/Truncated/workspace_1.8/stargate/data/Map.txt"));
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
	 */
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
