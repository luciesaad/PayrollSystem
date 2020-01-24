import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Admin extends Account implements MenuInterFace {

    private static ArrayList<User> users = new ArrayList<>();

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

    public User getUser(String username) throws NoSuchFieldException {

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

    public void printAllUsers(){
       for(int i = 0; i < users.size(); i++){
           System.out.println(users.get(i).getUsername());
       }
     }

     public void viewAccount(){
      System.out.println( "Account user: " + getUsername());
      System.out.println("Account balance: " + getAccountBalance());
      System.out.println("Employment role: " + getEmploymentRole());
      System.out.println("Salary: " + getSalary());
     }

     @Override
     public void printMenu(){
        System.out.println("1 - View Account \n" +
                         "2 - Create User \n" +
                        "3 - See Users \n" +
                        "4 - Requests \n" +
                        "5 - Pay salary \n" +
                        "6 - Log out \n" +
                        "7 - Turn off program \n" +
                        "8 - See Menu again");
     }


}
