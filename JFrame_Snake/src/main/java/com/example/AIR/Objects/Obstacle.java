package com.example.AIR.Objects;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Obstacle {

    public ImageIcon obstacleGraphix;

    private Random random = new Random();

    public int wieViel;
    public ArrayList<Integer> indexes;

    public Obstacle(String fileName, int howMany)
    {
        this.obstacleGraphix = new ImageIcon(fileName);
        wieViel = howMany;
        indexes = new ArrayList<>(wieViel);


        for(int i = 0; i < wieViel; ++i)
        {
            int idx = random.nextInt(8);

            if(!indexes.contains(idx))
                indexes.add(idx);
            else
                --i;
        }
    }

    public ArrayList<Point> obstaclePos = new ArrayList<>(Arrays.asList(
            new Point(80 ,64), new Point(144 ,160), new Point(208 ,160), new Point(240 ,256),
            new Point(304 ,256), new Point(336 ,352), new Point(432 ,384), new Point(464 ,480)
    ));


}
