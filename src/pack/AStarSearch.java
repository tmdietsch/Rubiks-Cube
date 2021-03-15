package pack;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarSearch {

	private RubiksCube startingCube;
	private PriorityQueue<RubiksCube> nodes;
	private ArrayList<String> searchedNodes; //Using toString method of a cube for easier comparison
	private int totalCost;
	
	public AStarSearch(RubiksCube start) {
		startingCube = start;
		nodes = new PriorityQueue<>();
		searchedNodes = new ArrayList<>();
		totalCost = -1;
	}
	
	public String startSearch() {
		
		return "Empty method";
	}
	
	public int getPathCost() {
		return totalCost;
	}
	
	private void addChildren(RubiksCube parent) {
		
		char[] list = new char[] {'G', 'R', 'B', 'O', 'W', 'Y'};
		
		for (char c : list) {
			nodes.add(parent.move_copy(c, true));
			nodes.add(parent.move_copy(c, false));
		}
		
	}
	
}
