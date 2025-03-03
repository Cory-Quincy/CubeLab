import java.util.Arrays;
import java.util.Scanner;

public class App {

    static Scanner scn = new Scanner(System.in);
    static boolean player1 = true;
    static boolean playing = true;

    static String[] whitePieces = {"♖", "♘", "♗", "♕", "♔","♙"};
    static String[] blackPieces = {"♜", "♞", "♝", "♛", "♚","♟︎"};

    static String[][] Board =   {
                                    {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"},
                                    {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"},
                                    {null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null},
                                    {"♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎"},
                                    {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"},
                                };

    static boolean containsValue(String[] array, String value) {
        for (String element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    static int[] GetInput(){
        System.out.println("Please enter x coord:");
        int moveX = scn.nextInt();
        System.out.println("Please enter y coord:");
        int moveY = scn.nextInt();
        int[] temp = {moveX, moveY};

        return temp;
    }

    static void HandleMove(int moveY, int moveX) {
        try{
            System.out.println("The piece is: " + Board[moveY][moveX]);

            switch(Board[moveY][moveX]){
                case "♟︎":

                    int[][] options = new int[4][2];

                    for(int[] option: options)
                        Arrays.fill(option, 10);

                    if(Board[moveY-1][moveX] == null){ //Is the space in front of me clear
                        options[0][0] = moveY-1;
                        options[0][1] = moveX;
                        if(Board[moveY-2][moveX] == null && moveY == 6){ //Is the space two spaces in front of me clear and am I on the first row
                            options[1][0] = moveY-2;
                            options[1][1] = moveX;
                        }
                    }
                    if(containsValue(whitePieces, Board[moveY-1][moveX-1])){ //If a white peice is on the diagonal left
                        options[2][0] = moveY-1;
                        options[2][1] = moveX-1;
                    }
                    if(containsValue(whitePieces, Board[moveY-1][moveX+1])){ //If a white peice is on the diagonal right
                        options[3][0] = moveY-1;
                        options[3][1] = moveX+1;
                    }
                    
                    for(int[] option : options){
                        System.out.println(option[0] + " " + option[1]);
                    }
                    
                    break;

                case "♞":
                    
                    break;

                case "♝":
                    
                    break;

                case "♛":
                    
                    break;

                case "♚":
                    
                    break;

                case "♜":
                    
                    break;

                default:

                    break;
            }

            switch(Board[moveY][moveX]){
                case "♙":
                    
                    break;

                case "♘":
                    
                    break;

                default:

                    break;
            }

            player1 = !player1;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You're selecting a point off the board.");
            GetInput();
        }
    }

    static void printBoard(){
        boolean flipper = true;
        for(int i = 0; i < Board.length; i++){
            for(int j = 0; j < Board[i].length; j++){
                if(Board[i][j] == null){
                    if(flipper){
                        System.out.print("███");
                    }
                    else{
                        System.out.print("   ");
                    }
                }else{
                    if(flipper){
                        System.out.print("█"+Board[i][j]+"█");
                    }
                    else{
                        System.out.print(" "+Board[i][j]+" ");
                    }
                }
                flipper = !flipper;
            }
            flipper = !flipper;
            System.out.println();
        }
    }

    public static void Menu(){
        System.out.print("Welcome to MD Chesss! \n Please enter one of the following options:\n");
        System.out.println("  1: Play with a friend");
        System.out.println("  2: Play against computer");
        System.out.println("  3: Change Dimensions");
        System.out.println("  q: Quit");

        String input = scn.nextLine();

        switch (input) {
            case "1":
                playing = true;
                break;
            case "2":
                System.out.println("This feature is unavailable, find a friend.");
                break;
            case "3":
                System.out.println("Chess is 8x8 get used to it.");
                break;
            case "q":
                playing = false;
                break;
            default:
                System.out.println("Good job reading *sarcasm*.");
                playing = false;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        Menu();
        while(playing){
            printBoard();
            int[] results = GetInput();
            HandleMove(results[0], results[1]);
        }
        scn.close();
    }
}

/*
 * public class App {
    public static void main(String[] args) throws Exception {
        int x = 8;
        int y = 8;

        boolean flipper = true;

        boolean playing = true;

        while(playing){
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(flipper){
                        System.out.print("██");
                    }
                    else{
                        System.out.print("  ");
                    }
                    flipper = !flipper;
                }
                flipper = !flipper;
                System.out.println();
            }
        }
    }
}
 */