package szlab4hazi;

public class Scale extends Elements {
	private boolean isPushed;
	
	public Scale(){
		super("scale");
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

}
