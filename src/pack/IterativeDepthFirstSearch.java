package pack;

import java.util.ArrayList;

public class IterativeDepthFirstSearch {

	private RubiksCube start;
	private RubiksCube goalState;
	
	public IterativeDepthFirstSearch(RubiksCube s, RubiksCube gS) {
		start = s.copy();
		goalState = gS;
	}
	
	public void Start() {
		ArrayList<String> path = new ArrayList<>();
		ArrayList<String> searched = new ArrayList<>();
		Node startN = new Node(start);
		if(DepthFirstSearch(start, startN, goalState.toString(), path, searched)) {
			System.out.println("DONE");
		}
	}
	
	
	private boolean DepthFirstSearch(RubiksCube pos, Node posN, String goal, ArrayList<String> path, ArrayList<String> searched) {
		RubiksCube temp;
		ArrayList<RubiksCube> children = new ArrayList<>();
		temp = pos.move_copy('U', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('U', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('D', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('D', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('R', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('R', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('L', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('L', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('F', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('F', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('B', true);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		temp = pos.move_copy('B', false);
		if(!searched.contains(temp.toString())) {
			children.add(temp);
		}
		
		if(children.size() == 0) {
			return false;
		}
		
		else if(pos.toString().equals(goal)) {
			//TODO add the path finder
			pos.printCube();
			return true;
		}
		else {
			searched.add(pos.toString());
			for(int i = 0; i < children.size(); i++) {
				if(!searched.contains(children.get(i).toString())) {
					searched.add(children.get(i).toString());
					Node tempN = new Node(children.get(i));
					posN.addChild(tempN);
					if(DepthFirstSearch(children.get(i), tempN, goal, path, searched)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
}
