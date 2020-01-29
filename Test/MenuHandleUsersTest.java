import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import java.io.InputStream;

import static org.junit.Assert.*;

public class MenuHandleUsersTest {

    private static StartProgram startProgram;
    private static MenuHandleUsers menuHandleUsers;


    @BeforeClass
    public static void suiteSetUp() {
        startProgram = new StartProgram();
        menuHandleUsers = new MenuHandleUsers();
    }


    @Test
    public void testPrintAllUsers() {

        //  assertTrue("Failed to print all users", listUsersLogic.printAllUsers());
    }

    @Test
    public void testGetUserToUpdate() {
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get input for User to update", 0, menuHandleUsers.chooseUserInput());
    }

    @Test
    public void testChooseUserInput() {
        String inputUser = "0";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get user input for chooseUserInput", 0, menuHandleUsers.chooseUserInput());
    }

    @Test
    public void testReturnChosenUser() {

        //TODO:Find a better way to test this method!!!!

        try {
            assertEquals("Failed to get user", "madde", menuHandleUsers.returnChosenUser(0));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testChooseUser() {
        //TODO: Find out how to test a switch menu in a loop
    }

    @Test
    public void testChangeUserNameInput() {
        String inputUser = "Pelle1";
        InputStream in = new ByteArrayInputStream(inputUser.getBytes());
        System.setIn(in);
        assertEquals("Failed to get the input for the name change", menuHandleUsers.changeUserNameInput());
    }

    @Test
    public void testChangeUserName() {
        //TODO: how to test ??
    }

    @Test
    public void testUpdateUsersSwitchMenu(){
        //TODO: be able to test int menu some way?
    }

    @Test
    public void testChangeUserPasswordInput(){
        String testInput = "password1234";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        assertEquals("Failed to change user password input", "password1234", menuHandleUsers.changeUserPasswordInput());
    }

    @Test
    public void testChangeUserPassword(){
        //TODO:How to test?? The same as changeUserName
    }

    @Test
    public void testChangeUserSalaryInput(){
        String testSalary = "5000";
        InputStream in = new ByteArrayInputStream(testSalary.getBytes());
        System.setIn(in);
        assertEquals("Failed to get input for change user salary input", "5000", menuHandleUsers.changeUserSalaryInput());
    }

    @Test
    public void testChangeUserSalary(){
        //TODO: how to test?? The same as changeUserName and ChangeUserPassword
    }

    @Test
    public void testChangeAccountBalanceInout(){
        String testBalance = "5000";
        InputStream in = new ByteArrayInputStream(testBalance.getBytes());
        System.setIn(in);
        assertEquals("Failed to get input for change account balance", "5000", menuHandleUsers.changeAccountBalanceInput());
    }

    @Test
    public void testChangeAccountBalance(){
        //TODO: how to test?
    }

    @Test
    public void testChangeUserRoleInput(){
        String testRole = "programmer";
        InputStream in = new ByteArrayInputStream(testRole.getBytes());
        System.setIn(in);
        assertEquals("Failed to get input for change user role input", "programmer", menuHandleUsers.changeUserRoleInput());
    }

    @Test
    public void testDeleteUser(){
        //TODO: check if user is deleted when method is run, if no is input then return to menu again.
    }

    @Test
    public void testPrintMenuEditUser() {
      String test = "1 - View Account \n" +
              "2 - Change username \n" +
              "3 - Change password \n" +
              "4 - Change salary \n" +
              "5 - Change account balance \n" +
              "6 - Change role  \n" +
              "7 - Delete user account \n" +
              "8 - Back to Main Menu  \n" +
              "9 - See Menu again";
      System.out.println(menuHandleUsers.printMenuEditUser());
      assertEquals("Failed to print menu edit user", test, menuHandleUsers.printMenuEditUser());
    }


}