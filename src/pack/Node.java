package pack;

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    
	String name;
	
    //where we were before the current node. Is null by default
    Node parent;
    //what is stored in the node
    RubiksCube self;
    //the children of the node
    //ArrayList<Node> children;
    
    int cost;
    int straightCost;
    
    Node(RubiksCube s){
        parent = null;
        self = s;
        //children = new ArrayList<>();
        name = s.toString();
        
        straightCost = s.heuristic();
        cost = 0;
    }
    
    Node(RubiksCube s, Node parent){
    	this.parent = parent;
    	self = s;
    	//children = new ArrayList
    	name = s.toString();
    	
    	this.cost = 2 + parent.cost;
    	this.straightCost = s.heuristic();
    }
    
//    public void addChild(Node c){
//        c.setParent(this);
//        children.add(c);
//    }
    
    public void setParent(Node p){
        parent = p;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public RubiksCube getSelf(){
        return self;
    }

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost + this.straightCost, o.cost + o.straightCost);
	}
    
}