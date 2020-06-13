package com.example.AIR;

import com.example.AIR.Frames.*;
import com.example.AIR.Panels.ChampionSelectPanel;

public  class Main {

    public static void main(String[] args)
    {
        initializeFrames();
    }


    private static void initializeFrames()
    {
        StartFrame.startWindow();
        AboutFrame.startWindow();
        ChampionSelectFrame.startWindow();
        GameOverFrame.startWindow();
    }


}
