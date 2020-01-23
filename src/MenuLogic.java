import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuLogic {

    private static StartProgram startProgram = new StartProgram();
    private Scanner menulogic = new Scanner(System.in);

    public void createUser() {
        String userName = createUsername();
        String userPsw = createUserPsw();
        String employmentRole = createUserEmployment();
        int userAccountBalance = createUserAccountBalance();
        int userSalary = createUserSalary();
        startProgram.getAdmin().createUser(userName, userPsw, userAccountBalance, userSalary, employmentRole);
    }
    private String createUsername(){
      try {
          System.out.println("Enter username: ");
          return menulogic.nextLine();
      }catch (InputMismatchException e){
          return  "That’s not "
                  + "an String. Try again: ";
      }
    }

    private String createUserPsw(){
        try{
            System.out.println("Enter Password: ");
            return menulogic.nextLine();
        }
        catch (InputMismatchException e){
            return "That´s not an String. Try again: ";
        }
    }

    private int createUserAccountBalance(){
        try{
            System.out.println("Enter Account balance: ");
            return menulogic.nextInt();

        }catch (InputMismatchException e){
            System.out.println("That´s not an Int. Try again: ");
            return 0;
        }
    }

    private int createUserSalary(){
        try{
            System.out.println("Enter salary: ");
           return menulogic.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("That´s not an Int. Try again: ");
            return 0;
        }
    }

    private String createUserEmployment(){
        try{

            System.out.println("Enter Employment role: ");
            return menulogic.nextLine();
        }
        catch (NoSuchElementException e){
            return "That´s not an String. Try again: ";
        }
    }
}
