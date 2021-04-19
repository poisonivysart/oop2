import java.rmi.registry.LocateRegistry ;
import java.rmi.registry.Registry ;
import java.util.Scanner;  // Import the Scanner class

// asks in the terminal the password, if the password is entered, then create administrator object.

public class Client{
  public static void main ( String args []) {
    
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry ( machine , port );

      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter the password if you are the administrator or leave it blank:");
      String pass = myObj.nextLine();

      if(pass != null && pass.length() != 0 && pass.equals("pass")){ 
        Administrator admin = new Administrator(pass);
        AdminInterface adminObj = (AdminInterface) registry.lookup("AdminInterface");
        System.out.println("Signed in as Administrator");
        System.out.println("StopServer: yes 1 no 0");
        int decision = myObj.nextInt();
        if(decision == 1){
          adminObj.stopServer();
          System.exit(0);
        }else{
        System.out.println("ok"); 

        }
      }else{
        System.out.println("Signed in as Guest");
      }
      CalculateService obj = (CalculateService) registry.lookup (" CalculateService ");
      // get from client calculator numbers and operand. We are gonna create 
      // NumbersAndOperand NaO = NumbersAndOperand(nnum1, num2, operand);
      
      

      System.out.println("Enter num1:");
      int num1 = myObj.nextInt();
      System.out.println("Enter num2:");
      int num2 = myObj.nextInt();
      System.out.println("Enter operand type: (1.+ 2.- 3./ 4.*)");
      int operand = myObj.nextInt();
      NumbersAndOperand NaO = new NumbersAndOperand(num1,num2,operand);

      System.out.println ( "Result: : "+ obj.calculate(NaO)) ;
  
    } catch ( Exception e) {
      System.out.println (" Client exception : " +e);
      }
    }
}


