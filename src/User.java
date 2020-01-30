import java.util.Scanner;

public class User extends Account implements MenuInterFace {
    private Scanner scan = new Scanner(System.in);
    private int requestedSalary;
    private String requestedRole;

    public User(String username, String password, int accountBalance, int salary, String employmentRole) {
        super(username, password, accountBalance, salary, employmentRole);
        this.requestedSalary = 0;
        this.requestedRole = "";
    }


    //prints menu for user
    public String printMenu(){  //update: added delete my account(requirement)
        return  "1 - View Account \n" +
                "2 - Request change of salary \n" +
                "3 - Request change of role \n" +
                "4 - Delete My Account \n" +
                "5 - Log out \n" +
                "6 - Turn off program  \n" +
                "7 - Back to Menu ";
    }

    public void viewAccount(String currentUser){
        for(int i  = 0; i < getUsers().size(); i++){
            if(currentUser.equals(getUsers().get(i).getUsername())){
                System.out.println("Account user: " + getUsers().get(i).getUsername());
                System.out.println("Account balance: " + getUsers().get(i).getAccountBalance());
                System.out.println("Employment role: " + getUsers().get(i).getEmploymentRole());
                System.out.println("Salary: " + getUsers().get(i).getSalary());
            }
        }
    }

    public void requestChangeSalary(){
        System.out.println("You are applying for a change of salary. Please enter your desired salary: ");
        int newSalaryRequest = scan.nextInt();
        setRequestedSalary(newSalaryRequest);
        System.out.println("Your request for a change of salary has been sent to Administrator.");
    }

    public void requestChangeRole(){
        System.out.println("You are applying for a change of role. Please enter your new role: ");
        String newRoleRequest = scan.next();
        setRequestedRole(newRoleRequest);
        System.out.println("Your request for a change of role has been sent to Administrator.");
    }

    public boolean deleteMyAccount(){
        boolean deleted = false;
        //user's role cannot be an administrator
        if(!getEmploymentRole().equals("Administrator")){
            //ask for username
            System.out.println("To delete your account, please enter your username: ");
            String enteredUsername = scan.next();

            try{
                System.out.println("Please enter your password: ");
                String enteredPsw = scan.next();

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
                    //TODO: write a logout function
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
    public int getRequestedSalary() {
        return requestedSalary;
    }
    public void setRequestedSalary(int requestedSalary) {
        this.requestedSalary = requestedSalary;
    }
    public String getRequestedRole() {
        return requestedRole;
    }
    public void setRequestedRole(String requestedRole) {
        this.requestedRole = requestedRole;
    }

}
