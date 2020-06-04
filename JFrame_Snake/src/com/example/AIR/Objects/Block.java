package com.example.AIR.Objects;

import com.example.AIR.Constants.Consts;

public class Block {
    int x;
    int y;
    void Block(int X, int Y){
        x=X;
        y=Y;
    }
    public void set(int X, int Y){
        x=X;
        y=Y;
    }
    public void moveDown(){
        y=y+1;
    }
    public void moveUp(){
        y=y-1;
    }
    public void moveLeft(){
        x-=1;
    }
    public void moveRight(){
        x+=1;
    }
}
