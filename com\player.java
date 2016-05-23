package com;

/**
 * Created by swir2476 on 5/17/2016.
 */
public class player
{
    private int intGameScore, intTurnScore;

    public player()
    {
        intGameScore = 0;
        intTurnScore = 0;
    }

    public int getIntGameScore()
    {
        intGameScore = intGameScore + intTurnScore;
        return intGameScore;
    }

    public int getIntTurnScore()
    {
        return  intTurnScore;
    }

    public int intPlayer(int player)
    {
        player = player * -1;
        return player;
    }

    public void AddTurnScore(int die1, int die2)
    {
        intTurnScore = intTurnScore + die1 + die2;
    }

    public void setZeroGameScore()
    {
        intTurnScore = 0;
        intGameScore = 0;
    }

    public void setZeroTurnScore()
    {
        intTurnScore = 0;
    }
}
