public class Admin extends Account  {
    private String username = "admin1";
    private String psw = "admin1234";
    private int accountBalanceAdmin;
    private int salaryAdmin;
    private String employmentRoleAdmin;

    public Admin(int accountBalance, int salary, String employmentRole) {
        super(accountBalance, salary, employmentRole);
        this.employmentRoleAdmin = employmentRole;
        this.salaryAdmin = salary;
        this.accountBalanceAdmin = accountBalance;
    }

    public int getAccountBalanceAdmin() {
        return accountBalanceAdmin;
    }

    public int getSalaryAdmin() {
        return salaryAdmin;
    }

    public String getEmploymentRoleAdmin() {
        return employmentRoleAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPsw() {
        return psw;
    }




}
