package com.example.AIR;

import com.example.AIR.Frames.*;

public  class Main {

    public static void main(String[] args)
    {
        initializeFrames();
    }


    private static void initializeFrames()
    {
        StartFrame.startWindow();
        MainFrame.startWindow();
        AboutFrame.startWindow();
        GameOverFrame.startWindow();
    }


}
