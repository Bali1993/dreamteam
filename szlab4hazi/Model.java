package szlab4hazi;

public class Model {
	private int FieldSize = 50;
	public static Elements[][] Field;
	
	public Model(){
		Field =  new Elements [FieldSize][FieldSize];
		readFile();
	}
	
	
	//txt b�l beolvassa az adatokat
	//txt - aff�le adatb�zis
	//txt pl igy n�z ki:
	
	//fal fal    fal fal fal
	//fal zpn     ut  ut fal
	//fal ezredes ... ... ..
	public void readFile(){
		//pl. txt beolvas�sn�l els� elem: fal
		//1. teh�t l�tre kell hozni egy fal objektumot: new Wall();
		//2. �s a Field[0][0]-ba berakod, setElement() seg�ts�g�vel
	}
	
	
}
