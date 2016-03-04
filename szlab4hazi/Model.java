package szlab4hazi;

public class Model {
	private static int FieldSize = 50;
	
	private Elements[][] Field;
	public Model(){
		Field =  new Elements [FieldSize][FieldSize];
	}
	
	
	//ezeket használja majd a Controller
	public Elements getField(int x, int y) {
		return Field[x][y];
	}
	
	public void setField(int x, int y, Elements element) {
		Field[x][y] = element;
	}

	
}
