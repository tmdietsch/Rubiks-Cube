package pack;

public class Main {
    public static void main(String[] args) {
//        System.out.println("\nTesting\n");
//        RubiksCube cube = new RubiksCube();
//        cube.printCube();
//        cube.randomize();
//        System.out.println("\n\n");
//        cube.printCube();
//        System.out.println("\n\n");
//        RubiksCube clone = cube.copy();
//        clone.printCube();
//        System.out.println("\n" + cube.equals(clone) + "\n\n");
//        clone.move_B();
//        cube.printCube();
//        System.out.println("\n\n");
//        clone.printCube();
//        System.out.println("\n" + cube.equals(clone) + "\n\n");
    	
    	RubiksCube cube = new RubiksCube();
    	
    	cube.move_B();
    	cube.move_D();
    	cube.move_F();
    	cube.move_Bp();
    	cube.move_Lp();
//    	cube.move_Fp();
//    	cube.move_Bp();
//    	cube.move_Up();
//    	cube.move_Up();
//    	cube.move_L();
    	
    	cube.printCube();
    	
    	AStarSearch aStar = new AStarSearch(cube);
    	
    	aStar.startSearch();
    	
    	System.out.println("Done");
    	
    	
    }
}