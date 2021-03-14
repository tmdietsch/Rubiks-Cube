package pack;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting\n");
        RubiksCube cube = new RubiksCube();
        cube.printCube();
        cube.randomize();
        System.out.println("\n\n");
        cube.printCube();
        System.out.println("\n\n");
        RubiksCube clone = cube.copy();
        clone.printCube();
        System.out.println("\n" + cube.equals(clone) + "\n\n");
        clone.move_B();
        cube.printCube();
        System.out.println("\n\n");
        clone.printCube();
        System.out.println("\n" + cube.equals(clone) + "\n\n");
    }
}