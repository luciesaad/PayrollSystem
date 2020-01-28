import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateUserLogic {
    private String userName;
    private String employmentRole;
    private int userAccountBalance;
    private int userSalary;
    private String userPsw;
    private static StartProgram startProgram = new StartProgram();
    protected String setUsernameInput(){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Enter username: ");
        userName = inputUser.nextLine();
        return userName;
    }

    public void checkUserNameInput(String username){
        if(inputIsEmpty(username)){
            throw new InputMismatchException("Username can´t be empty ");
        }else if(!startProgram.hasCorrectLength(username)){
            throw new InputMismatchException("Username value must have 6-10 characters. Please try again ");
        }else if(!startProgram.hasLetterNumCombo(username)){
            throw new InputMismatchException("Username must contain both letters and numbers. Please try again!");
        }else if(startProgram.usersNameMatches(username)){
            throw new InputMismatchException("please choose another username");
        }
    }

    protected boolean createUserName() throws InputMismatchException{
        String userName = setUsernameInput();
        try{
            checkUserNameInput(userName);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    protected String setUserPswInput(){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Enter Password: ");
        userPsw = inputUser.nextLine();
        return userPsw;
    }

    protected void checkUserPsw(String userPsw){
        if(inputIsEmpty(userPsw)){
            throw new InputMismatchException("Password can´t be empty ");
        }else if(!startProgram.hasCorrectLength(userPsw)){
            throw new InputMismatchException("Password value must have 6-10 characters. Please try again ");
        }else if(!startProgram.hasLetterNumCombo(userPsw)){
            throw new InputMismatchException("Password must contain both letters and numbers. Please try again!");
        }
    }

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

    protected String setUserAccountBalance(){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Enter Account balance: ");
        String account = inputUser.nextLine();
        return account;
    }
    protected void checkUserAccountBalance(String account){
        if(inputIsEmpty(account)){
            throw new InputMismatchException("Account balance can´t be blank ");
        }else if(!hasNumber(account)){
            throw new InputMismatchException("Account balance can´t be letters, please only enter numbers");
        }else if(startProgram.hasLetterNumCombo(account)){
            throw new InputMismatchException("Account balance can only be numbers, please try again!");
        }
    }

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
    protected String setUserSalary(){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Enter salary: ");
        return inputUser.nextLine();
    }
    protected void checkUserSalary(String userSalary){
        if(inputIsEmpty(userSalary)){
            throw new InputMismatchException("Salary can´t be blank");
        }else if(!hasNumber(userSalary)){
            throw new InputMismatchException("Salary can´t be letters, please only enter numbers");
        }else if(startProgram.hasLetterNumCombo(userSalary)){
            throw new InputMismatchException("Salary can´t be numbers and letters, please enter only numbers!");
        }
    }

    protected boolean createUserSalary() throws InputMismatchException{
        String salary = setUserSalary();
        try {
            checkUserSalary(salary);
            userSalary += Integer.parseInt(salary);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }
    protected String setUserEmployment(){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Enter Employment role: ");
        employmentRole = inputUser.nextLine();
        return employmentRole;
    }

    protected void checkUserEmployment(String role){
        if(inputIsEmpty(role)){
            throw new InputMismatchException("Employment role can´t be empty ");
        }else if(role.equals("admin")){
            throw new InputMismatchException("Employment role can´t be admin ");
        }else if(startProgram.hasLetterNumCombo(role)){
            throw new InputMismatchException("Employment role can´t contain both letters and numbers. Please try again!");
        }
    }

    protected boolean createUserEmployment() throws InputMismatchException{
        String role = setUserEmployment();
        try{
            checkUserEmployment(role);
            return true;
        }catch (InputMismatchException e){
            throw e;
        }
    }

    protected boolean inputIsEmpty(String checkInput){
        return checkInput.isEmpty() || checkInput.isBlank();
    }
    protected boolean hasNumber(String checkInput) {
        StringBuilder sb = new StringBuilder();
        for (char c : checkInput.toCharArray()) {      //for each char in char array from input, do following:
            if (Character.isDigit(c)) {           //check if one of chars is a number
                sb.append(c);
                return true;
            }else if (Character.isLetter(c)) {
                sb.append(c);
                return false;
            }
        }
        return false;
    }
    protected String getUserName() {
        return userName;
    }
    protected String getUserPsw() {
        return userPsw;
    }
    protected int getUserAccountBalance() {
        return userAccountBalance;
    }

    protected int getUserSalary() {
        return userSalary;
    }
    protected String getEmploymentRole() {
        return employmentRole;
    }
}
