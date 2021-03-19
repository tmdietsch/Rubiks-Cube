package pack;

public class Main {
    public static void main(String[] args) {
    	
    	RubiksCube reference = RubiksCube.REFERENCE;
    	RubiksCube cube = new RubiksCube();
    	
    	cube.move_B();
    	cube.move_D();
    	cube.move_F();
    	cube.move_Bp();
    	cube.move_Lp();
    	cube.move_Fp();
    	cube.move_Bp();
    	cube.move_Up();
//    	cube.move_Up();
//    	cube.move_L();
//    	
    	cube.printCube();
    	
    	AStarSearch aStar = new AStarSearch(cube, 2);
    	
    	aStar.startSearchRecursive();
    	
    	System.out.println("Done");
    	
    	
    }
}