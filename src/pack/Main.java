package pack;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting\n");
        RubiksCube cube = new RubiksCube();
        cube.printCube();
        cube.randomize();
        System.out.println("\n\n");
        cube.printCube();
    }
}