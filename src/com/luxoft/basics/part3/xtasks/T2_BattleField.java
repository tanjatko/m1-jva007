package com.luxoft.basics.part3.xtasks;

import java.util.Arrays;

public class T2_BattleField
{

    String[][] battleField = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", "B", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "B", "B", "B", " ", " ", " "},
            {"B", " ", "B", " ", "B", " ", " ", " ", " "},
            {"B", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", " ", " ", "B", "B", "B", " ", " ", "B"},
            {" ", " ", "T", "B", "E", "B", " ", " ", " "}
    };

    void runTheGame() throws Exception
    {
        printCurrentBattleField();
    }

    /**
     * Should print battle field to console output.
     */
    private void printCurrentBattleField()
    {
        for (int i = 0; i < battleField.length; i++)
        {
            System.out.println(Arrays.deepToString(battleField[i]));
        }
    }


    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception
    {
        T2_BattleField bf = new T2_BattleField();
        bf.runTheGame();
    }

    public T2_BattleField() throws Exception
    {
    }
}