import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuLogicTest {

    private static MenuLogic menuLogic;
    private static StartProgram  startProgram;
    @BeforeClass
    public static void suiteSetup(){
        menuLogic = new MenuLogic();

    }

    @Test
    public void createUser() {
        menuLogic.createUser();
    }


}