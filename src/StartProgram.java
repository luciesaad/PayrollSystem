import java.util.Scanner;

public class StartProgram {

    public Admin getAdmin() {
        return admin;
    }

    private Admin admin = new Admin(0, 20000, "Administrator");
    private Scanner userInput = new Scanner(System.in);
    private User user = new User("madde","madde1",0,30000,"Programmer");

    public void runProgram() {
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
       // loginAdmin();
        printMenuAdmin();
    }

    private void loginAdmin() {
        boolean loginDone = false;
        while (!loginDone){
            System.out.print("Enter Username: ");
            String username = userInput.nextLine();
            System.out.print("Enter Password: ");
            String password = userInput.nextLine();

            if(!usernameMatches(username)){
                checkInputConditions(username);
            }else{
                if(pswMatches(password)){
                    loginDone = true;
                    System.out.println("Welcome " + username);
                }else{
                    checkInputConditions(password);
                }
            }
        }
    }

    private boolean usernameMatches(String match){
        return match.equals(admin.getUsername());
    }
    private boolean pswMatches(String match){
        return match.equals(admin.getPsw());
    }

    private void checkInputConditions(String input) {
        String wrong = "Try again";
        if (input.isEmpty()) {
            System.out.println(wrong);
        } else if(!hasCorrectLength(input)){
            System.out.println("Input value must have 6-10 characters. Please try again: ");
        }else if(!hasLetterNumCombo(input)){
            System.out.println("Input value must contain both letters and numbers. Please try again:");
        } else {
            System.out.println("Your authentication information is incorrect. Please try again.");
        }
    }

    private boolean hasCorrectLength(String input){
        if(input.length() < 6 || input.length() > 10){
            return false;
        }
        return true;
    }

    private boolean hasLetterNumCombo(String input){
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
        // if we find at least one digit and one letter, stop looping and return true
        // if combo not found, return false
        return (numFound && letterFound);
    }

    public void printMenuAdmin(){
        int menu = 0;
        System.out.println("Menu: ");
        admin.printMenu();
        System.out.println("Enter the menu number of what you want to do: ");
        while(menu != 7) {
             menu = userInput.nextInt();

            switch (menu) {
                case 1:
                    //view Account
                    admin.viewAccount();
                    System.out.print("To go back to the menu press 8: ");
                case 2:
                    //Create User
                    createUserByAdmin();
                case 3:
                    //See Users
                case 4:
                    //Requests
                case 5:
                    //Pay Salary
                case 6:
                    //Log out
                case 7:
                    //shut down
                    break;
                case 8:
                    //print menu again
                    admin.printMenu();
                    System.out.println("Enter the number of what you want to do: ");
            }
        }
        userInput.close();
    }

    public void createUserByAdmin(){
        System.out.println("Enter username: ");
        String userName = userInput.next();
        System.out.println("Enter Password: ");
        String userPsw = userInput.next();
        System.out.println("Enter Account balance: ");
        int userAccountBalance = userInput.nextInt();
        System.out.println("Enter salary: ");
        int userSalary = userInput.nextInt();
        System.out.println("Enter Employment role: ");
        String employmentRole = userInput.nextLine();






        admin.createUser(userName,userPsw,userAccountBalance, userSalary, employmentRole);
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
            case 6:
                //Print Menu again
                user.printMenu();
        }

        userInput.close();

    }
}
