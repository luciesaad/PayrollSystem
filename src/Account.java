public abstract class Account {
    private int accountBalance;
    private int salary;
    private String employmentRole;


    public Account(int accountBalance, int salary, String employmentRole) {
        this.accountBalance = accountBalance;
        this.salary = salary;
        this.employmentRole = employmentRole;
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
