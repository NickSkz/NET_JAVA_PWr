package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.ScorePanel;
import com.example.AIR.Panels.StartPanel;

import javax.swing.*;
import java.awt.*;

public class ScoreFrame
{
    static ScorePanel scorePanel;

    private ScoreFrame()
    {

    }

    public static void startWindow()
    {
        //START WINDOW
        JFrames.scoreFrame = new JFrame("Snake");
        scorePanel = new ScorePanel();

        JFrames.scoreFrame.setMinimumSize(new Dimension(Consts.scoreX, Consts.scoreY));
        JFrames.scoreFrame.setResizable(false);
        JFrames.scoreFrame.setVisible(false);
        JFrames.scoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrames.scoreFrame.add(scorePanel);
    }
}
