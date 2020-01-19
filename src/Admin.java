import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account  {

    private static ArrayList<User> users = new ArrayList<User>();

    public Admin(int accountBalance, int salary, String employmentRole) {
        super("admin1", "admin1234", accountBalance, salary, employmentRole);
    }

    private int getIndex(String username) throws NoSuchFieldException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        throw new NoSuchFieldException("User not found!");
    }

    private User getUser(String username) throws NoSuchFieldException {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        throw new NoSuchFieldException("User not found!");
    }

    public void createUser(String username, String password, int accountBalance, int salary, String employmentRole) {
        User newUser = new User(username, password, accountBalance, salary, employmentRole);
        users.add(newUser);
    }

    public void deleteUser(String username) {
        int userIndex ;
        try {
            userIndex = getIndex(username);
            users.remove(userIndex);
        } catch (NoSuchFieldException e) {
            System.out.println("Could not delete user! Errormessage: " + e.getMessage());
        }
    }


    public String requestedUserSalary(String username){
        int newSalary ;
        String request ="";
        Scanner input = new Scanner(System.in);
        try {
            User user = getUser(username);
            newSalary =  user.getRequestedSalary();
               System.out.println("approve salary y/n: ");
               String check = input.nextLine();
                if(check.equals( "y" )|| check.equals("Y")){
                    user.setSalary(newSalary);
                    request = "Your salary has been approved";
                    return request;
                }
                else {
                    request = "Your salary request has been declined ";
                    return request;
                }

        } catch (NoSuchFieldException e){
            System.out.println("Could not delete user! Errormessage: " + e.getMessage());
        }
        return request;
    }
}
