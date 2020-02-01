import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StartProgramFunctionsTest {

    private static Utils utils;
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetUp(){
        utils = new Utils();
        startProgram = new StartProgram();
    }

    @Test
    public void usernameMatches() {
        utils.getAdmin().createUser("kalle1", "kalle1234", 0, 50,"tester");
        String testInput = "kalle1";
        assertTrue("Failed to match username",startProgram.usernameMatches(testInput) );
        utils.getAdmin().deleteUser("kalle1");
    }
}
