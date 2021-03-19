package pack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	private RubiksCube start;
	private RubiksCube goalState;
	
	public BreadthFirstSearch(RubiksCube s, RubiksCube gS) {
		start = s.copy();
		goalState = gS;
	}
	
	public void Start() {
		ArrayList<Node> path = new ArrayList<>();
		BFS(start, goalState.toString(), path);
	}
	
	public void BFS(RubiksCube start, String goal, ArrayList<Node> p) {
		HashSet<String> searched = new HashSet<>();
		Queue<Node> search = new LinkedList<>();
		Node s = new Node(start.copy());
		Node currLocation;
		int count = 0;
		
		boolean found = false;
		search.add(s);
		
		while(!search.isEmpty() && !found) {
			currLocation = search.remove();
			if(currLocation.getSelf().toString().equals(goal)) {
				p.add(currLocation);
				found = true;
				currLocation.getSelf().printCube();
			}
			else {
				RubiksCube temp;
				RubiksCube currCube = currLocation.getSelf();
				ArrayList<RubiksCube> children = new ArrayList<>();
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
				for(int i = 0; i < children.size(); i++) {
					String tempName = children.get(i).toString();
					if(!searched.contains(tempName)) {
						Node tempN = new Node(children.get(i));
						search.add(tempN);
						searched.add(tempName);
					}
				}
			}
			searched.add(currLocation.getSelf().toString());
			count++;
			if(count%10000 == 0) {
				System.out.println("Nodes searched " + count);
			}
			
		}
		
	}
	
	
	
}
