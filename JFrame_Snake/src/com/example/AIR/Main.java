package com.example.AIR;

import javax.swing.*;
import java.awt.*;
import java.security.KeyStore;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Plansza plansza = new Plansza();

        obj.setBounds(10,10,600,600);
        obj.setBackground(Color.BLACK);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(plansza);
    }
}
