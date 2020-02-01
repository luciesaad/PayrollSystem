import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class CreateUserLogicFuntionTest {

    private static CreateUserLogic createUserLogic;
    private static StartProgram startProgram;

    @BeforeClass
    public static void suiteSetup(){
        startProgram = new StartProgram();
        createUserLogic = new CreateUserLogic();
    }

    @Test
    public void testGetUserName(){
        String inputUser = "pelle1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        createUserLogic.setUsernameInput();
        assertEquals("Failed to get username", "pelle1", createUserLogic.getUserName());
    }

    @Test
    public void testGetUserPsw(){
        String inputUser = "pelle1456";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        createUserLogic.setUserPswInput();
        assertEquals("Failed to get userpassword", "pelle1456", createUserLogic.getUserPsw());
    }

    @Test
    public void getUserAccountBalance(){
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        createUserLogic.createUserAccountBalance();
        assertEquals("Failed to get user account balance ", 0, createUserLogic.getUserAccountBalance());
    }
}
