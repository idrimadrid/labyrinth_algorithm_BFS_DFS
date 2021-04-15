package labyrinthe;

import java.util.ArrayList;
import javax.swing.JOptionPane;	

public class SearchInterface{

	public static void main(String[] args){
		// debut toujours à (0,0)
		int x=10;
		Grid2D g=new Grid2D(x,x);		
		ArrayList<Location> Path = new ArrayList<>();
		g.showGrid2d();
		int recherche=1;
		if (recherche==1) {
			new BreadthFirstSearch().search(g.getStart(), g, Path);
		}else if (recherche == 2) {
			new BreadthFirstSearch().search(g.getStart(), g, Path);

		}
		Path.add(g.getGoal());
		for (Location location : Path) {
			location.Set_State_Location(Etat.VISITED);
			if (location.equals(g.getGoal())) {
				location.Set_State_Location(Etat.GOAL);
			}
			System.out.println(location);
		}
	}
}




