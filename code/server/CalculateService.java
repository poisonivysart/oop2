import java.rmi.Remote ;
import java.rmi.RemoteException ;

public interface CalculateService extends Remote{
	public String messageDistant ( ) throws RemoteException ;
}

