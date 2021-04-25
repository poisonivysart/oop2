import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner; // Import the Scanner class

public class Client {
  public static void main(String... s) {
    Calculator Calc = new Calculator();
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      CalculateService obj = (CalculateService) registry.lookup(" CalculateService ");

      int num1, num2, equals, operand;
      int c = 0;
      double result = 0;
      NumbersAndOperand NaO;
      while (true) {
        Thread.sleep(1000);
        if (Calc.getPassword().equals("pass")) {
          System.out.print("Right password\n The server is stopped by the administrator\n ");
          Administrator admin = new Administrator("pass");
          AdminInterface adminObj = (AdminInterface) registry.lookup("AdminInterface");
          adminObj.stopServer();
          break;
        }
        equals = Calc.getEquals();
        operand = Calc.getNumbersAndOperand().getOperand();

        if (equals == 1 && c == 0) {

          NaO = Calc.getNumbersAndOperand();
          result = obj.calculate(NaO);
          Calc.setResult(result);
          System.out.println("Result: " + result);
          c += 1;
        } else if (equals == 0) {
          c = 0;
        }
      }
    } catch (Exception e) {
      System.out.println(" Client exception : " + e);
    }
    System.exit(0);
  }

}