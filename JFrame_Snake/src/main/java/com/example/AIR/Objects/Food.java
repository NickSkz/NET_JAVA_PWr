package com.example.AIR.Objects;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Food {

    public ImageIcon foodGraphix;


    private Random random = new Random();
    public int possIdx;


    public Food(String fileName)
    {
        this.foodGraphix = new ImageIcon(fileName);
        possIdx = random.nextInt(8);
    }

    public ArrayList<Point> foodPosition = new ArrayList<>(Arrays.asList(
            new Point(48 ,64), new Point(144 ,128), new Point(176 ,160), new Point(240 ,224),
            new Point(272 ,256), new Point(336 ,320), new Point(400 ,384), new Point(464 ,448)
    ));

    public int getNextPos(){
        possIdx = random.nextInt(8);
        return possIdx;
    }
}
