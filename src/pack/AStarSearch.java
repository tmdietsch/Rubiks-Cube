package pack;

import java.util.HashMap;
import java.util.PriorityQueue;

public class AStarSearch {

	private final char[] moveList = new char[] {'F', 'R', 'B', 'U', 'D', 'L'};
	
	private RubiksCube startingCube;
	private PriorityQueue<RubiksCube> nodeKeys;
	private HashMap<String, RubiksCube> searchedNodes;
	private int totalCost;
	private int iterativeDepth;
	
	public AStarSearch(RubiksCube start) {
		startingCube = start;
		nodeKeys = new PriorityQueue<>();
		searchedNodes = new HashMap<>();
		totalCost = -1;
	}
	
	public AStarSearch(RubiksCube start, int iterativeDepth) {
		startingCube = start;
		nodeKeys = new PriorityQueue<>();
		searchedNodes = new HashMap<>();
		totalCost = -1;
		
		this.iterativeDepth = iterativeDepth;
	}
	
	public String startSearch() {
		
		RubiksCube currentCube = startingCube;

		int num = 0;
		while(!checkIfSolved(currentCube)) {
			addChildren(currentCube);
			
			num++;
			if (num % 10000 == 0)
				System.out.println(nodeKeys.size() + ", " + num);
			
			if (num % 100000 == 0)
				currentCube.printCube();
			
//			if (nodeKeys.size() > 1000000) {
//				PriorityQueue<RubiksCube> backup = new PriorityQueue<RubiksCube>();
//				
//				for (int p = 0; p < 100000; p++) {
//					backup.add(nodeKeys.remove());
//				}
//				
//				nodeKeys = backup;
//			}
			
			RubiksCube temp = nodeKeys.remove();
			currentCube = searchedNodes.get(temp.toString());
		}
		
		
		
		return currentCube.toString();
	}
	
	public String startSearchRecursive() {
		RubiksCube currentCube = startingCube;

		HashMap<String, RubiksCube> dummy = new HashMap<>();
		dummy.put(currentCube.toString(), currentCube);
		
		int num = 0;
		while(!addChildrenRecursive(dummy, iterativeDepth)) {
			
			num++;
			if (num % 2500 == 0)
				System.out.println(nodeKeys.size() + ", " + num);
			
			if (num % 10000 == 0)
				currentCube.printCube();
			
			RubiksCube temp = nodeKeys.remove();
			currentCube = searchedNodes.get(temp.toString());
			
			dummy = new HashMap<>();
			dummy.put(currentCube.toString(), currentCube);
		}
		
		return currentCube.toString();
	}
	
	public int getPathCost() {
		return totalCost;
	}
	
	private boolean checkIfSolved(RubiksCube rub) {
		
		String solved = RubiksCube.REFERENCE.toString();
		String checking = rub.toString();
		
		if (solved.equals(checking))
			return true;
		
		return false;
		
	}
	
	private void addChildren(RubiksCube parent) {
		
		
		int numMoves = 3;
		
		searchedNodes.put(parent.toString(), parent);
		
		for (char c : moveList) {
			
			for (int i = 0; i < numMoves; i++) {
				RubiksCube rCube = parent.move_copy(c, i);
				String str = rCube.toString();
				
				if (!searchedNodes.containsKey(str)) {
					nodeKeys.add(rCube);
					searchedNodes.put(str, rCube);
				}
			}
		}

	}
	
	private boolean addChildrenRecursive(HashMap<String, RubiksCube> map, int depth) {
		
		if (depth == 0) return false;
		
		int numMoves = 3;
		
		searchedNodes.putAll(map);
		
		HashMap<String, RubiksCube> mapToAdd = new HashMap<>();
		
		for (RubiksCube mapCube : map.values()) {
			
			for (int charNum = 0; charNum < moveList.length; charNum++) {
				for (int i = 0; i < numMoves; i++) {
					
					RubiksCube rCube = mapCube.move_copy(moveList[charNum], i);
					
					if (checkIfSolved(rCube))
						return true;
					
					if (!searchedNodes.containsKey(rCube.toString()))
						mapToAdd.put(rCube.toString(), rCube);
				}
			}
		}
		
		if (depth == 1) {
			nodeKeys.addAll(mapToAdd.values());
			
			searchedNodes.putAll(mapToAdd);
			
			return false;
		}
		
		return addChildrenRecursive(mapToAdd, depth - 1);
		
	}
	
//	private HashMap<String, RubiksCube> recursiveLookAhead(HashMap<String, RubiksCube> map, int depth) {
//		
//		if (depth == 0) return null;
//		
//		char[] list = new char[] {'F', 'R', 'B', 'U', 'D', 'L'};
//		int numMoves = 3;
//		
//		
//		return null;
//	}
	
}
