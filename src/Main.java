/**
 * @author Madeleine Hallqvist, Lucie Saad
 * */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        runProgram();
    }

    public static void runProgram(){
        System.out.println("Welcome to Saad and Hallqvist Payroll system!");
        LoginAdmin();
    }
    public static void LoginAdmin(){
        Scanner input = new Scanner(System.in);
        String newUser = "";
       Admin admin = new Admin(0, 2000, "Administrator");
       while (!newUser.equals(admin.getUsername())){
           System.out.print("Enter Username: ");
           String username = input.nextLine();
           newUser = checkUsername(username);
           System.out.println(newUser);
           if(newUser.equals(admin.getUsername())){
               System.out.println(newUser);
               break;
           }
       }
    }
    private static String checkUsername(String username) {
        Admin admin = new Admin(0, 2000, "Administrator");
        String wrong = "Try again";
            if (username.equals(admin.getUsername())) {
                return username;
            } else if (username.equals(null)) {
                return wrong;
            } else {
                return wrong;
            }

    }

}
