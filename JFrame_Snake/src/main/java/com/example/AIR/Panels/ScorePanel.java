package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Frames.ScoreFrame;
import com.example.AIR.UserInfo.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScorePanel extends JPanel
{
    private JLabel scoreLabel;
    private JList<String> scoreList;

    private JButton clearRankingButton;

    public static ArrayList<String> players;

    DBConnect connection;

    public ScorePanel()
    {
        setLayout(null);
        players = new ArrayList<>();
        connection = new DBConnect();

        clearRankingButton = new JButton("Reset The Scoreboard");
        clearRankingButton.setBounds(370, 600, 180, 20);
        clearRankingButton.addActionListener( (e) ->
        {
            connection.clearTable();
            JFrames.scoreFrame.setVisible(false);
            JFrames.scoreFrame.dispose();
        });
        add(clearRankingButton);
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
        scoreLabel.setBounds(160, 0, 400, 70);
        add(scoreLabel);

        connection.selectAllEntries();

        scoreList = new JList<>(players.toArray(new String[0]));
        scoreList.setBounds(50, 100, 500, 500);
        scoreList.setBackground(Color.GRAY);
        scoreList.setForeground(Color.WHITE);
        add(scoreList);
    }

}
