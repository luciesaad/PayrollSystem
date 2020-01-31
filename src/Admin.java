import java.util.ArrayList;
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
     * method createUser() enables the Admin to create a new user in the system
     * takes in 5 params
     * adds the newly created user to the array list with all users
     * @param username String for username
     * @param password String for password
     * @param accountBalance int for account balance
     * @param salary int for salary
     * @param employmentRole String for role/position
     * @return User for testing purposes
     */
    public User createUser(String username, String password, int accountBalance, int salary, String employmentRole) {
        User newUser = new User(username, password, accountBalance, salary, employmentRole);
        getUsers().add(newUser); //adds newly created user to the array list of all users
        return newUser;
    }

    /**
     * method deleteUser() enables the Admin to delete user by specifying the name of the user in array list
     * @param username String representing the username to be deleted
     * catches NoSuchField exception in case the username is not found and prints the error message
     */
    public void deleteUser(String username) {
        int userIndex;
        try {
            userIndex = getIndex(username);
            getUsers().remove(userIndex);
        } catch (NoSuchFieldException e) {
            System.out.println("Could not delete user! Errormessage: " + e.getMessage());
        }
    }

    /**
     * method checkUserRequests() enables the Admin to see all user requests (both salary and role)
     * calls getAllRequests() method
     * catches NoSuchField exception in case user not found
     */
    public void checkUserRequests() {
        int newSalary;
        String adminAnswer, newRole;

        //if there are no requests, print this
        if (getAllRequests().isEmpty()){
            System.out.println("No requests found!");
        }

        //while list of request is not empty, continue
        while (!getAllRequests().isEmpty()) {
            System.out.println("There are " + getAllRequests().size() + " requests pending: ");

            //go through all requests and either approve or do not approve them
            for (int i = 0; i < getAllRequests().size(); i++) {
                try {
                    User user = getUser(getAllRequests().get(i));

                    //if user applied for salary change
                    if (user.getRequestedSalary()>0){
                        newSalary = user.getRequestedSalary();              //set int newSalary to user's requested salary
                        adminAnswer = printSalaryRequirementGetAnswer(user, newSalary);     //print form for approving salary request
                        approveDismissSalary(user, newSalary, adminAnswer);     //call this method to get approval/dismissal

                    }
                    //if user applied for role change
                    if(!user.getRequestedRole().equals("")){
                        newRole = user.getRequestedRole();
                        adminAnswer = printRoleRequirementGetAnswer(user, newRole);     //print form for approving role request, call approveDismissRole
                        approveDismissRole(user, newRole, adminAnswer);
                    }

                } catch (NoSuchFieldException e) {
                    System.out.println("User not found! Errormessage: " + e.getMessage());
                }
            }
            getAllRequests().clear();  //remove all requests as they all have been handled
            System.out.println("No requests left! Good job!");
        }
    }

    public String printSalaryRequirementGetAnswer(User user, int newSalary){
        Scanner input = new Scanner(System.in);
        System.out.println("User " + user.getUsername() + " has requested to update salary to: " + newSalary);
        System.out.println("Approve new salary? (y/n): ");
        return input.nextLine();
    }
    public String printRoleRequirementGetAnswer(User user, String newRole){
        Scanner input = new Scanner(System.in);
        System.out.println("User " + user.getUsername() + " has requested to update role to: " + newRole);
        System.out.println("Approve new role? (y/n): ");
        return input.nextLine();
    }

    public String approveDismissSalary(User user, int newSalary, String adminAnswer){
        String message;
        if (adminAnswer.equals("y") || adminAnswer.equals("Y")) {   //if salary approved
            user.setSalary(newSalary);
            message = user.getUsername() + "'s salary has been updated!";
        }else{
            message = user.getUsername() + "'s new salary not approved!";
        }
        System.out.println(message);
        user.setRequestedSalary(0);     //set users requested salary to 0 - as request has been handled
        return message;
    }

    public String approveDismissRole(User user, String newRole, String adminAnswer){
        String message;
        if (adminAnswer.equals("y") || adminAnswer.equals("Y")) {   //if role approved
            user.setEmploymentRole(newRole);
            message = user.getUsername() + "'s role has been updated!";
        }else{
            message = user.getUsername() + "'s new role not approved!";
        }
        System.out.println(message);
        user.setRequestedRole("");  //set user's request to empty - as request has been handled
        return message;
    }

    /**
     * method getAllRequests creates array list with names of all users who requested something
     * to know how many request there are in total
     * array make have name duplicates in case one user requested for both salary and role update
     * @return ArrayList of Strings that is being used in checkUserRequests()
     */
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

    /**
     * method viewAccount() prints account of a specified user
     * @param user takes in String with admin's username
     */
    public void viewAccount(String user){
        System.out.println(menuLogic.viewAdminAccount(user));
    }

    /**
     * method printUserName returns username of desired user
     * @param user String representing username
     * @return String with username if user exists, else "can't find user"
     */
     public String printUserName(String user){
        for(int i = 0; i <User.getUsers().size(); i++){
            if(User.getUsers().get(i).getUsername().equals(user)){
                return User.getUsers().get(i).getUsername();
            }
        }
         return "Can't find user";
     }

    /**
     * method printMenu() is method specified in the Interface and prints out the menu
     * @return  String for testing purposes
     */
     @Override
     public String printMenu(){
        return          "1 - View Account \n" +
                        "2 - Create User \n" +
                        "3 - See Users \n" +
                        "4 - Requests \n" +
                        "5 - Pay salary \n" +
                        "6 - Log out \n" +
                        "7 - Turn off program \n" +
                        "8 - See Menu again";
     }

    /**
     * method getArrayUsers() is a getter for array list of all existing user objects
     * @return Array list
     */
     public ArrayList<User> getArrayUsers(){
        return getUsers();
     }
}
