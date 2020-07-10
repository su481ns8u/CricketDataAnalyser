package com.cricketDataAnalyser.adapters;

import com.cricketDataAnalyser.dao.CricketDAO;
import com.cricketDataAnalyser.exceptions.CricketAnalysisException;
import com.cricketDataAnalyser.models.BattingDataCSV;
import com.openCsvBuilder.exceptions.CSVBuilderException;
import com.openCsvBuilder.services.CSVBuilderFactory;
import com.openCsvBuilder.services.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class CricketAdapter {
    public abstract Map<String, CricketDAO> loadCricketData(String... csvFilePath) throws CricketAnalysisException;

    public <E> Map<String, CricketDAO> loadCricketData(Class<E> CSVClass, String csvFilePath)
            throws CricketAnalysisException{
        Map<String, CricketDAO> cricketDAOMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> cricketIterator = csvBuilder.csvFileIterator(reader, CSVClass);
            Iterable<E> cricketIterable = () -> cricketIterator;
            switch (CSVClass.getSimpleName()) {
                case "BattingDataCSV":
                    StreamSupport.stream(cricketIterable.spliterator(), false)
                            .map(BattingDataCSV.class::cast)
                            .forEach(cricketCSV -> cricketDAOMap.put(cricketCSV.playerName, new CricketDAO(cricketCSV)));
                    break;
            }
            return cricketDAOMap;
        } catch (IOException e) {
            throw new CricketAnalysisException(e.getMessage(),
                    CricketAnalysisException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketAnalysisException("Invalid header or delimiter",
                    CricketAnalysisException.ExceptionType.INVALID_HEADER_AND_DELIMITER);
        } catch (CSVBuilderException e) {
            throw new CricketAnalysisException(e.getMessage(), e.type.name());
        }
    }
}
