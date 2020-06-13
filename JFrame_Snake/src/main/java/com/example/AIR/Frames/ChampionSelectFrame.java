package com.example.AIR.Frames;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Panels.AboutPanel;
import com.example.AIR.Panels.ChampionSelectPanel;

import javax.swing.*;
import java.awt.*;

public class ChampionSelectFrame {

    private ChampionSelectFrame()
    {

    }

    public static void startWindow()
    {
        JFrames.championSelectFrame = new JFrame("Select Champion!");
        ChampionSelectPanel championSelectPanel = new ChampionSelectPanel();

        JFrames.championSelectFrame.setMinimumSize(new Dimension(Consts.championX, Consts.championY));
        JFrames.championSelectFrame.setBackground(Color.BLACK);
        JFrames.championSelectFrame.setResizable(false);
        JFrames.championSelectFrame.setVisible(false);
        JFrames.championSelectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrames.championSelectFrame.add(championSelectPanel);
    }
}
