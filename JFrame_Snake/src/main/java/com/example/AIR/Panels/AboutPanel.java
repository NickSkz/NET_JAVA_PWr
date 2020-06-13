package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {

    public AboutPanel()
    {
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Consts.aboutX, Consts.aboutY);

        g.setColor(Color.GREEN);
        g.drawString("Creators: Mikołaj, Przemek -> That's all you need to know!", 5, 30);
    }
}
