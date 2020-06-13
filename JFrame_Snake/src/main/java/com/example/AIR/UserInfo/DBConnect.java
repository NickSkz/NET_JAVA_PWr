package com.example.AIR.UserInfo;

import com.example.AIR.Panels.ScorePanel;

import java.sql.*;

public class DBConnect {


    public DBConnect()
    {
        connect();
    }

    public Connection con;
    private boolean isConnected;

    //Connect to DB
    private void connect(){
        isConnected = true;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_snake?useTimezone=true&serverTimezone=UTC", "USER", "user1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Show all records
    public void selectAllEntries() {
        if (isConnected) {
            try {
                Statement stm = con.createStatement();
                ResultSet resSet = stm.executeQuery("SELECT * FROM entries ORDER BY overall DESC LIMIT 20");

                while (resSet.next()) {
                    ScorePanel.players.add(resSet.getString("nickname") + ",   Points: " + resSet.getString("points") + ",   Time: " + resSet.getString("time") + ",   Overall: " + resSet.getString("overall") + ",   Date: " + resSet.getString("date"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Insert entry
    public void insertEntry(String nickname){
        if(isConnected) {
            try {
                java.util.Date date = new java.util.Date();
                java.sql.Timestamp trueDatum = new java.sql.Timestamp(date.getTime());

                Statement stm = con.createStatement();
                String insertSql = String.format("INSERT INTO entries(nickname, points, time, overall, date)  VALUES ('%s', '%s', '%s', '%s', '%s')", nickname, Stats.points, Stats.zeit, Stats.overall, trueDatum);
                stm.executeUpdate(insertSql);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void clearTable()
    {
        if(isConnected) {
            try {
                Statement stm = con.createStatement();
                String truncateSql = String.format("TRUNCATE TABLE entries");
                stm.executeUpdate(truncateSql);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
