import java.util.InputMismatchException;
import java.util.Scanner;

public class StartProgram {
    private MenuLogic menuLogic;
    private Utils utils;
    public static String currentUser;

    public StartProgram() {
        menuLogic = new MenuLogic();
        utils = Utils.getInstance();
        currentUser = "";
    }

    /**This method starts the program, it calls the login method.*/
    public void runProgram() {
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
        loginAdmin();
    }

    /**Calls the login method*/
    protected void loginAdmin() {
        login();
    }

    /**This method handles login, takes user input and checks calls methods that
     * checks if username and password is a match to any user or admin.*/
    private void login() {
      Scanner scanner = utils.getScanner();
        boolean loginDone = false;
        while (!loginDone){
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            //if there is no username match
            if(!username.equals(utils.getAdmin().getUsername()) && !usernameMatches(username)){
               System.out.println(checkInputConditions(username));
            }
            //if admin logs in
            else if(username.equals(utils.getAdmin().getUsername())){
                if(adminPswMatches(password)){
                    loginDone = true;
                    currentUser = username;
                    System.out.println("Welcome to Administration " + username);
                    printMenuAdmin();
                }else{
                    System.out.println("Login unsuccessful. Try again.");
                }
            }
            //there is a match, but it is not admin - try to log in a regular user
            else{
                if(userPswMatches(username, password)){
                    loginDone = true;
                    currentUser = username;
                    System.out.println("Welcome " + username);
                    //printMenuUser();
                }
                else{
                    System.out.println("Login unsuccessful. Try again.");
                }
            }
        }
    }

    /**This method resets currentUser and calls login admin again so that you
     * can login again as another user or as admin again*/
    public void logout(){
        setCurrentUser("");
        loginAdmin();
    }

    /**This method checks if username matches and catches exception if don´t
     * @exception NoSuchFieldException if user isn´t a match*/
    protected boolean usernameMatches(String matchUsername){
            try {
                utils.getAdmin().getUser(matchUsername); //access get user method //TODO: can the static reference be fixed?
                return true;
            } catch (NoSuchFieldException e) {
               e.getLocalizedMessage();
                return false;
            }
    }
    /**This method checks if admin password matches*/
    protected boolean adminPswMatches(String matchPsw){return matchPsw.equals(utils.getAdmin().getPsw());}

