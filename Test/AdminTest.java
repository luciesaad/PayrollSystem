import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
   private Admin adminTest = new Admin(0, 20000, "Administrator");
    @Test
    public void getUsername() {
        assertEquals("admin1", adminTest.getUsername());
    }

    @Test
    public void getPsw() {
        assertEquals("admin1234", adminTest.getPsw());
    }

    @Test
    public void getAccountBalanceAdmin() {
        assertEquals(0, adminTest.getAccountBalanceAdmin());
    }

    @Test
    public void getSalaryAdmin() {
        assertEquals(20000,adminTest.getSalaryAdmin());
    }

    @Test
    public void getEmploymentRoleAdmin() {
        assertEquals("Administrator", adminTest.getEmploymentRoleAdmin());
    }
}