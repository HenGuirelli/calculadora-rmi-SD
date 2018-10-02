import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {
    public MensageiroImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp += valor;
        return resp;
    }

    @Override
    public double subitrair(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp -= valor;
        return resp;
    }

    @Override
    public double multiplicar(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp *= valor;
        return resp;
    }

    @Override
    public double dividir(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp /= valor;
        return resp;
    }
	

}
