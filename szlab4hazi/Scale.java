package szlab4hazi;

public class Scale extends LabyrinthElements {
	private boolean isPushed;
	public int scaleIdentifier; 
	//pl egy szám 1-5 között, ha mondjuk 5 mérleg van
	//azért van szükség rá, hogy legyen vmi kapcsolat adott mérleg-ajtó között
	
	public Scale(int scaleID){
		super("scale");
		scaleIdentifier = scaleID;
	}

	public boolean isPushedGetter() {
		if(isPushed)
			return true;
		else
			return false;
			
	}

	public void isPushedSetter(boolean ispushed) {
		isPushed = ispushed;
	}
	
	//ha isPushed=true, tehát ha le van nyomva a mérleg, rajta van a doboz (vagy maga az ezredes), akkor
	//kinyitja a mérleggel azonos ID-jü ajtót, melynek megtalálásához
	//végig kell menni a tömbön
	//ha megvan, akkor isClosedSetter() fv. segítségével az isClosed változót false-ra kell állítani
	public void doorOpener(){
		
	}
	
	//ha isPushed=false, tehát ha nincs a mérlegen semmi, akkor
	//bezárja a hozzá tartozó ajtót
	public void doorCloser(){
		
	}

}
