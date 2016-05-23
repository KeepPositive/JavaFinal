package com;
import java.util.Scanner;

/**
 * Created by swir2476 on 5/17/2016.
 */
public class diceGame
{
    public static void main(String[] args)
    {
        int intWinScore = 100, intPlayer = 1, intDie1 = 0, intDie2 = 0, intTurnScore = 0, intGameScore=0;

        die[]Die = new die[2];
        player[]Player = new player[2];

        Scanner in = new Scanner(System.in);

        for(int intCount = 0; intCount < 2; intCount++)
        {
            Die[intCount] = new die();
            Player[intCount] = new player();
        }

        while(Player[0].getIntGameScore() != intWinScore & Player[1].getIntGameScore() != intWinScore)
        {
            if(intPlayer == 1)
            {
                System.out.println("--------------------------------");
                intDie1 = Die[0].getIntFaceValue();
                intDie2 = Die[1].getIntFaceValue();
                System.out.println(intDie1 + " <- Die 1");
                System.out.println(intDie2 + " <- Die 2");
                if(intDie1 == 1 && intDie2 == 1)//if both equal 1
                {
                    Player[0].setZeroGameScore();
                    System.out.println("Both of your die rolled a one, you lose all the points.");
                    intGameScore = Player[0].getIntGameScore();
                    System.out.println("Your current game score is " + intGameScore);
                    intPlayer = Player[0].intPlayer(intPlayer);
                    Player[0].setZeroTurnScore();
                    intGameScore = 0;
                    intTurnScore = 0;
                }else if(intDie1 == 1 || intDie2 == 1)//if only one equals 1
                {
                    Player[0].setZeroTurnScore();
                    System.out.println("One of your die rolled a one, you lose all the points this turn.");
                    intGameScore = Player[0].getIntGameScore();
                    System.out.println("Your current game score is " + intGameScore);
                    intPlayer = Player[0].intPlayer(intPlayer);
                    Player[0].setZeroTurnScore();
                    intGameScore = 0;
                    intTurnScore = 0;
                }else//neither of them equal 1
                {
                    Player[0].AddTurnScore(intDie1, intDie2);
                    intTurnScore = Player[0].getIntTurnScore();
                    System.out.println("Turn score: " + intTurnScore + "   Game: "+intGameScore);
                    System.out.println("--------------------------------");
                    System.out.println("Would your like to roll?");
                    System.out.print("Type 1 for yes or 2 for no : ");
                    int intTurn = in.nextInt();
                    if(intTurn != 1)
                    {
                        System.out.println("You ended your turn with a turn score of " + intTurnScore);
                        intGameScore = Player[0].getIntGameScore();
                        System.out.println("Your current game score is " + intGameScore);
                        intPlayer = Player[0].intPlayer(intPlayer);
                        Player[0].setZeroTurnScore();
                        intGameScore = 0;
                        intTurnScore = 0;
                    }
                }
            }else if(intPlayer == -1)
            {
                System.out.println("Com");
                intPlayer = 1;
            }
        }
    }
}