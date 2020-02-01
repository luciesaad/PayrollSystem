import java.util.Scanner;

public class User extends Account implements MenuInterFace {
    private Utils utils = Utils.getInstance();
    private int requestedSalary;
    private String requestedRole;

    /**
     * constructor for User, takes in 5 params and initializes int requestedSalary and String requestedROle
     * @param username String for username
     * @param password String for password
     * @param accountBalance int for account balance
     * @param salary int for current salary
     * @param employmentRole String for role/position
     */
    public User(String username, String password, int accountBalance, int salary, String employmentRole) {
        super(username, password, accountBalance, salary, employmentRole);
        this.requestedSalary = 0;
        this.requestedRole = "";
    }

    /**
     * method printMenu() prints out user menu
     * @return String with user menu
     */
    public String printMenu(){
        return  "1 - View Account \n" +
                "2 - Request change of salary \n" +
                "3 - Request change of role \n" +
                "4 - Delete My Account \n" +
                "5 - Log out \n" +
                "6 - Turn off program  \n" +
                "7 - Back to Menu ";
    }

    /**
     * method viewAccount() prints current account status for the logged in user, inkl. balance, role, salary
     * @param currentUser String representing the logged in user
     */
    public void viewAccount(String currentUser){
        //loop through all existing users, then print info for the logged in one('currentUser')
        for(int i  = 0; i < getUsers().size(); i++){
            if(currentUser.equals(getUsers().get(i).getUsername())){
                System.out.println("Account user: " + getUsers().get(i).getUsername());
                System.out.println("Account balance: " + getUsers().get(i).getAccountBalance());
                System.out.println("Employment role: " + getUsers().get(i).getEmploymentRole());
                System.out.println("Salary: " + getUsers().get(i).getSalary());
            }
        }
    }

    /**
     * method requestChangeSalary() enables the user to request a new salary
     * takes input of int and runs setRequestedSalary
     */
    public void requestChangeSalary(){
        Scanner scanner = utils.getScanner();
        System.out.println("You are applying for a change of salary. Please enter your desired salary: ");
        int newSalaryRequest = scanner.nextInt();
        setRequestedSalary(newSalaryRequest);
        System.out.println("Your request for a change of salary has been sent to Administrator.");
    }
    /**
     * method requestChangeRole() enables the user to request a new role
     * takes input of String and runs setRequestedRole
     */
    public void requestChangeRole(){
        Scanner scanner = utils.getScanner();
        System.out.println("You are applying for a change of role. Please enter your new role: ");
        String newRoleRequest = scanner.next();
        setRequestedRole(newRoleRequest);
        System.out.println("Your request for a change of role has been sent to Administrator.");
    }

    /**
     * method deleteMyAccount() enables user to delete his own account
     * takes in user input for username and password that must match AND must belong to the logged in user
     * @return boolean deletion successful - return true, else return false
     * catches NoSuchField exception if entered user not found
     */
    public boolean deleteMyAccount(){
        Scanner scanner = utils.getScanner();
        boolean deleted = false;
        //user's role cannot be an administrator if deletion is to succeed
        if(!getEmploymentRole().equals("Administrator")){
            //ask for username and password
            System.out.println("To delete your account, please enter your username: ");
            String enteredUsername = scanner.next();
            System.out.println("Please enter your password: ");
            String enteredPsw = scanner.next();
            try{
                //set user to current user
                User user = getUser(StartProgram.currentUser);

                //check if given username matches the current user. If so - set user to the entered username.
                // -> user can only delete him-/herself
                if(StartProgram.currentUser.equals(enteredUsername)){
                    user = getUser(enteredUsername);
                }

                //check if password matches
                if(user.getPsw().equals(enteredPsw)){
                    //remove user from the list and log out
                    getUsers().remove(getIndex(enteredUsername));
                    System.out.println("User " + enteredUsername + " has been deleted. Logging out...");
                    deleted = true;
                    return deleted;
                }else{
                    //if password doesn't match, deletion fails and user can return back to menu.
                    System.out.println("Deletion failed. Incorrect password.");
                }
            }catch (NoSuchFieldException e) { //user has not been found. Show menu again.
                System.out.println("User not found! Deletion failed.");
                printMenu();
            }
        }
        return deleted;
    }

    //getters and setters

    /**
     * getter for requested salary
     * @return int requestedSalary
     */
    public int getRequestedSalary() {
        return requestedSalary;
    }

    /**
     * setter for requested salary
     * @param requestedSalary int representing desired salary
     */
    public void setRequestedSalary(int requestedSalary) {
        this.requestedSalary = requestedSalary;
    }

    /**
     * getter for requested role
     * @return String requestedRole
     */
    public String getRequestedRole() {
        return requestedRole;
    }

    /**
     * setter for requested role
     * @param requestedRole String representing desired role
     */
    public void setRequestedRole(String requestedRole) {
        this.requestedRole = requestedRole;
    }

}
