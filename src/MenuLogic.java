public class MenuLogic {

    private StartProgram startProgram = new StartProgram();


    public void createUser(){
        System.out.println("Enter username: ");
        String userName = userInput.next();
        System.out.println("Enter Password: ");
        String userPsw = userInput.next();
        System.out.println("Enter Account balance: ");
        int userAccountBalance = userInput.nextInt();
        System.out.println("Enter salary: ");
        int userSalary = userInput.nextInt();
        System.out.println("Enter Employment role: ");
        String employmentRole = userInput.nextLine();

        startProgram.getAdmin().createUser();


    }
}
