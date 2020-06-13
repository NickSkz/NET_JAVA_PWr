package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.GameOverFrame;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.UserInfo.DBConnect;
import com.example.AIR.UserInfo.Stats;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    JLabel gameOverLabel;
    JLabel saveScoreLabel;

    JLabel pointsLabel;
    JLabel zeitLabel;
    JLabel overallLabel;

    JButton tryAgainButton;
    JTextField nickName;

    DBConnect connection;

    public GameOverPanel()
    {
        setLayout(null);
        connection = new DBConnect();

        nickName = new JTextField();
        nickName.setBounds(60, 230, 240, 20);
        add(nickName);

        tryAgainButton = new JButton("TRY AGAIN!");
        tryAgainButton.setBounds(60, 270, 240, 50);
        tryAgainButton.addActionListener((e) ->
        {
            JFrames.gameFrame.setVisible(true);

            if(!nickName.getText().isEmpty())
            {
                System.out.println("DSESSE");
                connection.insertEntry(nickName.getText());
                nickName.setText("");
            }

            pointsLabel.setText("");
            zeitLabel.setText("");
            overallLabel.setText("");

            saveScoreLabel.setText("");
            gameOverLabel.setText("");

            JFrames.gameOverFrame.setVisible(false);
            JFrames.gameOverFrame.dispose();
        });
        add(tryAgainButton);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Consts.scoreX, Consts.scoreY);

        gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setFont(new Font("Serif", Font.PLAIN, 42));
        gameOverLabel.setForeground(Color.GREEN);
        gameOverLabel.setBounds(60, 0, 400, 70);
        add(gameOverLabel);





        pointsLabel = new JLabel("Points: " + String.valueOf(Stats.points));
        pointsLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        pointsLabel.setForeground(Color.RED);
        pointsLabel.setBounds(60, 80, 200, 30);
        add(pointsLabel);


        zeitLabel = new JLabel("Zeit: " + String.valueOf(Stats.zeit));
        zeitLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        zeitLabel.setForeground(Color.RED);
        zeitLabel.setBounds(60, 110, 200, 30);
        add(zeitLabel);


        overallLabel = new JLabel("Overall: " + String.valueOf(Stats.overall));
        overallLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        overallLabel.setForeground(Color.RED);
        overallLabel.setBounds(60, 140, 200, 30);
        add(overallLabel);



        saveScoreLabel = new JLabel("Save Your Score!");
        saveScoreLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        saveScoreLabel.setForeground(Color.CYAN);
        saveScoreLabel.setBounds(60, 170, 400, 70);
        add(saveScoreLabel);


    }

}
