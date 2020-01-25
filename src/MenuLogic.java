import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuLogic {

    private static StartProgram startProgram = new StartProgram();

    public boolean createUser() {
       boolean userCreated = false;
        while (!userCreated) {
            String userName = createUsernameInput();
            String userPsw = createUserPswInput();
            String employmentRole = createUserEmployment();
            int userAccountBalance = createUserAccountBalance();
            int userSalary = createUserSalary();

            if(checkInput(userName, userPsw)){
                startProgram.getAdmin().createUser(userName, userPsw, userAccountBalance, userSalary, employmentRole);
                System.out.print("User " +  startProgram.getAdmin().printUserName(userName)+ " was created");
                userCreated = true;
            }
        }
        return false;
    }

    protected boolean checkInput(String username, String userPsw){

        //Kollar om input är empty
        //Kollar om
        return !username.isEmpty() && !userPsw.isEmpty();
    }

    protected String createUsernameInput(){
        Scanner inputUser = new Scanner(System.in);
        try {
            System.out.println("Enter username: ");
            String input = inputUser.nextLine();
            if(input.isEmpty()){
                throw  new InputMismatchException();
            }
          return input;
      }catch (InputMismatchException e){
          System.out.print( "Please enter valid username: ");
          return  "Please enter valid username:";
      }
    }

    protected String createUserPswInput(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter Password: ");
            return inputUser.nextLine();
        }
        catch (InputMismatchException e){
            return "That´s not an String. Try again: ";
        }
    }

    protected int createUserAccountBalance(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter Account balance: ");
            String inValue = inputUser.nextLine();
            int returnValue = Integer.parseInt(inValue);
            return returnValue;

        }catch (InputMismatchException e){
            System.out.println("That´s not an Int. Try again: ");
            return -1;
        }
    }

    protected int createUserSalary(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter salary: ");
            String inValue = inputUser.nextLine();
            int returnValue = Integer.parseInt(inValue);
           return returnValue;
        }
        catch (InputMismatchException e){
            System.out.println("That´s not an Int. Try again: ");
            return -1;
        }
    }

    protected String createUserEmployment(){
        Scanner inputUser = new Scanner(System.in);
        try{

            System.out.println("Enter Employment role: ");
            return inputUser.nextLine();
        }
        catch (NoSuchElementException e){
            return "That´s not an String. Try again: ";
        }
    }
}
