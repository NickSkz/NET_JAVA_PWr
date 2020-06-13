package com.example.AIR.Panels;

import com.example.AIR.Constants.Consts;
import com.example.AIR.Frames.GameOverFrame;
import com.example.AIR.Frames.JFrames;
import com.example.AIR.Objects.Food;
import com.example.AIR.Objects.Obstacle;
import com.example.AIR.Objects.Snake;
import com.example.AIR.UserInfo.Stats;
import org.apache.commons.lang3.SerializationUtils;

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
    private Obstacle obstacle;

    private boolean gameIsOn;
    private boolean isFirstMove;

    Thread zeitThread;
    private int zeit;
    private boolean timeRuns;

    private int points;

    public Plansza()
    {
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        food = new Food("res/food.png");
        snake = new Snake("res/head.png", "res/body.png");
        obstacle = new Obstacle("res/obstacle.png", 3);

        gameIsOn = true;
        isFirstMove = true;

        timer = new Timer(100,this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Consts.mainX, Consts.mainY);
        g.setColor(Color.GRAY);
        g.fillRect(Consts.LeftWall, Consts.TopWall, Consts.RightWall, Consts.BottomWall);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 22));
        g.setColor(Color.CYAN);

        g.drawString("Points: " + points, 10, 20);
        g.drawString("Time: " + String.valueOf(zeit), 435, 20);


        menuButton = new JButton("Menu");
        menuButton.setBounds(Consts.mainX - 115, Consts.mainY - 40, 100, 40);
        menuButton.addActionListener((e) -> {
            gameIsOn = false;
            setDefault();
            JFrames.gameFrame.setVisible(false);
            JFrames.gameFrame.dispose();
            JFrames.startFrame.setVisible(true);
        });
        add(menuButton);


        for(int i : obstacle.indexes)
            obstacle.obstacleGraphix.paintIcon(this, g, obstacle.obstaclePos.get(i).X, obstacle.obstaclePos.get(i).Y);



        snake.head.paintIcon(this, g, snake.snakePos.get(0).X, snake.snakePos.get(0).Y);
        for (int i = 1; i < snake.snakeLength; ++i)
            snake.body.paintIcon(this, g, snake.snakePos.get(i).X, snake.snakePos.get(i).Y);



        checkPoint();
        food.foodGraphix.paintIcon(this, g, food.foodPosition.get(food.possIdx).X, food.foodPosition.get(food.possIdx).Y);

        if (checkCollision())
        {
            gameIsOn = false;

            Stats.points = points;
            Stats.zeit = zeit;
            Stats.overall = points * zeit;

            setDefault();

            JFrames.gameOverFrame.setVisible(true);

            JFrames.gameFrame.setVisible(false);
            JFrames.gameFrame.dispose();
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
                    snake.snakePos.set(i, SerializationUtils.clone(snake.snakePos.get(i-1)));

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
                    snake.snakePos.set(i, SerializationUtils.clone(snake.snakePos.get(i-1)));

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
                    snake.snakePos.set(i, SerializationUtils.clone(snake.snakePos.get(i-1)));

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
                    snake.snakePos.set(i, SerializationUtils.clone(snake.snakePos.get(i-1)));

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

        if(isFirstMove)
        {
            zeitThread = new Thread(){
                public void run(){
                    timeRuns = true;
                    while(gameIsOn){
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch (Exception e)
                        {

                        }
                        ++zeit;
                    }
                }
            };
            zeitThread.start();
            isFirstMove = false;
        }


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
            ++points;
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

        for(int i : obstacle.indexes)
        {
            if(snake.snakePos.get(0).equals(obstacle.obstaclePos.get(i)))
                return true;
        }
        return false;
    }


    private void setDefault(){
        snake.direction = Snake.Direction.NONE;
        food = new Food("res/food.png");
        snake = new Snake("res/head.png", "res/body.png");
        obstacle = new Obstacle("res/obstacle.png", 3);
        points = 0;

        if(timeRuns)
        {
            try
            {
                zeitThread.join();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        timeRuns = false;
        zeit = 0;

        isFirstMove = true;
        gameIsOn = true;
        repaint();
    }

}
