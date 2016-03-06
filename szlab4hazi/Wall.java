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
	
	//setSpecial()-re nincs sz�ks�g�nk, mert a falak statikus elemek
	//tulajdons�gaik fixek, a txt-b�l val� beolvas�skor eld�l
}
