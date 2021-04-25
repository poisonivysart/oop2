import java.rmi.registry.LocateRegistry ;
import java.rmi.registry.Registry ;
import java.rmi.server.UnicastRemoteObject ;
import java.util.Arrays ;

public class Server{
 
  private static int port = 1099;
  public static void main ( String [ ] args ) { 
    try {
			
      CalculateService skeletonCalculate = (CalculateService) UnicastRemoteObject.exportObject(new Calculate () , 0);
      AdminInterface skeletonAdmin = (AdminInterface) UnicastRemoteObject.exportObject(new ServerStop () , 0);
      System.out.println ( "Server is ready" ) ;
      Registry registry = LocateRegistry.getRegistry (port);
      registry.rebind ("AdminInterface", skeletonAdmin );
      
      if (! Arrays.asList(registry.list()).contains (" CalculateService "))
        registry.bind(" CalculateService ", skeletonCalculate );
      else
        registry.rebind (" CalculateService ", skeletonCalculate );
      
  } catch ( Exception ex) {
    ex.printStackTrace ();
    }
  }

  
}
