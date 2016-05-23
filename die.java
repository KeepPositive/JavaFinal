package com;
import java.util.Random;

/**
 * Created by swir2476 on 5/17/2016.
 */
public class die
{
    private int intFaceValue;
    final private int MAX = 6;
    Random ranDie = new Random();

    public die()
    {
        intFaceValue = 0;
    }

    public void roll()
    {
        intFaceValue = ranDie.nextInt(MAX) + 1;
    }

    public int getIntFaceValue()
    {
        roll();
        return intFaceValue;
    }
}
