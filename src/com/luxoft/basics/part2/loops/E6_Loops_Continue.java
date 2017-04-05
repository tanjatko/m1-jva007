package com.luxoft.basics.part2.loops;

public class E6_Loops_Continue
{
    public static void main(String[] args)
    {
        int counter = 0;
        int totalCycles = 10;

        while (counter < totalCycles)
        {
            if (counter % 3 == 0)
            {
                counter++;
                continue;
            }

            System.out.println(counter++);
        }
    }
}
