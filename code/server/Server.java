import java.rmi.registry.LocateRegistry ;
import java.rmi.registry.Registry ;
import java.rmi.server.UnicastRemoteObject ;
import java.util.Arrays ;

public class Server implements CalculateService{
  
  public static void main ( String [ ] args ) { 
    try {
			
      int port = 1099;
      CalculateService skeleton = (CalculateService) UnicastRemoteObject.exportObject(new Calculate () , 0);
      System.out.println ( "Serveur is ready" ) ;
      Registry registry = LocateRegistry.getRegistry (port);
      System.out.println ( " Service Message enregistre " ) ;
      if (! Arrays.asList(registry.list()).contains (" CalculateService "))
        registry.bind(" CalculateService ", skeleton );
      else
        registry.rebind (" CalculateService ", skeleton );
  } catch ( Exception ex) {
    ex.printStackTrace ();
    }
  }
}
