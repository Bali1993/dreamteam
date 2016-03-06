package szlab4hazi;

public class Colonel extends Elements{
	private String direction; //up, down, left, right
	private int ZPMCounterMax;
	private int ZPMCounter;
	public boolean haveBox; // ezt érdemes publikra, mert a View osztály majd tuti lekérdezi értékét, és ne kelljen már egy getter erre is
	public static boolean isAlive; //azért kell hogy statikus legyen, hogy a Hole osztály be tudja állítani ezt változót false-ra
	public int colonelStartingPosition_x;
 	public int colonelStartingPosition_y;
 		//az ezredes legelsõ, a feltöltéskor megadott pozicioja
 		//azért van rá szükség, hogy a Controller tudja elöször hogy hol van, ne kelljen megkeresnie a 2D-s tömbben
	
	public Colonel(int x, int y){
		super("colonel");
		ZPMCounter = 0;
		ZPMCounterMax = 5; //amennyi ZPM-et összesen össze kell gyüjtenie az ezredesnek
		haveBox = false;
		isAlive = true;
		colonelStartingPosition_x = x;
		colonelStartingPosition_y = y;
	}
	
	
	//ezredes aktualis iranyat adja vissza
	public String getDirection() {
		return direction;
	}

	//Controller végzi majd a direction valtozo beallitasat a billentyü lenyomasok alapjan
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void move(){
		//direction irányban az x vagy y koordináta növelése,
		//setElement() segítségével
		//ahonnan pedig ellép az ezredes szintén setElement()-ezni kell, csak egy road-ot
		
		//itt kéne meghívni a Hole osztály kill() függvényét is, ha
		//az ezredes olyan cellára lép
		
		//ha rámegy a mérlegre, vagy lelép onnan, akkor
		//meg kell változtatni a Scale isPushed változóját
		//és meghívni a Scale doorOpener() vagy doorCloser() metódusát
		
	}
	
	//Létrehoz egy Bullet objektumot
	public void shoot(String colour){
		Bullet bullet = new Bullet(colour, getPosition_x()+1, getPosition_y()+1, direction);
		//a Colonel indexéhez képest 1-el nagyobb indexet kell átadni, direction irányban
		//a Colonel indexe és direction-e a létrehozás pillanatában érvényes, arra van szükségünk
		//tehát azt mindenképp át kell adni a Bullet konstr.nak
	}
	
	//ZPM vagy doboz felvétele
	public void pickUp (){
		//ha fel vesz egy ZPM-et:
		//1. ZPMCounter++
		//2. Model osztály Field-jének megfelelõ indexét ZPM -> út Elements-re kell cserélni
		
		//ha fel vesz egy dobozt:
		//1. haveBox = true
		//2. Model osztály Field-jének megfelelõ indexét doboz -> út Elements-re kell cserélni
		
		//ha a dobozt a mérlegrõl veszi fel, akkor a
		//Scale osztály isPushed változóját false-ra kell állítani
		//és meghívni a Scale doorCloser() metódusát
	}
	
	//doboz lerakása
	public void putDown (){
		//ha lerak egy dobozt:
		//1. haveBox = false
		//2. Model osztály Field-jének megfelelõ indexét út -> doboz Elements-re kell cserélni
		
		//ha a dobozt a mérlegre rakja, akkor a
		//Scale osztály isPushed változóját true-ra kell állítani
		//és meghívni a Scale doorOpener() metódusát
	}
	
	//féregjáraton át való haladás
	public void teleport(){
		//ha megvan nyitva mind a 2 szinü portal és
		//az ezredes belelép az egyikbe, akkor
		//módosítani kell a pozícioját setElement()-el
	}
	
	//nyertünk-e, az ezredes összegyüjtötte-e az összes ZPM-et
	public boolean win (){
		if(ZPMCounter == ZPMCounterMax)
			return true; //nyertünk
		else
			return false; //még nem nyertünk
	}
	
	public boolean gameOver(){
		if(isAlive)
			return false;
		else
			return true;
	}
	
}
