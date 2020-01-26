import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
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
        testSetUsernameInput();
        testSetUserPswInput();
        testSetUserAccountBalance();
        testCreateUserEmployment();
        testCreateUserSalary();
    }

    @Test
    public void testSetUsernameInput(){
        String inputUser = "madde";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get username input.", "madde", menuLogicObjekt.setUsernameInput());
    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserNameInput(){
        String testInput = "";
        menuLogicObjekt.checkUserNameInput(testInput);
    }
    @Test
    public void testCreateUserName(){
        String inputUser = "madde1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create username", menuLogicObjekt.createUserName());
    }

    @Test
    public void testSetUserPswInput(){
        String inputUser = "madde1234";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get password input", "madde1234", menuLogicObjekt.setUserPswInput());
    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserPsw(){
        String testInput = "";
        menuLogicObjekt.checkUserPsw(testInput);
    }

    @Test
    public void testCreateUserPsw(){
        String inputUser = "madde1234";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user password", menuLogicObjekt.createUserPsw());
    }

    @Test
    public void testSetUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
       assertEquals("Failed to get account balance input", "0", menuLogicObjekt.setUserAccountBalance());

    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserAccountBalance(){
        String testInput = "";
        menuLogicObjekt.checkUserAccountBalance(testInput);
    }

    @Test
    public void testCreateUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user account balance", menuLogicObjekt.createUserAccountBalance());
    }

    @Test
    public void testSetUserSalary(){
        String inputUser = "35000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get salary input", "35000", menuLogicObjekt.setUserSalary());
    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserSalary(){
        String testInput = "";
        menuLogicObjekt.checkUserSalary(testInput);
    }

    @Test
    public void testCreateUserSalary(){
        String inputUser = "35000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user salary", menuLogicObjekt.createUserSalary());
    }

    @Test
    public void TestSetCreateUserEmployment(){
        String inputUser = "programmer";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to set employment role input", "programmer", menuLogicObjekt.setUserEmployment());
    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserEmployment(){
        String testInput = "";
        menuLogicObjekt.checkUserEmployment(testInput);
    }

    @Test
    public void testCreateUserEmployment(){
        String inputUser = "programmer";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user employment role", menuLogicObjekt.createUserEmployment());
    }

    @Test
    public void testInputIsEmpty(){
        String empty="";
        assertTrue("",menuLogicObjekt.inputIsEmpty(empty));
    }

    @Test
    public void testHasNumber(){
        String testInput = "11aa";
        assertTrue("",menuLogicObjekt.hasNumber(testInput));
    }

    @Test
    public void testGetUserName(){
        String inputUser = "pelle1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        menuLogicObjekt.setUsernameInput();
        assertEquals("Failed to get username", "pelle1", menuLogicObjekt.getUserName());
    }

    @Test
    public void testGetUserPsw(){
        String inputUser = "pelle1456";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        menuLogicObjekt.setUserPswInput();
        assertEquals("Failed to get userpassword", "pelle1456", menuLogicObjekt.getUserPsw());
    }

    @Test
    public void getUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        menuLogicObjekt.createUserAccountBalance();
        assertEquals("Failed to get user account balance ", 0, menuLogicObjekt.getUserAccountBalance());
    }

    @Test
    public void getUserSalary(){
        String inputUser = "45000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        menuLogicObjekt.createUserSalary();
       assertEquals("Failed to get user salary", 45000, menuLogicObjekt.getUserSalary());
    }


}