import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {
	public MensageiroImpl() throws RemoteException {
		super();
		}
	public void enviarMensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println( msg );
	}
	@Override
public String lerMensagem() throws RemoteException {
		// TODO Auto-generated method stub
		return "This is not a Hello World! message";
		
	}

}
