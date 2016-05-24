package com;
import java.util.Scanner;

/**
 * Created by swir2476 on 5/17/2016.
 */
public class diceGame
{
    public static void main(String[] args)
    {
        int intPlayer = 1, intTurnScore, intGameScore, intDie1, intDie2;
        final int WINSCORE = 100, COMPUTERSCORELIMIT = 20;
        String str11 = "Both of your die rolled a one, you lose all the points.";
        String str1x = "One of your die rolled a one, you lose all the points this turn.";
        String strxx = "Your turn ended with a turn score of ";

        die[]Die = new die[2];
        player[]Player = new player[2];

        Scanner in = new Scanner(System.in);

        for(int intCount = 0; intCount < 2; intCount++)//Creates the players
        {
            Die[intCount] = new die();
            Player[intCount] = new player();
        }

        printRules();
        
        while(Player[0].getIntGameScore() != WINSCORE || Player[1].getIntGameScore() != WINSCORE)
        {
            if(intPlayer == 1)//User
            {
                intGameScore = Player[1].getIntGameScore();
                System.out.println("COMs current game score is " + intGameScore);
                intGameScore = Player[0].getIntGameScore();
                System.out.println("Your current game score is " + intGameScore);

                int intTurn = rollAgain();
                while (intTurn == 1)
                {
                    intDie1 = Die[0].getIntFaceValue();
                    intDie2 = Die[1].getIntFaceValue();
                    System.out.println(intDie1 + " <- Die 1");
                    System.out.println(intDie2 + " <- Die 2");
                    if(intDie1 == 1 && intDie2 == 1)//if both equal 1
                    {
                        System.out.println("double 1    -------    DEBUG");
                        Player[0].setZeroGameScore();
                        Player[0].setZeroTurnScore();
                        intPlayer = endUserTurn(str11,Player[0].getIntTurnScore(), Player[0].getIntGameScore(), Player[0].intPlayer(intPlayer));
                    }else if (intDie1 == 1 || intDie2 == 1)//if only one equals 1
                    {
                        System.out.println("single 1    -------    DEBUG");
                        Player[0].setZeroTurnScore();
                        intPlayer = endUserTurn(str1x,Player[0].getIntTurnScore(), Player[0].getIntGameScore(), Player[0].intPlayer(intPlayer));
                    } else//neither of them equal 1
                    {
                        System.out.println("no 1    -------    DEBUG");
                        intTurnScore = Player[0].AddTurnScore(intDie1, intDie2);
                        System.out.println("Turn score: " + intTurnScore + "   Game: " + intGameScore);
                        intTurn = rollAgain();
                    }
                }//end of while
                intPlayer = endUserTurn(strxx,Player[0].getIntTurnScore(), Player[0].getIntGameScore(), Player[0].intPlayer(intPlayer));
                Player[0].setZeroTurnScore();
            }else if(intPlayer == -1)//Computer
            {
                while(Player[1].getIntTurnScore() < COMPUTERSCORELIMIT)
                {
                    intDie1 = Die[0].getIntFaceValue();
                    intDie2 = Die[1].getIntFaceValue();
                    Player[1].AddTurnScore(intDie1, intDie2);
                }
                System.out.println("The Computer's turn is over.");
                intPlayer = Player[1].intPlayer(intPlayer);
            }
        }
    }//end of main

    public static void printRules()//prints the rules for the game
    {
        System.out.println("Welcome to the DiceGame. It's you against the computer.");
        System.out.println("You play by rolling the dice. The first player to get 100 points wins.");
        System.out.println("However, if you roll one 1 you lose all the points you've accumulated in your turn.");
        System.out.println("If you roll two 1's, you lose all your points. You can turn the dice over at any time.");
        System.out.println("However, if you roll one or two 1's, you lose your turn.");
        System.out.println("I (the computer) play by the same rules, except I'll always turn over the dice when I've rolled 20 or more points in a single turn.");
    }

    public static int endUserTurn(String string, int turnScore, int playerScore, int playerSwitch)//when the user's turn ends
    {
        if(turnScore > 0)
        {
            System.out.println(string + turnScore);
        }
        else
        {
            System.out.println(string);
        }
        System.out.println("Your current game score is " + playerScore);
        printLines();
        return playerSwitch;
    }

    public static int rollAgain()//finds if user wants to roll
    {
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Would your like to roll?");
        System.out.print("Type 1 for yes or 2 for no : ");

        return in.nextInt();
    }

    public static void printLines()//prints lines
    {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
    }
}//end of program
