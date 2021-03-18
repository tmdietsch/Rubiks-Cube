package pack;

import java.util.ArrayList;
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
		ArrayList<String> searched = new ArrayList<>();
		Queue<Node> search = new LinkedList<>();
		Node s = new Node(start.copy());
		Node currLocation = new Node(null);
		
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
				ArrayList<RubiksCube> children = new ArrayList<>();
				temp = currLocation.getSelf().move_copy('U', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('U', false);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('D', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('D', false);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('R', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('R', false);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('L', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('L', false);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('F', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('F', false);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('B', true);
				children.add(temp);
				temp = currLocation.getSelf().move_copy('B', false);
				children.add(temp);
				for(int i = 0; i < children.size(); i++) {
					String tempName = children.get(i).toString();
					if(!searched.contains(tempName)) {
						Node tempN = new Node(children.get(i));
						currLocation.addChild(tempN);
						search.add(tempN);
						searched.add(tempName);
					}
				}
			}
			searched.add(currLocation.getSelf().toString());
		}
		
	}
	
	
	
}
