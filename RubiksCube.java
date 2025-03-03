import java.util.Arrays;

public class RubiksCube {
    private char[][][] cube; // 3D Array to store cube faces
    private final char[] colors = {'w', 'y', 'r', 'o', 'b', 'g'}; // white, yellow, red, orange, blue, green
    
    public RubiksCube() {
        cube = new char[6][3][3]; // 6 faces, 3x3 grid each
        initializeCube();
    }
    
    private void initializeCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(cube[i][j], colors[i]);
            }
        }
    }
    
    public void printCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public void moveU() {
        rotateFaceClockwise(0);
        // Adjust adjacent faces
        char[] temp = cube[2][0].clone();
        cube[2][0] = cube[4][0];
        cube[4][0] = cube[3][0];
        cube[3][0] = cube[5][0];
        cube[5][0] = temp;
    }

    public void moveD() {
        rotateFaceClockwise(1);
        char[] temp = cube[2][2].clone();
        cube[2][2] = cube[5][2];
        cube[5][2] = cube[3][2];
        cube[3][2] = cube[4][2];
        cube[4][2] = temp;
    }

    public void moveR() {
        rotateFaceClockwise(5);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][2];
            cube[0][i][2] = cube[2][i][2];
            cube[2][i][2] = cube[1][i][2];
            cube[1][i][2] = cube[3][2 - i][0];
            cube[3][2 - i][0] = temp;
        }
    }

    public void moveL() {
        rotateFaceClockwise(5);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][2];
            cube[2][i][2] = cube[1][i][2];
            cube[1][i][2] = cube[3][2 - i][0];
            cube[3][2 - i][0] = temp;
        }
    }

    public void moveF() {
        rotateFaceClockwise(2);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][2][i];
            cube[0][2][i] = cube[4][2 - i][2];
            cube[4][2 - i][2] = cube[1][0][2 - i];
            cube[1][0][2 - i] = cube[5][i][0];
            cube[5][i][0] = temp;
        }
    }

    public void moveB() {
        rotateFaceClockwise(3);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][0][i];
            cube[0][0][i] = cube[5][i][2];
            cube[5][i][2] = cube[1][2][2 - i];
            cube[1][2][2 - i] = cube[4][2 - i][0];
            cube[4][2 - i][0] = temp;
        }
    }
    
    private void rotateFaceClockwise(int face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[j][2 - i] = cube[face][i][j];
            }
        }
        cube[face] = temp;
    }
    
    public static void main(String[] args) {
        RubiksCube rubiksCube = new RubiksCube();
        System.out.println("Initial Cube State:");
        rubiksCube.printCube();
        
        rubiksCube.moveU();
        System.out.println("After U Move:");
        rubiksCube.printCube();

        rubiksCube.moveD();
        System.out.println("After D Move:");
        rubiksCube.printCube();

        rubiksCube.moveR();
        System.out.println("After R Move:");
        rubiksCube.printCube();

        rubiksCube.moveL();
        System.out.println("After L Move:");
        rubiksCube.printCube();

        rubiksCube.moveF();
        System.out.println("After F Move:");
        rubiksCube.printCube();

        rubiksCube.moveB();
        System.out.println("After B Move:");
        rubiksCube.printCube();
    }
}
