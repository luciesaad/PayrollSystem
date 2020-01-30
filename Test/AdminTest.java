import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminTest {

    private static Admin adminTest ;
    private  static User userTest;
    private static StartProgram startProgram;


    @BeforeClass
    public static void suiteSetup() {
        adminTest = new Admin(0, 20000, "Administrator");
        userTest = new User("pelle","pelle123", 0, 25000,"Programmer");
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
    public void createUser(){
        adminTest.createUser("pelle", "pelle123", 0, 23000,"programmer");
        assertEquals("Failed to create user", "pelle", userTest.getUsername());
    }

    @Test
    public void testDeleteUser(){
        adminTest.createUser("kalle1", "kalle1234", 0, 4000,"tester");
        adminTest.deleteUser("kalle1");
        assertEquals("Failed to delete user", 0, adminTest.getArrayUsers().size());
    }

    @Test
    public void testPrintUserNameCorrectInput(){
        String username = "kalle1";
        adminTest.createUser("kalle1", "kalle1234", 0, 4000,"tester");
        assertEquals("Failed to print user name", "kalle1", adminTest.printUserName(username));
    }

    @Test
    public void testPrintUserNameIncorrectInput(){
        assertEquals("Failed print user name", "Cant find user", adminTest.printUserName("pelle"));
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