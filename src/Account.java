public abstract class Account {

    private String username;
    private String psw;
    private int accountBalance;
    private int salary;
    private String employmentRole;


    public Account(String username, String password, int accountBalance, int salary, String employmentRole) {
        this.username = username;
        this.psw = password;
        this.accountBalance = accountBalance;
        this.salary = salary;
        this.employmentRole = employmentRole;
    }

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
}
