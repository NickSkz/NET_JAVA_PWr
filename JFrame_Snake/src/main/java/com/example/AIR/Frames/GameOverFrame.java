package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.GameOverPanel;
import com.example.AIR.Panels.Plansza;

import javax.swing.*;
import java.awt.*;

public class GameOverFrame {

    private GameOverFrame()
    {

    }

    public static void startWindow()
    {
        //GAME WINDOW
        JFrames.gameOverFrame = new JFrame("Game Over :(");
        GameOverPanel gameOverPanel = new GameOverPanel();

        JFrames.gameOverFrame.setMinimumSize(new Dimension(Consts.overX, Consts.overY));
        JFrames.gameOverFrame.setBackground(Color.BLUE);
        JFrames.gameOverFrame.setResizable(false);
        JFrames.gameOverFrame.setVisible(false);
        JFrames.gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrames.gameOverFrame.add(gameOverPanel);
    }
}
