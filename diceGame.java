import java.util.Scanner;

public class diceGame
{
    public static void main(String[] args)
    {
        int intPlayer = 1, intTurnScore, intGameScore, intDie1, intDie2, intEndScore = 0;
        final int WINSCORE = 100, COMSCORELIMIT = 20;
        String str11 = "Both of your die rolled a one, you lose all the points.";
        String str1x = "One of your die rolled a one, you lose all the points this turn.";
        String strxx = "Your turn ended with a turn score of ";

        die die1 = new die();
        die die2 = new die();
        player playerUser = new player();
        player playerCom = new player();

        printRules();

        while(intEndScore <= WINSCORE)
        {
            if (intPlayer == 1)//User
            {
                intGameScore = playerCom.getIntGameScore();
                System.out.println("Com's current game score is " + intGameScore);
                intGameScore = playerUser.getIntGameScore();
                System.out.println("Your current game score is " + intGameScore);

                char charTurn = rollAgain();
                while (charTurn == 'y')
                {
                    intDie1 = die1.getIntFaceValue();
                    intDie2 = die2.getIntFaceValue();
                    System.out.println(intDie1 + " <- Die 1");
                    System.out.println(intDie2 + " <- Die 2");
                    if(intDie1 == 1 && intDie2 == 1)//if both equal 1
                    {
                        playerUser.setZeroGameScore();
                        playerUser.setZeroTurnScore();
                        charTurn = '~';
                        intPlayer = endUserTurn(str11,playerUser.getIntTurnScore(), playerUser.getIntGameScore(), playerUser.intPlayer(intPlayer));
                    }else if (intDie1 == 1 || intDie2 == 1)//if only one equals 1
                    {
                        playerUser.setZeroTurnScore();
                        charTurn ='~';
                        intPlayer = endUserTurn(str1x,playerUser.getIntTurnScore(), playerUser.getIntGameScore(), playerUser.intPlayer(intPlayer));
                    } else//neither of them equal 1
                    {
                        intTurnScore = playerUser.AddTurnScore(intDie1, intDie2);
                        System.out.println("Turn score: " + intTurnScore + "   Game Score: " + intGameScore);
                        charTurn = rollAgain();
                    }
                }//end of while
                if(charTurn == 'n')
                {
                    intPlayer = endUserTurn(strxx,playerUser.getIntTurnScore(), playerUser.getIntGameScore(), playerUser.intPlayer(intPlayer));
                    playerUser.setZeroTurnScore();
                    intEndScore = playerUser.getIntGameScore();
                }
                if (charTurn != 'y' && charTurn != 'n' && charTurn != '~')
                {
                    System.out.println("You did not type 'y' or 'n'.");
                    charTurn = rollAgain();
                }
            }else if(intPlayer == -1)//Computer
            {
                while(intPlayer == -1)
                {
                    intDie1 = die1.getIntFaceValue();
                    intDie2 = die2.getIntFaceValue();
                    System.out.println(intDie1 + " <- Die 1 - Computer Roll");
                    System.out.println(intDie2 + " <- Die 2 - Computer Roll");
                    if(intDie1 == 1 && intDie2 == 1)//if both equal 1
                    {
                        playerCom.setZeroGameScore();
                        playerCom.setZeroTurnScore();
                        intPlayer = playerCom.intPlayer(intPlayer);
                    }else if (intDie1 == 1 || intDie2 == 1)//if only one equals 1
                    {
                        playerCom.setZeroTurnScore();
                        intPlayer = playerCom.intPlayer(intPlayer);
                    } else//neither of them equal 1
                    {
                        playerCom.AddTurnScore(intDie1, intDie2);
                    }
                    System.out.println("--------------------------------");
                    if(playerCom.getIntTurnScore() >= COMSCORELIMIT)
                    {
                        System.out.println("The Computer's score limit reached.");
                        intEndScore = playerCom.getIntGameScore();
                        playerCom.setZeroTurnScore();
                        intPlayer = playerCom.intPlayer(intPlayer);
                    }
                }//end of while
            }//end of com
        }//end of while
        System.out.println("The game is over!");
        intGameScore = playerCom.getIntGameScore();
        System.out.println("Com's final game score is " + intGameScore);
        intGameScore = playerUser.getIntGameScore();
        System.out.println("Your final game score is " + intGameScore);
        if(playerCom.getIntGameScore() > playerUser.getIntGameScore())
            System.out.println("The computer has won! Better luck next time!");
        else
            System.out.println("You won! Great Job!");

        System.out.println("Would you like to clear the console?");
        clear();
    }//end of main

    private static void printRules()//prints the rules for the game
    {
        System.out.println("Welcome to the DiceGame. It's you against the computer.");
        System.out.println("You play by rolling the dice. The first player to get 100 points wins.");
        System.out.println("However, if you roll one 1 you lose all the points you've accumulated in your turn.");
        System.out.println("If you roll two 1's, you lose all your points. You can turn the dice over at any time.");
        System.out.println("However, if you roll one or two 1's, you lose your turn.");
        System.out.println("I (the computer) play by the same rules, except I'll always turn over the dice when I've rolled 20 or more points in a single turn.");
        System.out.println();
        System.out.println("--------------------------------");
    }

    private static int endUserTurn(String string, int turnScore, int playerScore, int playerSwitch)//when the user's turn ends
    {
        if(turnScore > 0)
            System.out.println(string + turnScore);
        else
            System.out.println(string);
        System.out.println("Your current game score is " + playerScore);
        printLines();
        return playerSwitch;
    }

    private static char rollAgain()//finds if user wants to roll
    {
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Would your like to roll?");
        System.out.print("Type 'y' for yes or 'n' for no : ");

        return in.next().charAt(0);
    }

    private static void printLines()//prints lines
    {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
    }

    private static void clear()//clears the console
    {
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("The game has ended would you like to clear the console?");
        System.out.print("Type 'y' for yes or 'n' for no : ");

        char charClear = in.next().charAt(0);

        if (charClear == 'y')
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static void startGame()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Would you like to start the game?");
        System.out.print("Type anything to begin : ");

        char charClear = in.next().charAt(0);
    }
}//end of program
