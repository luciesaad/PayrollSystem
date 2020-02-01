import java.util.Scanner;

public class Utils {
    private static Utils singleInstance = null;
    private static Scanner scanner;
    private Admin admin;

    public static Utils getInstance() {
        if (singleInstance == null){
            singleInstance = new Utils();
        }
        return singleInstance;
    }

   public Utils(){
        admin = new Admin(0, 20000, "Administrator");
   }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    /**This method checks so that a username and password contains both char and number*/
    public boolean hasLetterNumCombo(String input){
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


    /**This method checks so that a username and password have the correct length*/
    public boolean hasCorrectLength(String input){
        if(input.length() < 6 || input.length() > 10){
            return false;
        }
        return true;
    }


    /**This method checks int input*/
    public boolean checkIntSize(String intToCheck){
        float check = Float.parseFloat(intToCheck);
        if(check >= 2147483646){
            return true;
        }else if(check <= -2147483646){
            return true;
        }
        else{
            return false;
        }
    }


    /**This method checks if admin username matches*/
    public boolean usersNameMatches(String match){return  match.equals(getAdmin().printUserName(match));}


}
