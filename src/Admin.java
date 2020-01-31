import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Admin class is a subclass of Account class, and implements interface MenuInterface
 */
public class Admin extends Account implements MenuInterFace {
    private static MenuLogic menuLogic = new MenuLogic();

    /**
     * constructor for Admin, super as reference to Account (superclass)
     * @param accountBalance int for accountBalance
     * @param salary int for salary
     * @param employmentRole String for role/position
     */
    public Admin(int accountBalance, int salary, String employmentRole) {
        super("admin1", "admin1234", accountBalance, salary, employmentRole);
    }

    /**
     * method createUser() 
     * @param username
     * @param password
     * @param accountBalance
     * @param salary
     * @param employmentRole
     * @return
     */
    public User createUser(String username, String password, int accountBalance, int salary, String employmentRole) {
        User newUser = new User(username, password, accountBalance, salary, employmentRole);
        getUsers().add(newUser);
        return newUser; //updated this method - to return User instead of void for testing purposes
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

    //method returns String for test purposes
    public String checkUserRequests() {
        int newSalary;
        String newRole, message;
        Scanner input = new Scanner(System.in);

        //call getAllSalaryRequests() to get list of names of all who requested salary update - if not empty, continue
        if (!getAllRequests().isEmpty()) {
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
                            System.out.println(newSalary);
                            message = user.getUsername() + "'s salary has been updated!";
                            System.out.println(message);
                            //set users requested salary to 0 - as request has been handled
                            user.setRequestedSalary(0);
                            return message;
                        }else{
                            message = user.getUsername() + "'s new salary not approved!";
                            System.out.println(message);
                            //set users requested salary to 0 - as request has been handled
                            user.setRequestedSalary(0);
                            return message;
                        }
                    }

                    //if user applied for role change
                    //else if cannot be used - would not work in case a user requests both salary AND role update!
                    if(!user.getRequestedRole().equals("")){
                        newRole = user.getRequestedRole();
                        System.out.println("User " + user.getUsername() + " has requested to update role to: " + newRole);
                        System.out.println("Approve new role? (y/n): ");
                        String check = input.nextLine();
                        if (check.equals("y") || check.equals("Y")) {
                            user.setEmploymentRole(newRole);
                            message = user.getUsername() + "'s role has been updated!";
                            System.out.println(message);
                            //set user's request to empty - as request has been handled
                            user.setRequestedRole("");
                            return message;
                        }else{
                            message = user.getUsername() + "'s new role not approved!";
                            System.out.println(message);
                            //set user's request to empty - as request has been handled
                            user.setRequestedRole("");
                            return message;
                        }
                    }

                } catch (NoSuchFieldException e) {
                    System.out.println("User not found! Errormessage: " + e.getMessage());
                }
            }
            //remove all salary requests that have been approved or dismissed
            getAllRequests().clear();
        } else {
            message = "No requests found!";
            System.out.println(message);
            return message;
        }
        return "";
    }

//method that creates an arraylist with names of all that requested something, to know how many request there are in total
    public ArrayList<String> getAllRequests(){
        int newSalary;
        String newRole;
        ArrayList<String> requestArrList = new ArrayList<>();

        //loop that gets all users that requested salary
        for(int i = 0; i < getArrayUsers().size(); i++){

            newSalary =getArrayUsers().get(i).getRequestedSalary();
            newRole = getArrayUsers().get(i).getRequestedRole();

            //two if-conditions neccessary, otherwise adds the username to the list only once - undesirable!
            if(newSalary != 0){
                requestArrList.add(getArrayUsers().get(i).getUsername());
            }
            if(!newRole.equals("")){
                requestArrList.add(getArrayUsers().get(i).getUsername());
            }
        }
        return requestArrList;
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
