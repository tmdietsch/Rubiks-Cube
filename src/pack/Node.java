package pack;


public class Node implements Comparable<Node> {
    
	String name;		//name of the node (comes from cube)
    Node parent;		//parent node
    RubiksCube self;	//cube represented by node
    
    int cost;			//cost so far
    int straightCost;	//cost if we move each color with no obstructions
    
    /**
     * Constructor
     * 
     * @param s
     */
    Node(RubiksCube s){
        parent = null;	//no parent
        self = s;		//setting cube
        name = s.toString();	//initializing name
        
        straightCost = s.heuristic();	//calculating heuristic
        cost = 0;						//calculating cost
    }
    
    /**
     * Constructor
     * 
     * @param s
     * @param parent
     */
    Node(RubiksCube s, Node parent){
    	this.parent = parent;	//setting parent
    	self = s;				//setting cube
    	name = s.toString();	//initializing name
    	
    	this.cost = 1 + parent.cost;		//calculating cost
    	this.straightCost = s.heuristic();	//calculating heuristic
    }
    
    /**
     * Sets the parent of the node
     * 
     * @param p
     */
    public void setParent(Node p){
        parent = p;
    }
    
    /**
     * Gets the parent of the node
     * 
     * @return
     */
    public Node getParent(){
        return parent;
    }
    
    /**
     * Gets the rubiks cube associated with the node
     * 
     * @return
     */
    public RubiksCube getSelf(){
        return self;
    }

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost + this.straightCost, o.cost + o.straightCost);
	}
    
}