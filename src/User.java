
public class User extends Account  {
    private int requestedSalary;

    public User(String username, String password, int accountBalance, int salary, String employmentRole) {
        super(username, password, accountBalance, salary, employmentRole);
       this.requestedSalary = 0;
    }

    public int getRequestedSalary() {
        return requestedSalary;
    }


}
