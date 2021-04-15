package labyrinthe;

import java.util.ArrayList;


public abstract class AbstractSearch {
	

	protected boolean equal(Location a,Location b){
		return ((a.Get_X_Location()==b.Get_X_Location())&&(a.Get_Y_Location()==b.Get_Y_Location())&&(a.Get_State_Location()==b.Get_State_Location()));
	}
	protected ArrayList<Location> getPossibleMoves(Location a,Grid2D G){
		Location t[][]=G.getGrid2d();
		ArrayList<Location> successeurs=new ArrayList<>();
		
		try {
			if(t [a.Get_X_Location()-1][a.Get_Y_Location()].Get_State_Location() == Etat.N_VISITED ){
				successeurs.add(new Location(a.Get_X_Location()-1, a.Get_Y_Location()));}
		} catch (ArrayIndexOutOfBoundsException e) { // catch out of bounds
				}
		try {
			if(t [a.Get_X_Location()][a.Get_Y_Location()-1].Get_State_Location() == Etat.N_VISITED){
				successeurs.add(new Location(a.Get_X_Location(), a.Get_Y_Location()-1));}
		} catch (ArrayIndexOutOfBoundsException e) { // catch out of bounds
			
		}
		try {
			if(t [a.Get_X_Location()+1][a.Get_Y_Location()].Get_State_Location() == Etat.N_VISITED){
				successeurs.add(new Location(a.Get_X_Location()+1,a.Get_Y_Location()));}
		} catch (ArrayIndexOutOfBoundsException e) { // catch out of bounds
			
		}
		try {
			if(t [a.Get_X_Location()][a.Get_Y_Location()+1].Get_State_Location() == Etat.N_VISITED){
				successeurs.add(new Location(a.Get_X_Location(),a.Get_Y_Location()+1));}
		} catch (ArrayIndexOutOfBoundsException e) { // catch out of bounds
		}

		return successeurs;
	}

}
