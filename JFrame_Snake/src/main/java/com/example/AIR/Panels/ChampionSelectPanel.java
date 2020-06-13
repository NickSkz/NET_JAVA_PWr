package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChampionSelectPanel extends JPanel {

    JButton firstButton;
    JButton secondButton;
    JButton thirdButton;

    JLabel firstLabel;
    JLabel secondLabel;
    JLabel thirdLabel;

    JLabel titleLabel;

    public static String headName;

    public ChampionSelectPanel()
    {
        setLayout(null);

        titleLabel = new JLabel("CHOOSE YOUR CHAMP!");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 42));
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setBounds(35, 10, 500, 70);
        add(titleLabel);



        firstButton = new JButton("Johnny!");
        firstButton.setBounds(30, 330, 140, 40);
        firstButton.addActionListener( (e) ->
        {
            headName = "res/head_johnny.png";

            JFrames.startFrame.setVisible(false);

            JFrames.championSelectFrame.setVisible(false);
            JFrames.championSelectFrame.dispose();

            MainFrame.startWindow();
            JFrames.gameFrame.setVisible(true);
        });
        add(firstButton);

        secondButton = new JButton("Jaro!");
        secondButton.setBounds(200, 330, 140, 40);
        secondButton.addActionListener( (e) ->
        {
            headName = "res/head_jaro.png";

            JFrames.startFrame.setVisible(false);

            JFrames.championSelectFrame.setVisible(false);
            JFrames.championSelectFrame.dispose();

            MainFrame.startWindow();
            JFrames.gameFrame.setVisible(true);
        });
        add(secondButton);


        thirdButton = new JButton("Andrzej!");
        thirdButton.setBounds(370, 330, 140, 40);
        thirdButton.addActionListener( (e) ->
        {
            headName = "res/head_andrzej.png";

            JFrames.startFrame.setVisible(false);

            JFrames.championSelectFrame.setVisible(false);
            JFrames.championSelectFrame.dispose();

            MainFrame.startWindow();
            JFrames.gameFrame.setVisible(true);
        });
        add(thirdButton);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Consts.championX, Consts.championY);

        paintFirstChamp();
        paintSecondChamp();
        paintThirdChamp();


    }


    private void paintFirstChamp()
    {
        ImageIcon headIcon = new ImageIcon("res/champ_johnny.jpg");
        Image imgHead = headIcon.getImage();
        Image scaledImgHead = imgHead.getScaledInstance(140, 200, Image.SCALE_SMOOTH);
        ImageIcon trueImage = new ImageIcon(scaledImgHead);

        firstLabel = new JLabel();
        firstLabel.setBounds(30, 100, 150, 200);
        firstLabel.setIcon(trueImage);
        add(firstLabel);
    }

    private void paintSecondChamp()
    {
        ImageIcon headIcon = new ImageIcon("res/champ_jaro.png");
        Image imgHead = headIcon.getImage();
        Image scaledImgHead = imgHead.getScaledInstance(140, 200, Image.SCALE_SMOOTH);
        ImageIcon trueImage = new ImageIcon(scaledImgHead);

        secondLabel = new JLabel();
        secondLabel.setBounds(200, 100, 150, 200);
        secondLabel.setIcon(trueImage);
        add(secondLabel);
    }

    private void paintThirdChamp()
    {
        ImageIcon headIcon = new ImageIcon("res/champ_andrzej.jpg");
        Image imgHead = headIcon.getImage();
        Image scaledImgHead = imgHead.getScaledInstance(140, 200, Image.SCALE_SMOOTH);
        ImageIcon trueImage = new ImageIcon(scaledImgHead);

        thirdLabel = new JLabel();
        thirdLabel.setBounds(370, 100, 150, 200);
        thirdLabel.setIcon(trueImage);
        add(thirdLabel);
    }
}
