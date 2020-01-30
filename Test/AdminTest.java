import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminTest {

    private static Admin adminTest ;
    private  static User userTest;


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
        assertEquals("Failed to create user", "pelle", userTest.getUsername());
    }


}