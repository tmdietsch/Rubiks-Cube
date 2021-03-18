package pack;

import java.util.ArrayList;

public class Node {
    
    //where we were before the current node. Is null by default
    Node parent;
    //what is stored in the node
    RubiksCube self;
    //the children of the node
    ArrayList<Node> children;
    
    Node(RubiksCube s){
        parent = null;
        self = s;
        children = new ArrayList<>();
    }
    
    public void addChild(Node c){
        c.setParent(this);
        children.add(c);
    }
    
    public void setParent(Node p){
        parent = p;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public RubiksCube getSelf(){
        return self;
    }
    
}