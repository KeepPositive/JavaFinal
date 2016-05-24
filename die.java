package com;
import java.util.Random;

/**
 * Created by swir2476 on 5/17/2016.
 */
public class die
{
    private static int intFaceValue;
    final private static int MAX = 6;
    static Random ranDie = new Random();

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
