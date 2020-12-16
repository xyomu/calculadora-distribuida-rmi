import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BasicServerImpl extends UnicastRemoteObject implements BasicServerInterface {

	private static final long serialVersionUID = 1L;

	protected BasicServerImpl() throws RemoteException {
		super();
	}

	@Override
	public double adicao(double valor1, double valor2) throws RemoteException {
		return valor1 + valor2;
	}

	@Override
	public double subtracao(double valor1, double valor2) throws RemoteException {
		return valor1 - valor2;
	}

	@Override
	public double multiplicacao(double valor1, double valor2) throws RemoteException {
		return valor1 * valor2;
	}

	@Override
	public double divisao(double valor1, double valor2) throws RemoteException {
		return valor1 / valor2;
	}

}
