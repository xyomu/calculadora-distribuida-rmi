import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class BasicServer {

	public static void main(String[] args) {
			
		try {

			Registry registryBasicServer = java.rmi.registry.LocateRegistry.createRegistry(10001);

			BasicServerImpl basicServer = new BasicServerImpl();
			registryBasicServer.rebind("BasicServer", basicServer);

			System.out.println("Servidor Basico rodando na porta = 10001");

		} catch (RemoteException exception) {

			System.out.println("Problemas ao conectar o servidor...");

		}
		
	}

}
