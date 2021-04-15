package labyrinthe;

import java.util.ArrayList;
import java.util.Random;



public class Grid2D extends AbstractSearch {
	public Location[][] grid2d;
	private int xD;
	private int yD;
	private Location Start;
	private Location Goal;
	public int Obstacles;
	private ArrayList<Location> ListObstacles = new ArrayList<>();


	Grid2D(int xD,int yD){
		this.xD=xD;
		this.yD=yD;
		this.grid2d = new Location[GetXD()][GetYD()];
		this.Start=new Location(0,0);
		this.Goal=new Location(this.GetX(), this.GetY(), Etat.GOAL);
		this.Obstacles=((this.GetXD())*(this.GetYD()))/4;

		for(int i=0; i<GetYD(); i++){
			for(int j=0; j<GetXD(); j++){
				this.grid2d[j][i]= new Location(j,i);
			}
		}
		setObstacles();
		updateGrid2dStartNGoal();
		updateGrib2dWalls();

	}
	public int GetXD(){
		return xD;
	}
	public int GetYD(){
		return yD;
	}
	public int GetX(){
		return xD-1;
	}
	public int GetY(){
		return yD-1;
	}
	public Location[][] getGrid2d(){
		return grid2d;
	}
	public int getObstacles() {
		return Obstacles;
	}

	public ArrayList<Location> getListObstacles() {
		return ListObstacles;
	}
	public void setObstacles() {
		int i = 0;
		// Tableau qui permettra de ne pas regénérer un obstacle déjà généré
		ArrayList<Location> array = new ArrayList<>();
		array.add(this.getStart());
		array.add(this.getGoal());
		while (i < this.getObstacles()) {
			Location l = genObsLoc();
			while (exists(l, array)) {
				l = genObsLoc();
			}
			l.Set_State_Location(Etat.WALL);
			ListObstacles.add(l);
			array.add(l);
			i++;
		}
	}
	public Location getStart() {
		return Start;
	}
	public void setGoal(int x, int y) {
		Goal = new Location(x,y,Etat.GOAL);
	}
	public Location getGoal() {
		return Goal;
	} 
	public Location genObsLoc() {
		int x = new Random().nextInt(this.GetX());
		int y = new Random().nextInt(this.GetY());
		return new Location(x, y);
	}
	// Vérifie l'existence d'une Location dans un array
	public boolean exists(Location l, ArrayList<Location> array) {
		for (Location loc : array) {
			if (loc.equals(l))
				return true;
		}
		return false;
	}

	public void updateGrid2dStartNGoal() {
		this.grid2d[0][0]=getStart();
		this.grid2d[GetX()][GetY()]=getGoal();
	}
	public void updateGrib2dWalls() {
		for (Location l : getListObstacles()) {
			grid2d[l.Get_X_Location()][l.Get_Y_Location()]=l;
		}
	}
	public void showGrid2d() {
		for(int y=0;y<GetYD();y++) {
			for(int i=0;i<GetXD();i++) {

				System.out.print(grid2d[i][y].Get_State_Location()+"          ");
				if(i==GetX()) {
					System.out.println(" ");
				}

			}
		}}
	// Mettre à jour une case en VISITED
	public void updateGrid2dVisited(Location l) {
		grid2d[l.Get_X_Location()][l.Get_Y_Location()].Set_State_Location(Etat.VISITED);
	}




}



