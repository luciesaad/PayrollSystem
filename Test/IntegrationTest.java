import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class IntegrationTest {

    private static StartProgram startProgram;
    @Before
    public void testSetUp(){
        startProgram = new StartProgram();
    }

    @After
    public void testTearDown(){
        startProgram = null;
    }

    @Test
    public void testUserLoginIncorrectUserFirstTime() {
        String input = "kalle1" + System.lineSeparator() + "kalle111" + System.lineSeparator() +
                "admin1" + System.lineSeparator() + "admin1234" + System.lineSeparator() + "7" ;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        startProgram.loginAdmin();

    }

    @Test
    public void testUserLoginCorrectUser(){
        String input = "admin1" + System.lineSeparator() + "admin1234" + System.lineSeparator() + "7" ;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        startProgram.loginAdmin();
    }
}
