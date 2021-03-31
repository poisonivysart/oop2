import java.rmi.registry.LocateRegistry ;
import java.rmi.registry.Registry ;

public class Client {
  public static void main ( String args []) {
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry ( machine , port );
      CalculateService obj = (CalculateService) registry.lookup (" CalculateService ");
      System.out.println ( "Le client recoit : "+ obj.messageDistant ( ) ) ;
  
    } catch ( Exception e) {
      System.out.println (" Client exception : " +e);
      }
    }
}


