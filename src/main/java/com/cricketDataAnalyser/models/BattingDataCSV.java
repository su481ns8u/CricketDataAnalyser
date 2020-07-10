package com.cricketDataAnalyser.models;

import com.opencsv.bean.CsvBindByName;

public class BattingDataCSV {
    //POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double battingAverage;

    public BattingDataCSV(String playerName, double battingAverage) {
        this.playerName = playerName;
        this.battingAverage = battingAverage;
    }
}
