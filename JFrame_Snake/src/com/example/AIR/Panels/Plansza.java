package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Objects.Food;
import com.example.AIR.Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Plansza extends JPanel implements ActionListener, KeyListener {

    private JLabel pointsLabel;
    private JLabel timeLabel;

    private JButton menuButton;

    private Timer timer;

    private Snake snake;
    private Food food;

    public Plansza()
    {
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        food = new Food("res/food.png");
        snake = new Snake("res/head.png", "res/body.png");

        timer = new Timer(100,this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Consts.mainX, Consts.mainY);
        g.setColor(Color.GRAY);
        g.fillRect(Consts.LeftWall, Consts.TopWall, Consts.RightWall, Consts.BottomWall);

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
            setDefault();
            JFrames.gameFrame.setVisible(false);
            JFrames.gameFrame.dispose();
            JFrames.startFrame.setVisible(true);
        });
        add(menuButton);


        snake.head.paintIcon(this, g, snake.snakePos.get(0).X, snake.snakePos.get(0).Y);
        for (int i = 1; i < snake.snakeLength; ++i)
            snake.body.paintIcon(this, g, snake.snakePos.get(i).X, snake.snakePos.get(i).Y);


        checkPoint();
        food.foodGraphix.paintIcon(this, g, food.foodPosition.get(food.possIdx).X, food.foodPosition.get(food.possIdx).Y);

        if (checkCollision())
        {
            try{
                Thread.sleep(3000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            setDefault();
        }


        g.dispose();
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        switch(snake.direction)
        {
            case TOP:

                for(int i = snake.snakeLength - 1; i > 0; --i)
                {
                    snake.snakePos.get(i).Y = snake.snakePos.get(i-1).Y;
                    snake.snakePos.get(i).X = snake.snakePos.get(i-1).X;

                    if(snake.snakePos.get(i).Y < 0 + Consts.TopWall)
                        snake.snakePos.get(i).Y = 512 + Consts.TopWall;
                }

                snake.snakePos.get(0).Y = snake.snakePos.get(0).Y - 32;
                if(snake.snakePos.get(0).Y < 0 + Consts.TopWall)
                    snake.snakePos.get(0).Y = 512 + Consts.TopWall;

                repaint();

                break;




            case LEFT:

                for(int i = snake.snakeLength - 1; i > 0; --i)
                {
                    snake.snakePos.get(i).X = snake.snakePos.get(i-1).X;
                    snake.snakePos.get(i).Y = snake.snakePos.get(i-1).Y;

                    if(snake.snakePos.get(i).X  < Consts.LeftWall)
                        snake.snakePos.get(i).X  = 512 + Consts.LeftWall;

                }

                snake.snakePos.get(0).X = snake.snakePos.get(0).X - 32;
                if(snake.snakePos.get(0).X  < Consts.LeftWall)
                    snake.snakePos.get(0).X  = 512 + Consts.LeftWall;

                repaint();

                break;




            case BOTTOM:

                for(int i = snake.snakeLength - 1; i > 0; --i)
                {
                    snake.snakePos.get(i).X = snake.snakePos.get(i-1).X;
                    snake.snakePos.get(i).Y = snake.snakePos.get(i-1).Y;

                    if(snake.snakePos.get(i).Y > 512 + Consts.TopWall)
                        snake.snakePos.get(i).Y = 0 + Consts.TopWall;
                }

                snake.snakePos.get(0).Y = snake.snakePos.get(0).Y + 32;
                if(snake.snakePos.get(0).Y > 512 + Consts.TopWall)
                    snake.snakePos.get(0).Y = 0 + Consts.TopWall;

                repaint();

                break;




            case RIGHT:

                for(int i = snake.snakeLength - 1; i > 0; --i)
                {
                    snake.snakePos.get(i).X = snake.snakePos.get(i-1).X;
                    snake.snakePos.get(i).Y = snake.snakePos.get(i-1).Y;

                    if(snake.snakePos.get(i).X > 512 + Consts.LeftWall)
                        snake.snakePos.get(i).X = 0 + Consts.LeftWall;
                }

                snake.snakePos.get(0).X = snake.snakePos.get(0).X + 32;
                if(snake.snakePos.get(0).X > 512 + Consts.LeftWall)
                    snake.snakePos.get(0).X = 0 + Consts.LeftWall;

                repaint();

                break;




            default:
                break;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && snake.direction != Snake.Direction.LEFT)
            snake.direction = Snake.Direction.RIGHT;

        if(e.getKeyCode() == KeyEvent.VK_LEFT && snake.direction != Snake.Direction.RIGHT)
            snake.direction = Snake.Direction.LEFT;

        if(e.getKeyCode() == KeyEvent.VK_UP && snake.direction != Snake.Direction.BOTTOM)
            snake.direction = Snake.Direction.TOP;

        if(e.getKeyCode() == KeyEvent.VK_DOWN && snake.direction != Snake.Direction.TOP)
            snake.direction = Snake.Direction.BOTTOM;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private boolean checkPoint(){
        if(snake.snakePos.get(0).equals(food.foodPosition.get(food.possIdx)))
        {
            ++snake.snakeLength;
            snake.snakePos.add(new com.example.AIR.Objects.Point(0, 0));
            food.possIdx = food.getNextPos();

            return true;
        }

        return false;
    }

    private boolean checkCollision(){
        for(int i = 1; i < snake.snakeLength; ++i)
        {
            if(snake.snakePos.get(0).equals(snake.snakePos.get(i)))
                return true;
        }
        return false;
    }


    private void setDefault(){
        snake.direction = Snake.Direction.NONE;
        food = new Food("res/food.png");
        snake = new Snake("res/head.png", "res/body.png");
        repaint();
    }

}
