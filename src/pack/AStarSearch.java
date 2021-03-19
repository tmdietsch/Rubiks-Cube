package pack;

import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearch {

	private final char[] moveList = new char[] {'F', 'R', 'B', 'U', 'D', 'L'};
	
	private Node startingCube;
	private PriorityQueue<Node> nodeKeys;
	private HashSet<String> searchedNodes;
	private int totalCost;
	
	public AStarSearch(RubiksCube start) {
		startingCube = new Node(start);
		nodeKeys = new PriorityQueue<>();
		searchedNodes = new HashSet<>();
		totalCost = -1;
	}
	
	public String startSearch() {
		
		Node currentCube = startingCube;

		int num = 0;
		while(currentCube.getSelf().heuristic() != 0) {
			addChildren(currentCube);
			
			num++;
			if (num % 10000 == 0)
				System.out.println(nodeKeys.size() + ", " + num);
			
			if (num % 100000 == 0)
				currentCube.getSelf().printCube();
			
			currentCube = nodeKeys.remove();
		}
		
		currentCube.getSelf().printCube();
		
		return currentCube.toString();
	}
	
	public int getPathCost() {
		return totalCost;
	}
	
	private void addChildren(Node parent) {
		
		
		int numMoves = 2;
		
		searchedNodes.add(parent.toString());
		
		for (char c : moveList) {
			
			for (int i = 0; i < numMoves; i++) {
				RubiksCube rCube = parent.getSelf().move_copy(c, i);
				String str = rCube.toString();
				
				if (!searchedNodes.contains(str)) {
					nodeKeys.add(new Node(rCube, parent));
					searchedNodes.add(str);
				}
			}
		}

	}
	
}
