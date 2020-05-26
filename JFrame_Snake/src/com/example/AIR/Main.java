package com.example.AIR;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Frames.MainFrame;
import com.example.AIR.Frames.ScoreFrame;
import com.example.AIR.Frames.StartFrame;
import com.example.AIR.Panels.Plansza;
import com.example.AIR.Panels.StartPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        initializeFrames();
    }


    private static void initializeFrames()
    {
        StartFrame.startWindow();
        MainFrame.startWindow();
        ScoreFrame.startWindow();
    }


}
