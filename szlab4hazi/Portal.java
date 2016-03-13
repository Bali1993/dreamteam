package szlab4hazi;

public class Portal extends Elements {
	private String portalColour; //yellow or blue
	
	public Portal (int x, int y, String colour){
		super("portal");
		portalColour = colour;
		//iletve a megfelel� indexen bejegyzi mag�t a Field-be:
		setElement(x, y, this);
	}
	
	public String getPortalColour(){
		return portalColour;
	}
	
	
}
