package szlab4hazi;

public class Model {
	private int FieldSize = 50;
	public static Elements[][] Field;
	
	public Model(){
		Field =  new Elements [FieldSize][FieldSize];
		readFile();
	}
	
	
	//txt böl beolvassa az adatokat
	//txt - afféle adatbázis
	//txt pl igy néz ki:
	
	//fal fal    fal fal fal
	//fal zpn     ut  ut fal
	//fal ezredes ... ... ..
	public void readFile(){
		//pl. txt beolvasásnál elsõ elem: fal
		//1. tehát létre kell hozni egy fal objektumot: new Wall();
		//2. és a Field[0][0]-ba berakod, setElement() segítségével
	}
	
	
}
