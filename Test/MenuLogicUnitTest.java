import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MenuLogicUnitTest {
    private static MenuLogic menuLogic;
    @BeforeClass
    public static void suiteSetUp(){
        menuLogic = new MenuLogic();
    }

    @Test
    public void testViewAdminAccount(){
        String test ="Account user: admin1\n" +
        "Account balance: 20000\n" +
        "Employment role: Administrator\n" +
        "Salary: 20000";
        assertEquals("Failed to view admin account values", test, menuLogic.viewAdminAccount("admin1") );
    }

    @Test
    public void testPaySalaryReturn(){
        assertEquals("Failed to pay out salary","Admin was the only one that got salary payed out" + "There are no users to pay out salary to", menuLogic.paySalaryReturn());
    }
}