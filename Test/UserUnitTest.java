import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class UserUnitTest {

    private static User userTest;
    private static ArrayList<User> usersArrTest;
    private String currentUser;

    @Before
    public void suiteSetup(){
        userTest = new User("lucie1", "lucie1234",0, 20000, "Programmer");
        usersArrTest = new ArrayList<>();
        usersArrTest.add(userTest);
        currentUser = userTest.getUsername();
    }

    /**A test on getters when viewing a user. */
    @Test
    public void viewAccount() {
        assertEquals("User getUsername failed.","lucie1",userTest.getUsername());
        assertEquals("User getAccountBalance failed.",0,userTest.getAccountBalance());
        assertEquals("User getEmploymentRole failed.","Programmer",userTest.getEmploymentRole());
        assertEquals("User getSalary failed.",20000,userTest.getSalary());
    }

}