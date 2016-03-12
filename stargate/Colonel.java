package game.stargate;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

//public class Colonel extends Coordinates {


public class Colonel{	
	private int x;
	private int y;
	
	private int tileX;
	private int tileY;
	
	private Image colonel; 
	
	//colonel dir
	
	//public Colonel(double x, double y) {
		//super(x, y);
	
	public Colonel(){		
		ImageIcon img = new ImageIcon();
		colonel = img.getImage();
		
		x = 32;
		y = 32;
	
		tileX = 1;
		tileY = 1;
	}
	public Image getColonel(){
		return this.colonel;
	}
	
	public void move(int dx,int dy,int tx,int ty){
		x += dx;
		y += dy;
		
		tileX += tx;
		tileY += ty;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public void setX(int x2){
		this.x = x2;
	}
	public void setY(int y2){
		this.y = y2;
	}
	
	public int getTileX(){
		return tileX;	
	} 
	public void setTileX(int tx){
		this.tileX = tx;
	}
	
	public int getTileY(){
		return tileY;
	}
	public void setTileY(int ty){
		this.tileY = ty;
	}

	
}





















