package br.com.fatec.controller;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;
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
    
    public double calcular(Expressao expressao) throws RemoteException {

        Operador sinal = expressao.getOperador().getOperador();
        
        if (sinal == Operador.ADD)
            return mensageiro.somar(expressao);
        if (sinal == Operador.SUB)
            return mensageiro.subitrair(expressao);
        if (sinal == Operador.MULT)
            return mensageiro.multiplicar(expressao);
        if (sinal == Operador.DIV)
            return mensageiro.dividir(expressao);

        return 0;
    }

}
