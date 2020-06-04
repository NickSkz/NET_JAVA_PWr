package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Plansza extends JPanel {

    private JLabel pointsLabel;
    private JLabel timeLabel;
    private Snake snake= new Snake();
    private JButton head;
    private JButton body;

    private JButton menuButton;

    public Plansza()
    {
        setLayout(null);
    }

    public void drawSnake(Graphics g){
        String str=Integer.toString(snake.wypisz_cokolwiek());
        pointsLabel.setText(str);
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Consts.mainX, Consts.mainY);
        g.setColor(Color.GRAY);
        g.fillRect(Consts.LeftWall,Consts.TopWall,Consts.RightWall-Consts.LeftWall, Consts.BottomWall-Consts.TopWall);

        pointsLabel = new JLabel("Points: ");
        pointsLabel.setFont(new Font("Serif", Font.PLAIN, 32));
        pointsLabel.setForeground(Color.WHITE);
        pointsLabel.setBounds(0, 0, 200, 40);
        add(pointsLabel);


        timeLabel = new JLabel("Time: ");
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 32));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(Consts.mainX - 150, 0, 100, 40);
        add(timeLabel);

        menuButton = new JButton("Menu");
        menuButton.setBounds(Consts.mainX - 115, Consts.mainY - 40, 100, 40);
        menuButton.addActionListener((e) -> {
            //JFrames.gameFrame.setVisible(false);
            //JFrames.startFrame.setVisible(true);
            drawSnake(g);
        });
        add(menuButton);



    }

}
