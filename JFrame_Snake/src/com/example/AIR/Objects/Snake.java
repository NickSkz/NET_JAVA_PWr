package com.example.AIR.Objects;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.Plansza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake{

    public enum Direction
    {
        TOP, BOTTOM, LEFT, RIGHT, NONE
    };

    public ImageIcon head;
    public ImageIcon body;

    public Direction direction = Direction.NONE;

    public int snakeLength = 2;
    private ArrayList<Point> startPos = new ArrayList<>(Arrays.asList(
            new Point(32 + Consts.LeftWall, 0 + Consts.TopWall), new Point(0 + Consts.LeftWall, 0 + Consts.TopWall)
    ));


    public ArrayList<Point> snakePos = new ArrayList<>();


    public Snake(String headFileName, String bodyFileName)
    {
        head = new ImageIcon(headFileName);
        body = new ImageIcon(bodyFileName);

        for(int i = 0; i < snakeLength; ++i)
        {
            snakePos.add(startPos.get(i));
        }
    }

}
