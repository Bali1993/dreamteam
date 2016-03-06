package szlab4hazi;

public class Hole extends LabyrinthElements {
	public Hole(){
		super("hole");
	}
	
	//ha rámegy az ezredes (beleesik a szakadékba)
	//akkor megöli, azaz a Colonel obj. isAlive változóját false-ra állítja
	public void kill(){
		Colonel.isAlive = false;
		
	}

}
