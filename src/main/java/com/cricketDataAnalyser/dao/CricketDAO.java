package com.cricketDataAnalyser.dao;

import com.cricketDataAnalyser.exceptions.CricketAnalysisException;
import com.cricketDataAnalyser.models.BattingDataCSV;
import com.cricketDataAnalyser.services.CricketAnalyser;

public class CricketDAO {
    public String playerName;
    public double battingAverage;

    public CricketDAO(BattingDataCSV battingDataCSV) {
        this.playerName = battingDataCSV.playerName;
        this.battingAverage = battingDataCSV.battingAverage;
    }

    public Object getCricketDTO(CricketAnalyser.PlayOption playOption) throws CricketAnalysisException {
        if (playOption.equals(CricketAnalyser.PlayOption.BAT))
            return new BattingDataCSV(playerName, battingAverage);
        throw new CricketAnalysisException
                ("Invalid option", CricketAnalysisException.ExceptionType.INVALID_PARAMETER);
    }
}
