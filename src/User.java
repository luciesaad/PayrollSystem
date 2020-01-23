
public class User extends Account implements MenuInterFace {
    private int requestedSalary;

    public User(String username, String password, int accountBalance, int salary, String employmentRole) {
        super(username, password, accountBalance, salary, employmentRole);
       this.requestedSalary = 0;
    }

    public int getRequestedSalary() {
        return requestedSalary;
    }


    public void printMenu(){
        System.out.println("1 - View Account \n" +
                "2 - Request change of salary \n" +
                "3 - Request change of role \n" +
                "4 - Log out \n" +
                "6 - Turn off program  \n" +
                "7 - See Menu again ");
    }

    public void viewAccount(){
        System.out.print("hej");
    }
}
