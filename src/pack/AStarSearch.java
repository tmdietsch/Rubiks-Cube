package pack;

import java.util.HashMap;
import java.util.PriorityQueue;

public class AStarSearch {

	private RubiksCube startingCube;
	private PriorityQueue<RubiksCube> nodeKeys;
	private HashMap<String, RubiksCube> searchedNodes;
	private int totalCost;
	
	public AStarSearch(RubiksCube start) {
		startingCube = start;
		nodeKeys = new PriorityQueue<>();
		searchedNodes = new HashMap<>();
		totalCost = -1;
	}
	
	public String startSearch() {
		
		RubiksCube completeCube = new RubiksCube();
		RubiksCube currentCube = startingCube;

		int num = 0;
		while(!currentCube.equals(completeCube)) {
			addChildren(currentCube);
			
			num++;
			if (num % 10000 == 0)
				System.out.println(nodeKeys.size() + ", " + num);
			
			if (num % 100000 == 0)
				currentCube.printCube();
			
			if (nodeKeys.size() > 1000000) {
				PriorityQueue<RubiksCube> backup = new PriorityQueue<RubiksCube>();
				
				for (int p = 0; p < 100000; p++) {
					backup.add(nodeKeys.remove());
				}
				
				nodeKeys = backup;
			}
			
			RubiksCube temp = nodeKeys.remove();
			currentCube = searchedNodes.get(temp.toString());
		}
		
		
		
		return currentCube.toString();
	}
	
	public int getPathCost() {
		return totalCost;
	}
	
	private void addChildren(RubiksCube parent) {
		
		char[] list = new char[] {'F', 'R', 'B', 'U', 'D', 'L'};
		
		searchedNodes.put(parent.toString(), parent);
		
		for (char c : list) {
			
			for (int i = 0; i < 3; i++) {
				RubiksCube rCube = parent.move_copy(c, i);
				String str = rCube.toString();
			
				if (!searchedNodes.containsKey(str)) {
					nodeKeys.add(rCube);
					searchedNodes.put(str, rCube);
				}
			}
		}
		
	}
	
}
