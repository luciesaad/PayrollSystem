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
        int userIndex;
        try {
            userIndex = getIndex(username);
            getUsers().remove(userIndex);
        } catch (NoSuchFieldException e) {
            System.out.println("Could not delete user! Errormessage: " + e.getMessage());
        }
    }

    public void checkUserRequests() {
        int newSalary;
        String newRole;
        Scanner input = new Scanner(System.in);

        //call getAllSalaryRequests() to get list of names of all who requested salary update - if not empty, continue
        if (getAllRequests().size() > 0) {
            System.out.println("There are " + getAllRequests().size() + " requests pending: ");

            //go through all requests and either approve or do not approve them
            for (int i = 0; i < getAllRequests().size(); i++) {
                try {
                    User user = getUser(getAllRequests().get(i));
                    //if user applied for salary change
                    if (user.getRequestedSalary()>0){
                        newSalary = user.getRequestedSalary();
                        System.out.println("User " + user.getUsername() + " has requested to update salary to: " + newSalary);
                        System.out.println("Approve new salary? (y/n): ");
                        String check = input.nextLine();
                        if (check.equals("y") || check.equals("Y")) {
                            user.setSalary(newSalary);
                            System.out.println(user.getUsername() + "'s salary has been updated!");
                        }else{
                            System.out.println(user.getUsername() + "'s new salary not approved!");
                        }
                        //if user applied for role change
                    }else if(!user.getRequestedRole().equals("")){
                        newRole = user.getRequestedRole();
                        System.out.println("User " + user.getUsername() + " has requested to update role to: " + newRole);
                        System.out.println("Approve new role? (y/n): ");
                        String check = input.nextLine();
                        if (check.equals("y") || check.equals("Y")) {
                            user.setEmploymentRole(newRole);
                            System.out.println(user.getUsername() + "'s role has been updated!");
                        }else{
                            System.out.println(user.getUsername() + "'s new role not approved!");
                        }
                    }

                } catch (NoSuchFieldException e) {
                    System.out.println("User not found! Errormessage: " + e.getMessage());
                }
            }
            //remove all salary requests that have been approved or dismissed
            getAllRequests().clear();
        } else {
            System.out.println("No requests found!");
        }
    }

//TODO: this method is a bit redundant (only good to check how many requests are there in total) - worthy?
    public ArrayList<String> getAllRequests(){
        int newSalary;
        String newRole;
        ArrayList<String> requestArrList = new ArrayList<>();

        //loop that gets all users that requested salary
        for(int i = 0; i < getUsers().size(); i++){
            User user = getUsers().get(i);
            newSalary = user.getRequestedSalary();
            newRole = user.getRequestedRole();

            if(newSalary != 0 || !newRole.equals("")){
                requestArrList.add(user.getUsername());
            }
        }
        return requestArrList;
    }

    public void viewAccount(){
        menuLogic.viewAdminAccount();
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

     public ArrayList<User> getArrayUsers(){
        return getUsers();
     }
}
