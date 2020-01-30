import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Admin extends Account implements MenuInterFace {
    private static MenuLogic menuLogic = new MenuLogic();
    public Admin(int accountBalance, int salary, String employmentRole) {
        super("admin1", "admin1234", accountBalance, salary, employmentRole);
    }

    public void createUser(String username, String password, int accountBalance, int salary, String employmentRole) {
        User newUser = new User(username, password, accountBalance, salary, employmentRole);
        getUsers().add(newUser);
    }

    public void deleteUser(String username) {
        int userIndex ;
        try {
            userIndex = getIndex(username);
            getUsers().remove(userIndex);
        } catch (NoSuchFieldException e) {
            System.out.println("Could not delete user! Errormessage: " + e.getMessage());
        }
    }

    public String requestedUserSalary(String username){
        int newSalary;
        String request = "";
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
            System.out.println("Could not find a request! Errormessage: " + e.getMessage());
        }
        return request;
    }

    public void viewAccount(String user){
        System.out.println(menuLogic.viewAdminAccount(user));
    }

     public String printUserName(String user){
        for(int i = 0; i <User.getUsers().size(); i++){
            if(User.getUsers().get(i).getUsername().equals(user)){
                return User.getUsers().get(i).getUsername();
            }
        }
         return "Cant find user";
     }

     @Override
     public String printMenu(){
        return"1 - View Account \n" +
                         "2 - Create User \n" +
                        "3 - See Users \n" +
                        "4 - Requests \n" +
                        "5 - Pay salary \n" +
                        "6 - Log out \n" +
                        "7 - Turn off program \n" +
                        "8 - See Menu again";
     }

     public ArrayList<User> getArrayUsers(){
        return getUsers();
     }
}
