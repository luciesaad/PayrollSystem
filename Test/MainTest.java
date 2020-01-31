import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void test() {
        Result result = JUnitCore.runClasses(AdminTest.class,CreateUserLogicTest.class, MenuHandleUsersTest.class,MenuLogicTest.class, StartProgramTest.class, UserTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}