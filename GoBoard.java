import java.util.Scanner;

public class GoBoard {

    public static void main(String[] args) {
        String[][] GoBoard = new String[9][9];

        boolean player1 = true;

        System.out.println("  0 1 2 3 4 5 6 7 8");
        for (int i = 0; i < GoBoard[0].length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < GoBoard.length; j++) {
                if (GoBoard[i][j] == null) {
                    if (j == 0){
                        System.out.print("|");
                    }
                    else{
                        System.out.print("-|");
                    }

                } else {
                    System.out.print(GoBoard[i][j]);
                }
                Scanner userInput = new Scanner(System.in);

            }
            System.out.println();

        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter x coordinate: ");
        int moveX = myObj.nextInt();
        System.out.println("Enter y coordinate: ");
        int moveY = myObj.nextInt();
        GoBoard[moveY][moveX] = "X";
        
    }
}