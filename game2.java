package project;
import java.util.*;
public class game2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Lego Set game competition!");
        String[] setNames = new String[3];
        int[] setPieces = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the name of Lego Set " + (i + 1) + ": ");
            setNames[i] = input.nextLine();
            System.out.print("Enter the number of pieces in Lego set " + (i + 1) + ": ");
            setPieces[i] = Integer.parseInt(input.nextLine());
        }

        int player1PiecesBuilt = 0;
        int player2PiecesBuilt = 0;
        int player1CompletedSets = 0;
        int player2CompletedSets = 0;
        int round = 0;
        boolean tiebreaker = false;

        while (true) {
            if (tiebreaker) {
                System.out.println("Tiebreaker round!");
                int i=1;
                while(i>0){
                    System.out.print("Enter the number of pieces Player 1 in Lego set used for building on day "+i);
                    int piecesBuilt1 = Integer.parseInt(input.nextLine());
                    player1PiecesBuilt += piecesBuilt1;
                    if (player1PiecesBuilt >= setPieces[i]) {
                        player1CompletedSets++;
                        player1PiecesBuilt -= setPieces[i];
                    }

                    System.out.print("Enter the number of pieces Player 2 in Lego set used for building on day "+i);
                    int piecesBuilt2 = Integer.parseInt(input.nextLine());
                    player2PiecesBuilt += piecesBuilt2;
                    if (player2PiecesBuilt >= setPieces[i]) {
                        player2CompletedSets++;
                        player2PiecesBuilt -= setPieces[i];
                    }

                    if (player1CompletedSets == 3 && player2CompletedSets == 3) {
                        System.out.println("The competition ended in a tie! There will be a tiebreaker round.");
                        tiebreaker = true;
                    } else if (player1CompletedSets == 3) {
                        System.out.println("Player 1 wins the competition!");
                        break;
                    } else if (player2CompletedSets == 3) {
                        System.out.println("Player 2 wins the competition!");
                        break;
                    }
                    
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter the number of pieces Player 1 in Lego set used for building on day "+i+1);
                    int piecesBuilt1 = Integer.parseInt(input.nextLine());
                    player1PiecesBuilt += piecesBuilt1;
                    if (player1PiecesBuilt >= setPieces[i]) {
                        player1CompletedSets++;
                        player1PiecesBuilt -= setPieces[i];
                    }

                    System.out.print("Enter the number of pieces Player 2 in Lego set used for building on day "+i+1);
                    int piecesBuilt2 = Integer.parseInt(input.nextLine());
                    player2PiecesBuilt += piecesBuilt2;
                    if (player2PiecesBuilt >= setPieces[i]) {
                        player2CompletedSets++;
                        player2PiecesBuilt -= setPieces[i];
                    }

                    if (player1CompletedSets == 3 && player2CompletedSets == 3) {
                        System.out.println("The competition ended in a tie! There will be a tiebreaker round.");
                        tiebreaker = true;
                    } else if (player1CompletedSets == 3) {
                        System.out.println("Congratulation to Player 1 for  winning the Lego Set competition!");
                        break;
                    } else if (player2CompletedSets == 3) {
                        System.out.println("Congratulation to Player 2 for  winning the Lego Set competition!");
                        break;
                    }
                }
            }

            if (!tiebreaker) {
                break;
            }
        }

        game1 player1Log = new game1(1, player1CompletedSets == 3 ? "None" : getCompletedSets(setNames, player1CompletedSets), player1CompletedSets == 3 ? "None" : getIncompleteSets(setNames, player1CompletedSets), player1PiecesBuilt);
        game1 player2Log = new game1(2, player2CompletedSets == 3 ? "None" : getCompletedSets(setNames, player2CompletedSets), player2CompletedSets == 3 ? "None" : getIncompleteSets(setNames, player2CompletedSets), player2PiecesBuilt);

        System.out.println("\nPlayer 1 Results:\n" + player1Log);
        System.out.println("Player 2 Results:\n" + player2Log);

        int totalRounds = tiebreaker ? round : round - 1;
        System.out.println("Total competition duration: " + totalRounds + " days");
    }

    private static String getCompletedSets(String[] setNames, int completedSets) {
        StringBuilder completed = new StringBuilder();
        for (int i = 0; i < completedSets; i++) {
            completed.append(setNames[i]);
            if (i < completedSets - 1) {
                completed.append(", ");
            }
        }
        return completed.toString();
    }

    private static String getIncompleteSets(String[] setNames, int completedSets) {
        StringBuilder incomplete = new StringBuilder();
        for (int i = completedSets; i < 3; i++) {
            incomplete.append(setNames[i]);
            if (i < 2) {
                incomplete.append(", ");
            }
        }
        return incomplete.toString();
    }
}
