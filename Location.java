package labyrinthe;

public class Location {
	private int x_Loc;
	private int y_Loc;
	private Etat state;
	
		Location(){
			x_Loc=0;
			y_Loc=0;
			state=Etat.N_VISITED;
		}
		Location(int x,int y){
			x_Loc=x;
			y_Loc=y;
			state=Etat.N_VISITED;
		}
	
		Location(int x,int y,Etat z){
			x_Loc=x;
			y_Loc=y;
			state=z;
		}
		public void SetLocation(int x,int y){
			x_Loc=x;
			y_Loc=y;
		}
		public void SetLocation(int x,int y,Etat z){
			x_Loc=x;
			y_Loc=y;
			state=z;
		}       
		public void Set_X_Location(int x){
			x_Loc=x;
		}
		public void Set_Y_Location(int y){
			y_Loc=y;
		}
		public void Set_State_Location(Etat z){
			state=z;
		}
		public int Get_X_Location(){return x_Loc;}
		public int Get_Y_Location(){return y_Loc;}
		public Etat Get_State_Location(){return state;}
		
		
		public boolean equals(int x, int y) {
			if (this.x_Loc == x && this.y_Loc == y)
				return true;
			return false;
		}
		
		public boolean equals(Location l) {
			if (this.x_Loc == l.x_Loc && this.y_Loc == l.y_Loc)
				return true;
			return false;
		}
		@Override
		public String toString() {
return ("X : "+this.Get_X_Location()+" Y = "+this.Get_Y_Location()+" Etat : "+this.Get_State_Location() );
		}
		
		
}

