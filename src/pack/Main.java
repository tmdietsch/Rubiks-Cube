package pack;

public class Main {
    public static void main(String[] args) {
    	
    	RubiksCube reference = RubiksCube.REFERENCE;
    	RubiksCube cube = new RubiksCube();
    	
    	cube.randomize(13);
    	
    	cube.printCube();
    	
    	AStarSearch aStar = new AStarSearch(cube, 2);
    	
    	aStar.startSearch();
    	
    	System.out.println("Done");
    	
    	
    }
}