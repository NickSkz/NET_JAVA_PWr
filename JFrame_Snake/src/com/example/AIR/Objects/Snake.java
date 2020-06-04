package com.example.AIR.Objects;

import com.example.AIR.Constants.Consts;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


enum direction{top , bottom, left, right}

public class Snake {
    Block head;
    List<Block> body= new ArrayList<Block>();
    direction dir;

    void Snake(){
        Block blok=new Block();
        head.set(10,10);
        blok.set(10,9);
        body.add(blok);
        blok.set(10,8);
        body.add(blok);
        blok.set(10,7);
        body.add(blok);
        dir=direction.bottom;
    }

    boolean checkHor(int y){
        if(y>50 || y<0){
            return true;
        }
        return body.stream().anyMatch(i -> i.y == y);
    }
    boolean checkVer(int x){
        if(x>50 || x<0){
            return true;
        }
        return body.stream().anyMatch(i -> i.x == x);
    }

    void move(){
        for (int i = 1; i > body.size(); i++) {
            body.set(i,body.get(i+1));
        }
        body.set(body.size()+1, head);

        switch (dir){
            case top:
                if (checkVer(head.y - 1) == false) {
                    head.moveUp();
                }
            case bottom:
                if(checkVer(head.y+1)==false){
                    head.moveDown();
                }
            case left:
                if(checkHor(head.x-1)==false) {
                    head.moveLeft();
                }
            case right:
                if (checkHor(head.x+1)==false) {
                    head.moveRight();
                }
        }
    }

    void eat(){
        body.add(head);
        switch (dir){
            case top:       head.moveUp();
            case bottom:    head.moveDown();
            case left:      head.moveLeft();
            case right:     head.moveRight();
        }
    }

    public int wypisz_cokolwiek(){
        return head.x;
    }
    public Rectangle position(){
        Rectangle rectangle= new Rectangle();
        rectangle.x=head.x*10+ Consts.LeftWall;
        rectangle.y=head.y*10+ Consts.TopWall;
        rectangle.height=10;
        rectangle.width=10;
        return rectangle;
    }
}
