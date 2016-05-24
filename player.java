package com;

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

    public int AddTurnScore(int die1, int die2)
    {
        intTurnScore = intTurnScore + die1 + die2;
        return intTurnScore;
    }

    public void setZeroGameScore()
    {
        intGameScore = 0;
    }

    public void setZeroTurnScore()
    {
        intTurnScore = 0;
    }
}
