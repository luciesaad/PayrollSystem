import java.util.InputMismatchException;
import java.util.Scanner;

public class ListUsersLogic {
    private static StartProgram startProgram = new StartProgram();
    private static CreateUserLogic createUserLogic = new CreateUserLogic();
    private  User user;
    private String newUserName ;

    public void adminUpdateUsers(){
        printAllUsers();
        chooseUser();

    }

    protected void printAllUsers() {
        String user;
            for (int i = 0; i < startProgram.getAdmin().getArrayUsers().size(); i++) {
                user = startProgram.getAdmin().getArrayUsers().get(i).getUsername();
                System.out.println(i + " " + user);
            }
    }

    protected int chooseUserInput(){
        Scanner scannerInput = new Scanner(System.in);
        String invalue;
        System.out.print("What user do you want to update? Please only enter the number");
        invalue = scannerInput.nextLine();
        int outvalue = Integer.parseInt(invalue);
        return outvalue;
    }

    protected User returnChoosenUser(int userIndex) throws NoSuchFieldException{

        for (int i = 0; i < startProgram.getAdmin().getArrayUsers().size(); i++){
            if(i == userIndex){
                return  startProgram.getAdmin().getArrayUsers().get(i);
            }
        }
        throw  new NoSuchFieldException("The input did not match any user");
    }

    protected void chooseUser(){
        int userIndex = chooseUserInput();

        try{
           user = returnChoosenUser(userIndex);
        }catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Chosen user is: " + user.getUsername());
        System.out.println("Menu: ");
        printMenuEditUser();
        updateUsersSwitchMenu();
    }

    protected void updateUsersSwitchMenu(){
        Scanner scannerInput = new Scanner(System.in);
        int menu = 0;
        System.out.println("Choose a number: ");
        menu = scannerInput.nextInt();
        while (menu != 7) {
            switch (menu) {
                case 1:
                    //view account user
                    user.viewAccount();
                    System.out.println("To see menu again press 8:");
                    menu = scannerInput.nextInt();
                    break;
                case 2:
                    //Change username
                    changeUserName();
                    System.out.println("To see menu again press 8: ");
                    menu=scannerInput.nextInt();
                    break;
                case 3:
                    //Change password
                    break;
                case 4:
                    //Change salary
                    break;
                case 5:
                    //Change Account balance
                    break;
                case 6:
                    //Delete user
                    break;
                case 7:
                    //Go back to main menu
                    break;
                case 8:
                    printMenuEditUser();
                    System.out.println("Choose a number:");
                    menu = scannerInput.nextInt();
                    break;
            }
        }
    }

    protected String changeUserNameInput(){
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter new username: ");
        return scannerInput.nextLine();
    }

    protected void checkUserNameInout(String newUserName) throws InputMismatchException{

            try {
                createUserLogic.checkUserNameInput(newUserName);
            } catch (InputMismatchException e) {
                throw e;
            }
    }
    
    protected void changeUserName(){
        newUserName = changeUserNameInput();
        boolean check = false;
       while (!check){
           try{
               checkUserNameInout(newUserName);
              check = true;
           }catch (InputMismatchException e){
               System.out.println(e.getMessage());
           }
       }
       user.setUsername(newUserName);
       System.out.println("Username was changed to: " + newUserName);

    }


    public void printMenuEditUser(){  //update: added delete my account(requirement)
        System.out.println(
                "1 - View Account \n" +
                        "2 - Change username \n" +
                        "3 - Change password \n" +
                        "4 - Change salary \n" +
                        "5 - Change role \n" +
                        "6 - Delete My Account  \n" +
                        "7 - Back to Main Menu  \n" +
                        "8 - See Menu again");
    }


}
