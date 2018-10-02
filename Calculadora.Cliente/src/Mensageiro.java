import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Mensageiro extends Remote {
    public double somar(double[] valores)       throws RemoteException;
    public double subitrair(double[] valores)   throws RemoteException;
    public double multiplicar(double[] valores) throws RemoteException;
    public double dividir(double[] valores)     throws RemoteException;
}
