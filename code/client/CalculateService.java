import java.rmi.Remote ;
import java.rmi.RemoteException ;

public interface CalculateService extends Remote{
	public void setNumber1( int number1) throws RemoteException ;
	public void setNumber2( int number2) throws RemoteException ;
	public void setOperand( int operand) throws RemoteException ;
	public void delete() throws RemoteException ;
	public void deleteAll() throws RemoteException ;
}

