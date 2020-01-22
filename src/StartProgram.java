import java.util.Scanner;

public class StartProgram {

    private Admin admin = new Admin(0, 20000, "Administrator");

    public void runProgram() {
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
        loginAdmin();
        // Get user input
        // If Admin -> create user, change payroll, delete user
    }

    private void loginAdmin() {
        Scanner input = new Scanner(System.in);
        boolean loginDone = false;
        while (!loginDone){
            System.out.print("Enter Username: ");
            String username = input.nextLine();
            System.out.print("Enter Password: ");
            String password = input.nextLine();

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
}
