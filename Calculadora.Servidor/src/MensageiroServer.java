import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class MensageiroServer {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		System.out.print("Servidor ativo...\n");
		new MensageiroServer();
	}
		public MensageiroServer(){
			try {Mensageiro m = new MensageiroImpl();
			//registra o servidor evitando de faze-lo  no console
			LocateRegistry.createRegistry(9999);
			 Naming.rebind("rmi://localhost:9999/MensageiroService", m);
			 }catch( Exception e ) { System.out.println(" Erro: " + e );}}}


