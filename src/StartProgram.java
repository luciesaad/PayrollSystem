import java.util.Scanner;

public class StartProgram {
    private MenuLogic menuLogic = new MenuLogic();
    private Admin admin = new Admin(0, 20000, "Administrator");
    private Scanner userInput = new Scanner(System.in);
    private User user = new User("testUser1","testUser12",0,30000,"Programmer"); //I guess we won't have this in the future?
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

    public void printMenuAdmin(){
        Scanner scannerInput = new Scanner(System.in);
        int menu = 0;
        System.out.println("Menu: ");
        admin.printMenu();
        System.out.println("Enter the menu number of what you want to do: ");
        menu = scannerInput.nextInt();
        while(menu != 7) {
            switch (menu) {
                case 1:
                    //view Account
                    admin.viewAccount();
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
                    //TODO: see if you got a request and what the user want to change
                case 5:
                    //Pay Salary
                    //TODO:be able to payout salary for the users
                    menuLogic.paySalary();
                    System.out.println("To go back to menu press 8: ");
                    menu = scannerInput.nextInt();
                case 6:
                    //Log out
                    //TODO:Be able to logout and login as user instead
                case 7:
                    //shut down
                    break;
                case 8:
                    //print menu again
                    admin.printMenu();
                    System.out.println("Enter the number of what you want to do: ");
                    menu = userInput.nextInt();
                    break;
            }
        }
    }



    public void printMenuUser(){
        System.out.println("Menu: ");
        user.printMenu();
        System.out.println("Enter the number of what you want to do: ");
        int userInputInt = userInput.nextInt();
        switch (userInputInt){
            case 1 :
                //view Account
            case 2:
                //Request change of salary
            case 3:
                //Request change of role
            case 4:
                //Log out
            case 5:
                //shut down
                break;
            case 6:
                //Print Menu again
                user.printMenu();
        }
        userInput.close();
    }

    //getters, setters
    public String getCurrentUser() {
        return currentUser;
    }
}
