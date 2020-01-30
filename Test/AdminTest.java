import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminTest {

    private static Admin adminTest ;
    private static User userTest;


    @BeforeClass
    public static void suiteSetup() {
        adminTest = new Admin(0, 20000, "Administrator");
        userTest = new User("pelle","pelle123", 0, 25000,"Programmer");
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
        assertEquals("Failed to create user", 1, adminTest.getArrayUsers().size());
    }

    @Test
    public void viewAccount(){

    }

    @Test
    public void testApproveUserSalary(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");

        userTest3.setRequestedSalary(30000);

        //approve updating Ulf's salary
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Request for salary update failed to be recognised!", "ulf's salary has been updated!", adminTest.checkUserRequests());
    }
    @Test
    public void testDissmissUserSalary(){
        User userTest4 = adminTest.createUser("kalle", "kalle1234", 0, 26000, "Tester Engineer");

        userTest4.setRequestedSalary(100000);

        //dismiss updating Kalle's salary
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Dismissal of salary update failed!", "kalle's new salary not approved!", adminTest.checkUserRequests());
    }

    @Test
    public void testApproveUserRole(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");

        userTest3.setRequestedRole("Gardener");

        //approve updating Ulf's role
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Request for role update failed to be recognized!", "ulf's role has been updated!", adminTest.checkUserRequests());
    }

    @Test
    public void testDismissUserRole(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");

        userTest3.setRequestedRole("Meme creator");

        //dismiss updating Ulf's role
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Dismissal for role update failed!", "ulf's new role not approved!", adminTest.checkUserRequests());
    }

    @Test
    public void testNoRequestsFound(){
        assertEquals("Requests found when they shouldn't!", "No requests found!", adminTest.checkUserRequests());
    }

    @Test
    public void getAllRequests(){
        User userTest2 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest2.setRequestedSalary(35000);
        userTest2.setRequestedRole("Project Manager");
        assertEquals(2, adminTest.getAllRequests().size());
    }

}