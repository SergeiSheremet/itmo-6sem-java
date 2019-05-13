package ru;

public class WorkArray<T extends Number>
{
    private T[] arrNums;

    public WorkArray(T[] numP)
    {
        arrNums = numP;
    }

    public double sum()
    {
        double doubleWork = 0;

        for (var num : arrNums)
        {
            doubleWork += num.doubleValue();
        }

        return doubleWork;
    }
}
