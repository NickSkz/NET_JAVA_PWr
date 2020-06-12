package com.example.AIR;

import com.example.AIR.Frames.MainFrame;
import com.example.AIR.Frames.ScoreFrame;
import com.example.AIR.Frames.StartFrame;

public  class Main {

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
