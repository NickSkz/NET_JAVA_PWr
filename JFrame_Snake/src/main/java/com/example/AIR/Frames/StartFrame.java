package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.StartPanel;

import javax.swing.*;
import java.awt.*;

public class StartFrame
{
    static StartPanel startPanel;

    private StartFrame()
    {

    }

    public static void startWindow()
    {
        //START WINDOW
        JFrames.startFrame = new JFrame("Snake");
        startPanel = new StartPanel();

        JFrames.startFrame.setMinimumSize(new Dimension(Consts.beginX, Consts.beginY));
        JFrames.startFrame.setResizable(false);
        JFrames.startFrame.setVisible(true);
        JFrames.startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrames.startFrame.add(startPanel);

    }
}
