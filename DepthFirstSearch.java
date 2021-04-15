package labyrinthe;

import java.util.ArrayList;

public class DepthFirstSearch extends AbstractSearch {

	@Override
	protected ArrayList<Location> getPossibleMoves(Location a, Grid2D G) {
		return super.getPossibleMoves(a, G);
	}
	public void search(Location l,Grid2D g,ArrayList<Location> path) {	
		ArrayList<Location> pile = new ArrayList<>();
		pile.add(l);
		Location n;
		boolean stop = false;
		do {
			n = pile.get(0);
			pile.remove(0);
			path.add(n);
			g.updateGrid2dVisited(n);
			if (n.Get_State_Location()==Etat.GOAL) {
				stop = true;
				System.out.println("Trouvé");
				pile.clear();
			} else {
				for (Location loc : getPossibleMoves(n, g)) {
					pile.add(loc);
				}
			}
		} while (!pile.isEmpty());
		if (!stop) {
			//System.out.println("Echec");
		}
		System.out.println("Cases visitées :");
	}



}
