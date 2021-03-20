package pack;
//Tim Dietsch and Carly Williams
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearch {

	//Move list in reference for addChildren method
	private final char[] moveList = new char[] {'F', 'R', 'B', 'U', 'D', 'L'};
	
	private Node startingCube;	//cube to start at
	private PriorityQueue<Node> nodes;	//queue of nodes to be looked at
	private HashSet<String> searchedNodes;	//all the nodes that have been searched
	
	/**
	 * Constructor
	 * 
	 * @param start
	 */
	public AStarSearch(RubiksCube start) {
		startingCube = new Node(start);
		nodes = new PriorityQueue<>();
		searchedNodes = new HashSet<>();
	}
	
	/**
	 * Main searching algorithm for A*
	 * 
	 * @return
	 */
	public String startSearch() {
		
		//Setting the current cube with the starting cube
		Node currentCube = startingCube;

		int num = 0;	//number of times gone through the while loop for debugging
		while(currentCube.getSelf().heuristic() != 0) {
			addChildren(currentCube);	//add all the children from the parent
			
			num++;	//increment
			if (num % 10000 == 0)	//show results every 10000 increments
				System.out.println("Searched Node Size: " + nodes.size() +
						", Number of increments: " + num);
			
			currentCube = nodes.remove();	//remove head of priority queue
		}
		
		currentCube.getSelf().printCube();	//print the resulting cube once done
		
		return currentCube.toString();	//return the string of the cube
	}
	
	/**
	 * Adds all the children of the parent to searchedNodes and
	 * priority queue nodes
	 * 
	 * @param parent
	 */
	private void addChildren(Node parent) {
		
		int numMoves = 2;	//For each direction a move can go
		
		//add the parent to the list of searched nodes
		searchedNodes.add(parent.toString());
		
		//Iterate through the moveList
		for (char c : moveList) {
			
			//Iterate through direction of move
			for (int i = 0; i < numMoves; i++) {
				
				//Get the cube from the resulting move
				RubiksCube rCube = parent.getSelf().move_copy(c, i);
				String str = rCube.toString();
				
				//Add it to our lists if not added yet
				if (!searchedNodes.contains(str)) {
					nodes.add(new Node(rCube, parent));
					searchedNodes.add(str);
				}
			}
		}

	}
	
}
