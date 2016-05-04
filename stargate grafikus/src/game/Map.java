package game;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;


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
	
	//cmd es eclipse miatt, lasd konstruktorban
	private String path;
	
	private Image image_box;
	private Image image_bullet_blue;
	private Image image_bullet_yellow;
	private Image image_bullet_red;
	private Image image_bullet_green;
	
	private Image image_character_up;
	private Image image_character_down;
	private Image image_character_left;
	private Image image_character_right;
	private Image image_character_up_with_box;
	private Image image_character_down_with_box;
	private Image image_character_left_with_box;
	private Image image_character_right_with_box;
	
	private Image image_door_opened;
	private Image image_door_closed;
	
	private Image image_portal_blue;
	private Image image_portal_yellow;
	private Image image_portal_red;
	private Image image_portal_green;
	
	private Image image_replicator;
	
	private Image image_scale;
	private Image image_scale_with_box;
	
	private Image image_wall_normal;
	private Image image_wall_special;
	
	private Image image_zpm;
	
	public Map(){		
		//kepek beolvasasa, a megfelelot kell kikommentezni
		//cmd-hez:
		//path = "../src/";
		
		//eclipse-hez:
		path = "src/";
		
		
		//fajlkezelesek
		openFile();
		readFile();
		closeFile();
		readImages();
	}

	
	private void readImages(){
		try{
			//doboz kepe
			image_box = ImageIO.read(new File(path + "box.jpg"));
			
			//lovedek kepei
			image_bullet_blue = ImageIO.read(new File(path + "bullet_blue.jpg"));
			image_bullet_yellow = ImageIO.read(new File(path + "bullet_yellow.jpg"));
			image_bullet_red = ImageIO.read(new File(path + "bullet_red.jpg"));
			image_bullet_green = ImageIO.read(new File(path + "bullet_green.jpg"));
			
			//karakter kepei
			image_character_up = ImageIO.read(new File(path + "character_up.jpg"));
			image_character_down = ImageIO.read(new File(path + "character_down.jpg"));
			image_character_left = ImageIO.read(new File(path + "character_left.jpg"));
			image_character_right = ImageIO.read(new File(path + "character_right.jpg"));
			image_character_up_with_box = ImageIO.read(new File(path + "character_up_with_box.jpg"));
			image_character_down_with_box = ImageIO.read(new File(path + "character_down_with_box.jpg"));
			image_character_left_with_box = ImageIO.read(new File(path + "character_left_with_box.jpg"));
			image_character_right_with_box = ImageIO.read(new File(path + "character_right_with_box.jpg"));
			
			//ajto kepei
			image_door_opened = ImageIO.read(new File(path + "door_opened.jpg"));
			image_door_closed = ImageIO.read(new File(path + "door_closed.jpg"));
			
			//portal kepei
			image_portal_blue = ImageIO.read(new File(path + "portal_blue.jpg"));
			image_portal_yellow = ImageIO.read(new File(path + "portal_yellow.jpg"));
			image_portal_red = ImageIO.read(new File(path + "portal_red.jpg"));
			image_portal_green = ImageIO.read(new File(path + "portal_green.jpg"));
			
			//replikator kepe
			image_replicator = ImageIO.read(new File(path + "replicator.jpg"));
			
			//merleg kepei
			image_scale = ImageIO.read(new File(path + "scale.jpg"));
			image_scale_with_box = ImageIO.read(new File(path + "scale_with_box.jpg"));
			
			//fal kepei
			image_wall_normal = ImageIO.read(new File(path + "wall_normal.jpg"));
			image_wall_special = ImageIO.read(new File(path + "wall_special.jpg"));
			
			//zpm kepe
			image_zpm = ImageIO.read(new File(path + "zpm.jpg"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//getter a doboz kepehez
	public Image get_image_box(){
		return image_box;
	}
	
	//getterek a lovedek kepeihez
	public Image get_image_bullet_blue(){
		return image_bullet_blue;
	}
	public Image get_image_bullet_yellow(){
		return image_bullet_yellow;
	}
	public Image get_image_bullet_red(){
		return image_bullet_red;
	}
	public Image get_image_bullet_green(){
		return image_bullet_green;
	}
	
	//getterek a karakter kepeihez
	public Image get_image_character_up(){
		return image_character_up;
	}
	public Image get_image_character_down(){
		return image_character_down;
	}
	public Image get_image_character_left(){
		return image_character_left;
	}
	public Image get_image_character_right(){
		return image_character_right;
	}
	public Image get_image_character_up_with_box(){
		return image_character_up_with_box;
	}
	public Image get_image_character_down_with_box(){
		return image_character_down_with_box;
	}
	public Image get_image_character_left_with_box(){
		return image_character_left_with_box;
	}
	public Image get_image_character_right_with_box(){
		return image_character_right_with_box;
	}
	
	//getterek az ajto kepeihez
	public Image get_image_door_opened(){
		return image_door_opened;
	}
	public Image get_image_door_closed(){
		return image_door_closed;
	}
	
	//getterek a portal kepeihez
	public Image get_image_portal_blue(){
		return image_portal_blue;
	}
	public Image get_image_portal_yellow(){
		return image_portal_yellow;
	}
	public Image get_image_portal_red(){
		return image_portal_red;
	}
	public Image get_image_portal_green(){
		return image_portal_green;
	}
	
	//getter a replikator kepehez
	public Image get_image_replicator(){
		return image_replicator;
	}
	
	//getterek a merleg kepeihez
	public Image get_image_scale(){
		return image_scale;
	}
	public Image get_image_scale_with_box(){
		return image_scale_with_box;
	}
	
	//getterek a fal kepeihez
	public Image get_image_wall_normal(){
		return image_wall_normal;
	}
	public Image get_image_wall_special(){
		return image_wall_special;
	}
	
	
	//getter a zpm kepehez
	public Image get_image_zpm(){
		return image_zpm;
	}
	
	
	//a txt egy sor�nak String-j�b�l vissza adja az adott oszlopban l�v� karaktert
	public char getElement(int x, int y){
		char elem = Map[y].charAt(x);
		return elem;
	}
	
	private void openFile() {
		try{
			s = new Scanner(new File(path + "Map.txt"));
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
