import java.rmi.registry.Registry ;
import java.rmi.server.UnicastRemoteObject ;
import java.rmi.registry.LocateRegistry ;
import java.rmi.Remote ;

public class ServerStop implements AdminInterface{
  private static int port = 1099;

  public ServerStop (){
    super();
  }

  public void stopServer(){
    System.out.println("Stopping server");
      try {

        Registry registry = LocateRegistry.getRegistry(port);
        CalculateService skeleton = (CalculateService) registry.lookup(" CalculateService ");
        AdminInterface adminObj = (AdminInterface) registry.lookup("AdminInterface");
        registry.unbind(" CalculateService ");
        registry.unbind("AdminInterface");
        // UnicastRemoteObject.unexportObject(registry, true);
        System.exit(1);
      }catch ( Exception ex) {
          ex.printStackTrace ();
          }
      }
}
