package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.AboutPanel;
import com.example.AIR.Panels.GameOverPanel;

import javax.swing.*;
import java.awt.*;

public class AboutFrame {

    private AboutFrame()
    {

    }

    public static void startWindow()
    {
        JFrames.aboutFrame = new JFrame("About us");
        AboutPanel aboutPanel = new AboutPanel();

        JFrames.aboutFrame .setMinimumSize(new Dimension(Consts.aboutX, Consts.aboutY));
        JFrames.aboutFrame .setBackground(Color.BLACK);
        JFrames.aboutFrame .setResizable(false);
        JFrames.aboutFrame .setVisible(false);
        JFrames.aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrames.aboutFrame .add(aboutPanel);
    }
}
