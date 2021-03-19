package pack;

public class Main {
    public static void main(String[] args) {
    	//Used to ID the goal state
    	RubiksCube reference = RubiksCube.REFERENCE;
    	//the cube we will run the search algorithm on 
    	RubiksCube cube = new RubiksCube();
    	//Performs the A* search
    	AStarSearch aStar;
    	//Performs the Breadth First search
    	BreadthFirstSearch bfs;
    	
    	//Run both algorithms after making 2 moves on the cube
    	System.out.println("Random move selected 2 times");
    	cube.randomize(2);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
    	//Run both algorithms after making 3 moves on the cube
    	cube = new RubiksCube();
    	System.out.println("Random move selected 3 times");
    	cube.randomize(3);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
    	//Run both algorithms after making 4 moves on the cube
    	cube = new RubiksCube();
    	System.out.println("Random move selected 4 times");
    	cube.randomize(4);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
    	//Run both algorithms after making 5 moves on the cube
    	cube = new RubiksCube();
    	System.out.println("Random move selected 5 times");
    	cube.randomize(5);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
    	//Run both algorithms after making 6 moves on the cube
    	//Runtime for this is decently longer than the others
    	cube = new RubiksCube();
    	System.out.println("Random move selected 6 times");
    	cube.randomize(6);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
    	//Run both algorithms after making 7 moves on the cube
    	//Runtime for this amount of moves is often unreasonable
    	cube = new RubiksCube();
    	System.out.println("Random move selected 7 times");
    	cube.randomize(7);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    }
}