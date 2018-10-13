package br.com.fatec.controller;

import br.com.fatec.enuns.Type;
import br.com.fatec.model.Expressao;
import br.com.fatec.model.Numerico;
import br.com.fatec.model.Parte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {
    public MensageiroImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(Expressao expressao) throws RemoteException {
        double resp = 0;         
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico){
                resp += Double.parseDouble(((Numerico) item).getValue());                
            }
        }
        return resp;
    }

    @Override
    public double subtrair(Expressao expressao) throws RemoteException {
        double resp = Double.parseDouble(((Numerico) expressao.getModel().get(0)).getValue());
        for (int i = 1; i < expressao.getModel().size(); i ++){
            Parte item = expressao.getModel().get(i);
            if (item.getType() == Type.numerico){
                resp -= Double.parseDouble(((Numerico) item).getValue());
                System.out.println(resp);
                System.out.println("valor: " +item.getValue());
                System.out.println("convertido " + Double.parseDouble(item.getValue()));
            }
        }
        return resp;
    }

    @Override
    public double multiplicar(Expressao expressao) throws RemoteException {
        double resp = 1;
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico)
                resp *= Double.parseDouble(((Numerico) item).getValue());
        }
        return resp;
    }

    @Override
    public double dividir(Expressao expressao) throws RemoteException {
        
        //pega o primeiro e divide pelo proximo
        double resp = Double.parseDouble(((Numerico) expressao.getModel().get(0)).getValue());
        for (int i = 1; i < expressao.getModel().size(); i ++){
            Parte item = expressao.getModel().get(i);
            if (item.getType() == Type.numerico)
                resp /= Double.parseDouble(((Numerico) item).getValue());
        }
        return resp;
    }

   
}
