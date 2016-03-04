package szlab4hazi;

public class Colonel extends Elements{
	private String direction; //up, down, left, right
	
	public Colonel(){
		super("colonel");
	}
	
	//ezredes aktualis iranyat adja vissza
	public String getDirection() {
		return direction;
	}

	//Controller végzi majd a direction valtozo beallitasat a billentyü lenyomasok alapjan
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void shoot(){
		
	}
	
	
}
