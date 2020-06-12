package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.Plansza;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    private MainFrame()
    {

    }

    public static void startWindow()
    {
        //GAME WINDOW
        JFrames.gameFrame = new JFrame("Snake");
        Plansza plansza = new Plansza();

        JFrames.gameFrame.setMinimumSize(new Dimension(Consts.mainX, Consts.mainY + 35));
        JFrames.gameFrame.setBackground(Color.BLUE);
        JFrames.gameFrame.setResizable(false);
        JFrames.gameFrame.setVisible(false);
        JFrames.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrames.gameFrame.add(plansza);
    }
}
