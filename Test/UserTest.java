import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class UserTest {

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

    @Test
    public void requestChangeSalary() {
        int reqSal = 30000;
        userTest.setRequestedSalary(reqSal);
        assertEquals("setSalary failed - value does not match!",30000, userTest.getRequestedSalary());
    }

    @Test
    public void requestChangeRole() {
        String reqRole = "Tester Engineer";
        userTest.setRequestedRole(reqRole);
        assertEquals("setRole failed - value does not match!","Tester Engineer", userTest.getRequestedRole());
    }

    @Test
    public void deleteMyAccount() {
        if(currentUser.equals(userTest.getUsername()) && !userTest.getEmploymentRole().equals("Administrator")){
            usersArrTest.remove(userTest);
        }
        assertEquals("The user has not been deleted from users list", 0, usersArrTest.size());
    }
}