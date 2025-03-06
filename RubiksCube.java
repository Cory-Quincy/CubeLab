import java.util.ArrayList;
import java.util.Scanner;

public class RubiksCube {
    static char[][][] cube =  {
                                    {
                                        {'w','w','w'},
                                        {'w','w','w'},
                                        {'w','w','w'}
                                    },
                                    {
                                        {'b','b','b'},
                                        {'b','b','b'},
                                        {'b','b','b'}
                                    },
                                    {
                                        {'r','r','r'},
                                        {'r','r','r'},
                                        {'r','r','r'}
                                    },
                                    {
                                        {'g','g','g'},
                                        {'g','g','g'},
                                        {'g','g','g'}
                                    },
                                    {
                                        {'y','y','y'},
                                        {'y','y','y'},
                                        {'y','y','y'}

                                    },
                                    {
                                        {'o','o','o'},
                                        {'o','o','o'},
                                        {'o','o','o'}
                                    },
                                };
    static void solve(ArrayList<String> stack){
        System.out.print("Solution: ");
        for (int i = stack.size() - 1; i >= 0; i--){
            System.out.print(stack.get(i));
            stack.remove(i);
        }
    }

    static void printCube(){
        System.out.println();
        for (int i = 0; i < cube.length; i++){
            for (int j = 0; j < cube[i].length; j++){
                for(int k=0; k<cube[i][j].length; k++){
                    System.out.print(cube[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static void rotateFaceClockwise(int face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[j][2 - i] = cube[face][i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[face][i][j] = temp[i][j];
            }
        }
        cube[face] = temp;
    }

    static void moveU() {
        rotateFaceClockwise(0);
        char[] temp = cube[2][0].clone();
        cube[2][0] = cube[4][0];
        cube[4][0] = cube[3][0];
        cube[3][0] = cube[5][0];
        cube[5][0] = temp;
    }

    static void moveD() {
        rotateFaceClockwise(1);
        char[] temp = cube[2][2].clone();
        cube[2][2] = cube[5][2];
        cube[5][2] = cube[3][2];
        cube[3][2] = cube[4][2];
        cube[4][2] = temp;
    }

    static void moveR() {
        rotateFaceClockwise(5);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][2];
            cube[0][i][2] = cube[2][i][2];
            cube[2][i][2] = cube[1][i][2];
            cube[1][i][2] = cube[3][2 - i][0];
            cube[3][2 - i][0] = temp;
        }
    }

    static void moveL() {
        rotateFaceClockwise(4);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][0];
            cube[0][i][0] = cube[3][2 - i][2];
            cube[3][2 - i][2] = cube[1][i][0];
            cube[1][i][0] = cube[2][i][0];
            cube[2][i][0] = temp;
        }
    }

    static void moveF() {
        rotateFaceClockwise(2);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][2][i];
            cube[0][2][i] = cube[4][2 - i][2];
            cube[4][2 - i][2] = cube[1][0][2 - i];
            cube[1][0][2 - i] = cube[5][i][0];
            cube[5][i][0] = temp;
        }
    }

    static void moveB() {
        rotateFaceClockwise(3);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][0][i];
            cube[0][0][i] = cube[5][i][2];
            cube[5][i][2] = cube[1][2][2 - i];
            cube[1][2][2 - i] = cube[4][2 - i][0];
            cube[4][2 - i][0] = temp;
        }
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        ArrayList<String> stack = new ArrayList<>();

        boolean play = true;

        int argsCount = args.length;
        int argsCurrent = 0;

        boolean display = false;

        while(play){
            String move;

            if(argsCount > argsCurrent){
                move = args[argsCurrent];
                argsCurrent++;
            }else{
                display = true;
                move = scn.nextLine();
            }

            switch (move.toUpperCase()) {
                case "U":
                    moveU();
                    stack.add("U'");
                    break;
                case "U'":
                    moveU();
                    moveU();
                    moveU();
                    stack.add("U");
                    break;
                case "D":
                    moveD();
                    stack.add("D'");
                    break;
                case "D'":
                    moveD();
                    moveD();
                    moveD();
                    stack.add("D");
                    break;
                case "L":
                    moveL();
                    stack.add("L'");
                    break;
                case "L'":
                    moveL();
                    moveL();
                    moveL();
                    stack.add("L");
                    break;
                case "R":
                    moveR();
                    stack.add("R'");
                    break;
                case "R'":
                    moveR();
                    moveR();
                    moveR();
                    stack.add("R");
                    break;
                case "F":
                    moveF();
                    stack.add("F'");
                    break;
                case "F'":
                    moveF();
                    moveF();
                    moveF();
                    stack.add("F");
                    break;
                case "B":
                    moveB();
                    stack.add("B'");
                    break;               
                case "B'":
                    moveB();
                    moveB();
                    moveB();
                    stack.add("B");
                    break;
                case "S":
                    solve(stack);
                    break;
                case "Q":
                    play = false;
                    break;
                default:
                    System.out.println("Bad! Very Bad!!");
                    break;
            }

            if(display) printCube();
        }

        scn.close();

    }
}
