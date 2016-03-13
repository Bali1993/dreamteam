package szlab4hazi;

public class Door extends Elements {
	private boolean isClosed; //ez alapj�n majd m�s k�pet jelenit meg a View oszt�ly az ajt�r�l
	public int doorIdentifier; 
	//pl egy sz�m 1-5 k�z�tt, ha mondjuk 5 ajt� van
	//az�rt van sz�ks�g r�, hogy legyen vmi kapcsolat adott m�rleg-ajt� k�z�tt
	
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
