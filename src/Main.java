/**
 * @author Madeleine Hallqvist, Lucie Saad
 * */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
       //Runs all the tests before the program runs.
    //    Result result = JUnitCore.runClasses(Admin.class);
      //  for(Failure failure : result.getFailures()){
        //   System.out.println(failure.toString());

        //start program
          StartProgram start = new StartProgram();
         start.runProgram();




       }

    }

