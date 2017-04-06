package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T4_TanksMoveRandom extends JPanel
{
    int tankX = 0;
    int tankY = 0;

    void runTheGame()
    {
        while (true)
        {
            randomMove();
        }
    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * @param \direction can be 1 - up, 2 - right, 3 - down, 4 - right
     */

    void randomMove()
    {
        long timeMilisec = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis());
        System.out.println((timeMilisec-((timeMilisec/100)*100)));
        int a1 =(int)(((timeMilisec-((timeMilisec/100)*100))/10));
        int a2 = (int)(((timeMilisec-((timeMilisec/100)*100))%10));

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1+a2);
        int randomNum=((a1+a2)/10)+((a1+a2)%10);

        if (randomNum<=4)
        {
            move(randomNum);
            System.out.println("<4: "+ randomNum);
        }
        else
        {
            randomNum = randomNum/2;
            move(randomNum);
            System.out.println(">4/2:  "+ randomNum);
        }


//        System.out.println((new Random().nextInt(4)+1));
//        move((new Random().nextInt(4)+1));
    }

    void move(int direction) {
        if ((direction == 1) && (tankY != 0)) {
            slowMove('-','Y');
        }
        else if ((direction == 2) && (tankX != 512)) {
            slowMove('+', 'X');
        }
        else if ((direction == 3) && (tankY != 512)) {
            slowMove('+', 'Y');
        }
        else if ((direction == 4) && (tankX != 0)) {

            slowMove('-','X');
        }
        sleep(70);
    }

    void slowMove(char dir, char coordinate) {

        int counter = 0;
        while (counter < 64) {
            repaint();
            if ((dir == '+')&&(coordinate=='X'))
            {
                tankX++;
            }
            else if ((dir == '-')&&(coordinate=='X'))
            {
                tankX--;
            }
            else if  ((dir == '+')&&(coordinate=='Y'))
            {
                tankY++;
            }
            else if  ((dir == '-')&&(coordinate=='Y'))
            {
                tankY--;
            }
            counter++;
            sleep(8);
        }
    }


    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 590;
    final int BF_HEIGHT = 590;

    public static void main(String[] args) throws Exception
    {
        T4_TanksMoveRandom bf = new T4_TanksMoveRandom();
        bf.runTheGame();
    }

    public T4_TanksMoveRandom() throws Exception
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