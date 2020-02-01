import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateUserLogicUnitTest {
    private static CreateUserLogic createUserLogic;
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetup(){
        startProgram = new StartProgram();
        createUserLogic = new CreateUserLogic();
    }

    @Test
    public void testSetUsernameInput(){
        String inputUser = "madde";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get username input.", "madde", createUserLogic.setUsernameInput());
    }

    @Test
    public void testSetUserPswInput(){
        String inputUser = "madde1234";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get password input", "madde1234", createUserLogic.setUserPswInput());
    }

    @Test
    public void testCreateUserName(){
        String inputUser = "madde1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create username", createUserLogic.createUserName());
    }

    @Test
    public void testCreateUserPsw(){
        String inputUser = "madde1234";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user password", createUserLogic.createUserPsw());
    }

    @Test
    public void testSetUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get account balance input", "0", createUserLogic.setUserAccountBalance());
    }

    @Test
    public void testCreateUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user account balance", createUserLogic.createUserAccountBalance());
    }

    @Test
    public void testSetUserSalary(){
        String inputUser = "35000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get salary input", "35000", createUserLogic.setUserSalary());
    }
    @Test
    public void testCreateUserSalary(){
        String inputUser = "35000";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user salary", createUserLogic.createUserSalary());
    }

    @Test
    public void TestSetCreateUserEmployment(){
        String inputUser = "programmer";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to set employment role input", "programmer", createUserLogic.setUserEmployment());
    }

    @Test
    public void testCreateUserEmployment(){
        String inputUser = "programmer";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertTrue("Failed to create user employment role", createUserLogic.createUserEmployment());
    }

    @Test
    public void getUserSalary(){
        assertEquals("Failed to get user salary", 35000, createUserLogic.getUserSalary());
    }

    @Test
    public void testInputIsEmpty(){
        String empty="";
        assertTrue("",createUserLogic.inputIsEmpty(empty));
    }

    @Test
    public void testHasNumber(){
        String testInput = "11aa";
        assertTrue("",startProgram.hasLetterNumCombo(testInput));
    }

    @Test(expected = InputMismatchException.class)
    public void testCheckUserNameInput(){
        String testInput = "";
        createUserLogic.checkUserNameInput(testInput);
    }


    @Test(expected = InputMismatchException.class)
    public void testCheckUserPsw(){
        String testInput = "";
        createUserLogic.checkUserPsw(testInput);
    }


    @Test(expected = InputMismatchException.class)
    public void testCheckUserAccountBalance(){
        String testInput = "";
        createUserLogic.checkUserAccountBalance(testInput);
    }


    @Test(expected = InputMismatchException.class)
    public void testCheckUserSalary(){
        String testInput = "";
        createUserLogic.checkUserSalary(testInput);
    }


    @Test(expected = InputMismatchException.class)
    public void testCheckUserEmployment(){
        String testInput = "";
        createUserLogic.checkUserEmployment(testInput);
    }
}
