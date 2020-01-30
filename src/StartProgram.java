import java.util.Scanner;

public class StartProgram {
    private MenuLogic menuLogic = new MenuLogic();
    private Admin admin = new Admin(0, 20000, "Administrator");
    private Scanner userInput = new Scanner(System.in);
    public static String currentUser = "";

    public void runProgram() {
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
        loginAdmin();
        userInput.close();
    }

    protected void loginAdmin() {
        login();
        userInput.close();
    }

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
                checkInputConditions(username);
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

    public void logout(){
        currentUser = "";
        loginAdmin();

    }

    //I think we should create just one 'login' method, and update the username+pswMatches methods so that they either call
    //the get username + get psw on admin or user based on the role or something. Plus in that login method, after login done = true;
    //we should have a global private String set there to the current username that is logged in for future purposes(e.g. deleteMyAccount in User)

    protected boolean usernameMatches(String matchUsername){
            try {
                admin.getUser(matchUsername); //access get user method //TODO: can the static reference be fixed?
                return true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
    }
    protected boolean adminPswMatches(String matchPsw){
        return matchPsw.equals(admin.getPsw());
    }
    protected boolean userPswMatches(String matchUsername, String matchPsw){
        try {
            return matchPsw.equals(admin.getUser(matchUsername).getPsw());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }
    protected boolean usersNameMatches(String match){return  match.equals(admin.printUserName(match));}

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

    protected boolean hasCorrectLength(String input){
        if(input.length() < 6 || input.length() > 10){
            return false;
        }
        return true;
    }

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

    public Admin getAdmin() {
        return admin;
    }

    /**Method with switch menu for admin.*/
    public void printMenuAdmin(){
        Scanner scannerInput = new Scanner(System.in);
        int menu = 0;
        System.out.println("Menu: ");
       System.out.println(admin.printMenu());
        System.out.println("Enter the menu number of what you want to do: ");
        menu = scannerInput.nextInt();
        while(menu != 7 && menu != 6) {
            switch (menu) {
                case 1:
                    //view Account
                    admin.viewAccount(getAdmin().getUsername());
                    System.out.print("To go back to the menu press 8: ");
                    menu = scannerInput.nextInt();
                        break;
                case 2:
                    //Create User
                    menuLogic.createUser();
                    System.out.println("To go back to the menu press 8: ");
                    menu = scannerInput.nextInt();
                    break;
                case 3:
                    //See Users
                    menuLogic.listAllUsers();
                    System.out.println("Main Menu");
                    admin.printMenu();
                    System.out.println("Enter the number of what you want to do: ");
                    menu = scannerInput.nextInt();
                    break;
                case 4:
                    //Requests
                    admin.checkUserRequests();
                    System.out.println("To go back to menu press 8: ");
                    menu = scannerInput.nextInt();
                    break;
                case 5:
                    //Pay Salary
                    menuLogic.paySalary();
                    System.out.println("To go back to menu press 8: ");
                    menu = scannerInput.nextInt();
                case 6:
                    //Log out
                    break;
                case 7:
                    //shut down
                    break;
                case 8:
                    //print menu again
                    System.out.println(admin.printMenu());
                    System.out.println("Enter the number of what you want to do: ");
                    menu = userInput.nextInt();
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

    //getters, setters
    public String getCurrentUser() {
        return currentUser;
    }

}
