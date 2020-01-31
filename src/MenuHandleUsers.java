import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHandleUsers {

    private static StartProgram startProgram = new StartProgram();
    private static CreateUserLogic createUserLogic = new CreateUserLogic();
    private User user;
    private String newUserName;
    private String newUserPassword;
    private String newUserSalary;
    private String newAccountBalance;
    private String newUserRole;

    /**This method checks if the user array has users and if it does it
     * calls two methods, printAllUsers and chooserUSer*/
    public void adminHandleUsers(){
        if(!startProgram.getAdmin().getArrayUsers().isEmpty()) {
            printAllUsers();
            chooseUser();
        }else {
            System.out.println("No users where found, please add users first");
        }
    }

    /**This method gets all the users in the Array that holds all the users.*/
    protected void printAllUsers() {
        String user;
            for (int i = 0; i < startProgram.getAdmin().getArrayUsers().size(); i++) {
                user = startProgram.getAdmin().getArrayUsers().get(i).getUsername();
                System.out.println(i + " " + user);
            }
    }

    /**This method gets the admins input on what user admin want´s to see.
     * @return outValue*/
    protected int chooseUserInput(){
        Scanner scannerInput = new Scanner(System.in);
        String inValue;
        System.out.print("What user do you want to update? Please only enter the number");
        inValue = scannerInput.nextLine();
        int outValue = Integer.parseInt(inValue);
        return outValue;
    }

    /**This method either returns the user index or it returns a excetption that
     * the input didn´t match any index in the array
     * @return index of user
     * @exception NoSuchFieldException*/
    protected User returnChosenUser(int userIndex) throws NoSuchFieldException{
        for (int i = 0; i < startProgram.getAdmin().getArrayUsers().size(); i++){
            if(i == userIndex){
                return  startProgram.getAdmin().getArrayUsers().get(i);
            }
        }
        throw  new NoSuchFieldException("The input did not match any user");
    }

    /**This method either catches a NoSuchFieldException or it prints out the user admin wanted to change
     * and it also prints out the new menu with the options for changing/updating a users values.
     * @exception NoSuchFieldException catches if there is no user match*/
    protected void chooseUser(){
        int userIndex = chooseUserInput();
        int menuChoice = 0;
        try{
           user = returnChosenUser(userIndex);
        }catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Chosen user is: " + user.getUsername());
        System.out.println("Menu: ");
        System.out.println(printMenuEditUser());
        updateUsersSwitchMenu(menuChoice);
    }

    /**This method contains the switch menu, with the menu options admin can choose from.
     * Like changing username, password and more.
     * @param menu holds the menu option*/
    protected void updateUsersSwitchMenu(int menu){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Choose a number: ");
        menu = scannerInput.nextInt();
        while (menu != 8) {
            switch (menu) {
                case 1:
                    //view account user
                    user.viewAccount(user.getUsername());
                    System.out.println("To see menu again press 9:");
                    menu = scannerInput.nextInt();
                    break;
                case 2:
                    //Change username
                    changeUserName();
                    System.out.println("To see menu again press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 3:
                    //Change password
                    changeUserPassword();
                    System.out.println("To see menu again, press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 4:
                    //Change salary
                    changeUserSalary();
                    System.out.println("To see menu again, press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 5:
                    //Change Account balance
                    changeAccountBalance();
                    System.out.println("To see menu again, press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 6:
                    //Change user role
                    changeUserRole();
                    System.out.println("To see Menu again, press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 7:
                    //Delete user
                    deleteUser();
                    System.out.println("To see menu again press 9: ");
                    menu = scannerInput.nextInt();
                    break;
                case 8:
                    //Go back to Main menu
                    break;
                case 9:
                    //Print menu again
                    System.out.println(printMenuEditUser());
                    System.out.println("Choose a number:");
                    menu = scannerInput.nextInt();
                    break;
            }
        }
    }

    /**This method gets the admins input for changing the users username*/
    protected String changeUserNameInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new username: ");
        return scannerInput.nextLine();
    }

    /**This method calls on a method that checks the new username so it checks all the
     * criterias for a username
     * @exception InputMismatchException throws a exception if username don´t pass all
     * the checks in checkUserNameInput
     * @param newUserName the new value for the username*/
    private void checkUserNameInput(String newUserName) throws InputMismatchException{
            try {
                createUserLogic.checkUserNameInput(newUserName);
            } catch (InputMismatchException e) {
                throw e;
            }
    }

    /**This method calls the changeUserNameInput method and the checkUserNameInput method and if
     * no exception is thrown it sets the new username
     * @exception InputMismatchException catches a exception if username don´t pass all the
     * checks in checkUserNameInput*/
    protected void changeUserName(){
        boolean check = false;
       while (!check){
           try{
               newUserName = changeUserNameInput();
               checkUserNameInput(newUserName);
              check = true;
           }catch (InputMismatchException e){
               System.out.println(e.getMessage());
           }
       }
       user.setUsername(newUserName);
       System.out.println("Username was changed to: " + newUserName);
    }

    /**This method gets the new password that admin puts in*/
    protected String changeUserPasswordInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new password: ");
        return scannerInput.nextLine();
    }

    /**This method calls on another method that checks if password is ok, if not it throws
     * a exception.
     * @exception InputMismatchException that tells the admin if input was not ok
     * @param newUserPassword the value of the new user password*/
    private void checkUserPasswordInput(String newUserPassword) throws InputMismatchException{
        try{
            createUserLogic.checkUserPsw(newUserPassword);
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**This method runs both changeUserPassword input and checkUserPassword. It continues untill checkuser'
     * dont throw a InputMismatchException and if true it sets the new password.
     * @exception  InputMismatchException catches it from checkUserPassword*/
    protected void changeUserPassword(){
        boolean check = false;
        while (!check){
            try {
                newUserPassword = changeUserPasswordInput();
                checkUserPasswordInput(newUserPassword);
                check = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        user.setPsw(newUserPassword);
        System.out.println("The password for user " + user.getUsername() + " was change to: " + newUserPassword);
    }

    /**gets admin input and returns it*/
    protected String changeUserSalaryInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new salary: ");
        return scannerInput.nextLine();
    }

    /**check the input and throws exception if not ok*/
    private void checkUserSalaryInput(String newUserSalary) throws InputMismatchException{
        try{
            createUserLogic.checkUserSalary(newUserSalary);
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**The method catches the exeption if thrown if not it sets the new salary*/
    protected void changeUserSalary(){
        boolean check = false;
        while(!check) {
            try {
                newUserSalary = changeUserSalaryInput();
                checkUserSalaryInput(newUserSalary);
                check = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        int salary = Integer.parseInt(newUserSalary);
        user.setSalary(salary);
        System.out.println("The salary was changed for the user " +  user.getUsername() + " new salary is: " + user.getSalary());
    }

    /**Takes the admin input and returns it*/
    protected String changeAccountBalanceInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new account balance: ");
        return scannerInput.nextLine();
    }

    /**The method checks the input and if not ok throws a exception*/
    private void checkAccountBalance(String newAccountBalance) throws InputMismatchException{
        try{
            createUserLogic.checkUserAccountBalance(newAccountBalance);
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**The method runs the check and catches the exception if there is one, if not it sets the
     * new account balance value*/
    protected void changeAccountBalance(){
        boolean check = false;
        while(!check){
            try{
                newAccountBalance = changeAccountBalanceInput();
                checkAccountBalance(newAccountBalance);
                check = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        int accountBalane = Integer.parseInt(newAccountBalance);
        user.setAccountBalance(accountBalane);
        System.out.println("The account balance for user " + user.getUsername() + " was change to: " + accountBalane);
    }

    /**Takes admins input for role change and returns it*/
    protected String changeUserRoleInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new employment role: ");
        return scannerInput.nextLine();
    }

    /**This method checks the input value and if not correct input it throws a exception
     * @param newUserRole the new user employment role
     * @exception InputMismatchException throws if not correct input is input*/
    private void checkUserRoleInput(String newUserRole) throws InputMismatchException {
        try{
            createUserLogic.checkUserEmployment(newUserRole);
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**This method catches InputMismatchEception and if checkUserRoleInput dont throw one it sets the new
     * user role value to the user.
     * @exception InputMismatchException to check the input is correct. */
    protected void changeUserRole(){
        boolean check = false;
        while(!check){
            try{
                newUserRole = changeUserRoleInput();
                checkUserRoleInput(newUserRole);
                check = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        user.setEmploymentRole(newUserRole);
        System.out.println("The employment role of user " + user.getUsername() + " was changed to: " + newUserRole);
    }

    /**Takes the answere if admin want to delete*/
    protected String deleteUserInput(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete user? ");
        return inputScanner.nextLine();
    }

    /**runs the checkinput and throws exception if not ok*/
    protected String checkExceptionDeleteUserInput() throws InputMismatchException{
        try {
            String inputToCheck = deleteUserInput();
            checkDeleteUserInput(inputToCheck);
            return inputToCheck;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**checks the input and throws exception message if input is not ok*/
    protected void checkDeleteUserInput(String testInput){
        if(testInput.isEmpty() || testInput.isBlank()){
            throw new InputMismatchException("It cant be empty please choose yes or no");
        }else if(startProgram.hasLetterNumCombo(testInput)){
            throw new InputMismatchException("please only enter yes or no");
        }
    }

    /**This method does so the admin can delete the user*/
    protected void deleteUser(){
        String username = user.getUsername();
        try{
           String confirm = checkExceptionDeleteUserInput();
            if(confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("y")) {
                startProgram.getAdmin().deleteUser(user.getUsername());
                System.out.println("User " + username + " was deleted");
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }

    /**Prints the menu choices for admin when changing the account of a user*/
    public String printMenuEditUser(){
        return
                "1 - View Account \n" +
                        "2 - Change username \n" +
                        "3 - Change password \n" +
                        "4 - Change salary \n" +
                        "5 - Change account balance \n" +
                        "6 - Change role  \n" +
                        "7 - Delete user account \n" +
                        "8 - Back to Main Menu  \n" +
                        "9 - See Menu again";
    }
}
