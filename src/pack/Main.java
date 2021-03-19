package pack;

public class Main {
    public static void main(String[] args) {
    	
    	RubiksCube reference = RubiksCube.REFERENCE;
    	RubiksCube cube = new RubiksCube();
    	AStarSearch aStar;
    	BreadthFirstSearch bfs;
    	
    	System.out.println("Random move selected 2 times");
    	cube.randomize(2);
    	cube.printCube();
    	
    	System.out.println("Breadth First Search");
    	bfs = new BreadthFirstSearch(cube, reference);
    	bfs.Start();
    	
    	System.out.println("A* Search");
    	aStar = new AStarSearch(cube);
    	aStar.startSearch();
    	
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