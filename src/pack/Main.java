package pack;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
    	//Used to ID the goal state
    	RubiksCube reference = RubiksCube.REFERENCE;
    	//the cube we will run the search algorithm on 
    	RubiksCube cube;;
    	//Performs the A* search
    	AStarSearch aStar;
    	//Performs the Breadth First search
    	BreadthFirstSearch bfs;
    	
    	//Timer variables
    	double startTime, endTime;
    	
    	for (int i = 2; i <= 9; i++) {
        	System.out.println("Random move selected " + i + " times");
        	cube = new RubiksCube();
        	cube.randomize(i);
        	cube.printCube();
        	
        	if (i <= 5) {
	        	System.out.println("Breadth First Search");
	        	bfs = new BreadthFirstSearch(cube, reference);
	        	startTime = System.currentTimeMillis();
	        	bfs.Start();
	        	endTime = (System.currentTimeMillis() - startTime) / 1000;
	        	
	        	System.out.println(endTime + " seconds");
	        	System.out.println();
        	}
        	
        	System.out.println("A* Search");
        	aStar = new AStarSearch(cube);
        	startTime = System.currentTimeMillis();
        	aStar.startSearch();
        	endTime = (System.currentTimeMillis() - startTime) / 1000;
        	
        	System.out.println(endTime + " seconds");
        	System.out.println();
    	}

    }
}