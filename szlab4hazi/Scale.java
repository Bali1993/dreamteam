package szlab4hazi;

public class Scale extends LabyrinthElements {
	private boolean isPushed;
	public int scaleIdentifier; 
	//pl egy sz�m 1-5 k�z�tt, ha mondjuk 5 m�rleg van
	//az�rt van sz�ks�g r�, hogy legyen vmi kapcsolat adott m�rleg-ajt� k�z�tt
	
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
	
	//ha isPushed=true, teh�t ha le van nyomva a m�rleg, rajta van a doboz (vagy maga az ezredes), akkor
	//kinyitja a m�rleggel azonos ID-j� ajt�t, melynek megtal�l�s�hoz
	//v�gig kell menni a t�mb�n
	//ha megvan, akkor isClosedSetter() fv. seg�ts�g�vel az isClosed v�ltoz�t false-ra kell �ll�tani
	public void doorOpener(){
		
	}
	
	//ha isPushed=false, teh�t ha nincs a m�rlegen semmi, akkor
	//bez�rja a hozz� tartoz� ajt�t
	public void doorCloser(){
		
	}

}
