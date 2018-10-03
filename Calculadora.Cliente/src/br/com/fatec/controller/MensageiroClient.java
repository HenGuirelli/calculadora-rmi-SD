package br.com.fatec.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class MensageiroClient {

    public static double calcular(String expressao) throws RemoteException {
        Mensageiro m = null;
        try {
            //ip
            LocateRegistry.getRegistry("localhost");
            m = (Mensageiro) Naming.lookup("rmi://localhost:9999/MensageiroService" );
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        char sinal = Compilador.getSinal(expressao);
        double[] numeros = Compilador.getNumeros(expressao);
        
        if (sinal == '+')
            return m.somar(numeros);
        if (sinal == '-')
            return m.subitrair(numeros);
        if (sinal == '*')
            return m.multiplicar(numeros);
        if (sinal == '/')
            return m.dividir(numeros);
        
        throw new RuntimeException("erro ao calcular");
    }

}
