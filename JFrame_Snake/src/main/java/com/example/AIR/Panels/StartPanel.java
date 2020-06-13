package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Frames.ScoreFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel
{
    private int buttonsBeginOffset = 280;
    private int playButtonPos = 0;
    private int scoreboardButtonPos = 1;
    private int aboutButtonPos = 2;
    private int exitButtonPos = 3;

    private JButton playButton;
    private JButton scoreboardButton;
    private JButton aboutButton;
    private JButton exitButton;

    private JLabel titleLabel;
    private JLabel imageLabel;

    private ImageIcon headIcon;

    public StartPanel()
    {
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Consts.beginX, Consts.beginY);

        try{
            getHead();
        }catch (Exception e){
            e.printStackTrace();
        }

        getButtons();
    }

    public void getButtons()
    {
        playButton = new JButton("Play!");
        playButton.setBounds(0, buttonsBeginOffset + playButtonPos * 70, Consts.beginX, 70);
        playButton.addActionListener( (e) ->
        {
            JFrames.startFrame.setVisible(false);
            JFrames.gameFrame.setVisible(true);
        });
        add(playButton);


        scoreboardButton = new JButton("Scoreboard");
        scoreboardButton.setBounds(0, buttonsBeginOffset + scoreboardButtonPos * 70, Consts.beginX, 70);
        scoreboardButton.addActionListener( (e) ->
        {
            ScoreFrame.startWindow();
            JFrames.scoreFrame.setVisible(true);
        });
        add(scoreboardButton);


        exitButton = new JButton("Exit");
        exitButton.setBounds(0, buttonsBeginOffset + exitButtonPos * 70, Consts.beginX, 70);
        exitButton.addActionListener( (e) ->
        {
            System.exit(0);
        });
        add(exitButton);


        aboutButton = new JButton("About creators");
        aboutButton.setBounds(0, buttonsBeginOffset + aboutButtonPos * 70, Consts.beginX, 70);
        aboutButton.addActionListener( (e) ->
        {
            JFrames.aboutFrame.setVisible(true);
        });
        add(aboutButton);
    }

    public void getHead() throws IOException {
        titleLabel = new JLabel("SNAKE!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 42));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 0, Consts.beginX, 70);
        add(titleLabel);

        ImageIcon headIcon = new ImageIcon("res/golota.jpg");
        Image imgHead = headIcon.getImage();
        Image sclaedImgHead = imgHead.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon trueImage = new ImageIcon(sclaedImgHead);

        imageLabel = new JLabel();
        imageLabel.setBounds(122, 65, 150, 200);
        imageLabel.setIcon(trueImage);
        add(imageLabel);
    }

}
