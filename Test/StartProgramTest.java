import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class StartProgramTest {
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetUp(){
        startProgram = new StartProgram();
    }

    @Test
    public void getAdmin() {
        assertEquals("Failed to get Admin", "admin1", startProgram.getAdmin().getUsername());
    }

    @Test
    public void testPrintMenuAdminInput_firstTime(){
        String inputUser = "1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user input value for Admin menu", "1", startProgram.printMenuAdminInput_firstTime());
    }

    @Test
    public void testMenuAdminInt_firstTime(){
        String inputUser = "1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to print admin menu and get input", 1, startProgram.printMenuAdminInt_firstTime());
    }

    @Test
    public void testPrintMenuAdminInput_goBackToMenu(){
        String inputUser = "2";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user input value for Admin menu", "2",startProgram.printMenuAdminInput_firstTime());
    }

    @Test
    public void testPrintMenuAdminInt_goBackToMenu(){
        String inputUser = "2";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user intput value for admin menu", 2, startProgram.printMenuAdminInt_goBackToMenu());
    }

    @Test
    public void testPrintMenuAdminInput_returnFormHandleUserMenu(){
        String inputUser = "3";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user input value for Admin menu", "3",startProgram.printMenuAdminInput_returnFromHandleUserMenu());
    }

    @Test
    public void testPrintMenuAdminInt_returnFromHandleUserMenu(){
        String inputUser = "4";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user input value from admin", 4,startProgram.printMenuAdminInt_returnFromHandleUserMenu());
    }

    @Test
    public void printMenuAdmin() {
        String inputUser = "1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);

        //TODO:Check if it does case 1
    }

    @Test
    public void testCheckIntSize_returnTrue(){
        assertTrue("failed to check int size", startProgram.checkIntSize("2147483647"));
    }

    @Test
    public void testCheckIntSize_returnFalse(){
        assertFalse("Failed to check int size", startProgram.checkIntSize("12"));
    }

    @Test
    public void usernameMatches() {
        startProgram.getAdmin().createUser("kalle1", "kalle1234", 0, 50,"tester");
        String testInput = "kalle1";
        assertTrue("Failed to match username",startProgram.usernameMatches(testInput) );
        startProgram.getAdmin().deleteUser("kalle1");
    }

    @Test
    public void testUsersNameMatches(){
        String testInput = "kalle";
        assertFalse("Failed to match username for user", startProgram.usersNameMatches(testInput));
    }

    @Test
    public void testAdminpswMatches() {
        String testInput = "admin1234";
        String testUserName ="admin1";
        assertTrue("Failed to match password", startProgram.adminPswMatches(testInput));
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