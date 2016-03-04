package szlab4hazi;

public class Door extends Elements {
	private boolean isClosed;

	public boolean isClosedGetter() {
		if(isClosed)
			return true;
		else
			return false;
			
	}

	public void isClosedSetter(boolean isclosed) {
		isClosed = isclosed;
	}
	
	

}
