package szlab4hazi;

public class Hole extends LabyrinthElements {
	public Hole(){
		super("hole");
	}
	
	//ha r�megy az ezredes (beleesik a szakad�kba)
	//akkor meg�li, azaz a Colonel obj. isAlive v�ltoz�j�t false-ra �ll�tja
	public void kill(){
		Colonel.isAlive = false;
		
	}

}
