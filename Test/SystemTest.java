import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemTest {

    @Test
    public void testSystem() {
        StartProgram startProgram = new StartProgram();
        String input = "kalle1" + System.lineSeparator() + "kalle111" + System.lineSeparator() +
                "admin1" + System.lineSeparator() + "admin1234" + System.lineSeparator() + "1" + System.lineSeparator() +
                "2" + System.lineSeparator() + "pelle1" + System.lineSeparator() + "pelle1234" + System.lineSeparator() +
                "programmer" + System.lineSeparator() + "0" + System.lineSeparator() + "5000" + System.lineSeparator() +
                "3" + System.lineSeparator() + "0" + System.lineSeparator() + "1" + System.lineSeparator() + "8" + System.lineSeparator() +
                "4" + System.lineSeparator() + "5" + System.lineSeparator() + "6" + System.lineSeparator() + "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        startProgram.loginAdmin();

    }

}
