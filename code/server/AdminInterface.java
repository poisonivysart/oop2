import java.rmi.Remote ;
import java.rmi.RemoteException ;

public interface AdminInterface extends Remote{
  public void stopServer() throws RemoteException;
}
