import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpecialServerInterface extends Remote {

	double raizQuadrada(double valor1) throws RemoteException;

	double potencia(double valor1, double valor2) throws RemoteException;

	double porcentagem(double valor1, double valor2) throws RemoteException;

}
