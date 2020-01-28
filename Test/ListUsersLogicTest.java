import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ListUsersLogicTest {

    private static StartProgram startProgram;
    private static ListUsersLogic listUsersLogic;

    @BeforeClass
    public static void suiteSetUp(){
        startProgram = new StartProgram();
        listUsersLogic = new ListUsersLogic();
    }

    @Test
    public void testPrintAllUsers() {

          //  assertTrue("Failed to print all users", listUsersLogic.printAllUsers());
        }
    @Test
    public void testGetUserToUpdate(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get input for User to update", 0, listUsersLogic.chooseUserInput());
    }
}