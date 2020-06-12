package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel
{
    private JLabel scoreLabel;

    private JList<String> scoreList;

    public ScorePanel()
    {
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Consts.scoreX, Consts.scoreY);

        scoreLabel = new JLabel("SCOREBOARD");
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 42));
        scoreLabel.setForeground(Color.GREEN);
        scoreLabel.setBounds(40, 0, 400, 70);
        add(scoreLabel);


        String[] players = {
                "Marian Paździoch: 42 points",
                "Mieczysław Putin: 39 points",
                "Jarosław Kaczyński: 35 points",
                "Johnny Sins: 24 points",
                "Mike Tyson: 20 points"
        };
        scoreList = new JList<>(players);
        scoreList.setBounds(100, 100, 200, 500);
        scoreList.setBackground(Color.GRAY);
        scoreList.setForeground(Color.WHITE);
        add(scoreList);
    }
}
