package szlab4hazi;

public class Bullet extends Elements{
	public String bulletColour; //yellow or blue
	private String bulletDirection;
	
	public Bullet(String colour, int bulletStartingPosition_x, int bulletStartingPosition_y, String direction){
		super("bullet");
		bulletColour = colour;
		bulletDirection = direction;
		
		//megfelelo Field index-re be kell jegyezni mag�t a Bullet objektumnak ! ! !
		setElement(bulletStartingPosition_x, bulletStartingPosition_y, this);
		//ezt �gy lehet am�gy, hogy this �tad�sa? :D
	}
	
	//x vagy y koordinata n�vel�se 1-el, bulletDirection ir�ny�ban: setElement() seg�ts�g�vel
	//eg�szen addig mig falba, m�rlegbe?, ajt�ba?, ZPM modulba? nem �tk�zik
	public void move(){
		//ciklusba k�ne ezt az eg�szet..

		Elements element = getElement(getPosition_x(), getPosition_y());
		if(getName(element) == "wall")
			if( ((Wall)element).getSpecial() == true )
				makePortal();
		//mi t�rt�nik itt?
		//adott x, y pozicion lek�rdezem getElement-el, hogy milyen elem van ott
		//ha a neve megegyezik a "wall"-al, akkor
		//ut�na megvizsg�lom hogy az a fal speci�lis-e
		//mivel tudom r�la hogy fal, ez�rt nyugodtan elv�gezhetem a Wall konverziot,
		//igy m�r tudok hivatkozni a special adattagj�ra is �s lek�rdezni azt
		
		//sztem ezt a vizsg�latot mindig 1 cell�val el�re meg k�ne n�zni, �s 
		//aszerint m�dos�tani a dolgokat
		//-> getPosition_x() + 1 vagy getPosition_y() + 1, bulletDirection-t�l f�gg�en
		
		else{
			//x++ vagy y++
		}
	}
	
	//ha specialis falba utkozik a bullet, akkor nyit egy port�lt
	public void makePortal(){
		//ez most ugye a bullet position-jai, amikor bele�tk�z�tt a specialis falba
		Portal portal = new Portal(getPosition_x(), getPosition_y(),bulletColour);
	}
	

}
