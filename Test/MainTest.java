import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest {

    @Test
    public void test() {
        Result result = JUnitCore.runClasses(AdminUnitTest.class, CreateUserLogicUnitTest.class, MenuHandleUsersTest.class, MenuLogicUnitTest.class, StartProgramUnitTest.class, UserUnitTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}