package com.cricketDataAnalyser.adapters;

import com.cricketDataAnalyser.dao.CricketDAO;
import com.cricketDataAnalyser.exceptions.CricketAnalysisException;
import com.cricketDataAnalyser.services.CricketAnalyser;

import java.util.Map;

public class CricketAdapterFactory {
    public Map<String, CricketDAO> getCricketData(CricketAnalyser.PlayOption playOption, String... csvFilePath)
            throws CricketAnalysisException {
        switch (playOption) {
            case BAT:
                return new BattingCricketAdapter().loadCricketData(csvFilePath);
            default:
                throw new CricketAnalysisException
                        ("Invalid Option", CricketAnalysisException.ExceptionType.INVALID_PARAMETER);
        }
    }
}
