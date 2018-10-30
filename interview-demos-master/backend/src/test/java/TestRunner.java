import com.quickbase.devint.service.ConcreteDataCleanImplTest;
import com.quickbase.devint.service.MergeDataImplTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Created by Darshan
 */
public class TestRunner {
    private final static Logger LOGGER = Logger.getLogger("com.quickbase.devint.service");
    public static void main(String[] args) throws IOException {
        Handler fileHandler  = null;
        fileHandler  = new FileHandler( "./quickbaseDemoServiceTest.log");
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(fileHandler);
        Result mergeDataTestResult = JUnitCore.runClasses(MergeDataImplTest.class);
        Result concreteDataCleanTestResult = JUnitCore.runClasses(ConcreteDataCleanImplTest.class);
        Result countryShortcodeTestResult = JUnitCore.runClasses(ConcreteDataCleanImplTest.class);
        //Check all failed test in MergedataTest
        for(Failure failure :mergeDataTestResult.getFailures()){
         System.out.println(failure.toString());
        }
        //Check all failed test in ConcreteDataTest
        for(Failure failure :concreteDataCleanTestResult.getFailures()){
            System.out.println(failure.toString());
        }
        //Check all failed test in CountryShortCodeTest
        for(Failure failure :countryShortcodeTestResult.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("All Test Cases Pssed Successfully");
    }

}
