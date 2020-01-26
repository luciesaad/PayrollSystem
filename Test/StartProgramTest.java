import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StartProgramTest {
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetUp(){
        startProgram = new StartProgram();
    }

    @Test
    public void runProgram() {
    }

    @Test
    public void loginAdmin(){
        String inputUser = "madde";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
    }

    @Test
    public void getAdmin() {
        assertEquals("Failed to get Admin", "admin1", startProgram.getAdmin().getUsername());
    }

    @Test
    public void printMenuAdmin() {

    }

    @Test
    public void printMenuUser() {
    }

    @Test
    public void usernameMatches() {
        String testInput = "admin1";
        assertTrue("Failed to match username",startProgram.usernameMatches(testInput) );
    }

    @Test
    public void testUsersNameMatches(){
        String testInput = "kalle";
        assertFalse("Failed to match username for user", startProgram.usersNameMatches(testInput));
    }
    
    @Test
    public void pswMatches() {
        String testInput = "admin1234";
        assertTrue("Failed to match password", startProgram.pswMatches(testInput));
    }

    @Test
    public void checkInputConditions() {
        String testInput = "Lucie";
        assertEquals("Failed to check input condition","Input value must have 6-10 characters. Please try again: ",startProgram.checkInputConditions(testInput));
    }

    @Test
    public void testHasCorrectLength() {
        String testInput = "Lucie12";
        assertTrue("Failed to check lengt", startProgram.hasCorrectLength(testInput) );

    }

    @Test
    public void testHasLetterNumCombo() {
        String testInput = "Lucie12";
        assertTrue("Failed to check letter/number combo", startProgram.hasLetterNumCombo(testInput));
    }
}