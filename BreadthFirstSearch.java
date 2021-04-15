package labyrinthe;

import java.util.ArrayList;

public class BreadthFirstSearch extends AbstractSearch {
	
	public void search(Location l, Grid2D g, ArrayList<Location> path) {
		ArrayList<Location> file = new ArrayList<>();
		file.add(l);
		Location n;
		int last = file.size() - 1;
		boolean stop = false;
		do {
			n = file.get(0);
			file.remove(last);
			path.add(n);
			g.updateGrid2dVisited(n);
			if (n.equals(g.getGoal())) {
				stop = true;
				System.out.println("Trouvé");
				file.clear();
			} else {
				for (Location loc : super.getPossibleMoves(n, g)) {
					file.add(loc);
				}
			}
		} while (!file.isEmpty());
		if (!stop) {
			//System.out.println("Echec");
		}
		System.out.println("Cases visitées :");
	}
}