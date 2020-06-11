package com.example.AIR.Objects;

import java.util.Objects;

public class Point {

    public int X;
    public int Y;

    public Point(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
            return true;

        if(!(other instanceof Point))
            return false;

        return this.X == ((Point) other).X && this.Y == ((Point) other).Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
