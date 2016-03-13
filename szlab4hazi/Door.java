package szlab4hazi;

public class Door extends Elements {
	private boolean isClosed; //ez alapján majd más képet jelenit meg a View osztály az ajtóról
	public int doorIdentifier; 
	//pl egy szám 1-5 között, ha mondjuk 5 ajtó van
	//azért van szükség rá, hogy legyen vmi kapcsolat adott mérleg-ajtó között
	
	public Door(int doorID){
		super("door");
		this.doorIdentifier = doorID;
		isClosed = true;
		
	}

	public boolean isClosedGetter() {
		if(isClosed)
			return true;
		else
			return false;
			
	}

	public void isClosedSetter(boolean isclosed) {
		isClosed = isclosed;
	}
	
	

}
