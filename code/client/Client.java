import java.rmi.registry.LocateRegistry ;
import java.rmi.registry.Registry ;

// asks in the terminal the password, if the password is entered, then create administrator object.

public class Client implements CalculateService{
  public static void main ( String args []) {
    
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry ( machine , port );
      CalculateService obj = (CalculateService) registry.lookup (" CalculateService ");
      // get from client calculator numbers and operand. We are gonna create 
      // NumbersAndOperand NaO = NumbersAndOperand(nnum1, num2, operand);
      

      System.out.println ( "Le client recoit : "+ obj.add(NaO)) ;
  
    } catch ( Exception e) {
      System.out.println (" Client exception : " +e);
      }
    }
}


