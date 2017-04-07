package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T5_TanksMoveToQuadrant extends JPanel
{
    int tankX = 0;
    int tankY = 0;

    void runTheGame()
    {

        moveToQuadrant("D6");
        moveToQuadrant("A2");
    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * @param \direction can be 1 - up, 2 - right, 3 - down, 4 - left
     */

    void moveToQuadrant(String quadrant) {

        int desiredNumberOfQuadro = (int)quadrant.charAt(1);
        char desiredCharOfQuadro = quadrant.charAt(0);

        while ((int)(getTankQuadrant(tankX,tankY).charAt(1))!=desiredNumberOfQuadro)
        {
            int upOrDown = getTankQuadrant(tankX,tankY).charAt(1) - desiredNumberOfQuadro;
            System.out.println(upOrDown);

            if (upOrDown < 0) {
                slowMove('+', 'Y'); //down
            } else
                slowMove('-', 'Y'); //up
        }

        while ((int)(getTankQuadrant(tankX,tankY).charAt(0))!=desiredCharOfQuadro)
        {
            System.out.println(getTankQuadrant(tankX,tankY).charAt(0)-desiredCharOfQuadro);
            int leftOrRight = getTankQuadrant(tankX,tankY).charAt(0)-desiredCharOfQuadro;

            if (leftOrRight<0)
            {
                slowMove('+', 'X');
            }
            else
                slowMove('-', 'X');
        }

    }

    void move(int direction) {
        if ((direction == 1) && (tankY != 0))
            slowMove('-','Y');
        else if ((direction == 2) && (tankX != 512))
            slowMove('+', 'X');
        else if ((direction == 3) && (tankY != 512))
            slowMove('+', 'Y');
        else if ((direction == 4) && (tankX != 0))
            slowMove('-','X');
        sleep(70);
    }

    void slowMove(char dir, char coordinate) {

        int counter = 0;
        while (counter < 64) {
            repaint();
            if ((dir == '+')&&(coordinate=='X'))
                tankX++;
            else if ((dir == '-')&&(coordinate=='X'))
                tankX--;
            else if  ((dir == '+')&&(coordinate=='Y'))
                tankY++;
            else if  ((dir == '-')&&(coordinate=='Y'))
                tankY--;
            counter++;
            sleep(8);
        }
    }

    String getTankQuadrant(int x, int y)
    {
        char res1 = (char)(((x+64)/64)+64);
        int res2 = (y+64)/64;
        String res = res1+""+res2;

        return res;
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 590;
    final int BF_HEIGHT = 590;

    public static void main(String[] args) throws Exception
    {
        T5_TanksMoveToQuadrant bf = new T5_TanksMoveToQuadrant();
        bf.runTheGame();
    }

    public T5_TanksMoveToQuadrant() throws Exception
    {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (i % 2 == 0)
                {
                    cc = new Color(252, 241, 177);
                }
                else
                {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

}