    /**This method checks if users username matches*/
    protected boolean userPswMatches(String matchUsername, String matchPsw){
        try {
            return matchPsw.equals(utils.getAdmin().getUser(matchUsername).getPsw());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**This method checks String input for username
     * @return String with instructions*/
    protected String checkInputConditions(String input) {
        if (input.isEmpty()) {
            return "Try again: ";
        } else if(!utils.hasCorrectLength(input)){
           return "Input value must have 6-10 characters. Please try again: ";
        }else if(!utils.hasLetterNumCombo(input)){
            return "Input value must contain both letters and numbers. Please try again:";
        } else {
            return "Your authentication information is incorrect. Please try again.";
        }
    }



    /**This method get the input the first time
     * @return the value of the menu choice*/
    protected String printMenuAdminInput_firstTime(){
       Scanner scanner = utils.getScanner();
        System.out.println("Menu: ");
        System.out.println(utils.getAdmin().printMenu());
        System.out.println("Enter the menu number of what you want to do: ");
        return scanner.nextLine();
    }

    /**this method get the input value every time the admin have choosen a option and wants
     * to go back to the menu again or do another menu option
     * @return returns the admin input*/
    protected String printMenuAdminInput_goBackToMenu(){
        Scanner scanner = utils.getScanner();
        System.out.println("To go back to the menu press 8: ");
        return scanner.nextLine();
    }

    /**This method takes admin input when admin have been in the menu that
     * handles changes for Users
     * @return  returns admin input*/
    protected String printMenuAdminInput_returnFromHandleUserMenu(){
        Scanner scanner = utils.getScanner();
        System.out.println("Main Menu");
        System.out.println(utils.getAdmin().printMenu());
        System.out.println("Enter the number of what you want to do: ");
        return scanner.nextLine();
    }

    /**This method checks the value admin inputed and if not ok it returns a exception*/
    protected void checkMenuInput(String menuValue)throws InputMismatchException, NumberFormatException {
        if(menuValue.isEmpty() && menuValue.isBlank()){
            throw new InputMismatchException("Input cant be empty!");
        }else if(utils.hasLetterNumCombo(menuValue)){
            throw new InputMismatchException("Input cant be letters and numbers");
        }else if(utils.checkIntSize(menuValue)){
            throw new InputMismatchException("please only input one number");
        }else if(menuValue.equals("") || menuValue == null){
            throw new NumberFormatException("Input cant be empty");
        }
    }

    /**This method returns the value of admin input the first time the menu runs
     * @return int value*/
    protected int printMenuAdminInt_firstTime(){
        String menuValue = printMenuAdminInput_firstTime();
        boolean check = checkInt(menuValue);
        while (!check){
            menuValue = printMenuAdminInput_firstTime();
            check = checkInt(menuValue);
            if(check) {
                return Integer.parseInt(menuValue);
            }
        }
        return Integer.parseInt(menuValue);
    }

    /**This method returns the value of admin input after admin have done a choice from
     * the menu
     * @return int value*/
    protected int printMenuAdminInt_goBackToMenu(){
        String menuValue = printMenuAdminInput_goBackToMenu();
        boolean check = checkInt(menuValue);
        while (!check){
            menuValue = printMenuAdminInput_goBackToMenu();
            check = checkInt(menuValue);
           if(check) {
               return Integer.parseInt(menuValue);
           }
        }
        return Integer.parseInt(menuValue);
    }

    /**This method returns the value of admin input when admin returns from have done
     * menu choice 3 and been in the under menu.
     * @return int value*/
    protected int printMenuAdminInt_returnFromHandleUserMenu(){
        String menuValue = printMenuAdminInput_returnFromHandleUserMenu();
        boolean check = checkInt(menuValue);
        while (!check){
            menuValue = printMenuAdminInput_returnFromHandleUserMenu();
            check = checkInt(menuValue);
            if(check) {
                return Integer.parseInt(menuValue);
            }
        }
        return Integer.parseInt(menuValue);
    }

    /**This method checks the input and either returns a message with a exception or it
     * returns the int
     * @return menuIntValue the admin input value
     * @exception InputMismatchException returns if input not ok
     * @exception NumberFormatException returns if input not ok*/
    private boolean checkInt(String menuValue) {
            try{
                checkMenuInput(menuValue);
                return true;
            }catch(InputMismatchException | NumberFormatException e){
                System.out.println(e.getMessage());
            }
        return false;
    }

    /**Method with switch menu for admin.*/
    public void printMenuAdmin(){
        int menu = 0;
        menu = printMenuAdminInt_firstTime();
        while(menu != 7 && menu != 6) {
            switch (menu) {
                case 1:
                    //view Account
                   utils.getAdmin().viewAccount(utils.getAdmin().getUsername());
                    menu = printMenuAdminInt_goBackToMenu();
                    break;
                case 2:
                    //Create User
                    menuLogic.createUser();
                    menu = printMenuAdminInt_goBackToMenu();
                    break;
                case 3:
                    //See Users
                    menuLogic.listAllUsers();
                    menu = printMenuAdminInt_returnFromHandleUserMenu();
                    break;
                case 4:
                    //Requests
                    utils.getAdmin().checkUserRequests();
                    menu = printMenuAdminInt_goBackToMenu();
                    break;
                case 5:
                    //Pay Salary
                    menuLogic.paySalary();
                    menu = printMenuAdminInt_goBackToMenu();
                case 6:
                    //Log out
                    break;
                case 7:
                    //shut down
                    break;
                case 8:
                    //print menu again
                    menu = printMenuAdminInt_firstTime();
                    break;
            }
        }
        if(menu == 6){
            System.out.println("You where logged out");
            logout();
       }
    }

    /**Method with switch menu for users.*/
    public void printMenuUser(){
        Scanner scanner = utils.getScanner();
        int userInputInt = 0;
        System.out.println("Menu: ");
        try {
            System.out.println(utils.getAdmin().getUser(currentUser).printMenu());
        }catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Enter the number of what you want to do: ");
        userInputInt = scanner.nextInt();
        while(userInputInt != 6 && userInputInt != 5) {
            switch (userInputInt) {
                case 1:
                    //view Account
                    try {
                       utils.getAdmin().getUser(currentUser).viewAccount(currentUser);
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = scanner.nextInt();
                    break;
                case 2:
                    //Request change of salary
                    try {
                        utils.getAdmin().getUser(currentUser).requestChangeSalary();
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = scanner.nextInt();
                    break;
                case 3:
                    //Request change of role
                    try {
                        utils.getAdmin().getUser(currentUser).requestChangeRole();
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = scanner.nextInt();
                    break;
                case 4:
                    //Delete my Account
                    try {
                        if(utils.getAdmin().getUser(currentUser).deleteMyAccount()){
                            logout();
                        }else{
                            System.out.println("To go back to menu press 7: ");
                            userInputInt = scanner.nextInt();
                        }
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    //Log out
                    break;
                case 6:
                    //Shut down
                    break;
                case 7:
                    //Print Menu again
                    try {
                        System.out.println(utils.getAdmin().getUser(currentUser).printMenu());
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Enter the number of what you want to do: ");
                    userInputInt = scanner.nextInt();
                    break;
            }
        }
        if(userInputInt == 5){
            System.out.println("You where logged out");
            logout();
        }
    }

    public String getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        StartProgram.currentUser = currentUser;
    }

}
