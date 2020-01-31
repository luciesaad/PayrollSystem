import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AdminTest {

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
    public void testCreateUser(){
        User user = adminTest.createUser("pelle1", "pelle123", 0, 23000,"programmer");
        assertEquals("Failed to create user", 1, adminTest.getArrayUsers().size());
        adminTest.deleteUser(user.getUsername());
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
        adminTest.deleteUser(username);
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

    @Test
    public void printSalaryRequirementGetAnswerYes(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        int newSalary = userTest3.getRequestedSalary();

        //get yes
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to approve new salary request - wrong input","y", adminTest.printSalaryRequirementGetAnswer(userTest3, newSalary));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void printSalaryRequirementGetAnswerNo(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(50000);
        int newSalary = userTest3.getRequestedSalary();

        //get no
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to dismiss new salary request - wrong input","n", adminTest.printSalaryRequirementGetAnswer(userTest3, newSalary));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void printRoleRequirementGetAnswerYes(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        String newRole = userTest3.getRequestedRole();

        //get yes
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to approve new role request - wrong input","y", adminTest.printRoleRequirementGetAnswer(userTest3, newRole));
        adminTest.deleteUser(userTest3.getUsername());
    }
    @Test
    public void printRoleRequirementGetAnswerNo(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        String newRole = userTest3.getRequestedRole();

        //get no
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to dismiss new role request - wrong input","n", adminTest.printRoleRequirementGetAnswer(userTest3, newRole));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void getAllRequests(){
        User userTest2 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest2.setRequestedSalary(35000);
        userTest2.setRequestedRole("Project Manager");
        assertEquals(2, adminTest.getAllRequests().size());
        adminTest.deleteUser(userTest2.getUsername());
    }

}