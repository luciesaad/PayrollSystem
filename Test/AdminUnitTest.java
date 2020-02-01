import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AdminUnitTest {

    private static Admin adminTest ;
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetup() {
        adminTest = new Admin(0, 20000, "Administrator");
        startProgram = new StartProgram();
    }

    @Test
    public void getUsername() {
        assertEquals("admin1", adminTest.getUsername());
    }

    @Test
    public void getPsw() {
        assertEquals("admin1234", adminTest.getPsw());
    }

    @Test
    public void getAccountBalanceAdmin() {
        assertEquals(0, adminTest.getAccountBalance());
    }

    @Test
    public void getSalaryAdmin() {
        assertEquals(20000,adminTest.getSalary());
    }

    @Test
    public void getEmploymentRoleAdmin() {
        assertEquals("Administrator", adminTest.getEmploymentRole());
    }

    @Test
    public void testPrintUserNameIncorrectInput(){
        assertEquals("Failed print user name", "Can't find user", adminTest.printUserName("pelle"));
    }

    @Test
    public void testPrintMenu(){
        String testInput = "1 - View Account \n" +
                "2 - Create User \n" +
                "3 - See Users \n" +
                "4 - Requests \n" +
                "5 - Pay salary \n" +
                "6 - Log out \n" +
                "7 - Turn off program \n" +
                "8 - See Menu again";
        assertEquals("failed to return print Menu", testInput, adminTest.printMenu());
    }
}