package br.com.fatec.controller;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;
import br.com.fatec.model.Parte;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        try {
            Operador sinal = expressao.getOperador().getOperador();
            for(Parte item : expressao.getModel()){
                System.out.println(item.getType());
            }
            if (sinal == Operador.ADD)
                return mensageiro.somar((Expressao)expressao.clone());
            if (sinal == Operador.SUB)
                return mensageiro.subtrair(expressao);
            if (sinal == Operador.MULT)
                return mensageiro.multiplicar(expressao);
            if (sinal == Operador.DIV)
                return mensageiro.dividir(expressao);
            
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MensageiroClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
