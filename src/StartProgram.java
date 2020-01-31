import java.util.InputMismatchException;
import java.util.Scanner;

public class StartProgram {
    private MenuLogic menuLogic = new MenuLogic();
    private Admin admin = new Admin(0, 20000, "Administrator");
    private Scanner userInput = new Scanner(System.in);
    public static String currentUser = "";

    /**This method starts the program, it calls the login method.*/
    public void runProgram() {
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
        loginAdmin();
        userInput.close();
    }

    /**Calls the login method*/
    protected void loginAdmin() {
        login();
        userInput.close();
    }

    /**This method handles login, takes user input and checks calls methods that
     * checks if username and password is a match to any user or admin.*/
    private void login() {
        Scanner input = new Scanner(System.in);
        boolean loginDone = false;
        while (!loginDone){
            System.out.print("Enter Username: ");
            String username = input.nextLine();
            System.out.print("Enter Password: ");
            String password = input.nextLine();

            //if there is no username match
            if(!username.equals(admin.getUsername()) && !usernameMatches(username)){
               System.out.println(checkInputConditions(username));
            }
            //if admin logs in
            else if(username.equals(admin.getUsername())){
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
                    printMenuUser();
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
        currentUser = "";
        loginAdmin();
    }

    /**This method checks if username matches and catches exception if don´t
     * @exception NoSuchFieldException if user isn´t a match*/
    protected boolean usernameMatches(String matchUsername){
            try {
               admin.getUser(matchUsername); //access get user method //TODO: can the static reference be fixed?
                return true;
            } catch (NoSuchFieldException e) {
               e.getLocalizedMessage();
                return false;
            }
    }
    /**This method checks if admin password matches*/
    protected boolean adminPswMatches(String matchPsw){return matchPsw.equals(admin.getPsw());}

    /**This method checks if users username matches*/
    protected boolean userPswMatches(String matchUsername, String matchPsw){
        try {
            return matchPsw.equals(admin.getUser(matchUsername).getPsw());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**This method checks if admin username matches*/
    protected boolean usersNameMatches(String match){return  match.equals(admin.printUserName(match));}

    /**This method checks String input for username
     * @return String with instructions*/
    protected String checkInputConditions(String input) {
        if (input.isEmpty()) {
            return "Try again: ";
        } else if(!hasCorrectLength(input)){
           return "Input value must have 6-10 characters. Please try again: ";
        }else if(!hasLetterNumCombo(input)){
            return "Input value must contain both letters and numbers. Please try again:";
        } else {
            return "Your authentication information is incorrect. Please try again.";
        }
    }

    /**This method checks int input*/
    public boolean checkIntSize(int intToCheck){
        if(intToCheck >= 2147483646){
            return true;
        }else if(intToCheck <= -2147483646){
            return true;
        }
        else{
            return false;
        }
    }

    /**This method checks so that a username and password have the correct length*/
    protected boolean hasCorrectLength(String input){
        if(input.length() < 6 || input.length() > 10){
            return false;
        }
        return true;
    }

    /**This method checks so that a username and password contains both char and number*/
    protected boolean hasLetterNumCombo(String input){
        StringBuilder sb = new StringBuilder();
        boolean numFound = false;
        boolean letterFound = false;
        for(char c : input.toCharArray()) {      //for each char in char array from input, do following:
            if (Character.isDigit(c)) {           //check if one of chars is a number
                sb.append(c);
                numFound = true;
            } else if (Character.isLetter(c)) {
                sb.append(c);
                letterFound = true;
            }
        }
        // if we find at least one digit and one letter, return true
        // if combo not found, return false
        return (numFound && letterFound);
    }

    /**Get admin*/
    public Admin getAdmin() {
        return admin;
    }

    /**This method get the input the first time
     * @return the value of the menu choice*/
    protected String printMenuAdminInput_firstTime(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println(admin.printMenu());
        System.out.println("Enter the menu number of what you want to do: ");
        return scannerInput.nextLine();
    }

    /**this method get the input value every time the admin have choosen a option and wants
     * to go back to the menu again or do another menu option
     * @return returns the admin input*/
    protected String printMenuAdminInput_goBackToMenu(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("To go back to the menu press 8: ");
        return scannerInput.nextLine();
    }

    /**This method takes admin input when admin have been in the menu that
     * handles changes for Users
     * @return  returns admin input*/
    protected String printMenuAdminInput_returnFromHandleUserMenu(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Main Menu");
        System.out.println(admin.printMenu());
        System.out.println("Enter the number of what you want to do: ");
        return scannerInput.nextLine();
    }

    /**This method checks the value admin inputed and if not ok it returns a exception*/
    protected void checkMenuInput(String menuValue)throws InputMismatchException, NumberFormatException {
        if(menuValue.isEmpty() && menuValue.isBlank()){
            throw new InputMismatchException("Input cant be empty!");
        }else if(hasLetterNumCombo(menuValue)){
            throw new InputMismatchException("Input cant be letters and numbers");
        }else if(checkIntSize(Integer.parseInt(menuValue))){
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
                    admin.viewAccount(getAdmin().getUsername());
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
                    admin.checkUserRequests();
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
        int userInputInt = 0;
        System.out.println("Menu: ");
        try {
            System.out.println(getAdmin().getUser(currentUser).printMenu());
        }catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Enter the number of what you want to do: ");
        userInputInt = userInput.nextInt();
        while(userInputInt != 6 && userInputInt != 5) {
            switch (userInputInt) {
                case 1:
                    //view Account
                    try {
                       getAdmin().getUser(currentUser).viewAccount(currentUser);
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = userInput.nextInt();
                    break;
                case 2:
                    //Request change of salary
                    try {
                        getAdmin().getUser(currentUser).requestChangeSalary();
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = userInput.nextInt();
                    break;
                case 3:
                    //Request change of role
                    try {
                        getAdmin().getUser(currentUser).requestChangeRole();
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("To go back to menu press 7: ");
                    userInputInt = userInput.nextInt();
                    break;
                case 4:
                    //Delete my Account
                    try {
                        if(getAdmin().getUser(currentUser).deleteMyAccount()){
                            logout();
                        }else{
                            System.out.println("To go back to menu press 7: ");
                            userInputInt = userInput.nextInt();
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
                        System.out.println(getAdmin().getUser(currentUser).printMenu());
                    }catch (NoSuchFieldException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Enter the number of what you want to do: ");
                    userInputInt = userInput.nextInt();
                    break;
            }
        }
        if(userInputInt == 5){
            System.out.println("You where logged out");
            logout();
        }
    }

    /**getters, setters*/
    public String getCurrentUser() {
        return currentUser;
    }

}
