import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SmokeTest {
    private static StartProgram startProgram;
    private static Admin adminTest;
    private static User userTest;

    @BeforeClass
    public static void smokeTestSuiteSetup(){
        startProgram = new StartProgram();
        adminTest = new Admin(0, 20000, "Administrator");
        userTest = new User("lucie1", "lucie1234", 0, 20000, "Programmer");
    }

    @Test
    public void testRunProgramAsAdmin(){
        //assume all users logged out
        logoutState();
        //log in as the admin
        loginAdmin();
        //show administration menu
        getCorrectMenuAdmin();
        //logout
        logout();
        //check users logged out
        logoutState();
    }

    @Test
    public void testRunProgramAsUser(){
        //assume all users logged out
        logoutState();
        //log in as a user
        loginUser();
        //show user menu
        getCorrectMenuUser();
        //logout
        logout();
        //check users logged out
        logoutState();
    }


    //common methods
    public void logoutState(){
        assertTrue(startProgram.getCurrentUser().equals(""));
    }
    public void logout(){
        StartProgram.setCurrentUser("");
    }

    //admin methods
    public void loginAdmin(){
        StartProgram.setCurrentUser("admin1");
        assertEquals("admin1", startProgram.getCurrentUser());
    }
    public void getCorrectMenuAdmin(){
        String menu = adminTest.printMenu();
        System.out.println(menu);

        assertEquals("failed to print out menu for admin", menu, adminTest.printMenu());
    }

    //user methods
    public void loginUser(){
        StartProgram.setCurrentUser(userTest.getUsername());
        assertEquals("lucie1", startProgram.getCurrentUser());
    }
    public void getCorrectMenuUser(){
        StartProgram.setCurrentUser(userTest.getUsername());
        String menu = userTest.printMenu();
        System.out.println(menu);

        assertEquals("failed to print out menu for user", menu, userTest.printMenu());
    }
}
