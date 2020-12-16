import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SpecialServerImpl extends UnicastRemoteObject implements SpecialServerInterface {

	private static final long serialVersionUID = 1L;

	protected SpecialServerImpl() throws RemoteException {
		super();
	}

	@Override
	public double raizQuadrada(double valor1) throws RemoteException {
		return Math.sqrt(valor1);
	}

	@Override
	public double potencia(double valor1, double valor2) throws RemoteException {
		return Math.pow(valor1, valor2);
	}

	@Override
	public double porcentagem(double valor1, double valor2) throws RemoteException {
		return (valor1 * valor2) / 100;
	}

}
