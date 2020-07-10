import com.cricketDataAnalyser.exceptions.CricketAnalysisException;
import com.cricketDataAnalyser.services.CricketAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class CricketAnalyserTest {
    private static String BATTING_DATA_CSV_PATH = "E:\\BootCamp\\IPLAnalyser\\src\\test\\resources\\Day16 Data_01 IPL2019FactsheetMostRuns.csv";

    CricketAnalyser cricketAnalyser;
    @Test
    public void givenBattingDataFilePath_ShouldReturnCorrectNumberOfRecords() throws CricketAnalysisException {
        cricketAnalyser = new CricketAnalyser();
        int size = cricketAnalyser.loadCricketData(CricketAnalyser.PlayOption.BAT, BATTING_DATA_CSV_PATH).size();
        Assert.assertEquals(102, size);
    }
}
