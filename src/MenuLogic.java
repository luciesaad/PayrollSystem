import java.util.InputMismatchException;

public class MenuLogic {

    private static StartProgram startProgram = new StartProgram();
    private static CreateUserLogic createUserLogic = new CreateUserLogic();
    private static MenuHandleUsers menuHandleUsers = new MenuHandleUsers();

    /**This method does so that Admin can create new Users.
     * @exception InputMismatchException if exxception comes back it gives the message and admin gets to try again*/
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

    /**This method calls on a method in the class MenuHandleUsers where Admin can change different things on a user*/
    public void listAllUsers(){
        menuHandleUsers.adminHandleUsers();
    }
    /**This method prints out admins account values*/
    public String viewAdminAccount(String username) {
        username = startProgram.getAdmin().getUsername();
      return "Account user: " + username + "\n"+
             "Account balance: " + startProgram.getAdmin().getAccountBalance() + "\n"+
             "Employment role: " + startProgram.getAdmin().getEmploymentRole()  + "\n"+
             "Salary: " + startProgram.getAdmin().getSalary();
    }

    /**This method runs paySalaryReturn and also prints out the return.*/
    public void paySalary(){
        System.out.println(paySalaryReturn());
    }

    /**This method Pays out salary to the users and to admin.
     * @return a string that tells if salary´s har paid or not*/
    public String paySalaryReturn(){
        int newAccountBalance;
        int oldAccountBalance;
        int sum;
        if(!startProgram.getAdmin().getArrayUsers().isEmpty()){
            for (int i = 0; i < startProgram.getAdmin().getArrayUsers().size(); i++){
                newAccountBalance = startProgram.getAdmin().getArrayUsers().get(i).getSalary();
                oldAccountBalance = startProgram.getAdmin().getArrayUsers().get(i).getAccountBalance();
                sum = newAccountBalance + oldAccountBalance ;
                startProgram.getAdmin().getArrayUsers().get(i).setAccountBalance(sum);
            }
            newAccountBalance = startProgram.getAdmin().getSalary();
            oldAccountBalance = startProgram.getAdmin().getAccountBalance();
            sum = newAccountBalance + oldAccountBalance;
            startProgram.getAdmin().setAccountBalance(sum);
            return "The salary´s are paid out";
        }else {
            newAccountBalance = startProgram.getAdmin().getSalary();
            oldAccountBalance = startProgram.getAdmin().getAccountBalance();
            sum = newAccountBalance + oldAccountBalance;
            startProgram.getAdmin().setAccountBalance(sum);
            return "Admin was the only one that got salary payed out" + "There are no users to pay out salary to";
        }
    }

}
