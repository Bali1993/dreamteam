package szlab4hazi;

public abstract class Elements {
		private String name;
		private int position_x; //0 vagy 1 vagy 2..
		private int position_y;		
		
		public Elements(String name){
			this.name = name;
		}
		
		public String getName(Elements element) {
			return element.name;
		}
		
		public Elements getElement(int x, int y) {
			return Model.Field[x][y];
		}
		
		public void setElement(int x, int y, Elements element) {
			Model.Field[x][y] = element;
			position_x = x;
			position_y = y;
		}

		public int getPosition_x() {
			return position_x;
		}

		public int getPosition_y() {
			return position_y;
		}
		
		
		//setPositon-ek fölöslegesek, mert mikor a Field-be bejegyzünk egy Elements objektumot (setElement), akkor
		//egyben a poziciot is megadjuk vele
		/*public void setPosition_x(int position_x) {
			this.position_x = position_x;
		}
		public void setPosition_y(int position_y) {
			this.position_y = position_y;
		}
		*/
		

		
		
}
