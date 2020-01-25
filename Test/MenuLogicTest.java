import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MenuLogicTest {

    private static MenuLogic menuLogicObjekt;
    private static StartProgram startProgram;
    @BeforeClass
    public static void suiteSetup(){
        menuLogicObjekt = new MenuLogic();
        startProgram = new StartProgram();
    }

    /**A integration test on input when creating a user. */
    @Test
    public void testCreateUser() {
        testCreateUserInput();
        testCreateUserPswInput();
        testCreateUserAccountBalance();
        testCreateUserEmployment();
        testCreateUserSalary();
    }

    @Test
    public void testCreateUserInput(){
        String inputUser = "madde";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get username input.", "madde", menuLogicObjekt.createUsernameInput());
    }

    @Test
    public  void testCreateUserPswInput(){
        String inputUser = "madde1234";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get password input", "madde1234", menuLogicObjekt.createUserPswInput());

    }

    @Test
    public void testCreateUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get account balance input", 0, menuLogicObjekt.createUserAccountBalance());

    }

    @Test
    public void testCreateUserSalary(){
        String inputUser = "35000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get salary input", 35000, menuLogicObjekt.createUserSalary());

    }

    @Test
    public void testCreateUserEmployment(){
        String inputUser = "programmer";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get employment role input", "programmer", menuLogicObjekt.createUserPswInput());

    }







}