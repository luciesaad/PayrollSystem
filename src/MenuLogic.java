import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuLogic {

    private static StartProgram startProgram = new StartProgram();
    private String userName;
    private String userPsw;
    private String employmentRole;
    private int userAccountBalance;
    private int userSalary;

    public boolean createUser() {
       boolean userCreated = false;
        userName = createUsernameInput();
        userPsw = createUserPswInput();
        employmentRole = createUserEmployment();
        userAccountBalance = createUserAccountBalance();
        userSalary = createUserSalary();

        while (!userCreated) {
            //Check if input is empty or mismatch, ask to input again. 
            if(userName.equals("Please enter correct username!") || userName.isEmpty()){
              System.out.println(userName);
              createUsernameInput();
            }else if(userPsw.equals("Please enter correct password!") || userPsw.isEmpty()){
                System.out.println(userPsw);
                createUserPswInput();
            }else if(employmentRole.equals("Please enter correct employment role!") || employmentRole.isEmpty()){
                System.out.println(employmentRole);
                createUserEmployment();
            }else if(userAccountBalance == -1){
                System.out.println("Please enter correct account balance!");
                createUserAccountBalance();
            }else if(userSalary == -1){
                System.out.println("Please enter correct salary!");
                createUserSalary();
            }
            else {
                startProgram.getAdmin().createUser(userName, userPsw, userAccountBalance, userSalary, employmentRole);
                System.out.println("User " +  startProgram.getAdmin().printUserName(userName)+ " was created");
                userCreated = true;
            }
        }
        return false;
    }

    protected String createUsernameInput(){
        Scanner inputUser = new Scanner(System.in);
       try{
            System.out.println("Enter username: ");
           userName = inputUser.nextLine();
           if(userName.isEmpty() || userName.isBlank()){
               throw new InputMismatchException();
           }
           return userName;
      }catch (InputMismatchException e){
           userName = "Please enter correct username!";
          return userName ;
      }
    }

    protected String createUserPswInput(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter Password: ");
            userPsw = inputUser.nextLine();
            if(userPsw.isEmpty() || userPsw.isBlank()){
                throw new InputMismatchException();
            }
            return userPsw;
        }
        catch (InputMismatchException e){
            userPsw = "Please enter correct password!";
            return userPsw;
        }
    }

    protected int createUserAccountBalance(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter Account balance: ");
            String inValue = inputUser.nextLine();
            userAccountBalance = Integer.parseInt(inValue);
            if(inValue.equals("")){
                throw new NumberFormatException();
            }
            return userAccountBalance;

        }catch (NumberFormatException e){
            return -1;
        }
    }

    protected int createUserSalary(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter salary: ");
            String inValue = inputUser.nextLine();
            userSalary = Integer.parseInt(inValue);
            if (inValue.equals("")){
                throw new NumberFormatException();
            }
           return userSalary;
        }
        catch (NumberFormatException e){
            return -1;
        }
    }

    protected String createUserEmployment(){
        Scanner inputUser = new Scanner(System.in);
        try{
            System.out.println("Enter Employment role: ");
            employmentRole = inputUser.nextLine();
            if(employmentRole.isEmpty() || employmentRole.isBlank()){
                throw new InputMismatchException();
            }
            return employmentRole;
        }
        catch (InputMismatchException e){
            employmentRole = "Please enter correct employment role!";
            return employmentRole;
        }
    }
}
