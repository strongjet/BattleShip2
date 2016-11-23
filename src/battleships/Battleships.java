package battleships;

import java.util.Scanner;

/**
 *
 * @author Radwane
 */
public class Battleships {

    final int BOARDSIZE = 10;
    int[][] board = new int[BOARDSIZE][BOARDSIZE];
    String SecondPlayer = "";
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Battleships method = new Battleships();
        System.out.print("\t---------------Welcome to the game BattleShips (v0.2)---------------"
                + "\n ________________" + "\n| ___________   |" + "\t\t\t\t\t\t      /:\"\"|" + "\n| |           | |"
                + "\t\t\t\t\t\t     |: 66|" + "\n| |   0   0   | |" + "\t\t____   _____________" + "\t\t     C     _) "
                + "\n| |     -     | |" + "\t\t\\   \\ /   /   _____/" + "\t\t      \\ ._|" + "\n| |   \\___/   | |"
                + "\t\t \\   Y   /\\_____  \\ " + "\t\t       ) /" + "\n| |___     ___| |" + "\t\t  \\     / /        \\"
                + "\t\t      /`\\\\" + "\n|_____|\\_/|_____|" + "\t\t   \\\\___/ /_______  /" + "\t\t     || |Y|" + "\n  _|__|/ \\|_|_   "
                + "\t\t                 \\/ " + "\t\t     || |#|" + "\n / ********** \\  " + "\t\t\t\t\t\t     || |#|" + "\n/  ************\\"
                + "\t\t\t\t\t\t     || |#|" + "\n------------------");

        method.SecondPlayer();
        method.PrintBoard();
        System.out.println("\nYou will begin with 5 Ships: \n\n1. Carrier, Size: 5"
                + " \n2. Battleship, Size: 4 \n3. Cruiser, Size: 3\n4. Submarine, Size 3 \n5. Destroyer, Size: 2\n");
        method.initialiseBoard();
    }

    public void initialiseBoard() {
        String coordinates;
        String[] Ships = new String[]{"Carrier:6", "Battleship:4", "Cruiser:3", "Submarine:3", "Destroyer:2"};
        for (int i = 0; i < Ships.length; i++) {
            System.out.println("Where would you like to place your " + Ships[i].split(":", 2)[0] + " of size "
                    + Ships[i].split(":", 2)[1] + "\nType in format xy for example a1: ");
            String Sx;
            String Sy;
            do {
                coordinates = input.next().toLowerCase();
                Sx = String.valueOf(coordinates.charAt(0));
                Sy = coordinates.substring(1);
                System.out.println("You have entered an invalid coordinate please-retype a valid input such as a1 or A1: ");
            } while (checkMoveIsLegal(Sx,Sy, coordinates) == false);
            
            //x = (int) (coordinates.charAt(0)) - 96;
            //y = Integer.parseInt(coordinates.substring(1));
        }
        
    }

    public boolean checkMoveIsLegal(String x, String y, String coordinates) {
        return (((coordinates.length() == 2 || coordinates.length() == 3 )) 
            && (y.matches("[1-9]")||y.contains("10"))&& x.contains ("[a-j]"));
    }

    public void PrintBoard() {
        System.out.println("\n \tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ ");
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + "");
            for (int column = 0; column < board.length; column++) {
                switch (board[row][column]) {
                    case -1:
                        System.out.print("\t" + "[XX]");
                        break;
                    case 0:
                        System.out.print("\t" + "[  ]");
                        break;
                    case 1:
                        System.out.print("\t" + "[Ca]");
                        break;
                    case 2:
                        System.out.print("\t" + "[Bs]");
                        break;
                    case 3:
                        System.out.print("\t" + "[Cr]");
                        break;
                    case 4:
                        System.out.print("\t" + "[Sm]");
                        break;
                    case 5:
                        System.out.print("\t" + "[Ds]");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }

    public void SecondPlayer() {
        do {
            System.out.print("\n\n\t Would you like to play against (c)omputer or (h)uman? (Please enter either c or h): ");
            SecondPlayer = input.next().toLowerCase();
        } while (!SecondPlayer.contains("c") && !SecondPlayer.contains("h"));
        if (SecondPlayer.equals("h")) {
            System.out.println("Player 1 Starts!\n");
        } else {
            computerInitialise();
        }
    }

    public void computerInitialise() {
        System.out.println("To be created!");
    }
}
