import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StartProgramFunctionsTest {

    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetUp(){
        startProgram = new StartProgram();
    }

    @Test
    public void usernameMatches() {
        startProgram.getAdmin().createUser("kalle1", "kalle1234", 0, 50,"tester");
        String testInput = "kalle1";
        assertTrue("Failed to match username",startProgram.usernameMatches(testInput) );
        startProgram.getAdmin().deleteUser("kalle1");
    }
}
