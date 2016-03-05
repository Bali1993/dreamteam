package szlab4hazi;

public class Colonel extends Elements{
	private String direction; //up, down, left, right
	private int ZPMCounterMax;
	private int ZPMCounter;
	public boolean haveBox; // ezt �rdemes publikra, mert a View oszt�ly majd tuti lek�rdezi �rt�k�t, �s ne kelljen m�r egy getter erre is
	public static boolean isAlive; //az�rt kell hogy statikus legyen, hogy a Hole oszt�ly be tudja �ll�tani ezt v�ltoz�t false-ra
	public int colonelStartingPosition_x;
 	public int colonelStartingPosition_y;
 		//az ezredes legels�, a felt�lt�skor megadott pozicioja
 		//az�rt van r� sz�ks�g, hogy a Controller tudja el�sz�r hogy hol van, ne kelljen megkeresnie a 2D-s t�mbben
	
	public Colonel(int x, int y){
		super("colonel");
		ZPMCounter = 0;
		ZPMCounterMax = 5; //amennyi ZPM-et �sszesen �ssze kell gy�jtenie az ezredesnek
		haveBox = false;
		isAlive = true;
		colonelStartingPosition_x = x;
		colonelStartingPosition_y = y;
	}
	
	
	//ezredes aktualis iranyat adja vissza
	public String getDirection() {
		return direction;
	}

	//Controller v�gzi majd a direction valtozo beallitasat a billenty� lenyomasok alapjan
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void move(){
		//direction ir�nyban az x vagy y koordin�ta n�vel�se,
		//setElement() seg�ts�g�vel
		//ahonnan pedig ell�p az ezredes szint�n setElement()-ezni kell, csak egy road-ot
		
		//itt k�ne megh�vni a Hole oszt�ly kill() f�ggv�ny�t is, ha
		//az ezredes olyan cell�ra l�p
		
	}
	
	//L�trehoz egy Bullet objektumot
	public void shoot(String colour){
		Bullet bullet = new Bullet(colour, getPosition_x()+1, getPosition_y()+1, direction);
		//a Colonel index�hez k�pest 1-el nagyobb indexet kell �tadni, direction ir�nyban
		//a Colonel indexe �s direction-e a l�trehoz�s pillanat�ban �rv�nyes, arra van sz�ks�g�nk
		//teh�t azt mindenk�pp �t kell adni a Bullet konstr.nak
	}
	
	//ZPM vagy doboz felv�tele
	public void pickUp (){
		//ha fel vesz egy ZPM-et:
		//1. ZPMCounter++
		//2. Model oszt�ly Field-j�nek megfelel� index�t ZPM -> �t Elements-re kell cser�lni
		
		//ha fel vesz egy dobozt:
		//1. haveBox = true
		//2. Model oszt�ly Field-j�nek megfelel� index�t doboz -> �t Elements-re kell cser�lni
	}
	
	//doboz lerak�sa
	public void putDown (){
		//ha lerak egy dobozt:
		//1. haveBox = false
		//2. Model oszt�ly Field-j�nek megfelel� index�t �t -> doboz Elements-re kell cser�lni
	}
	
	//f�regj�raton �t val� halad�s
	public void teleport(){
		//ha megvan nyitva mind a 2 szin� portal �s
		//az ezredes belel�p az egyikbe, akkor
		//m�dos�tani kell a poz�cioj�t setElement()-el
	}
	
	//nyert�nk-e, az ezredes �sszegy�jt�tte-e az �sszes ZPM-et
	public boolean win (){
		if(ZPMCounter == ZPMCounterMax)
			return true; //nyert�nk
		else
			return false; //m�g nem nyert�nk
	}
	
	public boolean gameOver(){
		if(isAlive)
			return false;
		else
			return true;
	}
	
}
