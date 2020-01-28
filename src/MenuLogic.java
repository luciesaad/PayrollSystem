import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuLogic {

    private static StartProgram startProgram = new StartProgram();
    private static CreateUserLogic createUserLogic = new CreateUserLogic();
    private static  ListUsersLogic listUsersLogic = new ListUsersLogic();


    public void createUser() {
       boolean userNameCreated = false;
       while(!userNameCreated){
            try{
                createUserLogic.createUserName();
                userNameCreated = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                userNameCreated = false;
            }
        }
        boolean userPswCreated = false;
        while(!userPswCreated){
            try{
                createUserLogic.createUserPsw();
                userPswCreated = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                userPswCreated = false;
            }
        }
        boolean userRoleCreated = false;
        while(!userRoleCreated){
            try{
                createUserLogic.createUserEmployment();
                userRoleCreated = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                userRoleCreated = false;
            }
        }
        boolean userAccountCreated = false;
        while(!userAccountCreated){
            try{
                createUserLogic.createUserAccountBalance();
                userAccountCreated = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                userAccountCreated = false;
            }
        }
        boolean userSalaryCreated = false;
        while(!userSalaryCreated){
            try{
                createUserLogic.createUserSalary();
                userSalaryCreated = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                userSalaryCreated = false;
            }
        }
        startProgram.getAdmin().createUser(createUserLogic.getUserName(), createUserLogic.getUserPsw(), createUserLogic.getUserAccountBalance(), createUserLogic.getUserSalary(), createUserLogic.getEmploymentRole());
        System.out.println("User " +  startProgram.getAdmin().printUserName(createUserLogic.getUserName())+ " was created");
    }

    public void listAllUsers(){
        listUsersLogic.adminUpdateUsers();
    }
}
