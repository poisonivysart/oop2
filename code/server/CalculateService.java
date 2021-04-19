import java.rmi.Remote ;
import java.rmi.RemoteException ;

public interface CalculateService extends Remote{
	public void add(int number1, int number2) throws RemoteException;
	public void subtract(int number1, int number2) throws RemoteException;
	public void divide(int number1, int number2) throws RemoteException;
	public void multiply(int number1, int number2) throws RemoteException;
	public double calculate(NumbersAndOperand NaO) throws RemoteException;
	public void delete() throws RemoteException ;
	public void deleteAll() throws RemoteException ;
}


