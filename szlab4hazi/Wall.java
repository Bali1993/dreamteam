package szlab4hazi;

public class Wall extends LabyrinthElements {
	private boolean special;
	
	public Wall(boolean special){
		super("wall");
		this.special = special;
	}
	
	public boolean getSpecial(){
		if(special)
			return true;
		else
			return false;
	}
	
	//setSpecial()-re nincs szükségünk, mert a falak statikus elemek
	//tulajdonságaik fixek, a txt-bõl való beolvasáskor eldõl
}
