import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateUserLogic {
    private String userName;
    private String employmentRole;
    private int userAccountBalance;
    private int userSalary;
    private String userPsw;
    private static Utils utils = Utils.getInstance();

    /**This method takes in admin input for creating a user username
     * @return String username*/
    protected String setUsernameInput(){
        Scanner scanner = utils.getScanner();
        System.out.println("Enter username: ");
        userName = scanner.nextLine();
        return userName;
    }

    /**This method checks the input so the value is ok, if not it throws a Exception
     * @exception InputMismatchException throws exception message*/
    public void checkUserNameInput(String username){
        if(inputIsEmpty(username)){
            throw new InputMismatchException("Username can´t be empty ");
        }else if(!utils.hasCorrectLength(username)){
            throw new InputMismatchException("Username value must have 6-10 characters. Please try again ");
        }else if(!utils.hasLetterNumCombo(username)){
            throw new InputMismatchException("Username must contain both letters and numbers. Please try again!");
        }else if(utils.usersNameMatches(username)){
            throw new InputMismatchException("please choose another username");
        }
    }

    /**This method returns true if username is ok if not it throws the exception
     * @return  exception or true*/
    protected boolean createUserName() throws InputMismatchException{
        String userName = setUsernameInput();
        try{
            checkUserNameInput(userName);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**The method takes the admin input for password and returns the input
     * @return userPsw*/
    protected String setUserPswInput(){
        Scanner scanner = utils.getScanner();
        System.out.println("Enter Password: ");
        userPsw = scanner.nextLine();
        return userPsw;
    }

    /**The method checks the input and throws exception if not ok
     * @exception InputMismatchException exception message*/
    protected void checkUserPsw(String userPsw){
        if(inputIsEmpty(userPsw)){
            throw new InputMismatchException("Password can´t be empty ");
        }else if(!utils.hasCorrectLength(userPsw)){
            throw new InputMismatchException("Password value must have 6-10 characters. Please try again ");
        }else if(!utils.hasLetterNumCombo(userPsw)){
            throw new InputMismatchException("Password must contain both letters and numbers. Please try again!");
        }
    }

    /**The method throws exception or returns true if its ok
     * @return true or throws exception message*/
    protected boolean createUserPsw() throws InputMismatchException{
        String userPsw = setUserPswInput();
        try {
            checkUserPsw(userPsw);
            return true;
        }
        catch (InputMismatchException e){
            throw   e;
        }
    }

    /**This method takes admin input and returns the value
     * @return account*/
    protected String setUserAccountBalance(){
        Scanner scanner = utils.getScanner();
        System.out.println("Enter Account balance: ");
        String account = scanner.nextLine();
        return account;
    }

    /**The method checks if account balance input is ok, if not throws a exception*/
    protected void checkUserAccountBalance(String account){
        if(inputIsEmpty(account)){
            throw new InputMismatchException("Account balance can´t be blank ");
        }else if(utils.hasLetterNumCombo(account)){
            throw new InputMismatchException("Account balance can only be numbers, please try again!");
        }else if(utils.checkIntSize(account)){
            throw new NumberFormatException("Account value can´t be that much");
        }
    }

    /**The method throws a exception or returns true. Depending on of checkUserAccountBalance
     * throws exception or not*/
    protected boolean createUserAccountBalance() throws InputMismatchException{
        String userAccountBalances = setUserAccountBalance();
        try{
            checkUserAccountBalance(userAccountBalances);
            userAccountBalance += Integer.parseInt(userAccountBalances);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**The method takes admin input and returns the value*/
    protected String setUserSalary(){
        Scanner scanner = utils.getScanner();
        System.out.println("Enter salary: ");
        return scanner.nextLine();
    }

    /**The method checks if salary value is not ok. If not it throws a exception*/
    protected void checkUserSalary(String userSalary){
        if(inputIsEmpty(userSalary)){
            throw new InputMismatchException("Salary can´t be blank");
        }else if(utils.hasLetterNumCombo(userSalary)){
            throw new InputMismatchException("Salary can´t be numbers and letters, please enter only numbers!");
        }else if(utils.checkIntSize(userSalary)){
            throw new NumberFormatException("Salary can´t be that much");
        }
    }

    /**The method runs check method and throws exception or returns true*/
    protected boolean createUserSalary() throws InputMismatchException, NumberFormatException{
        String salary = setUserSalary();
        try {
            checkUserSalary(salary);
            userSalary += Integer.parseInt(salary);
            return true;
        }catch (InputMismatchException | NumberFormatException e){
            throw e;
        }
    }

    /**The method takes admin input and returns the value*/
    protected String setUserEmployment(){
        Scanner scanner = utils.getScanner();
        System.out.println("Enter Employment role: ");
        employmentRole = scanner.nextLine();
        return employmentRole;
    }

    /**The method checks the input value and if not ok throws a exception*/
    protected void checkUserEmployment(String role){
        if(inputIsEmpty(role)){
            throw new InputMismatchException("Employment role can´t be empty ");
        }else if(role.equals("admin")){
            throw new InputMismatchException("Employment role can´t be admin ");
        }else if(utils.hasLetterNumCombo(role)){
            throw new InputMismatchException("Employment role can´t contain both letters and numbers. Please try again!");
        }
    }

    /**The method throws a exception or returns true depending on if checkUserEmployment
     * throws exception or not*/
    protected boolean createUserEmployment() throws InputMismatchException{
        String role = setUserEmployment();
        try{
            checkUserEmployment(role);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    /**Checks so input is not empty or blank*/
    protected boolean inputIsEmpty(String checkInput){
        return checkInput.isEmpty() || checkInput.isBlank();
    }

    /**getters*/
    protected String getUserName() {return userName;}
    protected String getUserPsw() {return userPsw;}
    protected int getUserAccountBalance() {return userAccountBalance;}
    protected int getUserSalary() {return userSalary;}
    protected String getEmploymentRole() {return employmentRole;}
}
