package br.com.fatec.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MensageiroClient {
    private Mensageiro mensageiro;
    
    public void conectar(){
         try {
            //ip
            LocateRegistry.getRegistry("localhost");
            mensageiro = (Mensageiro) Naming.lookup("rmi://localhost:8080/MensageiroService" );       
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }    
    
    public double calcular(String expressao) throws RemoteException {

        char sinal = Compilador.getSinal(expressao);
        double[] numeros = Compilador.getNumeros(expressao);        
        
        if (sinal == '+')
            return mensageiro.somar(numeros);
        if (sinal == '-')
            return mensageiro.subitrair(numeros);
        if (sinal == '*')
            return mensageiro.multiplicar(numeros);
        if (sinal == '/')
            return mensageiro.dividir(numeros);

        return 0;
    }

}
