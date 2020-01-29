import java.util.ArrayList;

public abstract class Account {
    private String username;
    private String psw;
    private int accountBalance;
    private int salary;
    private String employmentRole;
    private static ArrayList<User> users = new ArrayList<>();

    public Account(String username, String password, int accountBalance, int salary, String employmentRole) {
        this.username = username;
        this.psw = password;
        this.accountBalance = accountBalance;
        this.salary = salary;
        this.employmentRole = employmentRole;
    }

    public void setPsw(String psw) {this.psw = psw; }
    public void setUsername(String username) {this.username = username; }

    public String getUsername() {
        return username;
    }

    public String getPsw() {
        return psw;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmploymentRole() {
        return employmentRole;
    }

    public void setEmploymentRole(String employmentRole) {
        this.employmentRole = employmentRole;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    //static methods for finding user in arraylist - getIndex, getUser
    public static int getIndex(String username) throws NoSuchFieldException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        throw new NoSuchFieldException("User not found!");
    }

    public static User getUser(String username) throws NoSuchFieldException {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        throw new NoSuchFieldException("User not found!");
    }
}
