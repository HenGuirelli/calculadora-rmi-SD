import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class MensageiroClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mensageiro m = null;
		try {
		//LocateRegistry.getRegistry("192.168.0.102");
		LocateRegistry.getRegistry("localhost");
		m = (Mensageiro) Naming.lookup("rmi://localhost:9999/MensageiroService" );
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println( m.lerMensagem() );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			m.enviarMensagem( "Hello World!" );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
