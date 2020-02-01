import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuHandleUsersFunctionTest {

    private static Utils utils;
    private static MenuHandleUsers menuHandleUsers;


    @BeforeClass
    public static void suiteSetUp() {
        utils = new Utils();
        menuHandleUsers = new MenuHandleUsers();
    }

    @Test
    public void testReturnChosenUser_Correct() {
        utils.getAdmin().createUser("frans1", "frans123", 0,40, "tester");
        try {
            assertEquals("Failed to get user", "frans1", menuHandleUsers.returnChosenUser(0).getUsername());
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
        utils.getAdmin().deleteUser("frans1");
    }
}
