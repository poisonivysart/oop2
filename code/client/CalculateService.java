import java.rmi.Remote ;
import java.rmi.RemoteException ;

public interface CalculateService extends Remote{
	public void delete() throws RemoteException ;
	public void deleteAll() throws RemoteException ;
}

