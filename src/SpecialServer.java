import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class SpecialServer {

	public static void main(String[] args) {
			
		try {

			Registry registrySpecialServer = java.rmi.registry.LocateRegistry.createRegistry(10002);
			
			SpecialServerImpl specialServer = new SpecialServerImpl();
			registrySpecialServer.rebind("SpecialServer", specialServer);
			
			System.out.println("Servidor Especial rodando na porta = 10002");

		} catch (RemoteException exception) {

			System.out.println("Problemas ao conectar o servidor...");

		}
		
	}

}
