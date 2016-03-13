package szlab4hazi;

public class Bullet extends Elements{
	public String bulletColour; //yellow or blue
	private String bulletDirection;
	
	public Bullet(String colour, int bulletStartingPosition_x, int bulletStartingPosition_y, String direction){
		super("bullet");
		bulletColour = colour;
		bulletDirection = direction;
		
		//megfelelo Field index-re be kell jegyezni magát a Bullet objektumnak ! ! !
		setElement(bulletStartingPosition_x, bulletStartingPosition_y, this);
		//ezt így lehet amúgy, hogy this átadása? :D
	}
	
	//x vagy y koordinata növelése 1-el, bulletDirection irányában: setElement() segítségével
	//egészen addig mig falba, mérlegbe?, ajtóba?, ZPM modulba? nem ütközik
	public void move(){
		//ciklusba kéne ezt az egészet..

		Elements element = getElement(getPosition_x(), getPosition_y());
		if(getName(element) == "wall")
			if( ((Wall)element).getSpecial() == true )
				makePortal();
		//mi történik itt?
		//adott x, y pozicion lekérdezem getElement-el, hogy milyen elem van ott
		//ha a neve megegyezik a "wall"-al, akkor
		//utána megvizsgálom hogy az a fal speciális-e
		//mivel tudom róla hogy fal, ezért nyugodtan elvégezhetem a Wall konverziot,
		//igy már tudok hivatkozni a special adattagjára is és lekérdezni azt
		
		//sztem ezt a vizsgálatot mindig 1 cellával elõre meg kéne nézni, és 
		//aszerint módosítani a dolgokat
		//-> getPosition_x() + 1 vagy getPosition_y() + 1, bulletDirection-tõl függõen
		
		else{
			//x++ vagy y++
		}
	}
	
	//ha specialis falba utkozik a bullet, akkor nyit egy portált
	public void makePortal(){
		//ez most ugye a bullet position-jai, amikor beleütközött a specialis falba
		Portal portal = new Portal(getPosition_x(), getPosition_y(),bulletColour);
	}
	

}
