import com.quickbase.devint.service.MergeDataImplTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Darshan
 */
public class TestRunner {
    public static void main(String[] args){
        System.out.println("Hello World");
        Result mergeDataTestResult = JUnitCore.runClasses(MergeDataImplTest.class);


        for(Failure failure :mergeDataTestResult.getFailures()){
         System.out.println(failure.toString());
        }

    }

}
