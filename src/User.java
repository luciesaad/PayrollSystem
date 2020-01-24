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

    public void printMenu(){  //update: added delete my account(requirement)
        System.out.println(
                "1 - View Account \n" +
                "2 - Request change of salary \n" +
                "3 - Request change of role \n" +
                "4 - Delete My Account \n" +
                "5 - Log out \n" +
                "6 - Turn off program  \n" +
                "7 - Back to Menu ");
    }

    public void viewAccount(){
        System.out.println("Account user: " + getUsername());
        System.out.println("Account balance: " + getAccountBalance());
        System.out.println("Employment role: " + getEmploymentRole());
        System.out.println("Salary: " + getSalary());
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

    public void deleteMyAccount(){
        if(!getEmploymentRole().equals("Administrator")){
            //ask for username
            System.out.println("To delete your account, please enter your username: ");
            String enteredUsername = scan.next();

            //find username of the currently logged in person

                //can se move the users arraylist + get index + getUser() to the parent class???

            //implement 'getUser' method from Admin
            //ask for password - if correct -
            //get access to users array and delete the user
            //log out that user automatically -> welcome page
        }
    }

    //getters and setters
    public int getRequestedSalary() {
        return requestedSalary;
    }
    private void setRequestedSalary(int requestedSalary) {
        this.requestedSalary = requestedSalary;
    }
    public String getRequestedRole() {
        return requestedRole;
    }
    private void setRequestedRole(String requestedRole) {
        this.requestedRole = requestedRole;
    }

}
