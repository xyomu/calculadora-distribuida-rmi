import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BasicServerInterface extends Remote {

	double adicao(double valor1, double valor2) throws RemoteException;

	double subtracao(double valor1, double valor2) throws RemoteException;

	double multiplicacao(double valor1, double valor2) throws RemoteException;

	double divisao(double valor1, double valor2) throws RemoteException;

}
