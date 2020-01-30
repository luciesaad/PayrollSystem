import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MenuLogicTest {
    private static MenuLogic menuLogic;
    private static StartProgram startProgram;
    @BeforeClass
    public static void suiteSetUp(){
        menuLogic = new MenuLogic();
        startProgram = new StartProgram();
    }

    @Test
    public void testViewAdminAccount(){
        String test = "Account user: " + startProgram.getAdmin().getUsername() + "\n"+
                "Account balance: " + startProgram.getAdmin().getAccountBalance() + "\n"+
                "Employment role: " + startProgram.getAdmin().getEmploymentRole()  + "\n"+
                "Salary: " + startProgram.getAdmin().getSalary();
        assertEquals("Failed to view admin account values", test, menuLogic.viewAdminAccount("admin1") );
    }

    @Test
    public void testPaySalaryReturn(){
        assertEquals("Failed to pay out salary","Admin was the only one that got salary payed out" + "There are no users to pay out salary to", menuLogic.paySalaryReturn());
    }
}