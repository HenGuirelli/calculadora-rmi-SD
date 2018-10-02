import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class MensageiroClient {

    public static void main(String[] args) {
        Mensageiro m = null;
        try {
            //ip
            LocateRegistry.getRegistry("localhost");
            m = (Mensageiro) Naming.lookup("rmi://localhost:9999/MensageiroService" );
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
