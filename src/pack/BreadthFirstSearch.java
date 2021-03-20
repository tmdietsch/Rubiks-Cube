package pack;
//Tim Dietsch and Carly Williams
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	//the state we are starting from
	private RubiksCube start;
	//the state we want to get to
	private RubiksCube goalState;
	
	public BreadthFirstSearch(RubiksCube s, RubiksCube gS) {
		start = s.copy();
		goalState = gS;
	}
	
	/**
	 * can be called by the user to start the algorithm
	 * */
	public void Start() {
		ArrayList<Node> path = new ArrayList<>();
		BFS(start, goalState.toString(), path);
	}
	
	public void BFS(RubiksCube start, String goal, ArrayList<Node> p) {
		//A hashset of states that have been searched
		HashSet<String> searched = new HashSet<>();
		//Queue of Nodes to search
		Queue<Node> search = new LinkedList<>();
		//starting location
		Node s = new Node(start.copy());
        //Holds the current location being searched
		Node currLocation;
		//Number of nodes searched
		int count = 0;
		
        //keeps track if the target has been found
		boolean found = false;
		search.add(s);
		
		while(!search.isEmpty() && !found) {
            //set the current location
			currLocation = search.remove();
            //checks if current location is the target
			if(currLocation.getSelf().toString().equals(goal)) {
                //add the target to find the path
				p.add(currLocation);
				found = true;
				currLocation.getSelf().printCube();
			}
			else {// current location isn't the target
				RubiksCube temp;
				//The current state of the cube
				RubiksCube currCube = currLocation.getSelf();
				//Holds all the states that can be reached from the current state
				ArrayList<RubiksCube> children = new ArrayList<>();
				//Put all the possible moves into the array
				temp = currCube.move_copy('U', 0);
				children.add(temp);
				temp = currCube.move_copy('U', 1);
				children.add(temp);
				temp = currCube.move_copy('D', 0);
				children.add(temp);
				temp = currCube.move_copy('D', 1);
				children.add(temp);
				temp = currCube.move_copy('R', 0);
				children.add(temp);
				temp = currCube.move_copy('R', 1);
				children.add(temp);
				temp = currCube.move_copy('L', 0);
				children.add(temp);
				temp = currCube.move_copy('L', 1);
				children.add(temp);
				temp = currCube.move_copy('F', 0);
				children.add(temp);
				temp = currCube.move_copy('F', 1);
				children.add(temp);
				temp = currCube.move_copy('B', 0);
				children.add(temp);
				temp = currCube.move_copy('B', 1);
				children.add(temp);
				//checks if any of the children have already been searched
				for(int i = 0; i < children.size(); i++) {
					String tempName = children.get(i).toString();
					//if we haven't searched here yet add it to the queue
					if(!searched.contains(tempName)) {
						Node tempN = new Node(children.get(i));
						search.add(tempN);
						searched.add(tempName);
					}
				}
			}
			//mark the current state as searched
			searched.add(currLocation.getSelf().toString());
			//Keeps count of how many states we have searched
			count++;
			if(count%10000 == 0) {
				System.out.println("Approx Searched Node Size: " + count);
			}
			
		}
		
	}
	
	
	
}
